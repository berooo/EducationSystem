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

@WebServlet("/LeaveApplyServlet")
public class LeaveApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String applyNum=req.getParameter("applyNum");
			String act=req.getParameter("act");
			ConnectOracle co=new ConnectOracle();
			co.getCon();
			Statement stat1=co.conn.createStatement();
	
			if(act.equals("success")){
				String sql1="update leave_apply set state='审核已通过' where applyNum='"+applyNum+"'";
				stat1.executeUpdate(sql1);
				resp.sendRedirect("DisposeLeaveApply");
			}else if(act.equals("fail")){
				String sql2="update leave_apply set state='审核未通过' where applyNum='"+applyNum+"'";
				stat1.executeUpdate(sql2);
				resp.sendRedirect("DisposeLeaveApply");
			}
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
