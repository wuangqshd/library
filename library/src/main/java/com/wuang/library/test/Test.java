package com.wuang.library.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.wuang.library.entry.SecoundMenu;
import com.wuang.library.entry.ThridMenu;

public class Test {
	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		List<ThridMenu> children = new ArrayList<ThridMenu>();
		for (int i = 0; i < 10; i++) {
			ThridMenu e = new ThridMenu(" " + i, "第" + i + "个", "sdf", "ddd");
			children.add(e);
		}
		List<SecoundMenu> resutls = new ArrayList<SecoundMenu>();
		for (int i = 0; i < 3; i++) {
			SecoundMenu secoundMenu = new SecoundMenu("123", children);
			resutls.add(secoundMenu);
		}
		ObjectMapper mapper = new ObjectMapper();
		String res = mapper.writeValueAsString(resutls);
		System.out.println(res);

	}
}
