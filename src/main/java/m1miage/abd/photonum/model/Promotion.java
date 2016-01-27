package m1miage.abd.photonum.model;

public class Promotion {

	private int IdPromotion;
	private Commande commandeDelivre;
	private Commande commandeUtilise;
	private float montant;

	public Promotion(Commande commandeDelivre) {
		this.commandeDelivre = commandeDelivre;
		float mnt = commandeDelivre.getPrixTotal();
		this.montant = (5 / 100) * mnt;
	}
	
	public Promotion(){}
	
	public int getIdPromotion() {
		return IdPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		IdPromotion = idPromotion;
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
