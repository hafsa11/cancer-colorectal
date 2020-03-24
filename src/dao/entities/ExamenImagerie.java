package dao.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExamenImagerie implements Serializable{
	
		   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String examen;
		public ExamenImagerie() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ExamenImagerie(int id, String examen) {
			super();
			this.id = id;
			this.examen = examen;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getExamen() {
			return examen;
		}
		public void setExamen(String examen) {
			this.examen = examen;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((examen == null) ? 0 : examen.hashCode());
			result = prime * result + id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ExamenImagerie other = (ExamenImagerie) obj;
			if (examen == null) {
				if (other.examen != null)
					return false;
			} else if (!examen.equals(other.examen))
				return false;
			if (id != other.id)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "" + examen + "";
		}
		
		
		

}
