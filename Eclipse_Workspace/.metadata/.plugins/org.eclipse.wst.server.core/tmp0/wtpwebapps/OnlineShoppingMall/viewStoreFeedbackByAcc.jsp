<jsp:include page="accountantLogin.jsp"></jsp:include>

<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	
	<div
		style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 550px; top: 266px"
		id="layer1">
		&nbsp;
		<table border="1" width="100%" id="table1">
			
			<tr>
				<td width="141" align="center"><b> <font size="2">Store
							Name</font></b></td>
				<td width="290" align="center"><b> <font size="2">Feedback</font></b></td>
				<td width="141" align="center"><b> <font size="2">Date</font></b></td>
				
			</tr>

			<c:forEach var="fback" items="${requestScope.feedbacklist}">
				<tr>
					<td width="141" align="center"><font size="2">${fback.strname}</font></td>
					<td width="290" align="center"><font size="2">${fback.feedback}</font></td>
					<td width="141" align="center"><font size="2">${fback.feedbackDate}</font></td>
					
				</tr>
			</c:forEach>




		</table>
	</div>
</body>
</html>
