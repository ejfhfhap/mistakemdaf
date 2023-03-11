package com.main.branche.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> getMemberList(){
		return memberDAO.getMemberList();
	}
}
