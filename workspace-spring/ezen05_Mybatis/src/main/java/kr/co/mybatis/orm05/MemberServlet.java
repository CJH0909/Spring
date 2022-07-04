package kr.co.mybatis.orm05;

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


@WebServlet("/mem5.do")
public class MemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		
		String action = request.getParameter("action");
		String forwardPage = "";
		
		if(action==null || action.equals("membersList")){
			List<MemberDTO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			forwardPage="orm5/listMembers.jsp";
		}
		else if(action.equals("deleteMember")) {
			String id = request.getParameter("id");
			dao.deleteMember(id);
			forwardPage = "mem5.do?action=membersList";
			
		}
		request.getRequestDispatcher(forwardPage).forward(request, response);
		
	}
}
