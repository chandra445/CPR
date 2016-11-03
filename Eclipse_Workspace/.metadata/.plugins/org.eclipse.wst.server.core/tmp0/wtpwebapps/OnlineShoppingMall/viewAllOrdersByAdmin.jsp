<jsp:include page="adminLogin.jsp"></jsp:include>

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
				
				<td width="141" align="center"><b> <font size="2">Order Id</font></b></td>
				<td width="141" align="center"><b> <font size="2">Customer Id</font></b></td>
				<td width="141" align="center"><b> <font size="2">user Name</font></b></td>
				<td width="141" align="center"><b> <font size="2">store Name</font></b></td>
				<td width="141" align="center"><b> <font size="2">product name</font></b></td>
				<td width="141" align="center"><b> <font size="2">price</font></b></td>
				<td width="141" align="center"><b> <font size="2">Quantity</font></b></td>
				<td width="141" align="center"><b> <font size="2">Total price</font></b></td>
				<td width="141" align="center"><b> <font size="2">Order Date</font></b></td>
				<td width="141" align="center"><b> <font size="2">Total bill</font></b></td>
			</tr>

			<c:forEach var="order" items="${requestScope.viewAllOrdersByAdmin}">
				<tr>
					<td width="141" align="center"><font size="2">${order.ordid}</font></td>
					<td width="141" align="center"><font size="2">${order.custid}</font></td>
					<td width="141" align="center"><font size="2">${order.uname}</font></td>
					<td width="141" align="center"><font size="2">${order.strname}</font></td>
					<td width="141" align="center"><font size="2">${order.productName}</font></td>
					<td width="141" align="center"><font size="2">${order.price}</font></td>
					<td width="141" align="center"><font size="2">${order.quantity}</font></td>
					<td width="141" align="center"><font size="2">${order.totalPriceForProduct}</font></td>
					<td width="141" align="center"><font size="2">${order.orderDate}</font></td>
					<td width="141" align="center"><font size="2">${order.bill}</font></td>
					
				</tr>
			</c:forEach>




		</table>
	</div>
</body>
</html>
