package domaci;

public class LP extends AlbumArtikal {

	private int tezina;
	
	public LP(Album album, String izdavac, double cena, int kolicina, int tezina) {
		super(album, izdavac, cena, kolicina);
		this.tezina = tezina;
	}

	@Override
	public String ime() {
		return super.ime() + " (" + tezina + "[g] LP)";
	}
}
