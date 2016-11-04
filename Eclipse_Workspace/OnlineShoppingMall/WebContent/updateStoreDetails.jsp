<jsp:include page="storeManagerLogin.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <script>
          function checkStoreForm() {
      		var error = 0;
      		var sname = document.multi.strname.value;
      		if (sname == '') {
      			error += 1;
      		}
      		

      		var username = document.multi.uname.value;

      		if (username == '') {
      			error += 1;
      		}
      		re = /^\w+$/;
      		if (!re.test(username)) {
      			alert("Error: Username must contain only letters, numbers and underscores!");
      			error += 1;
      		

      		}

      		var userpword = document.multi.pwd.value;
      		if (userpword == '') {
      			error += 1;
      		}
      		if (userpword == username) {
      			alert("Error: Password must be different from Username!");
      			error += 1;
      		}
      		re = /[0-9]/;
      		if (!re.test(userpword)) {
      			alert("Error: password must contain at least one number (0-9)!");
      			error += 1;
      			
      		}
      		re = /[a-z]/;
      		if (!re.test(userpword)) {
      			alert("Error: password must contain at least one lowercase letter (a-z)!");
      			error += 1;
      			
      		}
      		re = /[A-Z]/;
      		if (!re.test(userpword)) {
      			alert("Error: password must contain at least one uppercase letter (A-Z)!");
      			error += 1;
      			
      		}

      		var numbers = /^[0-9]+$/;

      		var cmobile = document.multi.bmobile.value;
      		if (cmobile == '') {
      			error += 1;
      		} else if (!(cmobile.match(numbers))) {
      			alert('Mobile Should Accept Only Numbers');
      			error += 1;
      			
      		}
      		
      		var bphone = document.multi.bphn.value;
      		if (cmobile == '') {
      			error += 1;
      		} else if (!(bphone.match(numbers))) {
      			alert('Business Phone Should Accept Only Numbers');
      			error += 1;
      			
      		}

      		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
      		var cemail = document.multi.bemail.value;
      		if (cemail == '') {
      			error += 1;
      		} else if (!filter.test(cemail)) {
      			alert('Not a valid Email');
      			error += 1;
      			
      		}
      		var address1 = document.multi.baddr.value;
      		if (address1 == '') {
      			error += 1;
      		}
      		
      		if (error == 0) {
      			document.submit();
      			return true;
      		} 
      		else {
      			var div = document.getElementById("alertDiv");
      			div.innerHTML = "All Fields Are Mandatory";
      			return false;

      		}
      	}

      	function allnumeric(inputtxt) {
      		var numbers = /^[0-9]+$/;
      		if (inputtxt.value.match(numbers)) {

      			return true;
      		} else {
      			alert('Please Allow numeric characters only');
      			return false;
      		}
      	}
          </script>
    </head>
    <body>
        <form action="updateStoreDetails.do" method="post" name=multi onsubmit="return checkStoreForm()">
            
            <div style="position: absolute; width: 535px; height: 54px; z-index: 1; left: 590px; top: 266px" id="layer1">
                <div align="center">
                <table border="0" width="73%" id="table1">
                    <tr>
                        <td width="170"><b><font size="2">Store ID</font></b></td>
                        <td><input type="text" name="storeId" size="20" value="${strBean.storeId }" readonly></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">Store Name</font></b></td>
                        <td><input type="text" name="strname" size="20" value="${strBean.strname }" readonly></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">User Name</font></b></td>
                        <td>
                        <input type="text" name="uname" size="20" value="${strBean.uname }" readonly></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">Password</font></b></td>
                        <td><input type="password" name="pwd" size="20" value="${strBean.pwd }"></td>
                    </tr>
                   <tr>
                        <td><b><font size="2">Store Category</font></b></td>
                        <td width="54%">
                        <select size="1" name="strType" value="${strBean.strType }">
                        <option selected value="${strBean.strType }">${strBean.strType }</option>
                        <option value="Dollor Store">Dollar Store</option>
                        <option value="Branded Store">Branded Store</option>
                        <option value="Department Store">Department Store
                        </option>
                        <option value="Super Market">Super Market</option>
                        <option value="Hyper Market">Hyper Market</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">Business Address</font></b></td>
                        <td><textarea rows="2" name="baddr" cols="17">${strBean.baddr }</textarea></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">Business Phone</font></b></td>
                        <td><input type="text" name="bphn" size="20" value="${strBean.bphn }"></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">Mobile</font></b></td>
                        <td><input type="text" name="bmobile" size="20" value="${strBean.bmobile }"></td>
                    </tr>
                    <tr>
                        <td width="170"><b><font size="2">Email ID</font></b></td>
                        <td><input type="text" name="bemail" size="20" value="${strBean.bemail }" readonly></td>
                    </tr>
                </table>               
            	</div>
            </div>	  
            
             <div style="position: absolute; width: 169px; height: 36px; z-index: 1; left: 750px; top: 533px" id="layer7">&nbsp; 
                    <input type="submit" value="Update">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="Reset">&nbsp;
                </div>
        </form>
    </body>
</html>