/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M10
 * Generated at: 2016-11-04 19:38:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class addAccountant_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminLogin.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction checkData() {\r\n");
      out.write("\t\tvar error = 0;\r\n");
      out.write("\t\tvar fname = document.multi.ftname.value;\r\n");
      out.write("\t\tif (fname == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar lname = document.multi.ltname.value;\r\n");
      out.write("\t\tif (lname == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar username = document.multi.uname.value;\r\n");
      out.write("\r\n");
      out.write("\t\tif (username == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tre = /^\\w+$/;\r\n");
      out.write("\t\tif (!re.test(username)) {\r\n");
      out.write("\t\t\talert(\"Error: Username must contain only letters, numbers and underscores!\");\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar userpword = document.multi.pwd.value;\r\n");
      out.write("\t\tif (userpword == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (userpword == username) {\r\n");
      out.write("\t\t\talert(\"Error: Password must be different from Username!\");\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tre = /[0-9]/;\r\n");
      out.write("\t\tif (!re.test(userpword)) {\r\n");
      out.write("\t\t\talert(\"Error: password must contain at least one number (0-9)!\");\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tre = /[a-z]/;\r\n");
      out.write("\t\tif (!re.test(userpword)) {\r\n");
      out.write("\t\t\talert(\"Error: password must contain at least one lowercase letter (a-z)!\");\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tre = /[A-Z]/;\r\n");
      out.write("\t\tif (!re.test(userpword)) {\r\n");
      out.write("\t\t\talert(\"Error: password must contain at least one uppercase letter (A-Z)!\");\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar numbers = /^[0-9]+$/;\r\n");
      out.write("\r\n");
      out.write("\t\tvar cmobile = document.multi.mobile.value;\r\n");
      out.write("\t\tif (cmobile == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t} else if (!(cmobile.match(numbers))) {\r\n");
      out.write("\t\t\talert('Mobile Should Accept Only Numbers');\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tvar filter = /^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$/i\r\n");
      out.write("\t\tvar cemail = document.multi.email.value;\r\n");
      out.write("\t\tif (cemail == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t} else if (!filter.test(cemail)) {\r\n");
      out.write("\t\t\talert('Not a valid Email');\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar address1 = document.multi.addr1.value;\r\n");
      out.write("\t\tif (address1 == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar address2 = document.multi.city.value;\r\n");
      out.write("\t\tif (address2 == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar address3 = document.multi.state.value;\r\n");
      out.write("\t\tif (address3 == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar address4 = document.multi.country.value;\r\n");
      out.write("\t\tif (address4 == '') {\r\n");
      out.write("\t\t\terror += 1;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (error == 0) {\r\n");
      out.write("\t\t\tdocument.submit();\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\tvar div = document.getElementById(\"alertDiv\");\r\n");
      out.write("\t\t\tdiv.innerHTML = \"All Fields Are Mandatory\";\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction allnumeric(inputtxt) {\r\n");
      out.write("\t\tvar numbers = /^[0-9]+$/;\r\n");
      out.write("\t\tif (inputtxt.value.match(numbers)) {\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert('Please Allow numeric characters only');\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"registerAccountant.do\" method=\"post\" name=\"multi\"\r\n");
      out.write("\t\tonsubmit=\"return checkData()\">\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"position: absolute; width: 433px; height: 152px; z-index: 1; left: 600px; top: 273px\"\r\n");
      out.write("\t\t\tid=\"layer1\">\r\n");
      out.write("\t\t\t<table border=\"0\" width=\"100%\" id=\"table1\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">First\r\n");
      out.write("\t\t\t\t\t\t\tName</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"ftname\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Last\r\n");
      out.write("\t\t\t\t\t\t\tName</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"ltname\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">User\r\n");
      out.write("\t\t\t\t\t\t\tName</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"uname\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Password</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"password\" name=\"pwd\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Mobile\r\n");
      out.write("\t\t\t\t\t\t\tNumber</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"mobile\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Email\r\n");
      out.write("\t\t\t\t\t\t\tID</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"email\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Date\r\n");
      out.write("\t\t\t\t\t\t\tof Birth</font></td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"date\" name=\"bday\" size=\"20\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Address1</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <textarea\r\n");
      out.write("\t\t\t\t\t\t\t\trows=\"2\" name=\"addr1\" cols=\"20\"></textarea></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"32%\"><font face=\"Arial Narrow\" color=\"#666600\">Address2</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <textarea\r\n");
      out.write("\t\t\t\t\t\t\t\trows=\"2\" name=\"addr2\" cols=\"20\"></textarea></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><font face=\"Arial Narrow\" color=\"#666600\">City</font></td>\r\n");
      out.write("\t\t\t\t\t<td><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"city\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><font face=\"Arial Narrow\" color=\"#666600\">State</font></td>\r\n");
      out.write("\t\t\t\t\t<td><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"state\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><font face=\"Arial Narrow\" color=\"#666600\">Country</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"country\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><font face=\"Arial Narrow\" color=\"#666600\">Zip Code</font></td>\r\n");
      out.write("\t\t\t\t\t<td width=\"66%\"><font size=\"3\" face=\"Trebuchet MS\"> <input\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" name=\"zip\" size=\"20\"></font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" align=\"center\"><div id=alertDiv\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: red\"></div></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr><td colspan=\"2\" align=\"center\" style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msgFailure}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"position: absolute; width: 170px; height: 25px; z-index: 5; left: 750px; top: 600px\"\r\n");
      out.write("\t\t\tid=\"layer5\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Submit\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"reset\" value=\"Reset\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div\r\n");
      out.write("\t\t\tstyle=\"position: absolute; width: 319px; height: 36px; z-index: 2; left: 700px; top: 200px\"\r\n");
      out.write("\t\t\tid=\"layer2\">\r\n");
      out.write("\t\t\t<b><font face=\"Bell MT\" size=\"5\" color=\"#D15803\">Account\r\n");
      out.write("\t\t\t\t\tRegistration</font></b>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
