package m1miage.abd.photonum.db;

public class Photo {

	private Album album;
	private Fichier fichier;
	private String titre;
	private String commentaire;
	private int page;

	public Photo(Album album, Fichier fichier) {
		this.album = album;
		this.fichier = fichier;
	}

	public Photo(Album album, Fichier fichier, String titre, String commentaire, int page) {
		this.album = album;
		this.fichier = fichier;
		this.titre = titre;
		this.commentaire = commentaire;
		this.page = page;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Album getAlbum() {
		return album;
	}

	public Fichier getFichier() {
		return fichier;
	}

}
