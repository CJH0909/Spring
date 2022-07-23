package kr.co.test.member.service;

import kr.co.test.member.dto.MemberDTO;

public interface MemberService {
	public int insertNewMember(MemberDTO memberDTO) throws Exception;
	public String duplicateCheck(String id) throws Exception;
}
