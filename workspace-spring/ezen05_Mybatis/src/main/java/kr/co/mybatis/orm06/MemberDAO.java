package kr.co.mybatis.orm06;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.mybatis.orm01.MemberDTO;

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
	
	public String selectName() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String name = session.selectOne("mapper.member.selectName");
		return name;
	}
	
	public String selectPwd() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		String pwd = session.selectOne("mapper.member.selectPwd");
		return pwd;
	}
	
	public MemberDTO selectMemberById(String id){
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberDTO memberDTO = session.selectOne("mapper.member.selectMemberById", id);
		return memberDTO;
	}
	public List<MemberDTO> selectMemberByPwd(String pwd){
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberDTO> membersList = session.selectList("mapper.member.selectMemberByPwd", pwd);
		return membersList;
	}
	
	public int InsertMember(MemberDTO dto) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember", dto); //memberDTO의 값을 전달하여 회원정보 데이터 갱신
		session.commit(); //수동 커밋이므로 반드시 commit() 메서드 호출
		return result;
	}
	public int InsertMember2(Map<String, String> memberMap) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.insert("mapper.member.insertMember", memberMap); //메서드로 전달된 HashMap을 다시 SQL문으로 전달함
		session.commit(); //수동 커밋이므로 반드시 commit() 메서드 호출
		return result;
	}
	public int updateMember(MemberDTO dto) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.update("mapper.member.updateMember", dto);
		session.commit();
		return result;
	}
	public int deleteMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int result = session.delete("mapper.member.deleteMember", id);
		session.commit();
		return result;
		
	}
	
}
