package kr.co.test.board.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

/*user_board_idx number(10) PRIMARY key
,member_nickname varchar(30)
,title varchar2(50)
,content varchar2(3000)
,postdate DATE DEFAULT sysdate*/
@Component("articleDTO")
public class ArticleDTO {

	private int user_board_idx;
	private String member_nickname;
	private String title;
	private String content;
	private Date postdate;
	
	public ArticleDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_board_idx() {
		return user_board_idx;
	}

	public void setUser_board_idx(int user_board_idx) {
		this.user_board_idx = user_board_idx;
	}

	public String getMember_nickname() {
		return member_nickname;
	}

	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
}
