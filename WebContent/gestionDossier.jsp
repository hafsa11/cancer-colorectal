<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="dao.*" %>
<%@ page import="dao.entities.*" %>
<%@ page import="beans.*" %>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>Espace Utilisateur</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
	


    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


</head>

<body>

    <div id="wrapper">
	<%@include file="enteteUt.jsp" %>

        <div id="page-wrapper">

            <div class="container-fluid">
				
                <!-- Page Heading -->
                <div class="row">
                	<h3 class="page-header" style="text-align:center">
                            <img class="img"  src="images\logo.png " width="" height="" alt="logo"/><small></small>
                   </h3>
                  <h3 class="page-header">
                            Gestion des dossiers médicaux <small></small>
                   </h3>
                <!-- /.row -->
			<div class="row">
                <div class="col-md-10 col-lg-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 class="panel-title">Liste des familles</h3></div>
                        <%
                        	FamilleDAO famDAO = new FamilleDAO();
                        	List<Famille> familles = new ArrayList<>();
                        	familles= famDAO.lister();
                        %>
                        <div class="panel-body">
                            	<table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th></th>
                                                            <th>Nom de Famille</th>
                                                            <th>Cas Index</th>
                                                            <th>Diagnostic</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
												<%
												int i=1;
												for(Famille famille :familles){		
				                               %>
                                                        <tr>
                                                            <td><%=i %></td>
                                                            <td><%=famille.getNomFamille() %></td>
                                                            <td><%=famille.getCasIndex()%></td> 
                                                            <td><%=famille.getDiagnostic()%></td>
															<td><a href="listIndDoss.chu?id=<%=famille.getId()%>"> <i class="fa fa-eye" > </i> Consulter</a></td>
                                                        </tr>
														
													<% 
													i++;
                                        			}
												
													%>
                                                    </tbody>
                                        </table>
                        </div><!-- panel-body -->
						
                    </div> <!-- panel -->
                </div> <!-- col-->

            </div> <!-- End row -->
         </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    </div>
    </body>
    
	<%@include file="piedUt.jsp" %>
</html>