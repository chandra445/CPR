<jsp:include page="index1.jsp"></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function validate() {
		var st = "";
		var i = 0;
		if (document.multi.username.value.trim() == "") {
			st += "\n User Name \n";
			i++;
		}
		if (document.multi.password.value.trim() == "") {
			st += "\n, Password \n";
			i++;
		}
		if (i == 0) {
			

			document.submit();
			return true;
		} else {
			var div = document.getElementById("alertDiv");
			div.innerHTML = "Please enter the below Fields........\n" + st;
			return false;
		}
	}
</script>

</head>
<body>
<h3></h3>
	<form action="login.do" name="multi" method="post"
		onsubmit="return validate()">
		<div
			style="position: absolute; width: 296px; height: 152px; z-index: 1; left: 650px; top: 286px"
			id="layer1">
			<table border="0" width="100%" id="table1">
			
				<tr>
					<td width="111"><font face="Arial Narrow">User Name</font></td>
					<td><input type="text" name="uname" size="23"></td>
					<td>*</td>
				</tr>
				<tr>
					<td width="111"><font face="Arial Narrow">Password</font></td>
					<td><input type="password" name="pwd" size="23"></td>
					<td>*</td>
				</tr>
				<tr>
					<td width="111"><font face="Arial Narrow">User Type</font></td>
					<td><select size="1" name="userRole">
							<option value="Admin">Admin</option>
							<option value="Store Manager">Store Manager</option>
							<option value="Accountant">Accountant</option>
							<option value="Customer">Customer</option>
					</select></td>
				</tr>
				<tr>
					<td width="111">&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width="111">&nbsp;</td>
					<td><input type="submit" value="Login" name="B1">&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="Reset" name="B2"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><div id=alertDiv
							style="color: red"></div></td>
				</tr>
				<tr><td colspan="2" align="center" style="color: red">${msg}</td></tr>
				<tr><td colspan="2" align="center" style="color: blue">${logoutMsg}</td></tr>
			</table>
			<p>&nbsp;&nbsp;&nbsp;
		</div>
	</form>
	<div
		style="position: absolute; width: 184px; height: 36px; z-index: 2; left: 750px; top: 192px"
		id="layer2">
		<b><font color="#D15803" size="5" face="Bell MT">Login</font></b>
	</div>
	<div
		style="position: absolute; width: 408px; height: 44px; z-index: 3; left: 482px; top: 430px"
		id="layer3">&nbsp;</div>
</body>
</html>