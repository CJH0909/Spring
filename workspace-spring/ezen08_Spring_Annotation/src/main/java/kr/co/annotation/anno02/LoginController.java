package kr.co.annotation.anno02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	@RequestMapping(value= {"/anno/loginForm.do", "anno/loginForm2.do"}, method = {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginFrm");
		return mav;
	}

}
