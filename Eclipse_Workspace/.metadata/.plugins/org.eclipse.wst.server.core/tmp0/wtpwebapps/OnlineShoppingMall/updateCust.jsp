<jsp:include page="customerLogin.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form action="updateCustomer.do" method="post" name=multi >
            
            <div style="position: absolute; width: 433px; height: 152px; z-index: 1; left: 600px; top: 273px" id="layer1">
                <div align="center">
                <table border="0" width="100%" id="table1">
				
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">User
							Name</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="uname" size="20" value="${user1.uname}" readonly></font></td>
							
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Password</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="password" name="pwd" size="20" value="${user1.pwd }"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Mobile
							Number</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="mobile" size="20" value="${user1.mobile}"></font></td>
				</tr>
				

				
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Address1</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
								type="text" name="addr1" size="20" value="${user1.addr1}"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Address2</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
								type="text" name="addr2" size="20" value="${user1.addr2}"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">City</font></td>
					<td><font size="3" face="Trebuchet MS"> <input
							type="text" name="city" size="20" value="${user1.city}"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">State</font></td>
					<td><font size="3" face="Trebuchet MS"> <input
							type="text" name="state" size="20" value="${user1.state}"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Country</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="country" size="20" value="${user1.country}"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Zip Code</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="zip" size="20" value="${user1.zip}"></font></td>
				</tr>

                </table>               
            	</div>
            </div>         
            
             <div style="position: absolute; width: 170px; height: 25px; z-index: 1; left: 750px; top: 600px" id="layer7">&nbsp; 
                    <input type="submit" value="Update">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="Reset">&nbsp;
             </div>
             <div
			style="position: absolute; width: 319px; height: 36px; z-index: 2; left: 700px; top: 200px"
			id="layer2">
			<b><font face="Bell MT" size="5" color="#D15803"><h6>${updateMessage }</h6>
					</font></b>
		</div>
        </form>
    </body>
</html>