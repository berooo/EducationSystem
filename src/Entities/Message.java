package Entities;

import java.util.Date;

public class Message {
	private String messageNum;
	private String content;
	private String applyNum;
	private String studentNum;
	private Date time;
	
	public String getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(String messageNum) {
		this.messageNum = messageNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
