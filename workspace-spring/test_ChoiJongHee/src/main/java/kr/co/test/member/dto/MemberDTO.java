package kr.co.test.member.dto;

import org.springframework.stereotype.Component;

@Component("memberDTO")
public class MemberDTO {
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_gender;
	private String member_nickname;
	private String member_email1;
	private String member_email2;
	private String member_birth_y;
	private String member_birth_m;
	private String member_birth_d;
	private String member_hp1;
	private String member_hp2;
	private String member_hp3;
	private String joindate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getMember_email1() {
		return member_email1;
	}

	public void setMember_email1(String member_email1) {
		this.member_email1 = member_email1;
	}

	public String getMember_email2() {
		return member_email2;
	}

	public void setMember_email2(String member_email2) {
		this.member_email2 = member_email2;
	}

	public String getMember_birth_y() {
		return member_birth_y;
	}

	public void setMember_birth_y(String member_birth_y) {
		this.member_birth_y = member_birth_y;
	}

	public String getMember_birth_m() {
		return member_birth_m;
	}

	public void setMember_birth_m(String member_birth_m) {
		this.member_birth_m = member_birth_m;
	}

	public String getMember_birth_d() {
		return member_birth_d;
	}

	public void setMember_birth_d(String member_birth_d) {
		this.member_birth_d = member_birth_d;
	}

	public String getMember_hp1() {
		return member_hp1;
	}

	public void setMember_hp1(String member_hp1) {
		this.member_hp1 = member_hp1;
	}

	public String getMember_hp2() {
		return member_hp2;
	}

	public void setMember_hp2(String member_hp2) {
		this.member_hp2 = member_hp2;
	}

	public String getMember_hp3() {
		return member_hp3;
	}

	public void setMember_hp3(String member_hp3) {
		this.member_hp3 = member_hp3;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	

}