package fr.adaming.ManagedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="produitMB")
@SessionScoped
public class ProduitManagedBean {

	@ManagedProperty(value="#{produitServiceBean}")
	private IProduitService produitService;
	
	private Produit produit;
	private List<Produit> listeProduits;

	private boolean value1 = true;
	private boolean value2 = false;
	
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
}
