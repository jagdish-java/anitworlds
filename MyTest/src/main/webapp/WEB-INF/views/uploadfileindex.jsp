<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<h2><a href="uploadfile.jsp">Upload Example</a></h2>
<%
if (session.getAttribute("uploadFile") != null
&& !(session.getAttribute("uploadFile")).equals("")) {
%>
<h3>Uploaded File</h3>
<br>
<img src="<%=session.getAttribute("uploadFile")%>" alt="Upload Image" />

<%
session.removeAttribute("uploadFile");
}
%>
</body>
</html>