package m1miage.abd.photonum;

public class FormatTirage {
	
	private int idFormat;
	private String libelle;
	private float prixUnitaire;
	private String resolutionMinimale;
	private float vitesseImpression;
	private int stockPapier;
	
	public FormatTirage(String lib, String resMin,float vi, int sp ){
		this.libelle = lib;
		this.resolutionMinimale =resMin;
		this.vitesseImpression = vi;
		this.stockPapier = sp;
		this.prixUnitaire =0;
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
	
}
