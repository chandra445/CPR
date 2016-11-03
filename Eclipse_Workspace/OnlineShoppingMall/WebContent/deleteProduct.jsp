<jsp:include page="productMgmt.jsp"></jsp:include>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="JS/form_valid.js"></script>
</head>
<body>
	<form action="deleteProduct.do" method="post" name="multi"
		onsubmit="return validateProd()">
		<div
			style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 650px; top: 266px"
			id="layer1">

			<table border="0" width="72%" id="table1" height="98">
				<tr>
					<td height="43" width="127"><b> Product Name :</b></td>
					<td height="43">
							 <select size="1" name="productName" tabindex="1">
							<c:forEach var="product" items="${requestScope.productlist}">
								<option>${product.productName}</option>
							</c:forEach>
					</select></td>
				</tr>
			</table>
		</div>
		<div
			style="position: absolute; width: 184px; height: 23px; z-index: 1; left: 650px; top: 450px"
			id="layer7">
			&nbsp; <input type="submit" value="Delete Product">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Reset">
		</div>
	</form>
</body>
</html>