package kr.co.test.board.service;

import java.util.List;

import kr.co.test.board.dto.ArticleDTO;

public interface ArticleService {
	public List<ArticleDTO> listArticles() throws Exception;
	public int addNewArticle(ArticleDTO articleDTO) throws Exception;
}
