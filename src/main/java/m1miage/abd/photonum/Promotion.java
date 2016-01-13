package m1miage.abd.photonum;

public class Promotion {

	private Commande cmdDelivre;
	private Commande comdUtilise;
	private float montant;
	
	public Promotion(Commande comDelivre){
		this.cmdDelivre = comDelivre;
		float mnt = comDelivre.getPrixTotal();
		this.montant = (5/100)*mnt;
	}

	public Commande getComdUtilise() {
		return comdUtilise;
	}

	public void setComdUtilise(Commande comdUtilise) {
		this.comdUtilise = comdUtilise;
	}

	public float getMontant() {
		return montant;
	}

	public Commande getCmdDelivre() {
		return cmdDelivre;
	}
}
