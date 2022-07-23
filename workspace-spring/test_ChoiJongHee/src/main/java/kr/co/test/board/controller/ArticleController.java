package kr.co.test.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import kr.co.test.board.dto.ArticleDTO;

public interface ArticleController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity<ArticleDTO> addNewArticle(ArticleDTO articleDTO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
