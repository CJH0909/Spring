package kr.co.ezenStore.member.dao;

import kr.co.ezenStore.member.dto.MemberDTO;

public interface MemberDAO {

	public String selectDuplicateCheck(String id);
	public int insertMember(MemberDTO memberDTO);

	

}
