package domaci;

import java.time.LocalDate;
import java.util.Arrays;

public class Album {

	private String naziv;
	private String izvodjac;
	private LocalDate datum;
	private MuzickaNumera[] nizPesama = new MuzickaNumera[5];
	private int brNumera;
	private int minuti = 0;
	private int sekunde = 0;

	public Album(String naziv, String izvodjac, LocalDate datum) {
		super();
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		brNumera = 0;
	}

	public void sirenjeNiza() {
		if (brNumera >= nizPesama.length) {
			nizPesama = Arrays.copyOf(nizPesama, nizPesama.length * 2);
		}
	}

	public void dodavanjeNaBrojace(MuzickaNumera n1) {
		brNumera++;
		String[] splitovanString = n1.getTrajanje().split(":");
		minuti += Integer.parseInt(splitovanString[0]);
		sekunde += Integer.parseInt(splitovanString[1]);
		while (sekunde > 60) {
			sekunde -= 60;
			minuti++;
		}
	}

	public void dodaj(MuzickaNumera n1) {
		sirenjeNiza();
		nizPesama[brNumera] = n1;
		dodavanjeNaBrojace(n1);
	}

	public void dodaj(String naziv, String trajanje) {
		sirenjeNiza();
		MuzickaNumera m1 = new MuzickaNumera(naziv, this.izvodjac, trajanje);
		nizPesama[brNumera] = m1;
		dodavanjeNaBrojace(m1);
	}

	public String getTrajanje () {
		return minuti + ":" + sekunde;
	}
	
	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public MuzickaNumera getMuzickaNumera(int index) {
		return nizPesama[index];
	}

	public String toString() {
		String s = "";
		s += izvodjac + " - " + naziv + "(" + datum.getYear() + "):[";
		for (int i = 0; i < nizPesama.length; i++) {
			if (nizPesama[i] != null) {
				s += "\n\t" + nizPesama[i];
			}
		}
		s += "\n]: " + minuti + ":" + sekunde;
		return s;
	}
}
