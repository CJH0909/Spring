package kr.co.test.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.test.board.dto.ArticleDTO;

@Repository("articleDAO")
public class ArticleDAOImpl implements ArticleDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ArticleDTO> selectAllArticlesList() throws DataAccessException {
		List<ArticleDTO> articleList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articleList;
	}
	@Override
	public int insertNewArticle(ArticleDTO articleDTO) throws DataAccessException {
			int articleNO = getNewArticleNO();
			articleDTO.setUser_board_idx(articleNO);
			int result = sqlSession.insert("mapper.board.insertNewArticle", articleDTO);
		return result;
	}
	
	@Override
	public int getNewArticleNO() throws DataAccessException {
		int result = sqlSession.selectOne("mapper.board.getNewArticleNO");
		return result;
	}
}
