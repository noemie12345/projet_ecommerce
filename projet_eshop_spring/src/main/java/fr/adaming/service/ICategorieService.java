package fr.adaming.service;

import fr.adaming.model.Categorie;

public interface ICategorieService extends IGeneriqueService<Categorie> {

	public Categorie getByNom(String nom);
}
