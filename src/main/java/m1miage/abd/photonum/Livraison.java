package m1miage.abd.photonum;

import java.util.Date;

public class Livraison {
	private Commande cmd;
	private Date dateLivraison;
	private String status;
	
	public Livraison(Commande cmd, Date d){
		this.cmd = cmd;
		this.dateLivraison = new Date();
		this.status = "En cours";
	}

	
	public Commande getCmd() {
		return cmd;
	}

	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
