package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DifferentiationDAO;
import dao.DossierDAO;
import dao.DysplasieDAO;
import dao.ExamenPostOpDAO;
import dao.ExamenPreOpAnormalDAO;
import dao.ExamenPreOpDAO;
import dao.HopitalDAO;
import dao.IndividuDAO;
import dao.LimiteResectEndoDAO;
import dao.NiveauInvasionDAO;
import dao.PolypeDAO;
import dao.SiegeDAO;
import dao.SousTypeDAO;
import dao.StromaDAO;
import dao.TumeurDAO;
import dao.TypeHystologiqueDAO;
import dao.TypePrelevementDAO;
import dao.entities.Differentiation;
import dao.entities.DossierMedicale;
import dao.entities.Dysplasie;
import dao.entities.ExamenPostOp;
import dao.entities.ExamenPreOp;
import dao.entities.Hopital;
import dao.entities.Lesion;
import dao.entities.LimiteChDist;
import dao.entities.LimiteChPro;
import dao.entities.LimiteResectEndo;
import dao.entities.MasseTumorale;
import dao.entities.NiveauInvasion;
import dao.entities.Polype;
import dao.entities.Polypose;
import dao.entities.Siege;
import dao.entities.SousType;
import dao.entities.Stroma;
import dao.entities.Tumeur;
import dao.entities.TypeHystologique;
import dao.entities.TypePrelevement;


