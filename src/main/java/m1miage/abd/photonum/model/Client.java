package m1miage.abd.photonum.model;

public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private String mail;
	private String adresse;
	private String mdp;
	private int statut;

	public Client() {
	}

	public Client(String nom, String prenom, String mail, String adresse, String mdp, int statut) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.mdp = mdp;
		this.statut = statut;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public boolean isActive() {
		if (statut == 1) {
			return true;
		} else if (statut == 0) {
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adresse="
				+ adresse + ", mdp=" + mdp + "]";
	}

}
