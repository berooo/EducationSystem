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
import Entities.Message;


/**
 * Servlet implementation class Message
 */
@WebServlet("/Message")
public class Stumessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stumessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNum=(String) request.getSession().getAttribute("studentNum");
	    String newpassword=request.getParameter("newpassword");
	    String action=request.getParameter("action");
		List<Message> messageList=new ArrayList<Message>();
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			if(action.equals("stuupdate")){
			String sql="update student set password='"+newpassword+"' where studentNum='"+studentNum+"'";
			stat.executeUpdate(sql);
			response.sendRedirect("DisposeInformation");
			}else{
			String sql="select * from message where studentNum = '"+studentNum+"'";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				
			Message msg=new Message();
			msg.setApplyNum(rs.getString("applyNum"));
			msg.setMessageNum(rs.getString("messageNum"));
			msg.setStudentNum(rs.getString("studentNum"));
			msg.setContent(rs.getString("content"));
			msg.setTime(rs.getDate("time"));
				messageList.add(msg);
			}
            request.getSession().setAttribute("messageList", messageList);
            response.sendRedirect("../Message.jsp");}
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
