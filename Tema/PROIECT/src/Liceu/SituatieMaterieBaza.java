package Liceu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class SituatieMaterieBaza implements Serializable {
	private Materie materie;
	private ArrayList<Integer> noteSemestru1 = new ArrayList<Integer>();
	private ArrayList<Integer> noteSemestru2 = new ArrayList<>();
	private Integer medieSemestru1;
	private Integer medieSemestru2;
	private ArrayList<SituatieMaterieBaza.Absenta> absente = new ArrayList<>();

	public SituatieMaterieBaza(Materie materie) {
		this.materie = materie;
	}

	class Absenta implements Serializable {
		private String status;
		private String data;

		public Absenta(String status, String data) {
			this.data = data;
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public String getData() {
			return data;
		}

		public String toString() {
			return status + " " + data;
		}
	}

	public String noteSemestre() {
		return "Note Semestru1: " + noteSemestru1.toString() + "\n"
				+ "Note Semestru2: " + noteSemestru2.toString();
	}

	public Integer medieSem1() {
		int s = 0;
		for (Integer i : noteSemestru1) {
			s += i;
		}
		medieSemestru1 = (s / noteSemestru1.size());
		return (s / noteSemestru1.size());
	}

	public Integer medieSem2() {
		int s = 0;
		for (Integer i : noteSemestru2) {
			s += i;
		}
		medieSemestru2 = (s / noteSemestru2.size());
		return (s / noteSemestru2.size());
	}

	public Float medieGenerala() {
		return (float) ((medieSem2() + medieSem1()) / 2);
	}

	public ArrayList<Integer> noteSem1() {
		return noteSemestru1;
	}

	public ArrayList<Integer> noteSem2() {
		return noteSemestru2;
	}

	public void addNotaSemestru1(Integer nota) {
		noteSemestru1.add(nota);
	}

	public void addNotaSemestru2(Integer nota) {
		noteSemestru2.add(nota);
	}

	public void addAbsenta(String s, String d) {
		absente.add(new Absenta(s, d));

	}

	public void modificareAbsenta(String s, String d, int i) {
		absente.set(i, new Absenta(s, d));
	}

	public String afisareAbsente() {
		return absente.toString();
	}

	@Override
	public String toString() {
		return materie.toString() + "\n" + noteSemestre() + "\n"
				+ "media pe semestrul 1: " + medieSem1() + " "
				+ "media pe semestrul 2: " + medieSem2() + "\nAbsente:"
				+ afisareAbsente();
	}
}
