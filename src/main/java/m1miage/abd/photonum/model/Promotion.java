package m1miage.abd.photonum.model;

public class Promotion {

	private Commande commandeDelivre;
	private Commande commandeUtilise;
	private float montant;

	public Promotion(Commande commandeDelivre) {
		this.commandeDelivre = commandeDelivre;
		float mnt = commandeDelivre.getPrixTotal();
		this.montant = (5 / 100) * mnt;
	}

	public Commande getCommandeUtilise() {
		return commandeUtilise;
	}

	public void setCommandeUtilise(Commande commandeUtilise) {
		this.commandeUtilise = commandeUtilise;
	}

	public float getMontant() {
		return montant;
	}

	public Commande getCommandeDelivre() {
		return commandeDelivre;
	}
}
