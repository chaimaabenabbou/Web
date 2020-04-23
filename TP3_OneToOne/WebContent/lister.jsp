<%@ page language="java" import = "pack.* ,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><b> </b></br></title>
</head>
<body>
<%
Collection <Personne> lpp = (Collection <Personne> )request.getAttribute("lpp");
%>


<h2> Personnes et leurs adresses </h2></br>
<%
for (Personne p: lpp) {
	Adresse a = p.getAdresses();
%>
	<% if( a != null ){ %>
	<p> <b><%=p.getP() %> </b></br>
	<p> <%=a.getAdresse() %> </p><br/>
<%} }%>

</br>

<a href = "Ser?op=Retour"> Retour </a> <br>

</body>
</html>