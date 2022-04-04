<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sending email</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body style="background:#80BFFF">
<center>
<form action="./EmailServlet">   
<table>
<tr>
<td>From</td>
<td><input type="text" name="from"></td>
</tr>
<tr>
<tr>
<td>To</td>
<td><input type="text" name="to"></td>
</tr>
<tr>
<td>Subject</td>
<td><input type="text" name="subject"></td>
</tr>    
<tr>
<td>Message</td>
<td><textarea cols="25" rows="8" name="message"></textarea></td>
</tr>
<tr>
<td>Login</td>
<td><input type="text" name="login"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
</table>
<br>
<input type="submit" value="submit">
</form>
</center>
 
</body>
</html>