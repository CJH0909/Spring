package kr.co.test.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.test.member.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewMember(MemberDTO memberDTO) throws DataAccessException {
		int result;
		result = sqlSession.insert("mapper.member.insertNewMember", memberDTO);
		return result;
	}
	
	@Override
	public String selectDuplicateCheck(String id) throws DataAccessException {
		String result = sqlSession.selectOne("mapper.member.duplicatecheck", id);
		return result;
	}
}
