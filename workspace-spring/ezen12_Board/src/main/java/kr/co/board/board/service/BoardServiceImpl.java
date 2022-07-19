package kr.co.board.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.co.board.board.dao.BoardDAO;
import kr.co.board.board.dto.ArticleDTO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<ArticleDTO> listArticles() throws Exception {
	
		List<ArticleDTO> ariclesList = boardDAO.selectAllArticlesList();
		return ariclesList;
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		// dao 호출
		int articleNo = boardDAO.insertNewArticle(articleMap);
		articleMap.put("articleNo", articleNo);
		
		boardDAO.insertNewImage(articleMap);
		
		return articleNo;
	}

}



















