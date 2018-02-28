package Entities;

import java.util.Date;

public class Leave_apply {
	private String applyNum;
	private Date applyTime;
	private String reason;
	private String state;
	private String studentNum;
	private String LessonNum;
	private String TeacherNum;
	public String getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(String applyNum) {
		this.applyNum = applyNum;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	public String getLessonNum() {
		return LessonNum;
	}
	public void setLessonNum(String lessonNum) {
		LessonNum = lessonNum;
	}
	public String getTeacherNum() {
		return TeacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		TeacherNum = teacherNum;
	}
	
	
}
