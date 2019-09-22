package domaci;

import java.util.Arrays;

public class Prodavnica {

	private String ime;
	private String lokacija;
	private Artikal[] inventar;
	private int brArtikala;

	public Prodavnica(String ime, String lokacija) {
		this.ime = ime;
		this.lokacija = lokacija;
		inventar = new Artikal[10];
	}

	public void sirenjeNiza() {
		if (brArtikala >= inventar.length) {
			inventar = Arrays.copyOf(inventar, inventar.length * 2);
		}
	}

	public Artikal[] pretrazi(String ime) {
		int brojac = 0;
		String temp, temp2 = ime.toLowerCase();
		for (int i = 0; i < brArtikala; i++) {
			temp = inventar[i].ime().toLowerCase();
			if (temp.contains(temp2)) {
				brojac++;
			}
		}
		Artikal[] nizPretrage = new Artikal[brojac];
		int j = 0;
		for (int i = 0; i < brArtikala; i++) {
			temp = inventar[i].ime().toLowerCase();
			if (temp.contains(temp2)) {
				nizPretrage[j] = inventar[i];
				j++;
			}
		}
		return nizPretrage;
	}

	public void dodaj(Artikal a) {
		sirenjeNiza();
		inventar[brArtikala] = a;
		brArtikala++;
	}

	public String getIme() {
		return ime;
	}

	public String getLokacija() {
		return lokacija;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime + ": " + lokacija + "[\n");
		for (int i = 0; i < brArtikala; i++) {
			sb.append(inventar[i].toString() + "\n");
		}
		return sb.toString();
	}
}
