package com.wuang.library.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuang.library.dao.model.Menu;
import com.wuang.library.dao.model.Worker;
import com.wuang.library.entry.SecoundMenu;
import com.wuang.library.entry.ThridMenu;
import com.wuang.library.service.manager.IMenuService;
import com.wuang.library.service.manager.IPowerService;
import com.wuang.library.service.manager.IUserService;
import com.wuang.library.service.manager.IWorkerService;

@Controller
public class MainController {
	@Autowired
	IPowerService powerService;
	@Autowired
	IWorkerService workerService;
	@Autowired
	IUserService userService;
	@Autowired
	IMenuService menuService;

	@RequestMapping("getmenu")
	@ResponseBody
	public String getmenu(HttpServletRequest request, HttpSession session)
			throws Exception {
		String result = "";
		List<SecoundMenu> resultMenus = new ArrayList<SecoundMenu>();
		String menuid = new String(request.getParameter("menuid").getBytes(
				"ISO8859-1"), "UTF-8");
		System.out.println(menuid);
		Worker worker = new Worker();
		worker = (Worker) session.getAttribute("AdminSession");
		Menu menu = new Menu();
		menu.setCreateid(worker.getId());
		menu.setMenufatherid(menuid);
		List<Menu> menus = menuService.findMenu(menu, 1, Integer.MAX_VALUE);
		for (int i = 0; i < menus.size(); i++) {
			SecoundMenu e = new SecoundMenu(menus.get(i).getMenuname(),
					getEndMenu(menus.get(i).getId()));
			resultMenus.add(e);
		}

		ObjectMapper mapperJso = new ObjectMapper();
		result = mapperJso.writeValueAsString(resultMenus);
		System.out.println(result);
		return result;
	}

	private List<ThridMenu> getEndMenu(String id) {
		// TODO Auto-generated method stub
		Menu tmenu = new Menu();
		tmenu.setMenufatherid(id);
		List<Menu> list = menuService.findMenu(tmenu, 1, Integer.MAX_VALUE);
		List<ThridMenu> list2 = new ArrayList<ThridMenu>();
		for (int i = 0; i < list.size(); i++) {
			ThridMenu thridMenu = new ThridMenu(list.get(i).getId(), list
					.get(i).getMenuname(), list.get(i).getMenutarget(), list
					.get(i).getMenupagedo());
			list2.add(thridMenu);
		}
		return list2;
	}

	@RequestMapping("getfristmenu")
	@ResponseBody
	public String getfristmenu(HttpServletRequest request, HttpSession session)
			throws Exception {
		String result = "";
		Worker manager = new Worker();
		manager = (Worker) session.getAttribute("AdminSession");
		Menu menu = new Menu();
		menu.setCreateid(manager.getId());
		System.out.println(manager.getId());
		menu.setMenuroot("0");
		List<Menu> menuList = menuService.findMenu(menu, 1, Integer.MAX_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		result = mapper.writeValueAsString(menuList);
		System.out.println(result);
		return result;
	}

	// @RequestMapping("center")
	// @ResponseBody
	// public String setCenter(HttpServletRequest request, HttpSession session)
	// throws Exception {
	// String result = "[{\"name\":\"系统管理\",\"children\":"
	// + "[{\"id\":\"menumanger\",\"name\":\"菜单管理\","
	// + "\"target\":\"navtab\",\"url\":\"menumanger.do\"},"
	// + "{\"id\":\"menupage\",\"name\":\"菜单页面\","
	// + "\"target\":\"navtab\",\"url\":\"menupage.do\"},"
	// + "{\"id\":\"personmsg\",\"name\":\"个人信息\","
	// + "\"target\":\"navtab\",\"url\":\"personmsg.do\"},"
	// + "{\"id\":\"about\",\"name\":\"关于我们\","
	// + "\"target\":\"navtab\",\"url\":\"about.do\"}," + "]}]";
	// return result;
	// }

}
