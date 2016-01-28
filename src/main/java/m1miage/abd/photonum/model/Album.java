package m1miage.abd.photonum.model;

public class Album {

	private Client client;
	private int idAlbum;
	private Talbum tAlbum;
	private String titre;
	private String preface;
	private String postface;
	private int nbPage;
	
	public enum Talbum {
		Album,Agenda52s,Agenda365j,CalendrierMural,CalendrierBureau,Livre;
	}

	public static final String tBasicAlbum = "Album";
	public static final String tAgenda52s = "Agenda52s";
	public static final String tAgenda365j = "Agenda365j";
	public static final String tCalendrierMural = "CalendrierMural";
	public static final String tCalendrierBureau = "CalendrierBureau";
	public static final String tLivre = "Livre";

	public Album() {
	}
	
	public Album(Client client, String talbum, String titre) {
		this.client = client;
		affecterType(talbum);
		this.titre = titre;
		this.preface = "";
		this.postface = "";
	}
	
	public Album(Client client, String talbum, String titre, int nbpages) {
		this.client = client;
		affecterType(talbum);
		this.titre = titre;
		this.nbPage = nbpages;
		this.preface = "";
		this.postface = "";
	}

	public Album(Client c, String talbum, String t, String prf, String psf, int nbp) {
		this.client = c;
		this.titre = t;
		affecterType(talbum);
		this.nbPage = nbp;
		this.preface = prf;
		this.postface = psf;

	}

	public void affecterType(String type){
		switch (type)
		{
		  case tAgenda52s:
		    this.tAlbum = Talbum.Agenda52s;
		    this.nbPage = 52;
		    break;
		  case tAgenda365j:
			  this.tAlbum = Talbum.Agenda365j;
			  this.nbPage = 365;
		    break;
		  case tCalendrierBureau:
			  this.tAlbum = Talbum.CalendrierBureau;
			  this.nbPage=20;
		    break;
		  case tCalendrierMural:
			  this.tAlbum = Talbum.CalendrierMural;
			  this.nbPage=12;
		    break;
		  case tLivre:
			    this.tAlbum = Talbum.Livre;
			    this.nbPage=32;
			    break;
		  default:
		    this.tAlbum = Talbum.Album;
		}
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client cli) {
		this.client = cli;
	}

	public String getTypeAlbum() {
		return this.tAlbum.toString();
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

	@Override
	public String toString() {
		return "Album [client=" + client + ", idAlbum=" + idAlbum + ", tAlbum=" + tAlbum + ", titre=" + titre
				+ ", preface=" + preface + ", postface=" + postface + ", nbPage=" + nbPage + "]";
	}
	
	

}
