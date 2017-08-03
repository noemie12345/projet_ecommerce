package fr.adaming.service;

import fr.adaming.model.Client;

public interface IClientService extends IGeneriqueService<Client> {

	public Client getByNom(Client client);

}
