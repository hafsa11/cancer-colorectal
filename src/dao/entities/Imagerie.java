package dao.entities;


import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;


@Entity
@SecondaryTable(name= Imagerie.TABLE_NAME, pkJoinColumns = @PrimaryKeyJoinColumn(name="id"))
public class Imagerie extends ExamenMedical{
	
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "Imagerie";
	
	@OneToOne
	private ExamenImagerie examen;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRadio;
    @Lob
    private Byte[] image;
    
	public Imagerie() {
		super();
	}
	
	
	public Imagerie(Hopital hopital, DossierMedicale dossier, ExamenImagerie examen, Date dateRadio, Byte[] image) {
		super(hopital, dossier);
		this.examen = examen;
		this.dateRadio = dateRadio;
		this.image = image;
	}


	public ExamenImagerie getExamen() {
		return examen;
	}


	public void setExamen(ExamenImagerie examen) {
		this.examen = examen;
	}


	public Date getDateRadio() {
		return dateRadio;
	}
	public void setDateRadio(Date dateRadio) {
		this.dateRadio = dateRadio;
	}
	public Byte[]  getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Imagerie [examen=" + examen + ", dateRadio=" + dateRadio + ", image=" + Arrays.toString(image) + "]";
	}
	
    
}
