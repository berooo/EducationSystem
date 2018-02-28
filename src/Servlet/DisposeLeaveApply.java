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
import Entities.Leave_apply;


/**
 * Servlet implementation class DisposeLeaveApply
 */
@WebServlet("/DisposeLeaveApply")
public class DisposeLeaveApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisposeLeaveApply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherNum=(String) request.getSession().getAttribute("teacherNum");
		List<Leave_apply> leaveApplyList=new ArrayList<Leave_apply>();
		ConnectOracle co=new ConnectOracle();
		co.getCon();
		try {
			Statement stat=co.conn.createStatement();
			String sql="select * from leave_apply where teacherNum = '"+teacherNum+"'";
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				Leave_apply ls=new Leave_apply();
				ls.setApplyNum(rs.getString("applyNum"));
				ls.setApplyTime(rs.getDate("applyTime"));
				ls.setReason(rs.getString("reason"));
				ls.setState(rs.getString("state"));
				ls.setStudentNum(rs.getString("studentNum"));
				ls.setLessonNum(rs.getString("lessonNum"));
				ls.setTeacherNum(rs.getString("teacherNum"));
				leaveApplyList.add(ls);
			}
            request.getSession().setAttribute("leaveApplyList", leaveApplyList);
            response.sendRedirect("../teacher_disposeLeaveApply.jsp");
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
