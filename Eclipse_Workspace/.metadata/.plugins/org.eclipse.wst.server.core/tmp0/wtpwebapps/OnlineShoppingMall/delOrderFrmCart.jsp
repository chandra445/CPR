<jsp:include page="viewCart.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>           
            <%!
            String pid;
            static int bil=0,i=0;
            Connection con;
            Statement st;
            PreparedStatement pst;
            ResultSet rs;
            %>
            <%
            pid=request.getParameter("pid");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            st=con.createStatement();
            st.execute("delete from prolist where pid='"+pid+"'");
            %>
            <div style="position: absolute; width: 368px; height: 32px; z-index: 5; left: 706px; top: 235px" id="layer5">
			<b><font size="2" color="#D15803">Order deleted successfully
</font></b>
</div>
    </body>
</html>
