package m1miage.abd.photonum.model;

import java.util.Date;

public class Livraison {

	private int idLivraison;
	private Commande commande;
	private Date date;
	private String status;

	public Livraison(){}
	
	public Livraison(Commande commande, Date date) {
		this.commande = commande;
		this.date = new Date();
		this.status = "En cours";
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdLivraison() {
		return idLivraison;
	}

	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}

}
