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
import com.wuang.library.dao.model.Borrow;
import com.wuang.library.dao.model.Worker;
import com.wuang.library.service.manager.IBorrowService;
import com.wuang.library.utils.CreateId;
import com.wuang.library.utils.GetTime;

@Controller
public class BorrowController {
	private static final String SUCCESS = "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
	private static final String FAILS = "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";
	@Autowired
	IBorrowService borrowService;

	@RequestMapping("borrowin")
	public String borrowIn() {
		return "manager/borrow/borrowin";
	}

	@RequestMapping("borrowout")
	public String borrowOut() {
		return "manager/borrow/borrowout";
	}

	@RequestMapping("borrowinfo")
	public String borrowInfo() {
		return "manager/borrow/borrowinfo";
	}

	@RequestMapping("findborrowuser")
	public String findBorrowUser() {
		return "manager/borrow/finduser";
	}

	@RequestMapping("findborrowbook")
	public String findBorrowBook() {
		return "manager/borrow/findbook";
	}

	@RequestMapping("findborrowinfo")
	@ResponseBody
	public String findBorrowinfo(HttpServletRequest request, HttpSession session) {
		String result = "";
		Borrow borrowinfo = new Borrow();
		List<Borrow> list = borrowService.findBorrow(borrowinfo, 1,
				Integer.MAX_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(list.size());
			result = mapper.writeValueAsString(list);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping("editborrowinfo")
	@ResponseBody
	public String editBorrowinfo(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Borrow borrowinfo = JSONObject.toJavaObject(object,
						Borrow.class);
				if (object.getBooleanValue("addFlag")) {
					borrowinfo.setBorrowstate("1");
					borrowinfo.setId(CreateId.createId());
					borrowinfo.setBorrowtime(GetTime.getCurrentDateTime());
					borrowinfo.setMangerid(worker.getId());
					s = borrowService.insertOne(borrowinfo);
				} else {
					s = borrowService.updateOne(borrowinfo);
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

	@RequestMapping("delborrowinfo")
	@ResponseBody
	public String delBorrowinfo(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Borrow> borrowinfos = JSONArray.parseArray(jsonString,
					Borrow.class);
			// System.out.println(jsonString);
			for (int i = 0; i < borrowinfos.size(); i++) {
				s = borrowService.deleteOne(borrowinfos.get(i).getId());
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

	@RequestMapping("findborrowout_book")
	@ResponseBody
	public String findBorrowOutBook(HttpServletRequest request,
			HttpSession session) {
		String result = "";
		Borrow borrowinfo = new Borrow();
		List<Borrow> list = borrowService.findBorrow(borrowinfo, 1,
				Integer.MAX_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(list.size());
			result = mapper.writeValueAsString(list);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
