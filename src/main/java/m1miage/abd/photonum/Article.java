package m1miage.abd.photonum;

public class Article {

	private Commande cmd;
	private Album album;
	private int quantite;
	
	public Article(Commande c, Album a, int q){
		this.album = a;
		this.cmd = c;
		this.quantite = q;
	}
	
	public Commande getCmd() {
		return cmd;
	}
	public void setCmd(Commande cmd) {
		this.cmd = cmd;
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
