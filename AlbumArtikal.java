package domaci;

public abstract class AlbumArtikal extends Artikal {
	
	private String izdavac;
	private Album album;
	
	public AlbumArtikal(Album album, String izdavac, double cena, int kolicina) {
		super(cena, kolicina);
		this.izdavac = izdavac;
		this.album = album;
	}
	
	public String ime() {
		return album.getIzvodjac() + " - " + album.getNaziv(); 
	}
	
	
	
}
