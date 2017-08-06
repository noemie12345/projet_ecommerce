package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDAO;
import fr.adaming.model.Commande;

@Service("commandeServiceBean")
@Transactional
public class CommandeService implements IGeneriqueService<Commande> {

	@Autowired
	private IGeneriqueDAO<Commande> comDAO;
	
	@Override
	public void add(Commande commande) {
		comDAO.add(commande);
	}

	@Override
	public void update(Commande commande) {
		comDAO.update(commande);
		
	}

	@Override
	public void delete(long id) {
		comDAO.delete(id);
		
	}

	@Override
	public Commande getById(long id) {
		return comDAO.getById(id);
	}

	@Override
	public List<Commande> getAll() {
		return (List<Commande>) comDAO.getAll();
	}

}
