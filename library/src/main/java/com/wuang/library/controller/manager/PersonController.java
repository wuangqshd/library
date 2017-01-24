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
import com.wuang.library.dao.model.Worker;
import com.wuang.library.service.manager.IWorkerService;
import com.wuang.library.utils.CreateId;
import com.wuang.library.utils.GetTime;

@Controller
public class PersonController {
	@Autowired
	IWorkerService workerService;
	private static final String SUCCESS = "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
	private static final String FAILS = "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";

	@RequestMapping("workerinfo")
	public String workerInfo(HttpServletRequest request) {
		return "manager/person/workerinfo";
	}

	@RequestMapping("getworkerinfo")
	@ResponseBody
	public String findWorkerInfo(HttpServletRequest request, HttpSession session) {
		String result = "";
		List<Worker> list = workerService.findWorker(new Worker(), 1,
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

	@RequestMapping("editworkerinfo")
	@ResponseBody
	public String editWorkerInfo(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker1 = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Worker worker = JSONObject.toJavaObject(object, Worker.class);
				if (object.getBooleanValue("addFlag")) {
					worker.setId(CreateId.createId());
					worker.setCreatetime(GetTime.getCurrentDateTime());
					worker.setCreateid(worker1.getId());
					worker.setUserpowerid("2");
					worker.setUserstate("1");
					worker.setUserpasswd("123456");
					s = workerService.insertOne(worker);
				} else {
					s = workerService.updateOne(worker);
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

	@RequestMapping("delworkerinfo")
	@ResponseBody
	public String delWorkerInfo(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Worker> workers = JSONArray.parseArray(jsonString,
					Worker.class);
			// System.out.println(jsonString);
			for (int i = 0; i < workers.size(); i++) {
				s = s && workerService.deleteOne(workers.get(i).getId());
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

	@RequestMapping("personmsg")
	public String personMsg(HttpServletRequest request, HttpSession session) {
		return "/manager/person/personmsg";
	}

	@RequestMapping("getpersonmsg")
	@ResponseBody
	public String getPersongMsg(HttpServletRequest request, HttpSession session) {
		String result = "";
		Worker worker = (Worker) session.getAttribute("AdminSession");
		String json = JSONObject.toJSONString(worker);
		System.out.println(json);
		return json;
	}

	@RequestMapping("editpersonmsg_self")
	@ResponseBody
	public String editPersonMsg(HttpServletRequest request, HttpSession session) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		// String strongString = request.getParameter("id");
		// System.out.println(strongString);
		try {
			Worker worker = (Worker) session.getAttribute("AdminSession");
			worker.setId(request.getParameter("id").toString().trim());
			worker.setUsername(request.getParameter("username").toString()
					.trim());
			worker.setUsercode(request.getParameter("usercode").toString()
					.trim());
			worker.setUseraccount(request.getParameter("useraccount")
					.toString().trim());
			worker.setUsermail(request.getParameter("usermail").toString()
					.trim());
			worker.setUserphone(request.getParameter("userphone").toString()
					.trim());
			worker.setUserage(request.getParameter("userage").toString().trim());
			worker.setUsercompany(request.getParameter("usercompany")
					.toString().trim());
			workerService.updateOne(worker);
			String jsonString = mapper.writeValueAsString(worker);
			System.out.println(jsonString);
			result = SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = FAILS;
		}

		return result;
	}
}
