package fr.adaming.ManagedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name="clMB")
@RequestScoped
public class ClientManagedBean {

	private Client client;
	
	private List<Client> listeCl;
	
	@ManagedProperty(value="#{clientServiceBean}")
	private IClientService clService;

	/**
	 * Constructeur vide
	 */
	public ClientManagedBean() {
		super();
		this.client = new Client();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClientManagedBean [client=" + client + ", listeCl=" + listeCl + ", clService=" + clService + "]";
	}

	/**
	 * Setters - getters des paramètres 
	 * @return
	 */
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeCl() {
		return listeCl;
	}

	public void setListeCl(List<Client> listeCl) {
		this.listeCl = listeCl;
	}
	
	//Méthode Service
	
	public String ajouterClient() {
		clService.add(this.client);
		this.listeCl = (List<Client>) clService.getAll();
		return "accueil";
	}
}
