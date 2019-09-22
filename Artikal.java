package domaci;

public abstract class Artikal {

	private int id;
	private static int brojacZaId;
	private double cena;
	private int kolicina;

	public Artikal(double cena, int kolicina) {
		this.cena = cena;
		this.kolicina = kolicina;
		id = brojacZaId++;
	}

	public boolean kupi() {
		if (kolicina <= 0) {
			return false;
		} else {
			kolicina--;
			return true;
		}
	}

	public abstract String ime();

	public String toString() {
		return "#" + id + ": " + ime() + " - " + cena + "[kol: " + kolicina + "]";
	}

	public int getId() {
		return id;
	}

	public double getCena() {
		return cena;
	}

	public int getKolicina() {
		return kolicina;
	}
}
