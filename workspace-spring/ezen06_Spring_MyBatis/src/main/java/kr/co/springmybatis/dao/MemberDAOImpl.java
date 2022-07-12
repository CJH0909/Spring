package kr.co.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import kr.co.springmybatis.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<MemberDTO> selectAllMemberList() throws DataAccessException {
	 	List<MemberDTO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");		
		return membersList;
	}
}
