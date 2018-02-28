package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.ConnectOracle;
import Entities.Lesson;
import Entities.Student;

/**
 * Servlet implementation class ReadStudentList
 */
@WebServlet("/ReadStudentList")
public class ManageStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherNum=(String) request.getSession().getAttribute("teacherNum");

		List<Student> StudentList=new ArrayList<Student>();
		List<String> lessonNum=new ArrayList<String>();
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			
			String sql="select s.studentNum,s.studentName,s.sex,s.class,l.lessonNum " +
					"from student s,lesson l,stu_choose_lesson stu,teacher t " +
					"where s.studentNum=stu.studentNum and l.lessonNum=stu.lessonNum and " +
					"l.teacherNum=t.teacherNum and t.teacherNum='"+teacherNum+"'";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				Student ls=new Student();
				ls.setStudentNum(rs.getString("studentNum"));
				ls.setStudentName(rs.getString("studentName"));
				ls.setSex(rs.getString("sex"));
				ls.setStuclass(rs.getString("class"));
				StudentList.add(ls);
				
				lessonNum.add(rs.getString("lessonNum"));
			}
            request.getSession().setAttribute("studentList", StudentList);
            request.getSession().setAttribute("lessonNum", lessonNum);
            response.sendRedirect("../teacher_manageStudentList.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
