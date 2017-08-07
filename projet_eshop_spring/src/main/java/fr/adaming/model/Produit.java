package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produits")
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private long idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	private String nom_cat;
	
	@Column(nullable=false, columnDefinition="TINYINT", length = 1)
	private boolean selectionne;
	
	@ManyToOne
	@JoinColumn(name="categorie_id", referencedColumnName="id_cat")
	private Categorie categorie;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(long idProduit, String designation, String description, double prix, int quantite, String nom_cat,
			boolean selectionne, Categorie categorie) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.nom_cat = categorie.getNomCategorie();
		this.selectionne = selectionne;
		this.categorie = categorie;
	}

	public Produit(String designation, String description, double prix, int quantite, String nom_cat,
			boolean selectionne, Categorie categorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.nom_cat = categorie.getNomCategorie();
		this.selectionne = selectionne;
		this.categorie = categorie;
	}

	public String getNom_cat() {
		return nom_cat;
	}

	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", description=" + description
				+ ", prix=" + prix + ", quantite=" + quantite + ", selectionne=" + selectionne + "]";
	}
	public long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
