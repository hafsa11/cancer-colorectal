<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.*"%>
<%@ page import="dao.entities.*"%>
<%@ page import="beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-theme.css" />
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" />
<script src="js/jquery.min.js">
	
</script>
<script src="js/bootstrap.js">
	
</script>
<title>Gestion des examens Cliniques</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div
				class="col-md-1 col-md-offset-1 col-lg-1 col-lg-offset-1 col-xs-1 col-xs-offset-1"
				id="logo">
				<img class="img" src="images\logo.png " width="" height=""
					alt="logo" />
			</div>
			<div class="col-lg-12 ">
				</br>
				</br>
			</div>
			<div class="row">

				<div class="pull-left col-lg-1">

					<div class="panel-body">
						<a href="espaceInfirmier.jsp"><button type="button"
								class="btn btn-primary btn-custom waves-effect waves-light m-b-5"
								style="width: 250px">Gestion Des Familles</button></a>
						<div class="col-sm-2 col-xs-2 col-md-2 col-lg-2"></div>
						</br>
						</br> <a href="gestionDossier.jsp"><button type="button"
								class="btn btn-success btn-custom waves-effect waves-light m-b-5"
								style="width: 250px">Gestion Des Dossiers Medicales</button></a>
						<div class="col-sm-2 col-xs-2 col-md-2 col-lg-2"></div>
						</br>
						</br> <a href="ajoutRendezVous.jsp"><button type="button"
								class="btn btn-info btn-custom waves-effect waves-light m-b-5"
								style="width: 250px">Gestion Des Rendez-Vous</button></a>
						<div class="col-sm-2 col-xs-2 col-md-2 col-lg-2"></div>
						</br>
						</br> <a><button type="button"
								class="btn btn-purple btn-custom waves-effect waves-light m-b-5"
								style="width: 250px">Deconnexion</button></a>
					</div>

				</div>

				<div class="col-lg-9 col-lg-offset-2">
					<div class="panel-body">
						<a href="gestionDossier.jsp"><button type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 250px">Nouveau Dossier M�dical</button></a> <a
							href="examens.jsp"><button type="button"
								class="btn btn-info btn-rounded waves-effect waves-light m-b-5"
								style="width: 250px">Examens Medicales</button></a> <a
							href="consultation.jsp"><button type="button"
								class="btn btn-warning btn-rounded waves-effect waves-light m-b-5"
								style="width: 250px">Consultation</button></a> </br> </br>
						<button type="button"
							class="btn btn-purple btn-rounded waves-effect waves-light m-b-5"
							style="width: 770px; height: 150px">Dossier M�dical</button>
					</div>
				</div>
				<div class="col-lg-12 ">
					<div class="panel-body">
						<a href="statut.jsp"><button type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 100px">Satut</button></a> <a href="ExamenClinique.jsp"><button
								type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 150px">Examen Clinique</button></a> <a
							href="Endoscopie.jsp"><button type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 150px">Endoscopie</button></a> <a
							href="AnaPathologie.jsp"><button type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 200px">Anatomie Pathologique</button></a> <a
							href="Imagerie.jsp"><button type="button"
								class="btn btn-info btn-rounded waves-effect waves-light m-b-5"
								style="width: 100px">Imagerie</button></a> <a href="Biologie.jsp"><button
								type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 100px">Biologie</button></a> <a href="Genetique.jsp"><button
								type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 100px">G�n�tique</button></a> <a href="Traitement.jsp"><button
								type="button"
								class="btn btn-default btn-rounded waves-effect m-b-5"
								style="width: 150px">Traitement</button></a>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">

						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Radiologie</h3>
							</div>
							<form class="form-horizontal" role="form"
								action="modImagerieTrait.chu" method="post">
								<div class="row">
									<div class="col-md-7 col-lg-offset-3">
										<div class="panel-body">
											<%
												Imagerie examen = (Imagerie) session.getAttribute("Imagerie");
												Date date = examen.getDateRadio();
												SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy");
												String dateFormatee = formatDateJour.format(date);
											%>
											<div class="form-group">
												<input type="hidden" class="form-control" name="dossier"
													value="<%=examen.getDossier().getId()%>"
													style="width: 250px">
											</div>
											<div class="form-group">
												<input type="hidden" class="form-control" name="idImagerie"
													value="<%=examen.getId()%>" style="width: 250px">
											</div>
											<div class="form-group">
												<label class="col-sm-2 form-control-label">Hopital:</label>
												<div class="col-sm-8">
													<%
														HopitalDAO hopDAO = new HopitalDAO();
														List<Hopital> hopitaux = new ArrayList<>();
														hopitaux = hopDAO.listerLesHopitaux();
													%>

													<select class="form-control" name="hopital"
														style="width: 250px" required>

														<%
															for (Hopital hop : hopitaux) {
														%>
														<option value="<%=hop.getId()%>"><%=hop.getHopital()%></option>
														<%
															}
														%>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 form-control-label">Medecin:</label>
												<div class="col-sm-8">
													<%
														MedecinDAO medDAO = new MedecinDAO();
														List<Medecin> medecins = new ArrayList<>();
														medecins = medDAO.listerLesMedecin();
													%>
													<select class="form-control" name="medecin"
														style="width: 250px" required>
														<%
															for (Medecin med : medecins) {
														%>
														<option value="<%=med.getId()%>"><%=med.getMedecin()%></option>
														<%
															}
														%>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 form-control-label">Examen:</label>
												<div class="col-sm-8">
													<%
														ExamenImagerieDAO examenDAO = new ExamenImagerieDAO();
														List<ExamenImagerie> examens = new ArrayList<>();
														examens = examenDAO.listerExamenImagerie();
													%>
													<select class="form-control" name="examen"
														style="width: 250px" required>
														<%
															for (ExamenImagerie exam : examens) {
														%>
														<option value="<%=exam.getId()%>"><%=exam%></option>
														<%
															}
														%>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label for="dateexamen" class="col-sm-2 form-control-label">Date
													d'examen:</label> <input type="text" name="dateImagerie"
													value="<%=dateFormatee%>" class="form-control"
													id="dateexamen" style="width: 250px" required>

											</div>
											<div class="form-group">
												<label for="" class="col-sm-2 form-control-label">Valeur</label>
												<input type="file" class="form-control" name="fichier" id=""
													value="<%=examen.getImage()%>" style="width: 250px"
													required>
											</div>

										</div>
									</div>

									<div class="form-group m-b-0">
										<div class="col-sm-offset-3 col-sm-9">
											<button type="submit"
												class="btn btn-info waves-effect waves-light">Modifier</button>
										</div>
									</div>


								</div>
							</form>
						</div>

					</div>
				</div>
				<!-- col -->



			</div>
		</div>
</body>
<footer>
<div class="row">
	<div
		class="col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4 col-xs-4 col-xs-offset-4"
		id="foot">
		<p>Copyright &copy; Registe@CRF</p>
	</div>
</div>
</footer>
</html>