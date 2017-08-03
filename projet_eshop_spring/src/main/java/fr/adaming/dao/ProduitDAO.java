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
		//Mise à jour du client avec la commande update.
		s.update(produit);
	}

	@Override
	public void delete(long id) {
		Session s = sf.getCurrentSession();
		//Trouver le client à updater en utilisant la méthode get
		Produit pr = (Produit) s.get(Produit.class, id);
				
		s.delete(pr);
	}

	@Override
	public Produit getById(long id) {
		Session s = sf.getCurrentSession();
		// Récuperer le client par id en utilisant une fonction de Hibernate
		Produit produit = (Produit) s.get(Produit.class, id);

		return produit;
	}

	@Override
	public List<Produit> getAll() {
		Session s = sf.getCurrentSession();
		
		//Requête HQL
		String req = "FROM Produit";
		//Création de la requête
		Query query = s.createQuery(req);
				
		//Récupération des résultats de la requête sous forme de liste
		List<Produit> listeProduit = query.list(); 
				
		return listeProduit;
	}

	@Override
	public Produit getByNom(String nom) {
		Session s = sf.getCurrentSession();
		
		//Requête HQL
		String req = "FROM Produit as p WHERE p.designation=:pNom";
		//Création de la requête
		Query query = s.createQuery(req);
		 //Assignation des paramètres 
        query.setParameter("pNom", nom);

        //Récupération du résultat de la requête
        Produit produit_rec = (Produit) query.uniqueResult();

        return produit_rec;
	}
}
