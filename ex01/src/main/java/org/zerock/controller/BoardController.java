package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j

public class BoardController {
	@Setter(onMethod_=@Autowired)
	private BoardService service;
	@RequestMapping("/list")
	public void list(Model model) {
		log.info("list........");
		model.addAttribute("list",service.getList());
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register" + board);
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	} 
	
	@GetMapping("/get")
	  public void get(@RequestParam("bno") Long bno, Model model) {
	    log.info("/get");
	    model.addAttribute("board", service.get(bno));
	  }
	
	@PostMapping("/modify")
	  public String modify(BoardVO board, RedirectAttributes rttr) {
	    log.info("modify:" + board);
	    if (service.modify(board)) {
	      rttr.addFlashAttribute("result", "success");
	    }
	    return "redirect:/board/list";
	  }


}
/*public class BoardController {
	private static final Logger logger=LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(BoardVO board,Model model) throws Exception{
		logger.info("register get..................");
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	//public String registPOST(BoardVO board,Model model) throws Exception{
	public String registPOST(BoardVO board,RedirectAttributes rttr) throws Exception{
	
		logger.info("register post........");
		logger.info(board.toString());
		
		service.regist(board);
		//model.addAttribute("result", "SUCCESS");
		rttr.addFlashAttribute("msg","SUCCESS");
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="listAll",method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("Show All List......");
		model.addAttribute("list",service.listAll());
		
	}
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno,RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listAll";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {

	   model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

	  logger.info("mod post............");

	  service.modify(board);
	  rttr.addFlashAttribute("msg", "SUCCESS");
	  
	  return "redirect:/board/listAll";
	}

}*/


