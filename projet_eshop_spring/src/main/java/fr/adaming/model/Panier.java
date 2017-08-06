package fr.adaming.model;

import java.util.List;

public class Panier {

	private Client client;
	private List<Client> listeClients;
	
	private Produit produit;
	private List<Produit> listeProduits;
	
	private LigneCommande ligne;
	private List<LigneCommande> listeLigne;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Panier(Client client, List<Client> listeClients, Produit produit, List<Produit> listeProduits,
			LigneCommande ligne, List<LigneCommande> listeLigne) {
		super();
		this.client = client;
		this.listeClients = listeClients;
		this.produit = produit;
		this.listeProduits = listeProduits;
		this.ligne = ligne;
		this.listeLigne = listeLigne;
	}

	public Panier(List<Client> listeClients, List<Produit> listeProduits, List<LigneCommande> listeLigne) {
		super();
		this.listeClients = listeClients;
		this.listeProduits = listeProduits;
		this.listeLigne = listeLigne;
	}
	
	public Panier(Client client, List<Produit> listeProduits, List<LigneCommande> listeLigne) {
		super();
		this.client = client;
		this.listeProduits = listeProduits;
		this.listeLigne = listeLigne;
	}

	//Getters et Setters
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	public LigneCommande getLigne() {
		return ligne;
	}
	public void setLigne(LigneCommande ligne) {
		this.ligne = ligne;
	}
	public List<LigneCommande> getListeLigne() {
		return listeLigne;
	}
	public void setListeLigne(List<LigneCommande> listeLigne) {
		this.listeLigne = listeLigne;
	}
	
}
