package kr.co.ezenStroe.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository()
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public String selectDuplicateCheck(String id) {
		String result = sqlSession.selectOne("mapper.member.duplicatecheck", id);
		return result;
	}

}
