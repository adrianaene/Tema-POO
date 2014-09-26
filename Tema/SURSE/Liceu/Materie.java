package Liceu;

import java.io.Serializable;

public class Materie implements Serializable {
	private String numeMaterie;
	private Integer numarOreSaptamana;
	private boolean areTeza;

	public Materie(String numeMaterie) {
		this.numeMaterie = numeMaterie;
	}

	public Integer getNumarOreSaptamana() {
		return numarOreSaptamana;
	}

	public void setNumarOreSaptamana(Integer numarOreSaptamana) {
		this.numarOreSaptamana = numarOreSaptamana;
	}

	public boolean isAreTeza() {
		return areTeza;
	}

	public void setAreTeza(boolean areTeza) {
		this.areTeza = areTeza;
	}

	public String toString() {
		String s = "";
		if (areTeza)
			s += "are Teza";
		else
			s += "nu are Teza";

		return "Materie:" + numeMaterie + "\n" + "Numar ore pe saptamana:"
				+ numarOreSaptamana.toString() + "\n" + s;
	}
}
