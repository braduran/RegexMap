package com.example.regex.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class RegexMap {
	
	public static void main(String[] args) {
		Map<Pattern, String> map = new LinkedHashMap<>();
		map.put(Pattern.compile("/aaa/([0-9].*)/bbb"), "4444");
		map.put(Pattern.compile("/aaa/bbb/[0-9]"), "3333");
		map.put(Pattern.compile("/aaa/[0-9]"), "2222");
		map.put(Pattern.compile("/aaa/bbb"), "5555");
		map.put(Pattern.compile("/([0-9].*)/bbb"), "7777");
		
		System.out.println("/aaa/11 : " + regex(map, "/aaa/11")); //2222
		System.out.println("/aaa/9087644 : " + regex(map, "/aaa/9087644")); //2222
		System.out.println("/aaa/bbb : " + regex(map, "/aaa/bbb")); //5555
		System.out.println("/aaa/bbb/11 : " + regex(map, "/aaa/bbb/11")); //3333
		System.out.println("/aaa/11/bbb : " + regex(map, "/aaa/11/bbb")); //4444
		System.out.println("/11/bbb : " + regex(map, "/11/bbb")); //7777
	}
	
	public static String regex(Map<Pattern, String> map, String key) {
		return map.entrySet().stream()
				.filter(m -> m.getKey().matcher(key).find())
				.findFirst()
				.map(l -> l.getValue())
				.orElse("NO ENCONTRADO");
	}
}
