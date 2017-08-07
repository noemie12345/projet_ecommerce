package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Categorie;

@Repository
public class CategorieDAO implements ICategorieDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public void add(Categorie categorie) {
		// Récupération de la session actuelle
		Session s = sf.getCurrentSession();

		// Ajouter la catégorie dans le contexte Hibernate
		s.save(categorie);
	}

	@Override
	public void update(Categorie categorie) {
		// Récupération de la session actuelle
		Session s = sf.getCurrentSession();

		// Mise à jour de la catégorie dans le contexte Hibernate
		s.update(categorie);

	}

	@Override
	public void delete(long id) {
		// Récupération de la session actuelle
		Session s = sf.getCurrentSession();

		// Récupération de la catégorie correspondant avec l'id
		Categorie categorie = (Categorie) s.get(Categorie.class, id);

		// Suppression de la catégorie dans le contexte Hibernate
		s.delete(categorie);

	}

	@Override
	public Categorie getById(long id) {
		// Récupération de la session actuelle
		Session s = sf.getCurrentSession();

		// Récuperer le client par id en utilisant une fonction de Hibernate
		Categorie categorie = (Categorie) s.get(Categorie.class, id);

		return categorie;
	}

	@Override
	public List<Categorie> getAll() {
		// Récupération de la session actuelle
		Session s = sf.getCurrentSession();

		// Requête HQL
		String req = "FROM Categorie";
		// Création de la requête
		Query query = s.createQuery(req);

		// Récupération des résultats de la requête sous forme de liste
		List<Categorie> listeCategories = query.list();

		return listeCategories;
	}

	@Override
	public Categorie getByNom(String nom) {
		// Récupération de la session actuelle
		Session s = sf.getCurrentSession();

		// Requête HQL
		String req = "FROM Categorie as c WHERE c.nomCategorie=:pNom";
		// Création de la requête
		Query query = s.createQuery(req);
		// Assignation des paramètres
		query.setParameter("pNom", nom);

		// Récupération du résultat de la requête
		Categorie categorie_rec = (Categorie) query.uniqueResult();

		return categorie_rec;
	}

}
