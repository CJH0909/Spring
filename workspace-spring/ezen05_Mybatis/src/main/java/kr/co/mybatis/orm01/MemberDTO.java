package kr.co.mybatis.orm01;

import java.sql.Date;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joindate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(String id, String pwd,String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.id = name;
		this.id = email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
}
