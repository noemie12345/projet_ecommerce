package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Produit;

@Repository
public class ProduitDAO implements IProduitDAO {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(Produit produit) {
		Session s = sf.getCurrentSession();
		//Ajouter le client dans le contexte Hibernate
		s.save(produit);
	}

	@Override
	public void update(Produit produit) {
		Session s = sf.getCurrentSession();
		//Mise � jour du client avec la commande update.
		s.update(produit);
	}

	@Override
	public void delete(long id) {
		Session s = sf.getCurrentSession();
		//Trouver le client � updater en utilisant la m�thode get
		Produit pr = (Produit) s.get(Produit.class, id);
				
		s.delete(pr);
	}

	@Override
	public Produit getById(long id) {
		Session s = sf.getCurrentSession();
		// R�cuperer le client par id en utilisant une fonction de Hibernate
		Produit produit = (Produit) s.get(Produit.class, id);

		return produit;
	}

	@Override
	public List<Produit> getAll() {
		Session s = sf.getCurrentSession();
		
		//Requ�te HQL
		String req = "FROM Produit";
		//Cr�ation de la requ�te
		Query query = s.createQuery(req);
				
		//R�cup�ration des r�sultats de la requ�te sous forme de liste
		List<Produit> listeProduit = query.list(); 
				
		return listeProduit;
	}

	@Override
	public Produit getByNom(String nom) {
		Session s = sf.getCurrentSession();
		
		//Requ�te HQL
		String req = "FROM Produit as p WHERE p.designation=:pNom";
		//Cr�ation de la requ�te
		Query query = s.createQuery(req);
		 //Assignation des param�tres 
        query.setParameter("pNom", nom);

        //R�cup�ration du r�sultat de la requ�te
        Produit produit_rec = (Produit) query.uniqueResult();

        return produit_rec;
	}
}
