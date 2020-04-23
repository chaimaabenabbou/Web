<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<b> Ajouter une personne</b></br></br>
</head>
<body>
<form action = "Ser" method="post">
 Nom : <input type="text" name = "nom"><br/><br/>
 Prenom : <input type="text" name = "prenom"><br/><br/>
 <input type="submit" value="ok"/>
 <input type="hidden" name="op" value="ajoutpersonne"/>
 </form>


</body>
</html>