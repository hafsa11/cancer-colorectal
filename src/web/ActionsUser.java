package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComplicationDAO;
import dao.DossierDAO;
import dao.ElargissementDAO;
import dao.GesteDAO;
import dao.HopitalDAO;
import dao.RRscoringDAO;
import dao.TraitementDAO;
import dao.TypeExereseDAO;
import dao.TypeInterventionDAO;
import dao.entities.Chimiotherapie;
import dao.entities.Chirurgie;
import dao.entities.Complication;
import dao.entities.Deroulement;
import dao.entities.DossierMedicale;
import dao.entities.Elargissement;
import dao.entities.Geste;
import dao.entities.Hopital;
import dao.entities.Imagerie;
import dao.entities.RRscoring;
import dao.entities.Radiotherapie;
import dao.entities.Traitement;
import dao.entities.TraitementEndoscopique;
import dao.entities.TypeExerese;
import dao.entities.TypeIntervention;

public class ActionsUser {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ActionsUser() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
	
}
