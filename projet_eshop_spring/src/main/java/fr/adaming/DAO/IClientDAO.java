package fr.adaming.DAO;

import fr.adaming.model.Client;

public interface IClientDAO extends IGeneriqueDAO<Client>{

	public Client getByNom (String nom);
	
	public Client getByTel (String tel);
}
