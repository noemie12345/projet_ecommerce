package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDAO;
import fr.adaming.model.Client;

@Service("clientServiceBean")
@Transactional
public class ClientService implements IClientService {

	@Autowired
	private IClientDAO clientDAO;
	
	@Override
	public void add(Client client) {
		// TODO Auto-generated method stub
		clientDAO.add(client);
		}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> getAll() {
		return (List<Client>) clientDAO.getAll();
	}

	@Override
	public Client getByNom(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
