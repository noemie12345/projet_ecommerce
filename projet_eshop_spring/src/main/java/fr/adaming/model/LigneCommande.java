package fr.adaming.model;

public class LigneCommande {

	private int quantite = 0;
	private int prix = 0;
	
	private Commande commande;

	private Produit produit;
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "LigneCommande [quantite=" + quantite + ", prix=" + prix + "]";
	}

	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	//Méthode de ligneCommande
	public int ajouterQuantite () {
		return this.quantite += 1;
	}
	
	public int diminuerQuantite () {
		return this.quantite -= 1;
	}
	
	public int totalProduit(int quantite) {
		return this.prix = prix*quantite;
	}
	
}
