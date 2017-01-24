package com.wuang.library.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuang.library.dao.model.Menu;
import com.wuang.library.dao.model.Power;
import com.wuang.library.dao.model.User;
import com.wuang.library.dao.model.Worker;
import com.wuang.library.service.manager.IMenuService;
import com.wuang.library.service.manager.IPowerService;
import com.wuang.library.service.manager.IUserService;
import com.wuang.library.service.manager.IWorkerService;
import com.wuang.library.utils.CreateId;
import com.wuang.library.utils.GetTime;

@Controller
public class LoginController {
	private String SUCCESS = "{\"statusCode\":200,\"message\":\"操作成功！\"}";
	@Autowired
	IWorkerService mangerService;
	@Autowired
	IWorkerService workerService;
	@Autowired
	IUserService userService;
	@Autowired
	IMenuService menuService;
	@Autowired
	IPowerService powerService;
	private static Worker worker;

	@RequestMapping(value = "/login")
	@ResponseBody
	public String adminLogin(@RequestBody ModelMap params, HttpSession session) {
		String result = "";
		String username = params.get("username").toString().trim();
		String password = params.get("password").toString().trim();
		System.out.println("name:==" + username + "==pass:==" + password);
		// 1、判断用户名及密码是否正确
		// 获取管理员信息
		Worker admin = new Worker();
		admin.setUseraccount(username);
		// 获取用户信息
		User user = new User();
		user.setUseraccount(username);
		// 判断用户还是管理员并验证登陆信息
		List<Worker> mangerList = mangerService.findWorker(admin, 1, 1);
		List<User> userList = userService.findUser(user, 1, 1);
		if ((mangerList.size() == 0) && (userList.size() == 0)) {
			result = "fail"; // 用户账户不正确
		} else if ((mangerList.size() == 0) && (userList.size() != 0)) {
			user = userList.get(0);
			String realpass = user.getUserpasswd();
			if (realpass.equals(password)) {
				result = "success";
				session.setAttribute("UserSession", user);
			} else {
				result = "fail"; // 用户密码不正确
			}
		} else if ((mangerList.size() != 0) && (userList.size() == 0)) {
			admin = mangerList.get(0);
			String realpass = admin.getUserpasswd();
			if (realpass.equals(password)) {
				result = "success";
				worker = admin;
				session.setAttribute("AdminSession", admin);
				// 2、判断是否为第一次登陆，如果是设置初始化数据库并弹出修改密码框
				Menu menu = new Menu();
				menu.setCreateid(admin.getId());
				List<Menu> menusList = menuService.findMenu(menu, 1,
						Integer.MAX_VALUE);
				if (menusList.size() == 0) {
					setStartMenu(admin.getUserpowerid());
				}
				index(session);
			} else {
				result = "fail"; // 用户密码不正确
			}
		} else {
			result = "fail";
		}

		System.out.println(result);
		return result;
	}

	@RequestMapping("changepassword")
	public String changePassword() {
		return "changepassword";
	}

	@RequestMapping("dochangepasswd")
	@ResponseBody
	public String doChangePasswd(HttpServletRequest request, HttpSession session)
			throws Exception {
		String result = "";
		try {
			String newPasswd = new String(request.getParameter("password")
					.getBytes("ISO8859-1"), "UTF-8");
			String oldPasswd = new String(request.getParameter("oldpassword")
					.getBytes("ISO8859-1"), "UTF-8");
			System.out.println("===============newpasswd============"
					+ newPasswd + "==================oldPasswd============="
					+ oldPasswd);
			// User user = new User();
			// user = (User) session.getAttribute("UserSession");
			// System.out.println(user.getUserpasswd());
			Worker worker = (Worker) session.getAttribute("AdminSession");
			if (worker.getUserpasswd().equals(oldPasswd)) {
				worker.setUserpasswd(newPasswd);
				workerService.updateOne(worker);
				result = SUCCESS;
			} else {
				result = "{\"statusCode\":300,\"message\":\"密码错误！修改失败！\"}";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "{\"statusCode\":300,\"message\":\"修改失败！\"}";
		}
		return result;
	}

	// 3、完成登陆后查询一级菜单，及相应菜单完成系统登陆
	@RequestMapping("index")
	public String index(HttpSession session) {
		Worker admin;
		User user;
		try {
			admin = (Worker) session.getAttribute("AdminSession");
			user = (User) session.getAttribute("UserSession");
			if (admin != null) {
				return "manager/index";
			} else {
				return "user/index";
			}
		} catch (Exception e) {
			session.removeAttribute("AdminSession");
			session.removeAttribute("UserSession");
			return "redirect:/";
		}

	}

	/**
	 * 退出登录
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String loadLogout(HttpSession session) {
		session.removeAttribute("AdminSession");
		session.removeAttribute("UserSession");
		return "redirect:/";
	}

	/**
	 * 注册
	 */
	@RequestMapping("/regedit")
	public String regedit(HttpSession session) {
		System.out.println("输出");
		return "index";

	}

	@RequestMapping("main")
	public String mainString() {
		return "manager/main";
	}

	@RequestMapping("timeout.do")
	public String timeOut() {
		return "manager/timeout";
	}

	/**
	 * 初始化菜单
	 * 
	 */
	private boolean setStartMenu(String userpowerid) {
		Power power = new Power();
		try {
			power = powerService.findOne(userpowerid);
			List<Menu> list = menuService.findOrderMenus(power.getStartmod());
			for (int i = 0; i < list.size(); i++) {
				String id = list.get(i).getId();
				String uuid = CreateId.createId();
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getMenufatherid().equals(id)) {
						list.get(j).setMenufatherid(uuid);
						list.get(j).setCreatetime(GetTime.getCurrentDateTime());
					}
				}
				list.get(i).setCreateid(worker.getId());
				list.get(i).setId(uuid);
				list.get(i).setCreatetime(GetTime.getCurrentDateTime());
				menuService.insertOne(list.get(i));
			}
			System.out.println("创建成功");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("创建失败");
			return false;
		}
	}
}
