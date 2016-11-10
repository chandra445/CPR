<jsp:include page="customerLogin.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.shoppingmall.pojo.*" %>
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
            String strid,pid,strname,ordid,uname,pname,custid,strid1,strname1,prname1;
            int qty,orid,qty1,x;
            double price,totprice,bill,price1,totprice1;
            Connection con;
            Statement st,st1,st2;
            PreparedStatement pst;
            ResultSet rs,rs1,rs2;
            %>
            <%
            UserBean userbean=(UserBean)session.getAttribute("customer");
            uname=userbean.getUname();
            
            custid=userbean.getCustid();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
            st=con.createStatement();
            try{
            rs=st.executeQuery("select ordid.nextval from dual");
            if(rs.next())
                orid=rs.getInt(1);
            ordid="Order"+orid;
              st1=con.createStatement();
              rs1=st1.executeQuery("select sum(totprice) from prolist");
              if(rs1.next())
              bill=rs1.getInt(1);
              System.out.println("Final Bill : "+bill);
            
             //java.util.Date d1=new java.util.Date();
             pst=con.prepareStatement("insert into bill (ORDID,CUSTID,UNAME,BILL) values(?,?,?,?)");
                pst.setString(1,ordid);
                System.out.println("orderid : "+ordid);
                pst.setString(2,custid);
                System.out.println("custid : "+custid);
                pst.setString(3,uname);
                System.out.println("uname : "+uname);
                pst.setDouble(4,bill);
                System.out.println("bill : "+bill);
                //pst.setDate(5,to_date(sysdate));
                pst.execute();
                rs=st.executeQuery("select * from prolist");
                while(rs.next())
               {
                 strid=rs.getString(1);
                 strname=rs.getString(2);
                 pid=rs.getString(3);
                 pname=rs.getString(4);
                 price=rs.getDouble(5);
                 qty=rs.getInt(6);
                 totprice=rs.getDouble(7);
                 pst=con.prepareStatement("insert into custorder values(?,?,?,?,?,?)");
                 pst.setString(1,ordid);
                 System.out.println("ordid : "+ordid);
                 pst.setString(2,strname);
                 System.out.println("strname : "+strname);
                 pst.setString(3,pname);
                 System.out.println("pname : "+pname);
                 pst.setDouble(4,price);
                 System.out.println("price : "+price);
                 pst.setDouble(5,qty);
                 System.out.println("qty : "+qty);
                 pst.setDouble(6,totprice);
                 System.out.println("totprice : "+totprice);
                 System.out.println("sql statement : "+pst);

                 pst.execute();
                 st2=con.createStatement();
                 st2.executeUpdate("update product set productquantity=productquantity-"+qty+" where strid='"+strid+"' and productid='"+pid+"'");
                //out.print(" "+strname+"  "+pname+"  "+price+"  "+qty+"   "+totprice+"<br>");
                 }


                %>
		<div style="position: absolute; width: 275px; height: 29px; z-index: 1; left: 550px; top: 239px" id="layer2">
			<font color="#D15803">
			<b>Your Order Details are </b>
			</font>
			<p><font color="#D15803"><b>Order Id :<%=ordid%></b></font></p>
			<p><font color="#D15803"><b>Total Order amount
			 is : 	<%=bill%></b></font></p>
        </div>
                <%
                st=con.createStatement();
                st.execute("delete from prolist");
                }catch(Exception e){
                	
                	System.out.println("exception" +e);
                	
                    %>
                    <div style="position: absolute; width: 275px; height: 29px; z-index: 1; left: 550px; top: 237px" id="layer2">
                     <font color="#D15803">
                     <b>Order Already Submitted.. </b>
	                	</font>
	                </div>
               <% }
               %>          
            <form action="completeOrder.do" method="post">
    		<div style="position: absolute; width: 663px; height: 204px; z-index: 2; left: 550px; top: 342px" id="layer3">
	<%

              st2=con.createStatement();
            rs2=st2.executeQuery("select count(ordid) from custorder where ordid='"+ordid+"'");
            if(rs2.next())
                x=rs2.getInt(1);
              st1=con.createStatement();
            rs1=st1.executeQuery("select * from custorder where ordid='"+ordid+"'");
             %>  
                                    <table border="0" width="100%" id="table1">
					
					<tr>
						<td width="112"><b><font size="2">Order Details:</font></b></td></tr>
						<tr><td colspan="2">
                                                    
                                                For this order id  there are <%=x%> orders  </td></tr>

                                            <tr><td colspan="2">    Details are as follows </td></tr>
                                             <tr><td colspan="3">    <%
                                                int i=0;
                                               while(rs1.next())
                                                {
                                                  strid1=rs1.getString(1);
                                                  strname1=rs1.getString(2);
                                                  prname1=rs1.getString(3);
                                                  price1=rs1.getInt(4);
                                                  qty1=rs1.getInt(5);
                                                  totprice1=rs1.getInt(6);
                                                  i++;
                                               %>
                                               Order <%=i%> details are:::
                                             Store name =  <%=strname1%>, Product name= <%=prname1%>, Price = <%=price%>, Quantity = <%=qty%>, TotalPrice = <%=totprice%>
                                            <%
	                                }
	                            %>			                                   
                        </td>
					</tr>
					
					<tr>
						<td width="112">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="112">&nbsp;</td>
						<td><input type="submit" value="submit"></td>
					</tr>
				</table>
			</div>
			</form>
    </body>
</html>