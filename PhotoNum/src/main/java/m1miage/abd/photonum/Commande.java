package m1miage.abd.photonum;

import java.util.ArrayList;
import java.util.Date;

public class Commande {

	private int idCommande;
	private Date dateCommande;
	private int prixTotal;
	private String statut;
	private ArrayList<Article> articlesCmd;
	
	public Commande(){
		this.dateCommande = new Date();
		this.prixTotal=0;
		this.statut ="En cours";
		this.articlesCmd = new ArrayList<Article>();
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

	public int getPrixTotal() {
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
		return articlesCmd;
	}

	public void setArticlesCmd(ArrayList<Article> articlesCmd) {
		this.articlesCmd = articlesCmd;
	}
	
	
}
