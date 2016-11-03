<jsp:include page="productMgmt.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
    </head>
    <body>
    <form action="saveProduct.do" method="post" name="multi" onsubmit="return validateProd()" >
         <div style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 600px; top: 266px" id="layer1">
        
            <table border="0" width="62%" id="table1">
            
            	<tr>
                    <td width="120"><b><font size="2">Store ID</font></b></td>
                    <td><input type="text" name="strid" size="20" value="${product.strid }" readonly></td>
                </tr>
                
                <tr>
                    <td width="120"><b><font size="2">Store Name</font></b></td>
                    <td><input type="text" name="strname" size="20" value="${product.strname }" readonly></td>
                </tr>
                <tr>
                    <td width="120"><b><font size="2">Product Name</font></b></td>
                    <td><input type="text" name="productName" size="20"></td>
                </tr>
                <tr>
                    <td width="120"><b><font size="2">Price</font></b></td>
                    <td><input type="text" name="productPrice" size="20"></td>
                </tr>
                <tr>
                    <td width="120"><b><font size="2">Quantity</font></b></td>
                    <td><input type="text" name="productQuantity" size="20"></td>
                </tr>
                <tr>
                    <td width="120"><b><font size="2">Description</font></b></td>
                    <td><textarea rows="2" name="productDescription" cols="20"></textarea></td>
                </tr>
            </table>
            </div>
            <div style="position: absolute; width: 184px; height: 23px; z-index: 1; left: 700px; top: 450px" id="layer7">&nbsp; 
                <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Reset">
            </div>
            </form>
    </body>
</html>