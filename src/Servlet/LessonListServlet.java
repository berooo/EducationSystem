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
import Entities.LessonList;

@WebServlet("/LessonListServlet")
public class LessonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=resp.getWriter();
		String lessonNum=req.getParameter("lessonNum");
		String studentNum=req.getParameter("studentNum");
		String action=req.getParameter("action");
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		System.out.println(action);
		if(action.equals("delete")){
			try {
				Statement stat = co.conn.createStatement();
				String sql="delete from lesson where lessonNum ='"+lessonNum+"'";
				stat.executeUpdate(sql);
				System.out.println("删除成功！");
				resp.sendRedirect("ManageCourse");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				pw.print("<script language='JavaScript'>alert('delete error');history.back();</script>");
			}
			
		}
		else if(action.equals("modify")){
			
			req.getSession().setAttribute("action", "modify");
			req.getSession().setAttribute("lessonNum", lessonNum);
			resp.sendRedirect("../Lesson.jsp");
			
		}else if(action.equals("add")){
			req.getSession().setAttribute("action", "add");
			resp.sendRedirect("../Lesson.jsp");
		}else if(action.equals("sturevoke")){
			Statement stat;
			try {
				stat = co.conn.createStatement();
				String sql="delete from stu_choose_lesson where studentNum='"+studentNum+"' and lessonNum='"+lessonNum+"'";
				stat.executeUpdate(sql);
				System.out.println("撤课成功！");
				resp.sendRedirect("DisposeCourse");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(action.equals("stuadd")){
			Statement stat;
			
			try {
				
				stat = co.conn.createStatement();
				String sql="insert into stu_choose_lesson values('"+studentNum+"','"+lessonNum+"')";
				stat.executeUpdate(sql);
				System.out.println("选课成功！");
				resp.sendRedirect("DisposeCourse");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				pw.print("<script language='JavaScript'>history.back();</script>");
				System.out.println("...");
			}
			
		}
		
	}
}
