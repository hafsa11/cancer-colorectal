<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="arbre.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<applet code="arbre.Arbre.class" width="300" height="200" codebase="/arbre/Arbre" archive="test.jar">
Votre navigateur n'est pas compatible Java !
</applet>

<applet code="Arbre.class" width="300" height="200" codebase="arbre/Arbre" archive="test.jar">
Votre navigateur n'est pas compatible Java !
</applet>

<applet code="Arbre.class" width="300" height="200" archive="test2.jar">
Votre navigateur n'est pas compatible Java !
</applet>

<applet code="Arbre.class" width="300" height="200" archive="test3.jar">
Votre navigateur n'est pas compatible Java !
</applet>

<applet code="arbre.Arbre.class" width="300" height="200" archive="test4.jar">
Votre navigateur n'est pas compatible Java !
</applet>
   
 <jsp:plugin type="applet" code="Arbre.class" width="300" height="200" codebase="." archive="test.jar">
 </jsp:plugin>

</body>
</html>