package kr.co.test.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.test.board.dto.ArticleDTO;
import kr.co.test.board.service.ArticleService;
import kr.co.test.common.base.BaseController;

@Controller("articleController")
@RequestMapping(value="/board")
public class ArticleControllerImpl extends BaseController implements ArticleController{
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	ArticleDTO articleDTo;
	
	@Override
	@RequestMapping(value="/listArticles")
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<ArticleDTO> articlesList = articleService.listArticles();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesList", articlesList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/addArticle")
	public ResponseEntity<ArticleDTO> addNewArticle(@ModelAttribute("article") ArticleDTO articleDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		articleService.addNewArticle(articleDTO);
		
		String message="";
		message = "<script>";
		message += " alert('게시판에 새 글을 추가했습니다.');";
		message += " location.href='"+request.getContextPath()+"/board/listArticles.do';";
		message += "</script>";
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		ResponseEntity resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		
		return resEnt;
		
	}
	
}
