package kr.co.board.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import kr.co.board.board.dto.ArticleDTO;
import kr.co.board.board.dto.ImageDTO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ArticleDTO> selectAllArticlesList() throws DataAccessException {
		List<ArticleDTO> articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}

	// 글정보를 게시판 테이블(T-BOARD)에 추가한 후 글 번호를 반환함
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		
		sqlSession.insert("mapper.board.insertNewArticle", articleMap);		
		return articleNO;
	}

	// 기게시글 번호의 MAX값 + 1 구함
	private int selectNewArticleNO() {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}

	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		
		List<ImageDTO> imageFileList = (List<ImageDTO>) articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");		// articleMap이 글 번호를 가져옴
		
		int imageFileNO = selectNewImageFileNO();					// 이미지 번호를 가져옴
		
		if (imageFileList != null && imageFileList.size() != 0) {
			// ImageDTO 객체를 차례대로 가져와 이미지번호와 글번호 속성을 설정함
			for (ImageDTO imageDTO : imageFileList) {
				imageDTO.setImageFileNO(++imageFileNO);
				imageDTO.setArticleNO(articleNO);
			}
			
			//T_IMAGEFILE 테이블에 INSERT
			sqlSession.insert("mapper.board.insertNewImage", imageFileList);
		}		
		
	}

	private int selectNewImageFileNO() {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}

	@Override
	public ArticleDTO selectArticle(int articleNO) throws DataAccessException {
		
		return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
	}

	@Override
	public List<ImageDTO> selectImageFileList(int articleNO) throws DataAccessException {
	
		List<ImageDTO> imageFileList = sqlSession.selectList("mapper.board.selectImageFileList", articleNO);
		
		return imageFileList;
	}

}















