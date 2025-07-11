package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;
import org.zerock.service.HelloService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@RequiredArgsConstructor
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@Autowired
	private  HelloService helloService;
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(sdf, false));
	}*/
	
	@GetMapping("/hello")
	public void hello() {
		
		System.out.println(helloService);

		System.out.println(helloService.sayHello());
		
		System.out.println("Hello......................");
		
	}
	@RequestMapping("")
	public void basic() {
		log.info("basic..................");
	}
	@RequestMapping(value="/basic",method = {RequestMethod.GET,RequestMethod.POST})
	public void basicGet() {
		log.info("get..............get...........");
	}
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic only get...................");
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		
		return "ex01";//jsp
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
					   @RequestParam("age") int age) {
		log.info("name:"+name);
		log.info("age:"+age);
		
		return "ex02";
	}
	@GetMapping("/ex02List")
	public String ex0List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: "+ids);
		
		return "ex02List";
	}
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo:"+todo);
		
		return "ex03";
	}
}







