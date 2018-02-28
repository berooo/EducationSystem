<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:useBean id="teacherNum" class="java.lang.String" scope="session"/>
<jsp:useBean id="action" class="java.lang.String" scope="session"/>
 <jsp:useBean id="lessonNum" class="java.lang.String" scope="session"/>
 <style type="text/css">
 @charset "utf-8";
/* CSS Document */

/* ---------- FONTAWESOME ---------- */
/* ---------- http://fortawesome.github.com/Font-Awesome/ ---------- */
/* ---------- http://weloveiconfonts.com/ ---------- */

@import url(http://weloveiconfonts.com/api/?family=fontawesome);

/* ---------- ERIC MEYER'S RESET CSS ---------- */
/* ---------- http://meyerweb.com/eric/tools/css/reset/ ---------- */

@import url(http://meyerweb.com/eric/tools/css/reset/reset.css);

/* ---------- FONTAWESOME ---------- */

[class*="fontawesome-"]:before {
  font-family: 'FontAwesome', sans-serif;
}

/* ---------- GENERAL ---------- */

body {
	background-color: #C0C0C0;
	color: #000;
	font-family: "Varela Round", Arial, Helvetica, sans-serif;
	font-size: 16px;
	line-height: 1.5em;
}

input {
	border: none;
	font-family: inherit;
	font-size: inherit;
	font-weight: inherit;
	line-height: inherit;
	-webkit-appearance: none;
}

/* ---------- LOGIN ---------- */

#login {
	margin: 50px auto;
	width: 400px;
}

#login h2 {
	background-color: #f95252;
	-webkit-border-radius: 20px 20px 0 0;
	-moz-border-radius: 20px 20px 0 0;
	border-radius: 20px 20px 0 0;
	color: #fff;
	font-size: 28px;
	padding: 20px 26px;
}

#login h2 span[class*="fontawesome-"] {
	margin-right: 14px;
}

#login fieldset {
	background-color: #fff;
	-webkit-border-radius: 0 0 20px 20px;
	-moz-border-radius: 0 0 20px 20px;
	border-radius: 0 0 20px 20px;
	padding: 20px 26px;
}

#login fieldset p {
	color: #777;
	margin-bottom: 14px;
}

#login fieldset p:last-child {
	margin-bottom: 0;
}

#login fieldset input {
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

#login fieldset input[type="text"] {
	background-color: #eee;
	color: #777;
	padding: 4px 10px;
	width: 328px;
}

#login fieldset input[type="submit"], #login fieldset input[type="reset"] {
	background-color: #33cc77;
	color: #fff;
	display: block;
	margin: 0 auto;
	padding: 4px 0;
	width: 100px;
}

#login fieldset input[type="submit"]:hover {
	background-color: #28ad63;
}
</style>
</head>
<body>
	<br/>
 	
 	<div id="login" align="center">
 	
 	<h2><span class="fontawesome-lock"></span>课程信息录入</h2>
 	<%
 	String act=action.toString();
 		String tNum=teacherNum.toString();
 		
 		System.out.println(act);
 		String les=lessonNum.toString();
 		if(act.equals("modify")){
 	%>
 	
 		<form  name="LoginForm" action="Servlet/LessonServlet" method="post">
 		<fieldset>
 			<p>课程号：<input type="text" name="lessonNum" value=<%=les %> /></p>
 			<p>课程名：<input type="text" name="lessonName"/></p>
 			<p>学年：<input type="text" name="year"/></p>
 			<p>学期：<input type="text" name="term"/></p>
 			<p>学分：<input type="text" name="credit"/></p>
 			<p>教师号：<input type="text" name="teacherNum" value=<%=tNum %> /></p>
 			<p>前课程号：<input type="text" name="beforelessonNum"/></p>
 			<p><input type="submit" value="update" name="submit"/>
 			<input type="reset" value="重置输入"/></p>
 			</fieldset>
 		</form>
 
 	<%
 		}else
 			if(act.equals("add")){
 	%>
 		<form  name="LoginForm" action="Servlet/LessonServlet" method="post">
 			<fieldset>
 			<p>课程号：<input type="text" name="lessonNum"/></p>
 			<p>课程名：<input type="text" name="lessonName"/></p>
 			<p>学年：<input type="text" name="year"/></p>
 			<p>学期：<input type="text" name="term"/></p>
 			<p>学分：<input type="text" name="credit"/></p>
 			<p>教师号：<input type="text" name="teacherNum" value=<%=tNum %> /></p>
 			<p>前课程号：<input type="text" name="beforelessonNum"/></p>
 			<p><input type="submit" value="add" name="submit"/></p>
 			</fieldset>																																						
 		</form>
 	<%
 		}
 	%>
 	</div>
</body>
</html>