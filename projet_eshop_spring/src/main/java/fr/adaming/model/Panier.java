package fr.adaming.model;

import java.util.List;

/**
 * Le panier n'est pas persistant. Il n'est pas sauvegardé dans la base de donnée et est unique à chaque client.
 * @author INTI-397
 *
 */
public class Panier {
	
	private Produit produit;
	private List<Produit> listeProduits;
	
	private LigneCommande ligne;
	private List<LigneCommande> listeLigne;
	
	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Panier(Produit produit, List<Produit> listeProduits,
			LigneCommande ligne, List<LigneCommande> listeLigne) {
		super();
		this.produit = produit;
		this.listeProduits = listeProduits;
		this.ligne = ligne;
		this.listeLigne = listeLigne;
	}

	public Panier(List<Produit> listeProduits, List<LigneCommande> listeLigne) {
		super();
		this.listeProduits = listeProduits;
		this.listeLigne = listeLigne;
	}

	public Panier(Produit produit, LigneCommande ligne) {
		super();
		this.produit = produit;
		this.ligne = ligne;
	}

	//Getters et Setters

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

	@Override
	public String toString() {
		return "Panier [produit=" + produit + ", listeProduits=" + listeProduits + ", ligne=" + ligne + ", listeLigne="
				+ listeLigne + "]";
	}
	
}
