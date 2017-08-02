package fr.adaming.dao;

import fr.adaming.model.Client;

public interface IClientDAO extends IGeneriqueDAO<Client>{

	public Client getByNom (String nom);
}
