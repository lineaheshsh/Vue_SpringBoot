package com.boot.test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.test.vo.Member;

@Component
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public List<Member> selectMembers() {
		return this.sqlSession.selectList("getMember");
	}
}
