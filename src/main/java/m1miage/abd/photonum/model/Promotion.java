package m1miage.abd.photonum.model;

public class Promotion {

	private int IdPromotion;
	private Commande commande;
	private float montant;
	
	public Promotion(){}
	
	public int getIdPromotion() {
		return IdPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		IdPromotion = idPromotion;
	}
	
	public void setMontant(float montant){
		this.montant = montant;
	}

	public float getMontant() {
		return montant;
	}

	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande){
		this.commande = commande;
	}
}
