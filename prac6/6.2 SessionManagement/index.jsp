<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Session Management</title> 
</head> 
<body> 
<% 
	Integer visitCount = (Integer) session.getAttribute("visitCount"); 
	if (visitCount == null) { 
    	visitCount = 1; 
	} else { 
    	visitCount += 1; 
	} 
	session.setAttribute("visitCount", visitCount); 
%> 
 
<h2>Welcome to the Session Management Page</h2> 
<p>You have visited this page <%= visitCount %> times.</p> 
 
</body> 
</html> 