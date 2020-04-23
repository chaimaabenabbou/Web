package pack;
import java.util.*;

import javax.ejb.Singleton;
import javax.persistence.*;



@Singleton
public class Facade {
	
	@PersistenceContext
	private EntityManager em;
		
	public void ajoutPersonne(String nom, String prenom) {
		Personne p = new Personne( nom, prenom);
		em.persist(p);
		
	}
	public void ajoutAdresse(String rue, String ville) {
		Adresse a = new Adresse(rue, ville);
		em.persist(a);
	}
	public Collection<Personne> listePersonnes(){
		TypedQuery<Personne> req = em.createQuery("select p from Personne p",Personne.class);
		Collection<Personne> personnes = req.getResultList();
		return personnes;
	}
	public Collection<Adresse> listeAdresses(){
		TypedQuery<Adresse> req = em.createQuery("select a from Adresse a",Adresse.class);
		Collection<Adresse> adresses = req.getResultList();
		return adresses;
	}
	public void associer(int idp, int ida) {		
		Personne p =em.find(Personne.class,idp);
		Adresse a = em.find(Adresse.class,ida);
		if (p==null || a == null) throw new RuntimeException("P ou A null");

		a.setOwner(p);
		p.getAdresses().add(a);
	}
}
