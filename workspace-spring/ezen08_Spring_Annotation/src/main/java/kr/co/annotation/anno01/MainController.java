package kr.co.annotation.anno01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController") 	//@Controller 애너테이션 이용해 MainController 클래스를 빈으로 자동 변환함. 빈 id는 mainController
@RequestMapping("/anno")		//@RequestMapping을 이용해 첫번째 단계의 RUL 요청이 /anno이면  mainController 빈을 요청함
public class MainController {
	
	@RequestMapping("/main1.do")
	public ModelAndView ezen1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "이젠아카데미");
		mav.setViewName("main");
		return mav;
	}
	

}
