package com.boot.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.test.dao.MemberDao;
import com.boot.test.vo.Member;

@Service("memberService")
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public List<Member> selectMembers() {
		return memberDao.selectMembers();		
	}
}
