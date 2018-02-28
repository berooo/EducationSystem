package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBHelper.ConnectOracle;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		ConnectOracle co=new ConnectOracle();
		try{
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			co.getCon();
			Statement stat=co.conn.createStatement();
			String sql1="select * from teacher where teacherNum ='"+account+"' and password ='"+password+"'";
			String sql2="select * from student where studentNum= '"+account+"' and password ='"+password+"'";
			ResultSet rs=stat.executeQuery(sql1);
			if(rs.next()){
				
				String teacherNum=rs.getString("teacherNum");
				request.getSession().setAttribute("teacherNum", teacherNum);
				co.closed();
				response.sendRedirect("../teacher_main.jsp");
				
			}else{
				rs=stat.executeQuery(sql2);
				if(rs.next()){
	
				String studentNum=rs.getString("studentNum");
				request.getSession().setAttribute("studentNum", studentNum);
				co.closed();
				response.sendRedirect("../student_main.jsp");
				
				}else{
					co.closed();
					pw.print("<script language='JavaScript'>alert('account or password error');history.back();</script>");
					System.out.println("...");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
