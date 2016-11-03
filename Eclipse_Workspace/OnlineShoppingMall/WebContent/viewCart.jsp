<jsp:include page="customerLogin.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@ page import="com.shoppingmall.pojo.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script LANGUAGE="JavaScript">
            function popUp(URL) {
            day = new Date();
            id = day.getTime();
            eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=1,location=0,statusbar=1,menubar=0,resizable=1,width=400,height=400,left = 362,top = 234');");
            }
            function confirmDelete(delUrl) {
              if (confirm("Are you sure you want to delete")) {
                document.location = delUrl;
              }
            }
        </script>
    </head>
    <body>
        <form action="bill.jsp" method="post">
             <%!
            String strid,pid,strname,ordid,uname,pname;
            int qty,reqty;
            double price,totprice,bill;
            static double bil=0,i=0;
            Connection con;
            Statement st;
            PreparedStatement pst;
            ResultSet rs;
            %>
            <%
            UserBean userbean=(UserBean)session.getAttribute("customer");
            uname=userbean.getUname();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            st=con.createStatement();
            rs=st.executeQuery("select * from prolist");
            %>
           <div style="position: absolute; width: 535px; height: 24px; z-index: 1; left: 550px; top: 204px" id="layer1">
				<font color="#B9B900">
				<b><marquee behavior="alternate">Welcome to <%=uname%>, Your Cart Details are given Below</marquee></b>
				</font>
			</div>
            <div style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 550px; top: 266px" id="layer1">
                <table border="1" width="100%" id="table1">
                    <tr>
                        <td align="center"><b><font size="2">Store Name</font></b></td>
                        <td align="center"><b><font size="2">Product Name</font></b></td>
                        <td align="center"><b><font size="2">Price</font></b></td>
                        <td align="center"><b><font size="2">Quantity</font></b></td>
                        <td align="center"><b><font size="2">Total Price</font></b></td>
                        <td align="center"><b><font size="2">Action</font></b></td>
                    </tr>
                    <%
                    while(rs.next())
                    {
                    	strid=rs.getString(1);
                        strname=rs.getString(2);
                        pid=rs.getString(3);
                        pname=rs.getString(4);
                        price=rs.getDouble(5);
                        reqty=rs.getInt(6);
                        totprice=rs.getDouble(7);
                        qty=rs.getInt(8);
                    
                    %>
                        <tr>
                            <td align="center"><font size="2"><%=strname%></font></td>
							<td align="center"><font size="2"><%=pname%></font></td>
							<td align="center"><font size="2"><%=price%></font></td>
							<td align="center"><font size="2"><%=reqty%></font></td>
							<td align="center"><font size="2"><%=totprice%></font></td>
                        	<td align="center"><b><a HREF="javascript:popUp('editOrder.jsp?pid=<%=pid%>&pname=<%=pname%>&price=<%=price%>&reqty=<%=reqty%>&strid=<%=strid%>&strname=<%=strname%>&qty=<%=qty%>')">
							<font size="2">Edit</font></a></b><font size="2">
                                /
</font>
<a href="javascript:confirmDelete('delOrderFrmCart.jsp?pid=<%=pid%>')"><font size="2">Delete</font></a></td>
                        <%
                        }
                        %>
                    </tr>
                </table>
            </div>
    	<div style="position: absolute; width: 100px; height: 32px; z-index: 5; left: 650px; top: 235px" id="layer5">
			<input type="submit" value="Submit Order" name="B1"></div>
    </form>
    </body>
</html>
