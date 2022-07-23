package kr.co.test.member.dao;

import org.springframework.dao.DataAccessException;

import kr.co.test.member.dto.MemberDTO;

public interface MemberDAO {
	public int insertNewMember(MemberDTO memberDTO) throws DataAccessException;
	public String selectDuplicateCheck(String id) throws DataAccessException;

}
