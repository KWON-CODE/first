package org.zerock.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import org.zerock.domain.MemberVO;
import org.zerock.domain.TestVO;

@Controller
@RequestMapping("/sample/*") //@WEbServlet("/sample/*")
@Slf4j
public class TestController {
	@RequestMapping(value="/test", method={RequestMethod.GET,RequestMethod.POST})
	public void test() {
		log.info("test...");
	}
	
	@RequestMapping(value="/testPage", method={RequestMethod.GET,RequestMethod.POST})
	public String testPage() {
		log.info("test...");
		
		return"testPage";
	}
	
	@RequestMapping("/testGet") //get諛⑹떇�쑝濡� �씤�떇
	public void testGet() {
		log.info("testGet.....");
	}
	
	@GetMapping("/getMap")
	public void getMap() {
		log.info("only get()...");
	}
	
	@GetMapping("/testVO")
	public void testVO(MemberVO vo) {
		log.info("MemberVO:"+vo);
	}
	
	@GetMapping("/param")
	public String param(@RequestParam("name") String name, @RequestParam("email") String email) {
		log.info("name:"+name);
		log.info("email:"+email);
		
		return "result";
	}
	
	@GetMapping("/listTest")
	public String listTest(@RequestParam("idx")ArrayList<String> idx) {
		 log.info("idx:"+idx);
		 
		return "listTest";
	}
	
	@GetMapping("/testVO2")
	public String testVO2(TestVO vo, @ModelAttribute("page") int page) {
		log.info("vo:"+vo);
		log.info("page:"+page);
		
		return "/sample/testVO2";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05......");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody TestVO ex06() {
		TestVO vo=new TestVO();
		vo.setName("spring");
		vo.setAge(21);
		
		return vo;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("ex07...............ex07");
		
		String msg= "{\"name\":\"�솉湲몃룞\"}";
		org.springframework.http.HttpHeaders header=new org.springframework.http.HttpHeaders();
		header.add("content-Type","application/json;charset=UTF-8");
		
		return new ResponseEntity<String> (msg,header,HttpStatus.OK);
	}
	
}











