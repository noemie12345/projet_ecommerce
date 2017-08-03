package fr.adaming.ManagedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="produitMB")
@RequestScoped
public class ProduitManagedBean {

	private Produit produit;
	
	private List<Produit> listeProduits;

	@ManagedProperty(value="#{produitServiceBean}")
	private IProduitService produitService;

	//Constructeur vide
	public ProduitManagedBean() {
		super();
		this.produit = new Produit();
	}

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
		return "accueil";
	}
}
