package fr.adaming.ManagedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

/**
 * Le managed Bean qui gère la vue de la page accessible au client et certaines des méthodes du CRUD pour l'admin
 * @author INTI-397
 *
 */
@ManagedBean(name = "clMB")
@SessionScoped
public class ClientManagedBean {

	private Client client;

	private List<Client> listeCl;

	private Panier panier;
	private Produit produit;
	private LigneCommande ligne;
	
	/**
	 * Utilisation du couplage faible (par interfaces) pour appeler les méthodes de la couche Service du Client
	 */
	@ManagedProperty(value = "#{clientServiceBean}")
	private IClientService clService;

	@ManagedProperty(value="#{produitServiceBean}")
	private IProduitService produitService;
	
	/**
	 * Constructeur vide qui instancie des classes vides
	 */
	public ClientManagedBean() {
		super();
		this.client = new Client();
		this.panier = new Panier();
		this.produit = new Produit();
		this.ligne = new LigneCommande();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le post construct permet de charger la liste des clients lors de l'ouverture de la page
	 */
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
	
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public LigneCommande getLigne() {
		return ligne;
	}

	public void setLigne(LigneCommande ligne) {
		this.ligne = ligne;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	// Méthode Service

	/**
	 * Méthode permettant d'ajouter un nouveau client dans la BD. Elle s'utilise par le biais d'un formulaire d'inscription
	 */
	public void ajouterClient() {
		clService.add(this.client);
		this.listeCl = (List<Client>) clService.getAll();
		FacesMessage message = new FacesMessage("Inscription réussie");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Méthode du CRUD permettant de supprimer un client de la base de donnée
	 * @return String l'identifiant de la page à retourner. Il est géré par le servlet d'aiguillage Faces Servlet.
	 */
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

	public void getIdProduit() {
		this.produit = produitService.getById(this.produit.getIdProduit());
		System.out.println("produit: "+produit);
		ajoutPanier();
	}
	
	/**
	 * Méthode permettant d'ajouter un produit dans le panier en instanciant un nouveau panier pour le client
	 */
	public void ajoutPanier() {
//		this.panier = new Panier(this.panier.getListeProduits(), this.panier.getListeLigne());
		this.panier = new Panier(this.produit, this.ligne);
		System.out.println("panier: "+panier);
		FacesMessage message = new FacesMessage("Produit ajouté au panier");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void ajouterProduit() {
		this.panier.getLigne().ajouterQuantite();
	}
	
	public void supprimerProduit() {
		this.panier.getLigne().diminuerQuantite();
	}
}
