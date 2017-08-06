package fr.adaming.service;

import fr.adaming.model.Produit;

public interface IProduitService extends IGeneriqueService<Produit>{

	public Produit getByNom (String nom);
}
