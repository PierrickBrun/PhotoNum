package m1miage.abd.photonum;

public class Album {

	private Client cli;
	private int idAlbum;
	private String titre;
	private String preface;
	private String postface;
	private int nbPage;
	
	public Album(Client c, int id, int nbp){
		
	}
	
	public Client getCli() {
		return cli;
	}
	public void setCli(Client cli) {
		this.cli = cli;
	}
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPreface() {
		return preface;
	}
	public void setPreface(String preface) {
		this.preface = preface;
	}
	public String getPostface() {
		return postface;
	}
	public void setPostface(String postface) {
		this.postface = postface;
	}
	public int getNbPage() {
		return nbPage;
	}
	public void setNbPage(int nbPage) {
		this.nbPage = nbPage;
	}
	
	
	
}
