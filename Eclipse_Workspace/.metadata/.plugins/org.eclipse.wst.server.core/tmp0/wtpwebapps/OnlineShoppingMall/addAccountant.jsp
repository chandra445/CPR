<jsp:include page="adminLogin.jsp"></jsp:include>
<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function checkData() {
		var error = 0;
		var fname = document.multi.ftname.value;
		if (fname == '') {
			error += 1;
		}
		var lname = document.multi.ltname.value;
		if (lname == '') {
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

		var cmobile = document.multi.mobile.value;
		if (cmobile == '') {
			error += 1;
		} else if (!(cmobile.match(numbers))) {
			alert('Mobile Should Accept Only Numbers');
			error += 1;
			
		}

		var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
		var cemail = document.multi.email.value;
		if (cemail == '') {
			error += 1;
		} else if (!filter.test(cemail)) {
			alert('Not a valid Email');
			error += 1;
			
		}
		var address1 = document.multi.addr1.value;
		if (address1 == '') {
			error += 1;
		}
		var address2 = document.multi.city.value;
		if (address2 == '') {
			error += 1;
			
		}
		var address3 = document.multi.state.value;
		if (address3 == '') {
			error += 1;
			
		}
		var address4 = document.multi.country.value;
		if (address4 == '') {
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
	<form action="registerAccountant.do" method="post" name="multi"
		onsubmit="return checkData()">
		<div
			style="position: absolute; width: 433px; height: 152px; z-index: 1; left: 600px; top: 273px"
			id="layer1">
			<table border="0" width="100%" id="table1">
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">First
							Name</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="ftname" size="20"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Last
							Name</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="ltname" size="20"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">User
							Name</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="uname" size="20"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Password</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="password" name="pwd" size="20"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Mobile
							Number</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="mobile" size="20"></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Email
							ID</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="email" size="20"></font></td>
				</tr>

				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Date
							of Birth</font></td>
					<td><input type="date" name="bday" size="20"></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Address1</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <textarea
								rows="2" name="addr1" cols="20"></textarea></font></td>
				</tr>
				<tr>
					<td width="32%"><font face="Arial Narrow" color="#666600">Address2</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <textarea
								rows="2" name="addr2" cols="20"></textarea></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">City</font></td>
					<td><font size="3" face="Trebuchet MS"> <input
							type="text" name="city" size="20"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">State</font></td>
					<td><font size="3" face="Trebuchet MS"> <input
							type="text" name="state" size="20"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Country</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="country" size="20"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Zip Code</font></td>
					<td width="66%"><font size="3" face="Trebuchet MS"> <input
							type="text" name="zip" size="20"></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><div id=alertDiv
							style="color: red"></div></td>
				</tr>
				<tr><td colspan="2" align="center" style="color: red">${msgFailure}</td></tr>
			</table>
		</div>
		<div
			style="position: absolute; width: 170px; height: 25px; z-index: 5; left: 750px; top: 600px"
			id="layer5">

			<p>
				<input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="Reset">
		</div>
		<div
			style="position: absolute; width: 319px; height: 36px; z-index: 2; left: 700px; top: 200px"
			id="layer2">
			<b><font face="Bell MT" size="5" color="#D15803">Account
					Registration</font></b>
		</div>

	</form>
</body>
</html>