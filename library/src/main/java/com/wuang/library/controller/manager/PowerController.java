package com.wuang.library.controller.manager;

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
import com.wuang.library.dao.model.Power;
import com.wuang.library.dao.model.Worker;
import com.wuang.library.service.manager.IPowerService;
import com.wuang.library.utils.GetTime;

@Controller
public class PowerController {
	@Autowired
	IPowerService powerService;

	private static final String SUCCESS = "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
	private static final String FAILS = "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";

	@RequestMapping("powerinfo")
	public String powerInfo(HttpServletRequest request) {
		return "manager/power/powerinfo";
	}

	@RequestMapping("otherpower")
	public String otherPower(HttpServletRequest request) {
		return "manager/power/otherpower";
	}

	@RequestMapping("findpower")
	@ResponseBody
	public String findPower(HttpServletRequest request, HttpSession session) {
		String result = "";
		List<Power> list = powerService.findPower(new Power(), 1,
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

	@RequestMapping("editpower")
	@ResponseBody
	public String editPower(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Power power = JSONObject.toJavaObject(object, Power.class);
				if (object.getBooleanValue("addFlag")) {
					power.setCreatetime(GetTime.getCurrentDateTime());
					power.setCreateid(worker.getId());
					s = powerService.insertOne(power);
				} else {
					s = powerService.updateOne(power);
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

	@RequestMapping("delpower")
	@ResponseBody
	public String delPower(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Power> powers = JSONArray.parseArray(jsonString, Power.class);
			// System.out.println(jsonString);
			for (int i = 0; i < powers.size(); i++) {
				s = powerService.deleteOne(powers.get(i).getId());
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

	@RequestMapping("findotherpower")
	@ResponseBody
	public String findOtherPower(HttpServletRequest request, HttpSession session) {
		String result = "";
		List<Power> list = powerService.findPower(new Power(), 1,
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

	@RequestMapping("editotherpower")
	@ResponseBody
	public String editOtherPower(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Power power = JSONObject.toJavaObject(object, Power.class);
				if (object.getBooleanValue("addFlag")) {
					power.setCreatetime(GetTime.getCurrentDateTime());
					power.setCreateid(worker.getId());
					s = powerService.insertOne(power);
				} else {
					s = powerService.updateOne(power);
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

	@RequestMapping("delotherpower")
	@ResponseBody
	public String delOtherPower(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Power> powers = JSONArray.parseArray(jsonString, Power.class);
			// System.out.println(jsonString);
			for (int i = 0; i < powers.size(); i++) {
				s = powerService.deleteOne(powers.get(i).getId());
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
