package m1miage.abd.photonum.model;

public class Article {

	private int idArticle;
	private Commande commande;
	private Album album;
	private Format format;
	private Prestataire prestataire;
	private int quantite;
	private float prix;

	public Article() {
	
	}
	
	public Article(Commande commande, Album album, int quantite, Format format) {
		this.album = album;
		this.prix = 0;
		this.commande = commande;
		this.quantite = quantite;
		this.format=format;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", commande=" + commande + ", album=" + album + ", format=" + format
				+ ", prestataire=" + prestataire + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	

}
