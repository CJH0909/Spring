package kr.co.springmybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import kr.co.springmybatis.dto.MemberDTO;
import kr.co.springmybatis.service.MemberService;

public class MemberControllerImpl extends MultiActionController implements MemberController {

	private MemberService memberService;
	
	// memberService 빈을 주입하기 위해 setter() 구현
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 브라우저에서의 요청명에서 확장명 .do를 제외한 뷰이름을 가져옴 */
		String viewName = getViewName(request);
		List<MemberDTO> membersList = memberService.listMembers();
				
		ModelAndView mav = new ModelAndView(viewName);
		// 조회한 회원 정보를 ModelAndView의 addObject() 이용해 바인딩함
		mav.addObject("membersList", membersList);
		return mav;
	}

	// http://localhost:8080/springmybatis/member/listMembers.do
	// request 객체에서 URL 요청명을 가져와 .do를 제외한 요청을 구함
	private String getViewName(HttpServletRequest request) {

		String contextPath = request.getContextPath();
		//주소창의 현재 uri 받아오기
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		
		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		
		String filename = uri.substring(begin, end);
		if (filename.indexOf(".") != -1) {
			filename = filename.substring(0, filename.lastIndexOf("."));
		}
		
		if (filename.indexOf("/") != -1) {
			filename = filename.substring(filename.lastIndexOf("/"), filename.length());
		}
				
		return filename;
	}
	
	
}












