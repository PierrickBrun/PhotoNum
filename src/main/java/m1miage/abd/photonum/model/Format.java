package m1miage.abd.photonum.model;

public class Format {

	private int idFormat;
	private String libelle;
	private float prixUnitaire;
	private String resolutionMinimale;
	private float vitesseImpression;
	private int stockPapier;

	public Format(){};

	public Format(String libelle, String resolutionMinimale, float vitesseImpression, int stockPapier, int prix) {
		this.libelle = libelle;
		this.resolutionMinimale = resolutionMinimale;
		this.vitesseImpression = vitesseImpression;
		this.stockPapier = stockPapier;
		this.prixUnitaire = prix;
	}

	public int getIdFormat() {
		return idFormat;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public String getResolutionMinimale() {
		return resolutionMinimale;
	}

	public void setResolutionMinimale(String resolutionMinimale) {
		this.resolutionMinimale = resolutionMinimale;
	}

	public float getVitesseImpression() {
		return vitesseImpression;
	}

	public void setVitesseImpression(float vitesseImpression) {
		this.vitesseImpression = vitesseImpression;
	}

	public int getStockPapier() {
		return stockPapier;
	}

	public void setStockPapier(int stockPapier) {
		this.stockPapier = stockPapier;
	}

	@Override
	public String toString() {
		return "Format [idFormat=" + idFormat + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire
				+ ", resolutionMinimale=" + resolutionMinimale + ", vitesseImpression=" + vitesseImpression
				+ ", stockPapier=" + stockPapier + "]";
	}
	
	
	
}
