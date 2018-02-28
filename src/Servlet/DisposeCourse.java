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

/**
 * Servlet implementation class DisposeCourse
 */
@WebServlet("/DisposeCourse")
public class DisposeCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisposeCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNum=(String) request.getSession().getAttribute("studentNum");
		List<Lesson> clessonList=new ArrayList<Lesson>();
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			String sql="select * from lesson " +
					"where lessonNum in" +
					" (select lessonNum from stu_choose_lesson where studentNum='"+studentNum+"')";
			System.out.println(sql);
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				Lesson ls=new Lesson();
				ls.setLessonNum(rs.getString("lessonNum"));
				ls.setLessonName(rs.getString("lessonName"));
				ls.setYear(rs.getString("year"));
				ls.setTerm(rs.getString("term"));
				ls.setCredit(rs.getInt("credit"));
				ls.setTeacherNum(rs.getString("teacherNum"));
				ls.setBeforelessonNum(rs.getString("BeforeLessonNum"));
				clessonList.add(ls);
			}
            request.getSession().setAttribute("clessonList", clessonList);
            response.sendRedirect("../student_disposeCouse.jsp");
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
