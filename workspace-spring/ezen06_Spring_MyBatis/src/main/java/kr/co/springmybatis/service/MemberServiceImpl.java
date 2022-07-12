package kr.co.springmybatis.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.springmybatis.dao.MemberDAO;
import kr.co.springmybatis.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	@Override
	public List<MemberDTO> listMembers() throws DataAccessException {
		List<MemberDTO> membersList = memberDAO.selectAllMemberList();
		return membersList;
	}
	
}
