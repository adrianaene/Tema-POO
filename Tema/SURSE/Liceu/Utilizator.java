package Liceu;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Utilizator implements Serializable {
	private String numeUtilizator;
	private String parola;

	public String getNumeUtilizator() {
		return numeUtilizator;
	}

	public void setNumeUtilizator(String numeUtilizator) {
		this.numeUtilizator = numeUtilizator;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	private String nume;
	private String prenume;

	// doi utilizatori vor fi identificati doar de numele de utilizator. Folosim
	// metoda cand stergem un utilizator dintr-un ArrayList, de exemplu: metoda
	// remove foloseste metoda equals pe obiectele din arrayList
	public boolean equals(Object obj) {
		return obj.equals(this.numeUtilizator);
	}

	public String toString() {
		return numeUtilizator + " " + parola + " " + nume + " " + prenume;
	}

}
