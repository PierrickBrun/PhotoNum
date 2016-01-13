package m1miage.abd.photonum;

public class FichierImage {

	private int idFichier;
	private String chemin;
	private boolean partage;
	private String priseDeVue;
	private String resolution;

	public FichierImage(String ch,String pdv, String res){
		this.chemin = ch;
		this.partage = false;
		this.priseDeVue = pdv;
		this.resolution = res;
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
