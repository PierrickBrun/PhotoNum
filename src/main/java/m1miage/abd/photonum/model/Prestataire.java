package m1miage.abd.photonum.model;

public class Prestataire {

	private int IdPrestataire;
	private String nom;
	private String adresse;
	private String telephone;
	private String activite;
	
	public Prestataire(){
	}
	
	public Prestataire(String nom, String adresse, String telephone){
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	public int getIdPrestataire() {
		return IdPrestataire;
	}
	public void setIdPrestataire(int idPrestataire) {
		IdPrestataire = idPrestataire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	@Override
	public String toString() {
		return "Prestataire [IdPrestataire=" + IdPrestataire + ", nom=" + nom + ", adresse=" + adresse + ", telephone="
				+ telephone + ", activite=" + activite + "]";
	}

	
}
