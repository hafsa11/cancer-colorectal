package dao.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name= Administrateur.TABLE_NAME, pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))
public class Administrateur extends Medecin{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "Administrateur";

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom, String prenom, String email, String login, String password, String medecin,
			String specialte, String statut, Hopital hopital) {
		super(nom, prenom, email, login, password, medecin, specialte, statut, hopital);
		// TODO Auto-generated constructor stub
	}
}
