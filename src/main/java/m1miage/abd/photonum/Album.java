package m1miage.abd.photonum;

public class Album {

	private Client client;
	private int idAlbum;
	private Format format;
	private String titre;
	private String preface;
	private String postface;
	private int nbPage;
	
	/*private static final String tAlbum = "ALBUM";
	private static final String tAgenda52s = "AGENDA52S";
	private static final String tAgenda365j = "AGENDA365J";
	private static final String tCalendrierMural = "CALENDRIERMURAL";
	private static final String tCalendrierBureau = "CALENDRIERBUREAU";*/

	public Album(Client client, Format format, String titre, int nbpages) {
		this.client = client;
		this.format = format;
		this.titre = titre;
		this.nbPage = nbpages;
		this.preface = "";
		this.postface = "";
	}

	public Album(Client c, String t, String prf, String psf, int nbp) {
		this.client = c;
		this.titre = t;
		this.nbPage = nbp;
		this.preface = prf;
		this.postface = psf;

	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client cli) {
		this.client = cli;
	}

	public Format getFormat() {
		return format;
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
