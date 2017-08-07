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
		// R�cup�ration de la session actuelle
		Session s = sf.getCurrentSession();

		// Ajouter la cat�gorie dans le contexte Hibernate
		s.save(categorie);
	}

	@Override
	public void update(Categorie categorie) {
		// R�cup�ration de la session actuelle
		Session s = sf.getCurrentSession();

		// Mise � jour de la cat�gorie dans le contexte Hibernate
		s.update(categorie);

	}

	@Override
	public void delete(long id) {
		// R�cup�ration de la session actuelle
		Session s = sf.getCurrentSession();

		// R�cup�ration de la cat�gorie correspondant avec l'id
		Categorie categorie = (Categorie) s.get(Categorie.class, id);

		// Suppression de la cat�gorie dans le contexte Hibernate
		s.delete(categorie);

	}

	@Override
	public Categorie getById(long id) {
		// R�cup�ration de la session actuelle
		Session s = sf.getCurrentSession();

		// R�cuperer le client par id en utilisant une fonction de Hibernate
		Categorie categorie = (Categorie) s.get(Categorie.class, id);

		return categorie;
	}

	@Override
	public List<Categorie> getAll() {
		// R�cup�ration de la session actuelle
		Session s = sf.getCurrentSession();

		// Requ�te HQL
		String req = "FROM Categorie";
		// Cr�ation de la requ�te
		Query query = s.createQuery(req);

		// R�cup�ration des r�sultats de la requ�te sous forme de liste
		List<Categorie> listeCategories = query.list();

		return listeCategories;
	}

	@Override
	public Categorie getByNom(String nom) {
		// R�cup�ration de la session actuelle
		Session s = sf.getCurrentSession();

		// Requ�te HQL
		String req = "FROM Categorie as c WHERE c.nomCategorie=:pNom";
		// Cr�ation de la requ�te
		Query query = s.createQuery(req);
		// Assignation des param�tres
		query.setParameter("pNom", nom);

		// R�cup�ration du r�sultat de la requ�te
		Categorie categorie_rec = (Categorie) query.uniqueResult();

		return categorie_rec;
	}

}
