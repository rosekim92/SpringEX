package com.kjm.myapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kjm.myapp.model.Book;
import com.kjm.myapp.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BookService bs;
	
	private ModelAndView mv = new ModelAndView();
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<Book> list = bs.findAllList();
		mv.addObject("bsList", list);
		
		mv.setViewName("bclist");
		
		return mv;
	}
	
	@RequestMapping(value = "/bcInsert", method = RequestMethod.GET)
	public ModelAndView bcInsert(HttpServletRequest request, HttpServletResponse response){
		logger.info("BCManagement Insert controller");
		return mv;
	}
	@RequestMapping(value = "/bcInsert", method = RequestMethod.POST)
	public ModelAndView bcInsertPost(HttpServletRequest request, HttpServletResponse response){
		logger.info("BCManagement Insert controller");
		
		System.out.println("값오나체크 : " + request.getParameter("company"));
		
		Book bc = new Book();
		bc.setCompany(request.getParameter("company"));
		bc.setName(request.getParameter("name"));
		bc.setRank(request.getParameter("rank"));
		bc.setPhone(request.getParameter("phone"));
		bc.setEmail(request.getParameter("email"));
		bc.setCp_addr(request.getParameter("cp_addr"));
		
		System.out.println("디비 : "+bc.getCompany());
		
		bs.insertBC(bc);
		System.out.println("insert success");
		
		List<Book> list = bs.findAllList();
		mv.addObject("bsList", list);
		
		response.setHeader("Refresh", "0; URL=/");
		
		mv.setViewName("bclist");
		
		return mv;
	}
	
	
	@RequestMapping(value = "/bcDelete", method = RequestMethod.GET)
	public ModelAndView bcDeleteGet(HttpServletRequest request, HttpServletResponse response){
		logger.info("BCManagement Insert controller");
		return mv;
	}
	@RequestMapping(value = "/bcDelete", method = RequestMethod.POST)
	public ModelAndView bcDelete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam int id){
		logger.info("BCManagement Insert controller");
		logger.info("넘어온 id" + id);
		
		bs.deleteByNum(id);
		
		logger.info("삭제성공");
		
		mv.setViewName("bclist");
		return mv;
	}
	
	@RequestMapping("/bcSeeView")
	public String seeView(int num,Model model){
		Book bsSee=bs.getBctableByNum(num);
		model.addAttribute("seeinfo",bsSee);
		return "bclistDetail";
	}
	
	
	@RequestMapping(value = "/bcUpdate", method = RequestMethod.GET)
	public ModelAndView bcUpdate(HttpServletRequest request, HttpServletResponse response){
		logger.info("BCManagement Update controller");
		return mv;
	}
	@RequestMapping(value = "/bcUpdate", method = RequestMethod.POST)
	public ModelAndView bcUpdatePost(HttpServletRequest request, HttpServletResponse response){
		logger.info("BCManagement Update controller");
		
		System.out.println("값오나체크 : " + request.getParameter("upCompany"));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("company", request.getParameter("upCompany"));
		map.put("name", request.getParameter("upName"));
		map.put("rank", request.getParameter("upRank"));
		map.put("phone", request.getParameter("upPhone"));
		map.put("email", request.getParameter("upEmail"));
		map.put("cp_addr", request.getParameter("upCp_addr"));
		map.put("bc_num", request.getParameter("upBcNum"));
		
		bs.bcUpdateByNum(map);
		
		response.setHeader("Refresh", "0; URL=/");
		
		mv.setViewName("bclist");
		
		return mv;
	}
}
