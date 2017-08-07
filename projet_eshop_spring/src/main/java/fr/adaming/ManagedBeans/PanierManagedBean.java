package fr.adaming.ManagedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Panier;

@ManagedBean(name="panierMB")
@SessionScoped
public class PanierManagedBean {

	
	private Panier panier;
	 
}
