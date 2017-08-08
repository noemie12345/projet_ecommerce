package fr.adaming.model;

public class LigneCommande {

	private int quantite = 1;
	private int prix;
	
	private Commande commande;

	private Produit produit;
	
	//Constructeur vide
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

//	//Constructeur Ligne de commande
//	public LigneCommande(int quantite, int prix) {
//		super();
//		this.quantite = quantite;
//		this.prix = (int) produit.getPrix();
//	}
	
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
	
	/**
	 * Méthode permettant d'augmenter la quantité d'un produit du panier
	 * @return int correspondant à la quantité du panier corrigée
	 */
	public int ajouterQuantite () {
		this.quantite += 1;
		if (quantite > this.produit.getQuantite()) {
			quantite = this.produit.getQuantite();
		}
		return quantite;
	}
	
	/**
	 * Méthode permettant de diminuer la quantité d'un produit du panier
	 * @return int correspondant à la quantité du panier corrigée
	 */
	public int diminuerQuantite () {
		this.quantite -= 1;
		if (quantite < 0) {
			quantite = 0;
		}
		return this.quantite;
	}
	
	/**
	 * Méthode permettant de donner le prix total des achats du panier.
	 * @param quantite
	 * @return int qui correspond au prix final à payer pour un produit
	 */
	public int totalProduit(int quantite) {
		return this.prix = (int) (this.prix*quantite);
	}
	
}
