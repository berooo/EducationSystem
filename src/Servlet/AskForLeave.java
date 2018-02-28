package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.ConnectOracle;

/**
 * Servlet implementation class AskForLeave
 */
@WebServlet("/AskForLeave")
public class AskForLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskForLeave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String studentNum=request.getParameter("studentNum");
		String reason=request.getParameter("reason");
		String lsn=request.getParameter("lsn");
		int count=0;
		String teacherNum="";
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			String sql="select count(*) as num from leave_apply";
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt("num");
				count++;
			}
			sql="select teacherNum from lesson where lessonNum="+lsn;
			rs=stat.executeQuery(sql);
			if(rs.next()){
				teacherNum=rs.getString("teacherNum");
				System.out.println(teacherNum);
			}
			sql="insert into leave_apply values("+count+",sysdate,'"+reason+"','Œ¥…Û∫À','"+studentNum+"','"+lsn+"','"+teacherNum+"')";
			System.out.println(sql);
			stat.executeUpdate(sql);
			response.sendRedirect("../student_main.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pw.print("<script language='JavaScript'>alert('ask for leave error');history.back();</script>");
			System.out.println("...");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
