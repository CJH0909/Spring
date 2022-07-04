package kr.co.ezenac.di03;

public class MemberServiceImpl implements MemberService{
	
	//주입되는 빈을 저장할 MemberDAO 타입의 속성 선언
	private memberDAO memberDAO;
	
	public void setMemberDAO(memberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	public void listMembers() {
		memberDAO.listMembers();  	 //주입된 빈을 이용해 listMembers()호출
		
	}

}
