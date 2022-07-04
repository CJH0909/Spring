package kr.co.mybatis.orm01;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {

	public static SqlSessionFactory sqlMapper= null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			String resource = "mybatis/sqlMapConfig.xml";
			
			try {
				Reader reader = Resources.getResourceAsReader(resource); //설정정보 읽어
				
				//마이바티스 이용하는 sqlSessionFactory 객체 가져옴
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<MemberDTO> selectAllMemberList(){
		sqlMapper = getInstance();
		
		//member.xml의 쿼리문을 호출하는데 필요한 SqlSession 객체 가져옴
		SqlSession session = sqlMapper.openSession();
		
		//여러 개 레코드를 조회하므로 selectList()실행
		List<MemberDTO>memList = session.selectList("mapper.member.selectAllMemberList");
		return memList;
		
	}
}
