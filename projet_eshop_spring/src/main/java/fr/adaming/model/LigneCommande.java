package fr.adaming.model;

public class LigneCommande {

	private int quantite;
	private int prix;
	
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
//	public Panier getPanier() {
//		return panier;
//	}
//	public void setPanier(Panier panier) {
//		this.panier = panier;
//	}
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
	
}
