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
 * Servlet implementation class DisposeInformation
 */
@WebServlet("/DisposeInformation")
public class DisposeInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisposeInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNum=(String) request.getSession().getAttribute("studentNum");
		List<Student> StudentList=new ArrayList<Student>();
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			String sql="select * from student where studentNum = '"+studentNum+"'";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				
				Student st=new Student();
				st.setStudentNum(rs.getString("studentNum"));
				st.setStudentName(rs.getString("studentName"));
				st.setSex(rs.getString("sex"));
				st.setStuclass(rs.getString("class"));
				st.setPassword(rs.getString("password"));
				st.setIDCard(rs.getString("IDCard"));
				StudentList.add(st);
			}
            request.getSession().setAttribute("studentList", StudentList);
            response.sendRedirect("../student_info.jsp");
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
