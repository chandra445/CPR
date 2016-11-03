<jsp:include page="index1.jsp"></jsp:include>
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
	<form action="registerStore.do" method=post name=multi
		onsubmit="return checkStoreForm()">
		<div
			style="position: absolute; width: 433px; height: 152px; z-index: 1; left: 600px; top: 273px"
			id="layer1">
			<table border="0" width="100%" id="table1">
				<tr>
					<td width="41%"><font face="Arial Narrow" color="#666600">Name
							of Store</font></td>
					<td width="56%"><font face="Trebuchet MS"> <input
							type="text" name="strname" size="20"></font></td>
				</tr>
				<tr>
					<td width="41%"><font face="Arial Narrow" color="#666600">User
							Name</font></td>
					<td width="56%"><font face="Trebuchet MS"> <input
							type="text" name="uname" size="20"></font></td>
				</tr>
				<tr>
					<td width="41%"><font face="Arial Narrow" color="#666600">Password</font></td>
					<td width="56%"><font face="Trebuchet MS"> <input
							type="password" name="pwd" size="20"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Store
							Category</font></td>
					<td width="56%"><font face="Trebuchet MS"> <select
							size="1" name="strType">
								<option selected value="Select">Select</option>
								<option value="Dollor Store">Dollar Store</option>
								<option value="Branded Store">Branded Store</option>
								<option value="Department Store">Department Store</option>
								<option value="Super Market">Super Market</option>
								<option value="Hyper Market">Hyper Market</option>
						</select></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Business
							Address</font></td>
					<td width="56%"><textarea rows="2" name="baddr" cols="18"></textarea></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Business
							Phone Number</font></td>
					<td width="56%"><font face="Trebuchet MS"> <input
							type="text" name="bphn" size="20"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">Business
							Mobile Number</font></td>
					<td width="56%"><font face="Trebuchet MS"> <input
							type="text" name="bmobile" size="20"></font></td>
				</tr>
				<tr>
					<td><font face="Arial Narrow" color="#666600">business
							Email ID</font></td>
					<td width="56%"><font face="Trebuchet MS"> <input
							type="text" name="bemail" size="20"></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><div id=alertDiv
							style="color: red"></div></td>
				</tr>
			</table>

		</div>
		<div
			style="position: absolute; width: 150px; height: 19px; z-index: 5; left: 751px; top: 519px"
			id="layer5">

			<p>
				<input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="Reset">
		</div>
		<div
			style="position: absolute; width: 319px; height: 36px; z-index: 2; left: 700px; top: 192px"
			id="layer2">
			<b><font face="Bell MT" size="5" color="#D15803">Store
					Registration</font></b>
		</div>

	</form>
</body>
</html>
