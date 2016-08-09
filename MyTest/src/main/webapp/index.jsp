<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<script type="text/javascript" src="WEB-INF/js/angular/angular.js"></script>
    <script type="text/javascript" src="WEB-INF/js/myApp.js"></script>
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

	<!-- <div ng-controller = "myCtrl">
		<input type="file" file-model="myFile"/>
		<button ng-click="uploadFile()">upload me</button>
	</div> -->
</body>
</html>
