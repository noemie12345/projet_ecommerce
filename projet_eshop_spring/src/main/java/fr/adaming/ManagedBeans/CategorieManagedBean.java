package fr.adaming.ManagedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "categorieMB")
@SessionScoped
public class CategorieManagedBean {

	private String nomCat;
	private Categorie categorie;
	private List<Categorie> listCategories;
	private List<SelectItem> categories;

	@ManagedProperty(value = "#{categorieServiceBean}")
	private ICategorieService catService;

	// Constructeur vide
	public CategorieManagedBean() {
		super();
		this.categorie = new Categorie();
	}

	@PostConstruct
	public void init() {
		this.categories = recupererToutNom();
		this.listCategories = (List<Categorie>) catService.getAll();
	}

	// Getters et Setters
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

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

	public ICategorieService getCatService() {
		return catService;
	}

	// Méthode Services

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

	public List<String> recupererListeNom() {
		List<String> noms = new ArrayList<String>();
		for (Categorie cat : catService.getAll()) {
			noms.add(cat.getNomCategorie());
//			System.out.println(cat.getNomCategorie());
		}
		return noms;
	}

	public List<SelectItem> recupererToutNom() {
		this.categories = new ArrayList<SelectItem>();
		List<String> listeNom = recupererListeNom();

		for (String noms : listeNom) {
			categories.add(new SelectItem(noms));
//			System.out.println("items = " + new SelectItem(noms));
		}
		return categories;
	}
}
