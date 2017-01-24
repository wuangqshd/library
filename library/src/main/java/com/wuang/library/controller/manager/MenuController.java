package com.wuang.library.controller.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wuang.library.dao.model.Menu;
import com.wuang.library.dao.model.Pager;
import com.wuang.library.dao.model.Power;
import com.wuang.library.dao.model.Worker;
import com.wuang.library.service.manager.IMenuService;
import com.wuang.library.service.manager.IPagerService;
import com.wuang.library.service.manager.IPowerService;
import com.wuang.library.service.manager.IWorkerService;
import com.wuang.library.utils.GetTime;

@Controller
public class MenuController {
	private static final String SUCCESS = "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
	private static final String FAILS = "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";
	@Autowired
	IMenuService menuService;
	@Autowired
	IPowerService powerService;
	@Autowired
	IWorkerService workerService;
	@Autowired
	IPagerService pagerService;

	@RequestMapping("menumanger")
	public String menuManger() {
		return "manager/menu/menumanger";
	}

	@RequestMapping("mymenu")
	public String Mymenu() {
		return "manager/menu/mymenu";
	}

	@RequestMapping("menupage")
	public String menuPage() {
		return "manager/menu/menupage";
	}

	@RequestMapping("about")
	public String about() {
		return "manager/person/about";
	}

	@RequestMapping("setmenu")
	@ResponseBody
	public String setMenu(HttpServletRequest request, HttpSession session)
			throws Exception {
		Power t = new Power();
		List<Power> powers = powerService.findPower(t, 1, Integer.MAX_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		String powersString = mapper.writeValueAsString(powers);
		System.out.println(powersString);
		return powersString;
	}

	@RequestMapping("findmenu")
	@ResponseBody
	public String findsetMenu(HttpServletRequest request, HttpSession session)
			throws Exception {
		String result = "";
		List<Menu> menus = new ArrayList<Menu>();
		Menu menu1 = new Menu();
		Worker worker = (Worker) session.getAttribute("AdminSession");
		menu1.setCreateid(worker.getId());
		menus = menuService.findMenu(menu1, 1, Integer.MAX_VALUE);
		for (int i = 0; i < menus.size(); i++) {
			menus.get(i).setCreateid(
					workerService.findOne(menus.get(i).getCreateid())
							.getUsername().toString());
		}
		ObjectMapper mapper = new ObjectMapper();
		result = mapper.writeValueAsString(menus);
		return result;
	}

	@RequestMapping("findmenuformod")
	@ResponseBody
	public String findsetMenuforMod(HttpServletRequest request,
			HttpSession session) throws Exception {
		String result = "";
		List<Menu> menus = menuService.findMenusForMod();
		ObjectMapper mapper = new ObjectMapper();
		result = mapper.writeValueAsString(menus);
		return result;
	}

	@RequestMapping("editmenu")
	@ResponseBody
	public String editMenu(HttpServletRequest request, HttpSession session)
			throws Exception {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Menu menu = JSONObject.toJavaObject(object, Menu.class);
				if (object.getBooleanValue("addFlag")) {
					menu.setCreatetime(GetTime.getCurrentDateTime());
					menu.setCreateid(worker.getId());
					s = menuService.insertOne(menu);
				} else {
					menu.setCreateid(worker.getId());
					s = menuService.updateOne(menu);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s) {
			return SUCCESS;
		} else {
			return FAILS;
		}
	}

	@RequestMapping("delmenu")
	@ResponseBody
	public String delMenu(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Menu> menus = JSONArray.parseArray(jsonString, Menu.class);
			System.out.println(jsonString);
			for (int i = 0; i < menus.size(); i++) {
				s = menuService.deleteOne(menus.get(i).getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s = false;
		}
		if (s) {
			return SUCCESS;
		} else {
			return FAILS;
		}
	}

	@RequestMapping("editmodmenu")
	@ResponseBody
	public String editModMenu(HttpServletRequest request, HttpSession session)
			throws Exception {
		boolean s = false;
		try {
			s = false;
			String jsonString = request.getParameter("json");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Menu menu = JSONObject.toJavaObject(object, Menu.class);
				menu.setCreatetime(GetTime.getCurrentDateTime());
				if (object.getBooleanValue("addFlag")) {
					s = menuService.insertOne(menu);
				} else {
					s = menuService.updateOne(menu);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (s) {
			return SUCCESS;
		} else {
			return FAILS;
		}

	}

	@RequestMapping("delmodmenu")
	@ResponseBody
	public String delModMenu(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Menu> menus = JSONArray.parseArray(jsonString, Menu.class);
			for (int i = 0; i < menus.size(); i++) {
				s = menuService.deleteOne(menus.get(i).getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s) {
			return SUCCESS;
		} else {
			return FAILS;
		}

	}

	@RequestMapping("findmypage")
	@ResponseBody
	public String findMyPage(HttpServletRequest request, HttpSession session) {
		String result = "";
		List<Pager> list = pagerService.findPager(new Pager(), 1,
				Integer.MAX_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		try {
			result = mapper.writeValueAsString(list);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping("editmypage")
	@ResponseBody
	public String editMyPage(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Pager pager = JSONObject.toJavaObject(object, Pager.class);
				if (object.getBooleanValue("addFlag")) {
					pager.setCreatetime(GetTime.getCurrentDateTime());
					pager.setCreateid(worker.getId());
					s = pagerService.insertOne(pager);
				} else {
					s = pagerService.updateOne(pager);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s) {
			return SUCCESS;
		} else {
			return FAILS;
		}
	}

	@RequestMapping("delmypage")
	@ResponseBody
	public String delMyPage(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Pager> pagers = JSONArray.parseArray(jsonString, Pager.class);
			// System.out.println(jsonString);
			for (int i = 0; i < pagers.size(); i++) {
				s = pagerService.deleteOne(pagers.get(i).getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (s) {
			return SUCCESS;
		} else {
			return FAILS;
		}

	}
}
