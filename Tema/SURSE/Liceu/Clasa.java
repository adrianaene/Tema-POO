package Liceu;

import java.io.Serializable;
import java.util.ArrayList;

public class Clasa implements Serializable {
	private String idClasa;
	private ArrayList<Elev> elevii = new ArrayList<Elev>();
	private ArrayList<Materie> materii = new ArrayList<Materie>();
	private Catalog catalog;

	public Clasa(String idClasa) {
		this.idClasa = idClasa;

	}

	public ArrayList<Materie> getMaterii() {
		return materii;
	}

	public void setMaterii(ArrayList<Materie> materii) {
		this.materii = materii;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public void addElev(Elev e) {
		this.elevii.add(e);
	}

	public void delElev(Elev e) {
		this.elevii.remove(e);
	}

	public String toString() {
		return idClasa + " " + elevii.toString() + "\n" + materii.toString()
				+ "\n" + catalog.toString();
	}

	public String afisareElevi() {
		return elevii.toString();
	}

	public ArrayList<Elev> getElevi() {
		return elevii;
	}
}
