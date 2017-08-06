package fr.adaming.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

@Repository
public class CommandeDAO implements IGeneriqueDAO<Commande> {

	@Autowired
	private SessionFactory sf;

	@Override
	public void add(Commande commande) {
		// Ouverture d"une session
		Session s = sf.getCurrentSession();

		// Ajout de la commande dans le contexte Hibernate
		s.save(commande);
	}

	@Override
	public void update(Commande commande) {
		// Ouverture d"une session
		Session s = sf.getCurrentSession();

		// Envoi de la commande mise à jour dans le contexte Hibernate
		s.update(commande);

	}

	@Override
	public void delete(long id) {
		// Ouverture d"une session
		Session s = sf.getCurrentSession();

		// Trouver la commande à supprimer en utilisant la méthode get
		Commande commande = (Commande) s.get(Commande.class, id);

		// Suppression de la commande dans le contexte Hibernate
		s.delete(commande);

	}

	@Override
	public Commande getById(long id) {
		// Ouverture d"une session
		Session s = sf.getCurrentSession();

		// Requête HQL
		String req = "FROM Commande as c WHERE e.idCommande=:pId";

		// Création de la requête avec l'objet Query
		Query query = s.createQuery(req);

		// Assignation des paramètres de la requête
		query.setParameter("pId", id);

		// Récupération de la requête dans un objet Commande
		Commande commande = (Commande) query.uniqueResult();

		return commande;
	}

	@Override
	public List<Commande> getAll() {
		// Ouverture d"une session
		Session s = sf.getCurrentSession();

		// Requête HQL
		String req = "FROM Commande";

		// Création de la requête avec l'objet Query
		Query query = s.createQuery(req);

		// Récupération de la réponse à la requête dans une liste de Commande
		@SuppressWarnings("unchecked")
		List<Commande> listeCommandes = query.list();

		return listeCommandes;
	}

}
