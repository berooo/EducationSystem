package Entities;

public class Lesson {
	private String lessonNum;
	private String lessonName;
	private String year;
	private String term;
	private int credit;
	private String teacherNum;
	private String beforelessonNum;
	public String getLessonNum() {
		return lessonNum;
	}
	public void setLessonNum(String lessonNum) {
		this.lessonNum = lessonNum;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTerm() {
		return term;
	}
	
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getBeforelessonNum() {
		return beforelessonNum;
	}
	public void setBeforelessonNum(String beforelessonNum) {
		this.beforelessonNum = beforelessonNum;
	}
	
	
}