public class ActionsAnapath {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private DossierDAO dosDAO;
	private HopitalDAO hopDAO;
	private TypePrelevementDAO typePrelDAO;
	private SiegeDAO siegeDAO;
	private TypeHystologiqueDAO typeHystoDAO;
	private DifferentiationDAO diffDAO;
	private StromaDAO stromaDAO;
	private NiveauInvasionDAO  niveauDAO;
	private TumeurDAO tumeurDAO;
	private PolypeDAO polypeDAO;
	private SousTypeDAO sousTypeDAO;
	private DysplasieDAO dyspDAO;
	private LimiteResectEndoDAO limiteEndoDAO;
	
	
	public ActionsAnapath() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ActionsAnapath(DossierDAO dosDAO, HopitalDAO hopDAO, TypePrelevementDAO typePrelDAO,
			SiegeDAO siegeDAO, TypeHystologiqueDAO typeHystoDAO, DifferentiationDAO diffDAO, StromaDAO stromaDAO,
			NiveauInvasionDAO niveauDAO, TumeurDAO tumeurDAO, PolypeDAO polypeDAO, SousTypeDAO sousTypeDAO,
			DysplasieDAO dyspDAO, LimiteResectEndoDAO limiteEndoDAO) {
		super();
		this.dosDAO = dosDAO;
		this.hopDAO = hopDAO;
		this.typePrelDAO = typePrelDAO;
		this.siegeDAO = siegeDAO;
		this.typeHystoDAO = typeHystoDAO;
		this.diffDAO = diffDAO;
		this.stromaDAO = stromaDAO;
		this.niveauDAO = niveauDAO;
		this.tumeurDAO = tumeurDAO;
		this.polypeDAO = polypeDAO;
		this.sousTypeDAO = sousTypeDAO;
		this.dyspDAO = dyspDAO;
		this.limiteEndoDAO = limiteEndoDAO;
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
	
	public String ajoutAnapath(){
		
		String doss= request.getParameter("dossier");
		
		int id_dossier =Integer.parseInt(doss);
		DossierMedicale dossier = dosDAO.trouverDossierById(id_dossier);
		
		String hop= request.getParameter("hopital");
		
		int id_hopital =Integer.parseInt(hop);
		Hopital hopital = hopDAO.trouverHopitalById(id_hopital);
		
		String typePrelev= request.getParameter("typePrelevement");
		
		int id_typePrelevement =Integer.parseInt(typePrelev);
		TypePrelevement typePrelevement = typePrelDAO.trouverTypePrelevementById(id_typePrelevement);
		
		String date = request.getParameter("dateExamen");
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateExamen = new Date();
		try {
			dateExamen = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String refAnaPath= request.getParameter("refAnaPath");

		String siegTumeur= request.getParameter("siegeTumeur");
		if(siegTumeur!=""){
			int id_siegeT =Integer.parseInt(siegTumeur);
			Siege siegeTumeur =siegeDAO.trouverSiegeById(id_siegeT);
			
			String typHystoTumeur= request.getParameter("typeHystoTumeur");
			int id_typHystoTumeur =Integer.parseInt(typHystoTumeur);
			TypeHystologique typeHystoTumeur =typeHystoDAO.trouverTypeHystologiqueById(id_typHystoTumeur);
			String difTumeur= request.getParameter("diffTumeur");
			int id_difTumeur =Integer.parseInt(difTumeur);
			Differentiation diffTumeur =diffDAO.trouverDifferentiationById(id_difTumeur);
			String strom= request.getParameter("stroma");
			int id_strom =Integer.parseInt(strom);
			Stroma stroma =stromaDAO.trouverStromaById(id_strom);
			String compColMuq= request.getParameter("compCollMuq");
			Float compCollMuq = null;
			if(compColMuq!=""){
				compCollMuq = Float.parseFloat(compColMuq);
			}
			String copCelInd= request.getParameter("compCelInd");
			Float compCellInd= null;
			if(copCelInd!=""){
				compCellInd = Float.parseFloat(copCelInd);
			}
			String emblVasc= request.getParameter("embolVasc");
			Boolean embolVasc=false;
			if(emblVasc!=""){
				embolVasc=true;
			}
			
			String engaPeri= request.getParameter("engaiPeri");
			Boolean engaiPeri=false;
			if(engaPeri!=""){
				engaiPeri=true;
			}
			String limitChirgPro= request.getParameter("limiteChirgPro");
			LimiteChPro   limiteChirgPro =LimiteChPro.valueOf(limitChirgPro);
			String limitChirgDist= request.getParameter("limiteChirgDist");
			LimiteChDist limiteChirgDist = LimiteChDist.valueOf(limitChirgDist);
			String niveauInvasion= request.getParameter("niveauInvasion");
			int id_niveau =Integer.parseInt(niveauInvasion);
			NiveauInvasion niveau =niveauDAO.trouverNiveauInvasionById(id_niveau);
			String ganglions= request.getParameter("ganglions");
			String nbrGanglions= request.getParameter("nbreGanglions");
			Integer nbreGanglions = null;
			if(nbrGanglions!=null){
				nbreGanglions =Integer.parseInt(nbrGanglions);
			}
			String loclPerit= request.getParameter("localPerit");
			Boolean localPerit=false;
			if(loclPerit!=""){
				localPerit=true;
			}
	
			Lesion lesion = null;
			String typHystoPolypeLesion= request.getParameter("typeHystoPolypeLesion");
			
				if(typHystoPolypeLesion!=""){
				
					int id_typeHystoPolypeLesion =Integer.parseInt(typHystoPolypeLesion);
					TypeHystologique typeHystoPolypeLesion =typeHystoDAO.trouverTypeHystologiqueById(id_typeHystoPolypeLesion);
					
					String siegPolypeLesion= request.getParameter("siegePolypeLesion");
					int id_siegePolypeLesion =Integer.parseInt(siegPolypeLesion);
					Siege siegePolypeLesion =siegeDAO.trouverSiegeById(id_siegePolypeLesion);
					Polypose polype = new Polypose(typeHystoPolypeLesion, siegePolypeLesion);
					
					String typHystoTumeurSynch= request.getParameter("typeHystoTumeurSynch");
					int id_typeHystoTumeurSynch =Integer.parseInt(typHystoTumeurSynch);
					TypeHystologique typeHystoTumeurSynch =typeHystoDAO.trouverTypeHystologiqueById(id_typeHystoTumeurSynch);
					
					
					String siegTumeurSynch= request.getParameter("siegeTumeurSynch");
					
					int id_siegeTumeurSynch =Integer.parseInt(siegTumeurSynch);
					Siege siegeTumeurSynch =siegeDAO.trouverSiegeById(id_siegeTumeurSynch);
					MasseTumorale tumeur = new  MasseTumorale(siegeTumeurSynch, typeHystoTumeurSynch);
					
					String mic= request.getParameter("mici");
					Boolean mici=false;
					if(mic!=""){
						mici=true;
					}
					String ulc�ration= request.getParameter("ulc�rations");
					Boolean ulc�rations=false;
					if(ulc�ration!=""){
						ulc�rations=true;
					}
					String autre= request.getParameter("autre");
					lesion = new  Lesion(polype, tumeur, mici, ulc�rations, autre);
				}
			Tumeur tumeur = new Tumeur(hopital, dossier, dateExamen, typePrelevement, refAnaPath, siegeTumeur, typeHystoTumeur, diffTumeur, compCollMuq, compCellInd, stroma, lesion, embolVasc, engaiPeri, limiteChirgPro, limiteChirgDist, niveau, ganglions, nbreGanglions, localPerit);
			tumeurDAO.ajouterTumeur(tumeur);
		}
		String nbre= request.getParameter("nbre");
		if(nbre !=""){
				int nombre = Integer.parseInt(nbre);
				String siegPolype= request.getParameter("siegePolype");
				int id_siegePolype =Integer.parseInt(siegPolype);
				Siege siegePolype =siegeDAO.trouverSiegeById(id_siegePolype);
				String typHystoPolype= request.getParameter("typeHystoPolype");
				int id_typeHystoPolype =Integer.parseInt(typHystoPolype);
				TypeHystologique typeHystoPolype =typeHystoDAO.trouverTypeHystologiqueById(id_typeHystoPolype);
				String souType= request.getParameter("sousType");
				int id_sousType =Integer.parseInt(souType);
				SousType sousType =sousTypeDAO.trouverSousTypeById(id_sousType);
				String dysplas= request.getParameter("dysplasie");
				int id_dysplasie =Integer.parseInt(dysplas);
				Dysplasie dysplasie =dyspDAO.trouverDifferentiationById(id_dysplasie);
				String limiteResectionEndot= request.getParameter("limiteResectionEndo");
				int id_limite =Integer.parseInt(limiteResectionEndot);
				LimiteResectEndo limiteResectionEndo =limiteEndoDAO.trouverDifferentiationById(id_limite);
				Polype polype = new Polype(hopital, dossier, dateExamen, typePrelevement, refAnaPath, nombre, siegePolype, typeHystoPolype, sousType, dysplasie, limiteResectionEndo);
				polypeDAO.ajouterPolype(polype);
		}
	
		
		return "/ajoutAnaPathologie.jsp";
	}
	public String suppAnatPath(){
		String id_Patient = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("idPatient", id_Patient);
		return "/suppAnatPath.jsp";
	}
	public String modAnatPath(){
		String id_Patient = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("idPatient", id_Patient);
		return "/modAnatPath.jsp";
	}
	
	public String suppTumeurTrait(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		TumeurDAO tumeurDAO =  new TumeurDAO();
		tumeurDAO.supprimerTumeur(id);
		return "/suppAnatPath.jsp";
	}
	
	public String suppPolypeTrait(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		PolypeDAO polypeDAO =  new PolypeDAO();
		polypeDAO.supprimerPolype(id);
		return "/suppAnatPath.jsp";
	}
	public String modTumeur(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		TumeurDAO tumeurDAO =  new TumeurDAO();
		Tumeur tumeur = tumeurDAO.trouverTumeurById(id);
		HttpSession sessionMod = request.getSession();
		sessionMod.setAttribute("Tumeur", tumeur);
		return "/modTumeur.jsp";
	}
	public String modPolype(){
		String ide = request.getParameter("id");
		int id = Integer.parseInt(ide);
		PolypeDAO polypeDAO =  new PolypeDAO();
		Polype polype = polypeDAO.trouverPolypeById(id);
		HttpSession sessionMod = request.getSession();
		sessionMod.setAttribute("Polype", polype);
		return "/modPolype.jsp";
	}
	public String modTumeurTrait(){
		
		String idTumeur = request.getParameter("idTumeur");
		int idAncienTumeur= Integer.parseInt(idTumeur);
		
		
		String doss= request.getParameter("dossier");
		
		int id_dossier =Integer.parseInt(doss);
		DossierMedicale dossier = dosDAO.trouverDossierById(id_dossier);
		
		String hop= request.getParameter("hopital");
		
		int id_hopital =Integer.parseInt(hop);
		Hopital hopital = hopDAO.trouverHopitalById(id_hopital);
		
		String typePrelev= request.getParameter("typePrelevement");
		
		int id_typePrelevement =Integer.parseInt(typePrelev);
		TypePrelevement typePrelevement = typePrelDAO.trouverTypePrelevementById(id_typePrelevement);
		
		String date = request.getParameter("dateExamen");
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateExamen = new Date();
		try {
			dateExamen = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String refAnaPath= request.getParameter("refAnaPath");

		String siegTumeur= request.getParameter("siegeTumeur");
	
			int id_siegeT =Integer.parseInt(siegTumeur);
			Siege siegeTumeur =siegeDAO.trouverSiegeById(id_siegeT);
			
			String typHystoTumeur= request.getParameter("typeHystoTumeur");
			int id_typHystoTumeur =Integer.parseInt(typHystoTumeur);
			TypeHystologique typeHystoTumeur =typeHystoDAO.trouverTypeHystologiqueById(id_typHystoTumeur);
			String difTumeur= request.getParameter("diffTumeur");
			int id_difTumeur =Integer.parseInt(difTumeur);
			Differentiation diffTumeur =diffDAO.trouverDifferentiationById(id_difTumeur);
			String strom= request.getParameter("stroma");
			int id_strom =Integer.parseInt(strom);
			Stroma stroma =stromaDAO.trouverStromaById(id_strom);
			String compColMuq= request.getParameter("compCollMuq");
			Float compCollMuq = null;
			if(compColMuq!=""){
				compCollMuq = Float.parseFloat(compColMuq);
			}
			String copCelInd= request.getParameter("compCelInd");
			Float compCellInd= null;
			if(copCelInd!=""){
				compCellInd = Float.parseFloat(copCelInd);
			}
			String emblVasc= request.getParameter("embolVasc");
			Boolean embolVasc=false;
			if(emblVasc!=""){
				embolVasc=true;
			}
			
			String engaPeri= request.getParameter("engaiPeri");
			Boolean engaiPeri=false;
			if(engaPeri!=""){
				engaiPeri=true;
			}
			String limitChirgPro= request.getParameter("limiteChirgPro");
			LimiteChPro   limiteChirgPro =LimiteChPro.valueOf(limitChirgPro);
			String limitChirgDist= request.getParameter("limiteChirgDist");
			LimiteChDist limiteChirgDist = LimiteChDist.valueOf(limitChirgDist);
			String niveauInvasion= request.getParameter("niveauInvasion");
			int id_niveau =Integer.parseInt(niveauInvasion);
			NiveauInvasion niveau =niveauDAO.trouverNiveauInvasionById(id_niveau);
			String ganglions= request.getParameter("ganglions");
			String nbrGanglions= request.getParameter("nbreGanglions");
			Integer nbreGanglions = null;
			if(nbrGanglions!=null){
				nbreGanglions =Integer.parseInt(nbrGanglions);
			}
			String loclPerit= request.getParameter("localPerit");
			Boolean localPerit=false;
			if(loclPerit!=""){
				localPerit=true;
			}
	
			Lesion lesion = null;
			String typHystoPolypeLesion= request.getParameter("typeHystoPolypeLesion");
			
				if(typHystoPolypeLesion!=""){
				
					int id_typeHystoPolypeLesion =Integer.parseInt(typHystoPolypeLesion);
					TypeHystologique typeHystoPolypeLesion =typeHystoDAO.trouverTypeHystologiqueById(id_typeHystoPolypeLesion);
					
					String siegPolypeLesion= request.getParameter("siegePolypeLesion");
					int id_siegePolypeLesion =Integer.parseInt(siegPolypeLesion);
					Siege siegePolypeLesion =siegeDAO.trouverSiegeById(id_siegePolypeLesion);
					Polypose polype = new Polypose(typeHystoPolypeLesion, siegePolypeLesion);
					
					String typHystoTumeurSynch= request.getParameter("typeHystoTumeurSynch");
					int id_typeHystoTumeurSynch =Integer.parseInt(typHystoTumeurSynch);
					TypeHystologique typeHystoTumeurSynch =typeHystoDAO.trouverTypeHystologiqueById(id_typeHystoTumeurSynch);
					
					
					String siegTumeurSynch= request.getParameter("siegeTumeurSynch");
					
					int id_siegeTumeurSynch =Integer.parseInt(siegTumeurSynch);
					Siege siegeTumeurSynch =siegeDAO.trouverSiegeById(id_siegeTumeurSynch);
					MasseTumorale tumeur = new  MasseTumorale(siegeTumeurSynch, typeHystoTumeurSynch);
					
					String mic= request.getParameter("mici");
					Boolean mici=false;
					if(mic!=""){
						mici=true;
					}
					String ulc�ration= request.getParameter("ulc�rations");
					Boolean ulc�rations=false;
					if(ulc�ration!=""){
						ulc�rations=true;
					}
					String autre= request.getParameter("autre");
					lesion = new  Lesion(polype, tumeur, mici, ulc�rations, autre);
				}
			Tumeur tumeur = new Tumeur(hopital, dossier, dateExamen, typePrelevement, refAnaPath, siegeTumeur, typeHystoTumeur, diffTumeur, compCollMuq, compCellInd, stroma, lesion, embolVasc, engaiPeri, limiteChirgPro, limiteChirgDist, niveau, ganglions, nbreGanglions, localPerit);
			tumeurDAO.modifierTumeur(idAncienTumeur, tumeur);
		
		
		return "/modTumeur.jsp";
	}
	public String modPolypeTrait(){
		String idPolype = request.getParameter("idPolype");
		int idAncienPolype= Integer.parseInt(idPolype);
		
		String doss= request.getParameter("dossier");
		
		int id_dossier =Integer.parseInt(doss);
		DossierMedicale dossier = dosDAO.trouverDossierById(id_dossier);
		
		String hop= request.getParameter("hopital");
		
		int id_hopital =Integer.parseInt(hop);
		Hopital hopital = hopDAO.trouverHopitalById(id_hopital);
		
		String typePrelev= request.getParameter("typePrelevement");
		
		int id_typePrelevement =Integer.parseInt(typePrelev);
		TypePrelevement typePrelevement = typePrelDAO.trouverTypePrelevementById(id_typePrelevement);
		
		String date = request.getParameter("dateExamen");
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Date dateExamen = new Date();
		try {
			dateExamen = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String refAnaPath= request.getParameter("refAnaPath");
		
		String nbre= request.getParameter("nbre");
		
				int nombre = Integer.parseInt(nbre);
				String siegPolype= request.getParameter("siegePolype");
				int id_siegePolype =Integer.parseInt(siegPolype);
				Siege siegePolype =siegeDAO.trouverSiegeById(id_siegePolype);
				String typHystoPolype= request.getParameter("typeHystoPolype");
				int id_typeHystoPolype =Integer.parseInt(typHystoPolype);
				TypeHystologique typeHystoPolype =typeHystoDAO.trouverTypeHystologiqueById(id_typeHystoPolype);
				String souType= request.getParameter("sousType");
				int id_sousType =Integer.parseInt(souType);
				SousType sousType =sousTypeDAO.trouverSousTypeById(id_sousType);
				String dysplas= request.getParameter("dysplasie");
				int id_dysplasie =Integer.parseInt(dysplas);
				Dysplasie dysplasie =dyspDAO.trouverDifferentiationById(id_dysplasie);
				String limiteResectionEndot= request.getParameter("limiteResectionEndo");
				int id_limite =Integer.parseInt(limiteResectionEndot);
				LimiteResectEndo limiteResectionEndo =limiteEndoDAO.trouverDifferentiationById(id_limite);
				Polype polype = new Polype(hopital, dossier, dateExamen, typePrelevement, refAnaPath, nombre, siegePolype, typeHystoPolype, sousType, dysplasie, limiteResectionEndo);
				polypeDAO.modifierPolype(idAncienPolype, polype);
		return "/modPolype.jsp";
	}
}
