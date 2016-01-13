package m1miage.abd.photonum;

public class Article {

	private Commande commande;
	private Album album;
	private int quantite;
	
	public Article(Commande commande, Album album, int quantite){
		this.album = album;
		this.commande = commande;
		this.quantite = quantite;
	}
	
	public Commande getCmd() {
		return commande;
	}
	public void setCmd(Commande commande) {
		this.commande = commande;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
