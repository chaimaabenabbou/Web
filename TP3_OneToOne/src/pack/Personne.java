package pack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Personne {

	String nom;
	String Prenom;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;	
	
	@OneToOne(fetch=FetchType.EAGER,mappedBy = "owner") //chargement des @
	Adresse adresses ;
	
	public Personne( String nom, String prenom) {
		super();
		this.nom = nom;
		Prenom = prenom; 
	}
	public Personne() {}
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Adresse getAdresses() {
		return adresses;
	}
	public void setAdresses(Adresse adresses) {
		this.adresses = adresses;
	}

	public String getP() {
		return this.nom +" "+ this.Prenom;
	}
	
}
