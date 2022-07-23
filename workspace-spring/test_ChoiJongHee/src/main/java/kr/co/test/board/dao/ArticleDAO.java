package kr.co.test.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import kr.co.test.board.dto.ArticleDTO;

public interface ArticleDAO {
	public List<ArticleDTO> selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(ArticleDTO articleDTO) throws DataAccessException; 
	public int getNewArticleNO() throws DataAccessException;
}
