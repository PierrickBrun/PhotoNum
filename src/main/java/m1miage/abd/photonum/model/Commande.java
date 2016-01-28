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

	public Commande(Client client) {
		this.dateCommande = new Date();
		this.prixTotal = 0;
		this.statut = "en cours";
		this.articles = new ArrayList<Article>();
		this.client=client;
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

	public void addArticle(Article article) {
		articles.add(article);
	}

	public void removeArticle(Article article) {
		articles.remove(article);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		// TODO Auto-generated method stub
		return this.dateCommande;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", promotion=" + promotion
				+ ", prixTotal=" + prixTotal + ", statut=" + statut + ", articles=" + articles + ", client=" + client
				+ "]";
	}

}
