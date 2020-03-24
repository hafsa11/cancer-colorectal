package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.entities.Utilisateur;

public class UtilisateurDAO {
	
	private final String  PU_NAME = "CHU";
    private EntityManagerFactory factory = null;

	
    
	public UtilisateurDAO() {
		factory = Persistence.createEntityManagerFactory(PU_NAME);
	}

	
	private EntityManager newEntityManager(){
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        return em;
    }
    
    private void closeEntityManager(EntityManager em){
        if(em != null){
            if(em.isOpen()){
                EntityTransaction trs = em.getTransaction();
                if(trs.isActive()){
                    trs.commit();
                }
                em.close();
            }
        }
    }
    
	
	 public boolean creerNouveauCompte(Utilisateur utilisateur){
	        boolean ajout = false;
	        try {
	            EntityManager em = this.newEntityManager();
	            em.persist(utilisateur);
	            this.closeEntityManager(em);
	            System.out.println("Utilisateur bien enregistre au platfrome !");
	            ajout = true;
	        } catch (Exception e) {
	            System.out.println("Erreur d'enregistrement du nouvel utilisateur !!!");
	        }
	        return ajout;
	    }
	    
	    public Utilisateur authentification(String loginOuEmail, String password){
	        Utilisateur utilisateur = null;
	        try {
	            EntityManager em = this.newEntityManager();
	            TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :log AND u.password = :pass", Utilisateur.class);
	            query.setParameter("log", loginOuEmail);
	            query.setParameter("pass", password);
	            System.out.println(loginOuEmail +" " +password);
	            utilisateur = query.getSingleResult();
	            this.closeEntityManager(em);
	        } catch (NoResultException e) {
	            System.out.println("Erreur authentification "+ e.getMessage());
	        }
	        return utilisateur;
	    }
	    
	    public boolean mettreAjourProfile(int idUtilisateur, Utilisateur nouvelUtilisateur){
	        boolean miseAjour = false;
	        try {
	            EntityManager em = this.newEntityManager();
	            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
	            utilisateur.setLogin(nouvelUtilisateur.getLogin());
	            utilisateur.setPassword(nouvelUtilisateur.getPassword());
	            utilisateur.setPhoto(nouvelUtilisateur.getPhoto());
	            this.closeEntityManager(em);
	            System.out.println("Profil de l'Utilisateur "+utilisateur+" est mise à jour !");
	            miseAjour = true;
	        } catch (Exception e) {
	            System.out.println("Erreur de mise à jour du profil utilisateur !!!");
	        }
	        return miseAjour;
	    }
	    
	    public int verifierUniciteChamps(String champ){
	        int nbrDefoisExistLeChamp = 0;
	        EntityManager em = this.newEntityManager();
	        Query requete = null;
	        
	       
	        requete = em.createQuery("SELECT COUNT u.login FROM Utilisateur u WHERE u.login = :champ");
	        
	        nbrDefoisExistLeChamp = Integer.parseInt(requete.getSingleResult().toString());
	        System.out.println("Nombre de champs trouve = "+nbrDefoisExistLeChamp);
	        
	        this.closeEntityManager(em);
	        return nbrDefoisExistLeChamp;
	    }
	    
	    public Utilisateur trouverUtilisateurParEmail(String login){
	        Utilisateur utilisateur = null;
	        EntityManager em = this.newEntityManager();
	        TypedQuery<Utilisateur> requete = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login", Utilisateur.class);
	        requete.setParameter("login", login);
	        try {
	            utilisateur = requete.getSingleResult();
	            this.closeEntityManager(em);
	        } catch (NoResultException e) {
	            System.out.println("Erreur : "+ e.getMessage());
	        }
	        return utilisateur;
	    }

}
