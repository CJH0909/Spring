package kr.co.ezenStore.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ezenStore.member.dto.MemberDTO;

@Repository()
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public String selectDuplicateCheck(String id) {
		String result = sqlSession.selectOne("mapper.member.duplicatecheck", id);
		return result;
	}
	
	@Override
	public int insertMember(MemberDTO memberDTO) {
		int result = sqlSession.insert("mapper.member.insertMember",memberDTO);
		return result;
	}

}
