package m1miage.abd.photonum;

public class Client {

	private int idClient;
	private String nom;
	private String prenom;
	private String mail;
	private String adresse;
	private String mdp;
	
	public Client(String n, String p, String m, String a,String mdp){
		this.nom = n;
		this.prenom = p;
		this.mail = m;
		this.adresse = a;
		this.mdp = mdp;
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


}

