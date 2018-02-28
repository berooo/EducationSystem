package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.ConnectOracle;

@WebServlet("/LessonServlet")
public class LessonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		String lessonNum,lessonName,year,term,teacherNum,beforelessonNum,submitvalue;
		PrintWriter out = resp.getWriter();
		int credit;
		lessonNum=req.getParameter("lessonNum");
		lessonName=req.getParameter("lessonName");
		year=req.getParameter("year");
		term=req.getParameter("term");
		teacherNum=req.getParameter("teacherNum");
		System.out.println(teacherNum);
		beforelessonNum=req.getParameter("beforelessonNum");
		credit=Integer.parseInt(req.getParameter("credit"));
		submitvalue=req.getParameter("submit");
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.getCon().createStatement();
			System.out.println(submitvalue);
			if(submitvalue.equals("add")){
			String sql="insert into lesson values('"+lessonNum+"','"+lessonName+"','"+year+"','"+term+"',"+credit+",'"+teacherNum+"','"+beforelessonNum+"')";
			stat.executeUpdate(sql);
			System.out.println("添加成功");
			
            out.print("<script language='JavaScript'>alert('添加课程成功');history.back();</script>");
			resp.sendRedirect("ManageCourse");
			}else if(submitvalue.equals("update")){
			String sql="update lesson set lessonName='"+lessonName+"',year='"+year+"',term='"+term+"',credit='"+credit+"',teacherNum='"+teacherNum+"',beforelessonNum='"+beforelessonNum+"' where lessonNum='"+lessonNum+"'";	
			stat.executeUpdate(sql);
			System.out.println("更新成功");
			out.print("<script language='JavaScript'>alert('更新课程成功');history.back();</script>");
			resp.sendRedirect("ManageCourse");
			}
			co.closed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		
	}
}
