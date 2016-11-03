<jsp:include page="customerLogin.jsp"></jsp:include>

<%@ page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript">
function popUp(URL) {
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=0,resizable=1,width=300,height=200');");
                    }
function validate() {
if(document.multi.qty.value > document.multi.reqty.value)
  return true;
 else {
  alert("Insufficient Quantity");
  return false;
      }
                    }
</script>
</head>
<body>
	  <form action="viewCart.jsp" method="post">
	<div
		style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 550px; top: 266px"
		id="layer1">
		&nbsp;
		<table border="1" width="100%" id="table1">
			
			<tr>
				<td width="141" align="center"><b> <font size="2">Store Id</font></b></td>
				<td width="141" align="center"><b> <font size="2">Store Name</font></b></td>
				<td width="141" align="center"><b> <font size="2">Product Id</font></b></td>
				<td width="141" align="center"><b> <font size="2">Product Name</font></b></td>
				<td width="141" align="center"><b> <font size="2">Price</font></b></td>
				<td width="141" align="center"><b> <font size="2">Quantity</font></b></td>
				<td width="141" align="center"><b> <font size="2">Product Description</font></b></td>
			</tr>

			<c:forEach var="product" items="${requestScope.productListForCustomer}">
				<tr>
					<td width="141" align="center"><font size="2">${product.strid}</font></td>
					<td width="141" align="center"><font size="2">${product.strname}</font></td>
					<td width="141" align="center"><font size="2">${product.productId}</font></td>
					<td width="141" align="center"><font size="2">${product.productName}</font></td>
					<td width="141" align="center" ><font size="2">${product.productPrice}</font></td>
					<td width="141" align="center"><font size="2">${product.productQuantity}</font></td>
					<td width="141" align="center"><font size="2">${product.productDescription}</font></td>
					<td align="center" width="111">
        <b>
            <a HREF="javascript:popUp('addToCart.jsp?pid=${product.productId}&pname=${product.productName}&price=${product.productPrice}&qty=${product.productQuantity}&strid=${product.strid}&strname=${product.strname}')">
            <font size="2">Add to Cart</font>
            </a>
        </b>
    </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="position: absolute; width: 86px; height: 30px; z-index: 4; left: 650px; top: 221px" id="layer4">
		<input type="submit" value="View Cart" name="B1"></div>
	</form>
</body>
</html>
