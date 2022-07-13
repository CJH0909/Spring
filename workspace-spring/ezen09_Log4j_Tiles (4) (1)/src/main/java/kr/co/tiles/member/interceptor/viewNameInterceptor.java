package kr.co.tiles.member.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//사용자 정의 인터셉터는 반드시 HandlerInterceptorAdapter를 상속받아야 함
public class viewNameInterceptor extends HandlerInterceptorAdapter {
		// 컨트롤러 실행 전 호출됨
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {

				String viewName = getViewName(request);
				
				/*
				 * HttpSession session = request.getSession(); //Locale 속성값을 세션에 저장해
				 * SessionLocaleResolver가 사용할 수 잇게 함 session.setAttribute("viewname", viewName);
				 */
				
				request.setAttribute("viewName", viewName);
			return true;
		}
		private String getViewName(HttpServletRequest request) {

			String contextPath = request.getContextPath();
			int begin = 0;
			if (!((contextPath == null) || ("".equals(contextPath)))) {
				begin = contextPath.length();					//전체 요청명의 길이 
			}		
			
			int end;		
			
			//주소창의 현재 uri 받아오기
			String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
			if(uri == null || uri.trim().equals("")) {
				uri = request.getRequestURI();
			}
					
			
			if (uri.indexOf(";") != -1) {
				end = uri.indexOf(";");
			} else if (uri.indexOf("?") != -1) {
				end = uri.indexOf("?");
			} else {
				end = uri.length();
			}
			
			
			String filename = uri.substring(begin, end);
			System.out.println("filename0:    " + filename);
			
			//  /member/listMembers.do
			if (filename.indexOf(".") != -1) {
				filename = filename.substring(0, filename.lastIndexOf("."));
			}
			
//			
			if (filename.indexOf("/") != -1) {
				//  /member/listMembers.do 요청할 경우 member/listMembers를 파일이름으로 가져옴
				filename = filename.substring(filename.lastIndexOf("/",1), filename.length());
			}		
			
			return filename;
		}
}