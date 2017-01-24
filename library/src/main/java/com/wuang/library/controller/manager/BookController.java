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
import com.wuang.library.dao.model.Book;
import com.wuang.library.dao.model.Magazine;
import com.wuang.library.dao.model.Worker;
import com.wuang.library.service.manager.IBookService;
import com.wuang.library.service.manager.IMagazineService;
import com.wuang.library.utils.CreateId;
import com.wuang.library.utils.GetTime;

@Controller
public class BookController {

	private static final String SUCCESS = "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
	private static final String FAILS = "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";

	@Autowired
	IBookService bookService;
	@Autowired
	IMagazineService magazineService;

	@RequestMapping("magazine")
	public String bookClass() {
		return "manager/book/magazine";
	}

	@RequestMapping("bookinfo")
	public String bookInfo() {
		return "manager/book/bookinfo";
	}

	@RequestMapping("findbook")
	@ResponseBody
	public String findBook(HttpServletRequest request, HttpSession session) {
		String result = "";
		Book book = new Book();
		List<Book> list = bookService.findBook(book, 1, Integer.MAX_VALUE);
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

	@RequestMapping("editbook")
	@ResponseBody
	public String editBook(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Book book = JSONObject.toJavaObject(object, Book.class);
				if (object.getBooleanValue("addFlag")) {
					book.setCreatetime(GetTime.getCurrentDateTime());
					book.setCreateid(worker.getId());
					s = bookService.insertOne(book);
				} else {
					s = bookService.updateOne(book);
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

	@RequestMapping("delbook")
	@ResponseBody
	public String delbook(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Book> books = JSONArray.parseArray(jsonString, Book.class);
			// System.out.println(jsonString);
			for (int i = 0; i < books.size(); i++) {
				s = bookService.deleteOne(books.get(i).getId());
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

	@RequestMapping("findmagazine")
	@ResponseBody
	public String findMagazine(HttpServletRequest request, HttpSession session) {
		String result = "";
		Magazine magazine = new Magazine();
		List<Magazine> list = magazineService.findMagazine(magazine, 1,
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

	@RequestMapping("editmagazine")
	@ResponseBody
	public String editMagazine(HttpServletRequest request, HttpSession session) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			Worker worker = (Worker) session.getAttribute("AdminSession");
			System.out.println(jsonString);
			JSONArray jsonArray = JSONArray.parseArray(jsonString);
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				Magazine magazine = JSONObject.toJavaObject(object,
						Magazine.class);
				if (object.getBooleanValue("addFlag")) {
					magazine.setMagazinestate("1");
					magazine.setId(CreateId.createId());
					magazine.setCreatetime(GetTime.getCurrentDateTime());
					magazine.setCreateid(worker.getId());
					s = magazineService.insertOne(magazine);
				} else {
					s = magazineService.updateOne(magazine);
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

	@RequestMapping("delmagazine")
	@ResponseBody
	public String delMagazine(HttpServletRequest request) {
		boolean s = false;
		try {
			String jsonString = request.getParameter("json");
			List<Magazine> magazines = JSONArray.parseArray(jsonString,
					Magazine.class);
			// System.out.println(jsonString);
			for (int i = 0; i < magazines.size(); i++) {
				s = magazineService.deleteOne(magazines.get(i).getId());
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
