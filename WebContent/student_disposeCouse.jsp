<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<jsp:useBean id="studentNum" class="java.lang.String" scope="session"/>
<script type="text/javascript">

 	function del(lessonNum,studentNum){
 		alert(lessonNum);
 		window.location.href="Servlet/LessonListServlet?lessonNum="+lessonNum+"&studentNum="+studentNum+"&action=sturevoke";
 	}
 	function add(studentNum){
 		
 		var lessonNum=prompt("请输入课程号：");
 		window.location.href="Servlet/LessonListServlet?lessonNum="+lessonNum+"&studentNum="+studentNum+"&action=stuadd";
 	}
 </script>
 <style type="text/css">
 html, body, div, span, object, iframe,
	h1, h2, h3, h4, h5, h6, p, blockquote, pre,
	abbr, address, cite, code,
	del, dfn, em, img, ins, kbd, q, samp,
	small, strong, sub, sup, var,
	b, i,
	dl, dt, dd, ol, ul, li,
	fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td {
		margin:0;
		padding:0;
		border:0;
		outline:0;
		font-size:100%;
		vertical-align:baseline;
		background:transparent;
	}
	
	body {
		margin:0;
		padding:0;
		font:12px/15px "Helvetica Neue",Arial, Helvetica, sans-serif;
		color: #555;
		background:#f5f5f5 url(bg.jpg);
	}
	
	a {color:#666;}
	
	#content {width:65%; max-width:690px; margin:6% auto 0;}
	
	/*
	Pretty Table Styling
	CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
	*/
	
	table {
		overflow:hidden;
		border:1px solid #d3d3d3;
		background:#fefefe;
		width:70%;
		margin:5% auto 0;
		-moz-border-radius:5px; /* FF1+ */
		-webkit-border-radius:5px; /* Saf3-4 */
		border-radius:5px;
		-moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
		-webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
	}
	
	th, td {padding:18px 28px 18px; text-align:center; }
	
	th {padding-top:22px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}
	
	td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
	
	tr.odd-row td {background:#f6f6f6;}
	
	td.first, th.first {text-align:left}
	
	td.last {border-right:none;}
	
	/*
	Background gradients are completely unnecessary but a neat effect.
	*/
	
	td {
		background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
	}
	
	tr.odd-row td {
		background: -moz-linear-gradient(100% 25% 90deg, #f6f6f6, #f1f1f1);
		background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f1f1f1), to(#f6f6f6));
	}
	
	th {
		background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
		background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
	}
	
	/*
	I know this is annoying, but we need additional styling so webkit will recognize rounded corners on background elements.
	Nice write up of this issue: http://www.onenaught.com/posts/266/css-inner-elements-breaking-border-radius
	
	And, since we've applied the background colors to td/th element because of IE, Gecko browsers also need it.
	*/
	
	tr:first-child th.first {
		-moz-border-radius-topleft:5px;
		-webkit-border-top-left-radius:5px; /* Saf3-4 */
	}
	
	tr:first-child th.last {
		-moz-border-radius-topright:5px;
		-webkit-border-top-right-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.first {
		-moz-border-radius-bottomleft:5px;
		-webkit-border-bottom-left-radius:5px; /* Saf3-4 */
	}
	
	tr:last-child td.last {
		-moz-border-radius-bottomright:5px;
		-webkit-border-bottom-right-radius:5px; /* Saf3-4 */
	}
	input[type="button"] {
	background-color: #FF4040;
	color: #fff;
	display: block;
	margin: 0 auto;
	padding: 4px 0;
	width: 100px;
}
</style>
</head>
<body>
	
	<center>
		<div align="center" id="content">
		<h1>选课信息</h1>
	    <jsp:useBean id="clessonList" class="java.util.ArrayList" scope="session"/>
		<table width="600" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>课程号</td>
			<td>课程名称</td>
			<td>学年</td>
			<td>学期</td>
			<td>学分</td>
			<td>前课程号</td>
			<td>撤课</td>
		</tr>
		  <%
		  String stn=studentNum.toString();
		  	int count=clessonList.size();
		  System.out.println("count:"+count);
		  for(int i=0;i<count;i++){
		 Entities.Lesson ls=(Entities.Lesson)clessonList.get(i);
		String lessonNum=ls.getLessonNum();
		String lessonName=ls.getLessonName();
		String year=ls.getYear();
		String term=ls.getTerm();
		int credit=ls.getCredit();
		String beforeLessonNum=ls.getBeforelessonNum();
		%>
		 <tr>
		 	<td><%=lessonNum %></td>
		 	<td><%=lessonName %></td>
		 	<td><%=year %></td>
		 	<td><%=term %></td>
		 	<td><%=credit %></td>
		 	<td><%=beforeLessonNum %></td>
		 	<td><a href="javascript:del(<%=lessonNum %>,<%=stn %>)">撤课</a></td>
		 </tr>
		<%
		  }
		  %>
		</table>
		 <input type="button" value="选课" onclick="add(<%=studentNum %>)"/>
		 </div>
	</center>
</body>
</html>