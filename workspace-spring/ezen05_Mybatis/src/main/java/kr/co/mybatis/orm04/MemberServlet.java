package kr.co.mybatis.orm04;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mybatis.orm01.MemberDTO;

@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		MemberDAO dao = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		String action = request.getParameter("action");
		String forwardPage = "";
		
		if(action ==null||action.equals("listmembers")) {
			List<MemberDTO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			forwardPage="orm1/listmembers.jsp";
		}
		else if(action.equals("selectMemberById")){
			String id = request.getParameter("value");
			memberDTO = dao.selectMemberById(id);
			request.setAttribute("memberDTO", memberDTO);
			forwardPage="orm3/memberInfo.jsp";
		}else if(action.equals("selectMemberByPwd")){
			String pwd = request.getParameter("value");
			List<MemberDTO> membersList = dao.selectMemberByPwd(pwd);
			request.setAttribute("membersList", membersList);
			forwardPage="orm3/listmembers.jsp";
		}else if(action.equals("insertMember")){
			MemberDTO dto = new MemberDTO();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setEmail(email);
			
			//회원 가입창에서 전송된 회원 정보를 memberDTO에 설정한 후 insertMember()메서드로 전달함
			dao.InsertMember(dto);
			forwardPage="/mem4.do?action=listmembers";
		}else if(action.equals("insertMember2")) {
			Map<String, String> memberMap = new HashMap<>();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			//회원가입창에서 전송된 회원 정보를 HashMap에
			//key/value 로 저장한 후 MemberDAO의 insertMember2()의 인자로 전달함
			memberMap.put("id", id);
			memberMap.put("pwd", pwd);
			memberMap.put("name", name);
			memberMap.put("email", email);
			
			dao.InsertMember2(memberMap);
			forwardPage="/mem4.do?action=listmembers";	
		}else if(action.equals("updateMember")) {
			MemberDTO dto = new MemberDTO();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setEmail(email);
			int result = dao.updateMember(dto);
		
			forwardPage="/mem4.do?action=listmembers";	
		}
		
		request.getRequestDispatcher(forwardPage).forward(request, response);

	}
	
}
