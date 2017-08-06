package fr.adaming.ManagedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Client;
import fr.adaming.model.Panier;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clMB")
@SessionScoped
public class ClientManagedBean {

	private Client client;

	private List<Client> listeCl;

	private Panier panier;

	@ManagedProperty(value = "#{clientServiceBean}")
	private IClientService clService;

	/**
	 * Constructeur vide
	 */
	public ClientManagedBean() {
		super();
		this.client = new Client();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		this.listeCl = (List<Client>) clService.getAll();
	}

	@Override
	public String toString() {
		return "ClientManagedBean [client=" + client + ", listeCl=" + listeCl + ", clService=" + clService + "]";
	}

	/**
	 * Setters - getters des paramètres
	 * 
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

	public void setClService(IClientService clService) {
		this.clService = clService;
	}
	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	// Méthode Service

	public String ajouterClient() {
		clService.add(this.client);
		this.listeCl = (List<Client>) clService.getAll();
		return "accueilClient";
	}

	public String supprimerClient() {
		clService.delete(this.client.getIdClient());
		this.listeCl = (List<Client>) clService.getAll();
		return "client";
	}

	public void rechercherClientNom() {
		this.client = clService.getByNom(this.client.getNomClient());
	}
	
	public void rechercherClient() {
		this.client = clService.getById(this.client.getIdClient());
	}

	public String ajoutPanier() {
		Panier panier = new Panier(this.client, this.panier.getListeProduits(), this.panier.getListeLigne());
		System.out.println("panier: " + panier);
		return "accueilClient";
	}
}
