<%@ page language="java" import = "pack.* ,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Associer</title>
</head>
<body>
<form method="post" action="/TP3_OneToOne/Ser">
<h1>Associer</h1></br>
<%
Collection<Personne> lp = (Collection<Personne>)request.getAttribute("lp");

Collection<Adresse> la = (Collection<Adresse>)request.getAttribute("la");
%>

<b> Choisir la personne </b></br>
<%
for (Personne p: lp) {
	int idp = p.getId();
	String personne = p.getP();
%>
 <div> 	
 	 <input type="radio"   name="idp" value= "<%=idp %>" ><%= personne %>
 </div>
<%} %>
</br></br>


<b> Choisir l'adresse </b></br>
<%
for (Adresse a: la) {
	int ida = a.getId();
	String adresse = a.getAdresse();
	if (a.getId()!=0 && a.getRue()!=null && a.getVille()!=null){
%>
	<div>
		<input type="radio"  name="ida" value= "<%=ida%>"><%= adresse %>
	</div>
<%}} %>



</br></br>
 <input type="submit" name="op" value="Ok"/></br>
 
<p>

<a href = "Ser?op=Retour"> Retour</a> <br>
</p>

</form>


</body>
</html>



