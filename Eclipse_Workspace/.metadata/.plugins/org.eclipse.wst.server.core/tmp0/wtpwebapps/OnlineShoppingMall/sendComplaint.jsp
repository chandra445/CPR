<jsp:include page="customerLogin.jsp"></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Shopping Mall</title>
    </head>
    <body>
    <form action="registerComplaint.do" method=post name=multi>     
        <div style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 550px; top: 214px" id="layer1">                
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b><font size="2">Please Submit your feedback (</font>maximum length : 
                150 characters only)
                </b>
                <table border="0" id="table1" width="585">
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
                        <td><b><font size="2">Feed Back
                        :</font></b></td>
                        <td width="469">
						<textarea rows="7" name="feedback" cols="56"></textarea></td>
                    </tr>
                    <tr><td colspan="2" align="center" style="color: black">${msgfeedback}</td></tr>
                    </table>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <input type="submit" value="Submit Feedback" name="B1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value="Reset" name="B2"></p>
            <p><br></div>
        </form>
    	
    </body>
</html>