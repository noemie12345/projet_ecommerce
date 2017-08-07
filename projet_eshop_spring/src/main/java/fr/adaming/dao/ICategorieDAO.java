package fr.adaming.dao;

import fr.adaming.model.Categorie;

public interface ICategorieDAO extends IGeneriqueDAO<Categorie> {

	public Categorie getByNom (String nom);
}
