package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.ConnectOracle;

@WebServlet("/StudentListServlet")
public class studentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lessonNumb=req.getParameter("lessonNum");
		String studentNum=req.getParameter("studentNum");
		ConnectOracle co=new ConnectOracle();
		co.getCon();
			try {
				Statement stat=co.conn.createStatement();
				String sql="delete from stu_choose_lesson where lessonNum='"+lessonNumb+"' and studentNum='"+studentNum+"'";
				System.out.println(sql);
				stat.executeUpdate(sql);
				System.out.println("ÒÆ³ý³É¹¦£¡");
				resp.sendRedirect("ManageStudentList");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
