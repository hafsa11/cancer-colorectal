package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DossierDAO;
import dao.ExamenImagerieDAO;
import dao.HopitalDAO;
import dao.ImagerieDAO;

import dao.entities.DossierMedicale;
import dao.entities.ExamenImagerie;
import dao.entities.Hopital;
import dao.entities.Imagerie;



public class ActionsImagerie {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private DossierDAO dosDAO;
	private HopitalDAO hopDAO;
	private ExamenImagerieDAO examImagDAO;
	private ImagerieDAO imagDAO;
	public ActionsImagerie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ActionsImagerie(DossierDAO dosDAO, HopitalDAO hopDAO, ExamenImagerieDAO examImagDAO, ImagerieDAO imagDAO) {
		super();
		this.dosDAO = dosDAO;
		this.hopDAO = hopDAO;
		this.examImagDAO = examImagDAO;
		this.imagDAO = imagDAO;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String ajoutImagerie(){
		String idDossier= request.getParameter("dossier");
		int id_dossier =Integer.parseInt(idDossier);
		DossierMedicale dossier = dosDAO.trouverDossierById(id_dossier);
		String idHopital= request.getParameter("hopital");
		int id_hopital =Integer.parseInt(idHopital);
		Hopital hopital = hopDAO.trouverHopitalById(id_hopital);
//		String medecin= request.getParameter("medecin");
		String date= request.getParameter("dateImagerie");
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateImagerie = new Date();
		try {
			dateImagerie = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String exam= request.getParameter("examen");
		int id_examen =Integer.parseInt(exam);
		ExamenImagerie examen = examImagDAO.trouverAspectMacroById(id_examen);
		
		String image= request.getParameter("fichier");
		
		Imagerie imagerie = new Imagerie(hopital, dossier, examen, dateImagerie, null);
		
		imagDAO.ajouterRadio(imagerie);
		
		return "/ajoutImagerie.jsp";
	}
	public String suppImagerie(){
		String id_Patient = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("idPatient", id_Patient);
		return"/suppImagerie.jsp";
	}
	public String modImagerie(){
		String id_Patient = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("idPatient", id_Patient);
		return "/modImagerie.jsp";
	}
	public String suppImagerieTrait(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		imagDAO.supprimerRadio(id);
		return "/suppImagerie.jsp";
	}
	public String modImag(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		Imagerie imagerie = imagDAO.trouverImagerieById(id);
		HttpSession sessionMod = request.getSession();
		sessionMod.setAttribute("Imagerie", imagerie);
		return "/modImagerieF.jsp";
	}
	public String modImagerieTrait(){
		String idImagerie = request.getParameter("idImagerie");
		int idAncienImagerie= Integer.parseInt(idImagerie);
		
		String idDossier= request.getParameter("dossier");
		int id_dossier =Integer.parseInt(idDossier);
		DossierMedicale dossier = dosDAO.trouverDossierById(id_dossier);
		String idHopital= request.getParameter("hopital");
		int id_hopital =Integer.parseInt(idHopital);
		Hopital hopital = hopDAO.trouverHopitalById(id_hopital);
//		String medecin= request.getParameter("medecin");
		String date= request.getParameter("dateImagerie");
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateImagerie = new Date();
		try {
			dateImagerie = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String exam= request.getParameter("examen");
		int id_examen =Integer.parseInt(exam);
		ExamenImagerie examen = examImagDAO.trouverAspectMacroById(id_examen);
		
		String image= request.getParameter("fichier");
		
		Imagerie imagerie = new Imagerie(hopital, dossier, examen, dateImagerie, null);
		
		imagDAO.modifierRadio(idAncienImagerie, imagerie);
		return "/modImagerie.jsp";
	}
}
