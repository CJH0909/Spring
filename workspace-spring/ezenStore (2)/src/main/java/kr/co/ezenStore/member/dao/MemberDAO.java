package kr.co.ezenStore.member.dao;

import org.springframework.dao.DataAccessException;

import kr.co.ezenStore.member.dto.MemberDTO;

public interface MemberDAO {

	public String selectDuplicateCheck(String id) throws DataAccessException;
	public int insertMember(MemberDTO memberDTO) throws DataAccessException;

}
