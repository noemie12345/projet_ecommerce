package fr.adaming.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Commande {

	private Long idCommande;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + "]";
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
}
