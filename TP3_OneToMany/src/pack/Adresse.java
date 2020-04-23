package pack;

import javax.persistence.*;

@Entity
public class Adresse {
	String rue;
	String ville;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@ManyToOne
	Personne owner;
	
	public Adresse(  String rue, String ville) {
		super();
		this.rue = rue;
		this.ville = ville;
	}
	public Adresse() {}
	
	
	public int getId() {
		return  id;
	}
	public void setId(int ida) {
		this.id = ida;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getAdresse() {
		return this.getId() + " rue " + this.getRue()+ " " + this.getVille(); 
		
	}
	public Personne getOwner() {
		return owner;
	}
	public void setOwner(Personne owner) {
		this.owner = owner;
	}

	
}
