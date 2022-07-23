package kr.co.ezenStore.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import kr.co.ezenStore.member.dto.MemberDTO;

public interface MemberController {

	public ResponseEntity<MemberDTO> addMember(MemberDTO member, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ResponseEntity<String> duplicateCheck(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
