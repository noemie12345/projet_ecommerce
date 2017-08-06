package fr.adaming.ManagedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean
public class SelectOneMenuView {

	private String categorie;
	private List<SelectItem> categories;

	@PostConstruct
	public void init() {
		SelectItemGroup g1 = new SelectItemGroup("Electronique");
		g1.setSelectItems(new SelectItem[] { new SelectItem("Portable", "Portable"),
				new SelectItem("Ordinateur", "Ordinateur"), new SelectItem("Tablette", "Tablette"),
				new SelectItem("Ordinateur de bureau", "Ordinateur de bureau") });

		categories = new ArrayList<SelectItem>();
		categories.add(g1);

	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

}
