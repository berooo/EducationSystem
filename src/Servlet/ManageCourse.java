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
import Entities.LessonList;

/**
 * Servlet implementation class ManageCourse
 */
@WebServlet("/ManageCourse")
public class ManageCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherNum=(String) request.getSession().getAttribute("teacherNum");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		LessonList lslst=new LessonList();
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			String sql="select * from lesson where teacherNum = '"+teacherNum+"'";
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
				lslst.addLesson(ls);
			}
            request.getSession().setAttribute("lessonList", lslst);
            response.sendRedirect("../teacher_manageCourse.jsp");
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
