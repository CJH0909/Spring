package kr.co.ezenStroe.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import kr.co.ezenStroe.member.dto.MemberDTO;

public interface MemberController {

		public ResponseEntity<MemberDTO> addMember(MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
			
		public ResponseEntity<String> quplicateCheck(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
