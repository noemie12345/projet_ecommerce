package fr.adaming.ManagedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

/**
 * Le managed Bean qui gère la vue de la page de gestion des produits comprenant des méthodes du CRUD pour l'admin
 * @author INTI-397
 *
 */
@ManagedBean(name="produitMB")
@SessionScoped
public class ProduitManagedBean {

	/**
	 * Utilisation du couplage faible (par interfaces) pour appeler les méthodes de la couche Service du Produit
	 */
	@ManagedProperty(value="#{produitServiceBean}")
	private IProduitService produitService;
	
	private Produit produit;
	private List<Produit> listeProduits;

	private boolean valeur;
	private boolean value1 = true;
	private boolean value2 = false;
	
	/**
	 * Constructeur vide qui instancie des classes vides
	 */
	//Constructeur vide
	public ProduitManagedBean() {
		super();
		this.produit = new Produit();
	}

	/**
	 * Le post construct permet de charger la liste des clients lors de l'ouverture de la page
	 */
	@PostConstruct
	public void init() {
		this.listeProduits = (List<Produit>) produitService.getAll();
	}
	
	//Liste des getters et des setters
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduit(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	public IProduitService getProduitService() {
		return produitService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	
	public boolean isValue1() {
		return value1;
	}

	public void setValue1(boolean value1) {
		this.value1 = value1;
	}

	public boolean isValue2() {
		return value2;
	}

	public void setValue2(boolean value2) {
		this.value2 = value2;
	}

	public void setValeur(boolean valeur) {
		this.valeur = valeur;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
	//Méthodes Services

	public String ajouterProduit() {
		produitService.add(this.produit);
		this.listeProduits = (List<Produit>) produitService.getAll();
		return "produit";
	}
	
	public String supprimerProduit() {
		produitService.delete(this.produit.getIdProduit());
		this.listeProduits = (List<Produit>) produitService.getAll();
		return "produit";
	}
	
	public void rechercherProduit() {
		 this.produit = produitService.getById(this.produit.getIdProduit());
	}
	
	public String modifierProduit() {
		produitService.update(this.produit);
		this.listeProduits = (List<Produit>) produitService.getAll();
		return "produit";
	}
	
	public boolean valeurSelectionne() {
		if (this.valeur == true) {
			return value1;
		} else {
			return value2;
		}
	}
}
