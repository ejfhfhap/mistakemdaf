package com.main.branche.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.branche.util.Naver;
import com.main.branche.util.Pager;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/list")
	public ModelAndView getMemberList() {
		ModelAndView modelAndView = new ModelAndView();
		
		List<MemberDTO> memberDTOs = memberService.getMemberList();
		
		modelAndView.addObject("memberDtos", memberDTOs);
		modelAndView.setViewName("/member/list");
		return modelAndView;
	}
	
	
	// ----------------------------------------------------------
	@GetMapping("/test")
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/member/test");
		return modelAndView;
	}
	
	@GetMapping("/getNaverData")
	public ModelAndView getNaverData(Pager pager) {
		ModelAndView modelAndView = new ModelAndView();
		
		pager.setPage(2); // 페이지 번호
		pager.setPerPage(12); // 페이지당 몇개 보여줄지 10~100
		pager.makeRow();
		pager.setSearch("장난감"); // 사용자 검색어
		// Client ID, Client Secret
		String datas = Naver.getShoppingData(null, null, pager);
		// -------------------------------------
		
		modelAndView.addObject("result", datas);
		modelAndView.setViewName("/common/ajaxResult");
		return modelAndView;
	}
}
