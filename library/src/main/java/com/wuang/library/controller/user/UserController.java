package com.wuang.library.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuang.library.dao.model.User;
import com.wuang.library.service.manager.IUserService;

@Controller
public class UserController {
	@Autowired
	IUserService userService;

	@RequestMapping("getborrowuserinfo")
	@ResponseBody
	public String getBorrowUserInfo(HttpServletRequest request,
			HttpSession session) {
		String result = "";
		User user = new User();
		List<User> list = userService.findUser(user, 1, Integer.MAX_VALUE);
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
