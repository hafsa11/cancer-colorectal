package dao.entities;


import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;


@Entity
@SecondaryTable(name= Medecin.TABLE_NAME, pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))
public class Medecin  extends Utilisateur{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "Medecin";
	
		private String medecin;
	    private String specialte;
	    private String statut;
	    
	    @ManyToOne
	    private Hopital hopital;
	    

	    public Medecin() {
	    }


	    public Medecin(String nom, String prenom, String email, String login, String password) {
			super(nom, prenom, email, login, password);
			
		}


		public Medecin(String nom, String prenom, String email, String login, String password, String medecin,
				String specialte, String statut, Hopital hopital) {
			super(nom, prenom, email, login, password);
			this.medecin = medecin;
			this.specialte = specialte;
			this.statut = statut;
			this.hopital = hopital;
		}


		public String getMedecin() {
	        return medecin;
	    }

	    public void setMedecin(String medecin) {
	        this.medecin = medecin;
	    }

	    public String getSpecialte() {
	        return specialte;
	    }

	    public void setSpecialte(String specialte) {
	        this.specialte = specialte;
	    }
	    
	    
	    
	    public String getLogin() {
			return login;
		}



		public void setLogin(String login) {
			this.login = login;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getStatut() {
			return statut;
		}



		public void setStatut(String statut) {
			this.statut = statut;
		}



		public Hopital getHopital() {
			return hopital;
		}



		public void setHopital(Hopital hopital) {
			this.hopital = hopital;
		}



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((hopital == null) ? 0 : hopital.hashCode());
			result = prime * result + ((login == null) ? 0 : login.hashCode());
			result = prime * result + ((medecin == null) ? 0 : medecin.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((specialte == null) ? 0 : specialte.hashCode());
			result = prime * result + ((statut == null) ? 0 : statut.hashCode());
			return result;
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Medecin other = (Medecin) obj;
			if (hopital == null) {
				if (other.hopital != null)
					return false;
			} else if (!hopital.equals(other.hopital))
				return false;
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			if (medecin == null) {
				if (other.medecin != null)
					return false;
			} else if (!medecin.equals(other.medecin))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (specialte == null) {
				if (other.specialte != null)
					return false;
			} else if (!specialte.equals(other.specialte))
				return false;
			if (statut == null) {
				if (other.statut != null)
					return false;
			} else if (!statut.equals(other.statut))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "" + getNom() + " " + getPrenom() + "";
		}



	

		

	

	   

}
