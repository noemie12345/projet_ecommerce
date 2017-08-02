package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDAO implements IClientDAO{

	@Autowired
	private SessionFactory sf;
	
	//Setter de SessionFactory
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void add(Client client) {
		//Ouverture d'une session 
		Session s = sf.getCurrentSession();
		
		//Ajouter le client dans le contexte Hibernate
		s.save(client);
	}

	@Override
	public void update(Client client) {
		Session s = sf.getCurrentSession();
		
		//Mise � jour du client avec la commande update.
		s.update(client);
	}

	@Override
	public void delete(Long id) {
		Session s = sf.getCurrentSession();
		
		//Trouver le client � updater en utilisant la m�thode get
		Client cl = (Client) s.get(Client.class, id);
		
		s.delete(cl);
	}

	@Override
	public Client getById(Long id) {
		Session s = sf.getCurrentSession();
		
		//R�cuperer le client par id en utilisant une fonction de Hibernate 
		Client client = (Client) s.get(Client.class, id);
		
		return client;
	}

	@Override
	public List<Client> getAll() {
		Session s = sf.getCurrentSession();
		
		//Requ�te HQL
		String req = "FROM Client";
		
		//Cr�ation de la requ�te
		Query query = s.createQuery(req);
		
		//R�cup�ration des r�sultats de la requ�te sous forme de liste
		List<Client> listeClient = query.list(); 
		
		return listeClient;
	}

	@Override
	public Client getByNom(String nom) {
		// TODO Auto-generated method stub
		Session s = sf.getCurrentSession();
		return null;
	}

}
