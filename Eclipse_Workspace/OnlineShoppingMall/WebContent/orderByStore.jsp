<jsp:include page="customerLogin.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="orderByStore.do" method="post" name="multi">
     
        <div style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 600px; top: 266px" id="layer1">
              <div align="center">
              <table border="0" width="72%" id="table1" height="98">
                  <tr>
                      <td height="43" width="127"><b>
                              Store Name :</b></td>
                      <td height="43">
                            <select size="1" name="strname" tabindex="1">
                               
                            <c:forEach var="store" items="${requestScope.storelist}">
								<option>${store.strname}</option>
							</c:forEach>
                            </select>
                      </td>
                  </tr>
                  <tr>
                      <td width="127">&nbsp;</td>
                      <td>
                      <input type="submit" value="Submit" name="B1" tabindex="2">&nbsp;&nbsp;&nbsp;&nbsp;
                      <input type="reset" value="Reset" name="B2" tabindex="3"></td>
                  </tr>
              </table>
          	</div>
          </div>
        </form>
    </body>
</html>