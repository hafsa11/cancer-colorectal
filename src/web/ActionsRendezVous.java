package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BeanDossier;
import dao.DossierDAO;
import dao.IndividuDAO;
import dao.RendezDAO;
import dao.entities.Individu;
import dao.entities.RendezVous;

public class ActionsRendezVous {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private IndividuDAO indDAO;
	private RendezDAO rendDAO;
	private DossierDAO dosDAO;
	
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
	
	
	public ActionsRendezVous(IndividuDAO indDAO, RendezDAO rendDAO, DossierDAO dosDAO) {
		super();
		this.indDAO = indDAO;
		this.rendDAO = rendDAO;
		this.dosDAO = dosDAO;
	}
	public String ajoutRendezVous(){
		String pat = request.getParameter("patient");
		int id = Integer.parseInt(pat);
		Individu patient = indDAO.trouverIndById(id);
		
		String date = request.getParameter("dateRendez");
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateRendez = new Date();
		try {
			dateRendez = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String objet = request.getParameter("objet");
		String heure = request.getParameter("heure");

		String note = request.getParameter("note");
		RendezVous rendez = new RendezVous(dateRendez, heure, objet, note, patient);
		
		rendDAO.ajouterRendez(rendez);
		return "/formRendezVous.jsp";
	}
	public String suppRend(){
		String idy = request.getParameter("id");
		int id = Integer.parseInt(idy);
		rendDAO.supprimerRendez(id);
		
		return "/suppRendezVous.jsp";
	}
	public String rechercheRendezVousMod(){
		String id = request.getParameter("individu");
//		
		HttpSession session =  request.getSession();
		session.setAttribute("idPatient", id);
		return "/modRendeVous.jsp";
	}
	public String rechercheRendezVous(){
		String id = request.getParameter("individu");
//		
		HttpSession session =  request.getSession();
		session.setAttribute("idPatient", id);
		return "/suppRendezVous.jsp";
	}
	public String recherchePatientRendezMod(){
		String id = request.getParameter("famille");
//		
		HttpSession session =  request.getSession();
		session.setAttribute("idFamille", id);
		return "/modRendeVous.jsp";
	}
	public String recherchePatientRendez(){
		String id = request.getParameter("famille");
//		
		HttpSession session =  request.getSession();
		session.setAttribute("idFamille", id);
		return "/suppRendezVous.jsp";
	}
	public String rendezVous(){
		String idDossier = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("Dossier", idDossier);
		return "/formRendezVous.jsp";
	}
	public String rechercheDossierRendez(){
		String nom = request.getParameter("famille");
		BeanDossier bean =  new BeanDossier();
//		bean.setId(id_Famille);
		bean.setDossiers(dosDAO.listeDossierByNonFamille(nom));
		HttpSession session =  request.getSession();
		session.setAttribute("beanDossier", bean);
		return "/ajoutRendezVous.jsp";
	}
	public String modRendezTrait(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		RendezVous rendez = rendDAO.trouverRendezVousById(id);
		HttpSession sessionModRend = request.getSession();
		sessionModRend.setAttribute("RendezVous", rendez);
		return "/modRendezTrait.jsp";
	}
	public String modifierRendezVous(){
		String idRendez = request.getParameter("idRendez");
		int Ancienid = Integer.parseInt(idRendez);
		String pat = request.getParameter("patient");
		int id = Integer.parseInt(pat);
		Individu patient = indDAO.trouverIndById(id);
		
		String date = request.getParameter("dateRendez");
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateRendez = new Date();
		try {
			dateRendez = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String objet = request.getParameter("objet");
		String heure = request.getParameter("heure");

		String note = request.getParameter("note");
		RendezVous rendez = new RendezVous(dateRendez, heure, objet, note, patient);
		
		rendDAO.modifierRendez(Ancienid, rendez);
		return "/modRendeVous.jsp";
	}
}
