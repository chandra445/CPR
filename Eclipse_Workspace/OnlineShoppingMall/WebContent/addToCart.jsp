
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function validate()
            {
               var q=parseInt(document.multi.qty.value);
               var rq=parseInt(document.multi.reqty.value);

               if(document.multi.reqty.value.length==0)
               {
               alert("Please Enter a Quantity");
                return false;
               }
               else if(q < rq)
               {
               alert("Avaliable quantity is "+document.multi.qty.value+" Only...");
                return false;
               }
               else
               {
                self.close();
                 return true;
               }
            }
        </script>
    </head>
    <body background="images/img02.png">
        <form action="addToCart1.jsp" name="multi" method="post" onsubmit="return validate()">
            <table width="169">
                <%!
                String strid="",pname,desc,pid="",strname,temp;
                int qty,reqqty;
                double price;
                %>
                <%
                temp="additems";
                session.setAttribute("temp",temp);
                strname=request.getParameter("strname");
                strid=request.getParameter("strid");
                pname=request.getParameter("pname");
                pid=request.getParameter("pid");
                qty=Integer.parseInt(request.getParameter("qty"));
                price=Double.parseDouble(request.getParameter("price"));
                pname=request.getParameter("pname");
                %>
                <tr>
                    <td width="112"><font color="#FFFFFF" size="2"><b>Product Name</b></font></td>
                    <td><font color="#FFFFFF"><%=pname%></font></td>
                </tr>
                <tr>
                    <td width="112"><font color="#FFFFFF" size="2"><b>Required Quantity</b></font></td>
                    <td><font color="#FFFFFF"><input type="text" size="1" name="reqty" tabindex="1"></font></td>
                </tr>
            </table>
            <input type="hidden" name="qty" value="<%=qty%>">
            <input type="hidden" name="pid" value="<%=pid%>">
            <input type="hidden" name="strid" value="<%=strid%>">
            <input type="hidden" name="strname" value="<%=strname%>">
            <input type="hidden" name="price" value="<%=price%>">
            <input type="hidden" name="pname" value="<%=pname%>">
        <div style="position: absolute; width: 140px; height: 44px; z-index: 1; left: 58px; top: 82px" id="layer1">
           <input type="submit" value="Submit" name="Submit" tabindex="2">
        </div>
        </form>      
    </body>
</html>
