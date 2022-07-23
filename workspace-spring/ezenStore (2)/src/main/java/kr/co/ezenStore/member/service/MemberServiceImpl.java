package kr.co.ezenStore.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ezenStore.member.dao.MemberDAO;
import kr.co.ezenStore.member.dto.MemberDTO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String duplicateCheck(String id) throws Exception {
		
		return memberDAO.selectDuplicateCheck(id);
	}
	
	@Override
	public int insertNewMember(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.insertMember(memberDTO);
		return result;
	}
}
