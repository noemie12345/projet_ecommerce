package fr.adaming.ManagedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="categorieMB")
@SessionScoped
public class CategorieManagedBean {

	private Categorie categorie;
	private List<Categorie> listCategories;
	
	@ManagedProperty(value="#{categorieServiceBean}")
	private ICategorieService catService;

	//Constructeur vide
	public CategorieManagedBean() {
		super();
		this.categorie = new Categorie();
	}
	
	@PostConstruct
	public void init() {
		this.listCategories = (List<Categorie>) catService.getAll();
	}

	//Getters et Setters
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}
	
	public void setCatService(ICategorieService catService) {
		this.catService = catService;
	}
	
	//Méthode Services
	
	public String ajouterCategorie() {
		catService.add(this.categorie);
		this.listCategories = (List<Categorie>) catService.getAll();
		return "categorie";
	}
	
	public String supprimerCategorie() {
		catService.delete(this.categorie.getIdCategorie());
		this.listCategories = (List<Categorie>) catService.getAll();
		return "categorie";
	}
	
	public void rechercherCategorie() {
		this.categorie = catService.getById(this.categorie.getIdCategorie());
	}
	
	public String modifierCategorie() {
		catService.update(this.categorie);
		this.listCategories = (List<Categorie>) catService.getAll();
		return "categorie";
	}
	
	public void rechercherCategorieNom() {
		this.categorie = catService.getByNom(this.categorie.getNomCategorie());
}
}
