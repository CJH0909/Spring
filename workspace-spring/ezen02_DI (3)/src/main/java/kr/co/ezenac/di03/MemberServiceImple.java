package kr.co.ezenac.di03;

import kr.co.ezenac.di.PersonService;

public class MemberServiceImple implements MemberService {

	//주입되는 빈을 저장할 MemberDAO 타입의 속성 선언
	private MemberDAO memberDAO;
	
	//설정파일에서 memberDAO빈을 생성한 후 setter로 속성 memberDAO에 주입함.
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMembers() {
		memberDAO.listMembers(); 			//주입된 빈을 이용해 listMembers() 메서드 호출 
		
	}


}
