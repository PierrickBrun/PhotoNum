package m1miage.abd.photonum.model;

import java.util.ArrayList;
import java.util.Date;

public class Commande {

	private int idCommande;
	private Date dateCommande;
	private Promotion promotion;
	private float prixTotal;
	private String statut;
	private ArrayList<Article> articles;
	private Client client;
	
	public Commande() {
		this.dateCommande = new Date();
		this.prixTotal = 0;
		this.statut = "En cours";
		this.articles = new ArrayList<Article>();
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public ArrayList<Article> getArticlesCmd() {
		return articles;
	}

	public void setArticlesCmd(ArrayList<Article> articlesCmd) {
		this.articles = articlesCmd;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


}
