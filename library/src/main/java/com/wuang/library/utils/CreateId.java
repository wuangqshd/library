package com.wuang.library.utils;

import java.util.Random;
import java.util.UUID;

public class CreateId {
	static Random random = new Random();

	public static String createId() {
		String result = "";
		for (int i = 0; i < 3; i++) {
			char c = 'a';
			c += random.nextInt(26);
			result += c;
		}
		result += UUID.randomUUID().toString().substring(30);
		return result;
	}

	public static void main(String[] args) {

		System.out.println(createId());
	}
}
