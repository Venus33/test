<%@page import="entity.Stu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生系统</title>
</head>
<body>
	<div id="containt" align="center">
	    <!-- 书写一个查询的表单 -->
		<form action="FindById" method="post">
			<label>学号：</label><input type="text" value="" name="id">
			<input type="submit" value="查询">
		</form>
		<!-- 显示数据库中数据的表格 -->
		<table>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
			</tr>
			<%
				// 获得保存在作用域中的数据
				List<Stu> list = (List<Stu>)request.getAttribute("list");
			if(list != null){
				// 将list中的数据展示到页面上
				for(Stu s : list){
					%>
					<tr>
						<td><%=s.getId() %></td>
						<td><%=s.getName()%></td>
						<td><%=s.getSex() %></td>
					<%
				}
			}
		%>
	 </table>
    </div>
</body>
</html>