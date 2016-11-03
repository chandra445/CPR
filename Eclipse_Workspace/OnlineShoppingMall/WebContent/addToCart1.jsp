<%@ page import="java.sql.*" %>

        <%!
        String strid,pname,pid,strname,temp;
        int qty,reqty;
        double price,totprice;
        Connection con;
        PreparedStatement pst;
        Statement st;
        ResultSet rs;
        %>
        <%
        temp=(String)session.getAttribute("temp");
        strid=request.getParameter("strid");
        strname=request.getParameter("strname");
        pname=request.getParameter("pname");
        pid=request.getParameter("pid");
        qty=Integer.parseInt(request.getParameter("qty"));
        reqty=Integer.parseInt(request.getParameter("reqty"));
        price=Double.parseDouble(request.getParameter("price"));
        totprice=reqty*price;

        System.out.println("temp : "+temp);
        System.out.println("strid : "+strid);
        System.out.println("strname : "+strname);
        System.out.println("pname : "+pname);
        System.out.println("pid : "+pid);
        System.out.println("qty : "+qty);
        System.out.println("reqty : "+reqty);
        System.out.println("price : "+price);
        System.out.println("totprice : "+totprice);

         Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        if(temp.equals("additems"))
        {
            pst=con.prepareStatement("insert into prolist values(?,?,?,?,?,?,?,?)");
            pst.setString(1,strid);
            pst.setString(2,strname);
            pst.setString(3,pid);
            pst.setString(4,pname);
            pst.setDouble(5, price); 
            pst.setInt(6,reqty);
            pst.setDouble(7,totprice);
            pst.setInt(8,qty);
            pst.execute();
        }
        else if(temp.equals("editorder"))
        {
            qty=qty-reqty;
            pst=con.prepareStatement("update prolist set reqty=?,totprice=?,qty=? where pid=?");
            pst.setInt(1,reqty);
            pst.setDouble(2,totprice);
            pst.setString(4,pid);
            pst.setInt(3,qty);
            pst.execute();
        }
        %>