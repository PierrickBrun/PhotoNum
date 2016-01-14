package m1miage.abd.photonum.db;

public class Fichier {

	private int idFichier;
	private String chemin;
	private boolean partage;
	private String priseDeVue;
	private String resolution;

	public Fichier(String chemin, String priseDeVue, String resolution) {
		this.chemin = chemin;
		this.partage = false;
		this.priseDeVue = priseDeVue;
		this.resolution = resolution;
	}

	public int getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(int idFichier) {
		this.idFichier = idFichier;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public boolean isPartage() {
		return partage;
	}

	public void setPartage(boolean partage) {
		this.partage = partage;
	}

	public String getPriseDeVue() {
		return priseDeVue;
	}

	public void setPriseDeVue(String priseDeVue) {
		this.priseDeVue = priseDeVue;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

}
