package kr.co.springmybatis.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import kr.co.springmybatis.dto.MemberDTO;

public interface MemberDAO {

	public List<MemberDTO> selectAllMemberList() throws DataAccessException;
}
