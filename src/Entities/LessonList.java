package Entities;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBHelper.ConnectOracle;

//�γ��б���
public class LessonList {
	ConnectOracle co;
	
	//�γ̼���
	private List<Lesson> lessons;
	private int size;
	
	public int getSize() {
       size=lessons.size();
		return size;
	}

	public LessonList(){
		
		
			lessons=new ArrayList<Lesson>();
			co=new ConnectOracle();
			co.getCon();
	}
	
	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	//��ӿγ̽��γ��б�
	public boolean addLesson(Lesson l){
		lessons.add(l);
		return true;
	}
	//�ڿγ��б���ɾ���γ�
	public boolean removeLesson(Lesson l){
		lessons.remove(l);
		String lessonNum=l.getLessonNum();
		Statement stat;
		try {
			stat = co.conn.createStatement();
			String sql="delete from lesson where lessonNum ='"+lessonNum+"'";
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
