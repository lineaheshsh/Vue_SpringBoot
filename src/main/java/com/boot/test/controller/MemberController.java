package com.boot.test.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.test.service.MemberService;
import com.boot.test.vo.Member;

@RestController
public class MemberController {

	@Resource(name="memberService")
	MemberService memberService;
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	@ResponseBody
	public List<Member> selectMembers() {
		
		System.out.println("[selectMembers] START");
		
		List<Member> resultVOList = memberService.selectMembers();
		
		if ( resultVOList != null ) {
			System.out.println("size : " + resultVOList.size());
		}
		
		return resultVOList;
	}
}
