package m1miage.abd.photonum.db;

import java.util.Date;

public class Livraison {
	private Commande commande;
	private Date date;
	private String status;

	public Livraison(Commande commande, Date date) {
		this.commande = commande;
		this.date = new Date();
		this.status = "En cours";
	}

	public Commande getCmd() {
		return commande;
	}

	public void setCmd(Commande cmd) {
		this.commande = cmd;
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

}
