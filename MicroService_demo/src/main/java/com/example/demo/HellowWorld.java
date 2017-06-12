package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.UserProperties;

@RestController
public class HellowWorld {
	
	@Autowired
	private UserProperties up;
	
	@Value("${demo.test}")
	private String test;
	
	@RequestMapping(value = "/hw")
	public String HelloWorld(){
		return "Hello World!!!!";
	}
	
	@RequestMapping(value = "/find")
	public Map<String,String> find(){
		Map<String,String> map = new HashMap<>();
		map.put("name", "Terry");
		map.put("age", "32");
		map.put("test", test);
		return map;
	}
	
	@RequestMapping(value = "/findUser")
	public Map<String,String> findUser(){
		Map<String,String> map = new HashMap<>();
		map.put("name", up.getName());
		map.put("age", String.valueOf(up.getAge()));
		map.put("id", up.getId());
		return map;
	}
}
