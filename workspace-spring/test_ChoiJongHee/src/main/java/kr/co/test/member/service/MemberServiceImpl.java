package kr.co.test.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.test.member.dao.MemberDAO;
import kr.co.test.member.dto.MemberDTO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int insertNewMember(MemberDTO memberDTO) throws Exception {
		int result;
		result = memberDAO.insertNewMember(memberDTO);
		return result;
	}
	
	@Override
	public String duplicateCheck(String id) throws Exception {
		
		return memberDAO.selectDuplicateCheck(id);
	}
}
