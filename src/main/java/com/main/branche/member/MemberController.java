package com.main.branche.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.branche.util.Naver;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@GetMapping("/test")
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/member/test");
		return modelAndView;
	}
	
	@GetMapping("/getNaverData")
	public ModelAndView getMemberList() {
		ModelAndView modelAndView = new ModelAndView();
		
		// Client ID, Client Secret ,search
		String datas = Naver.getShoppingData(null, null, "노트북");
		// -------------------------------------
		
		modelAndView.addObject("result", datas);
		modelAndView.setViewName("/common/ajaxResult");
		return modelAndView;
	}
}
