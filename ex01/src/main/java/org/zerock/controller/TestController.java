package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MemberVo;
import org.zerock.domain.TestVO;

//import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*") //@WebServlet("/sample/*")
//@Log4j
@Slf4j

public class TestController {
	@RequestMapping(value="/test", method={RequestMethod.GET,RequestMethod.POST})
	public void test() {
		log.info("test..");
	}
	@RequestMapping(value="/testPage", method={RequestMethod.GET,RequestMethod.POST})
	public String testPage() {
		log.info("test....");
	
		return "testPage";
	}
	@RequestMapping("/testGet")
	public void testGet() {
		log.info("testGet......");
		
	}
	
	@GetMapping("/getMap")
	public void getMap() {
		log.info("only get()......");
		
	}
	@GetMapping("/testVO")
	public void testVO(MemberVo vo) {
		log.info("MemberVO:"+vo);
	}
	
	@GetMapping("/param") 
	public String param(@RequestParam("name") String name,
			@RequestParam("email") String email){
		log.info("name:" + name);
		log.info("email:"+email);
		
		return "result";
			
	}
	@GetMapping("/listTest")
	public String listTest(@RequestParam("idx")ArrayList<String> idx) {
		log.info("idx:"+idx);
		return "listTest";
	}
	
	@GetMapping("/testVO2")
	public String testVO2(TestVO vo, @ModelAttribute("page")int page) {
		log.info("vo:"+vo);
		log.info("page:"+page);
		return "/sample/testVO2";
	}
	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05.............");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody TestVO ex06() {

		TestVO vo = new TestVO();
		vo.setName("spring");
		vo.setAge(24);
		
		return vo;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("ex07..............ex01........");
		String msg="{\"\":\"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("content-Type","application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg,header,HttpStatus.OK);
		
	}
	
	
}
