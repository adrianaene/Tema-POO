package Liceu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Centralizator implements Serializable {
	private ArrayList<Utilizator> utilizatori = new ArrayList<>();
	private ArrayList<Clasa> clase = null;
	private Hashtable<Materie, Hashtable<Clasa, Profesor>> dictionar;

	private static Centralizator c = null;

	private Centralizator() {
	}

	public static Centralizator getInstance() {
		File f = new File("data");
		if (c == null) {
			if (f.exists() == false) {// daca nu exista fisierul binar, il
										// instantiem
				c = new Centralizator();
			} else {
				ObjectInputStream in;
				try {
					in = new ObjectInputStream(new FileInputStream("data"));
					c = (Centralizator) in.readObject();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return c;
	}

	public ArrayList<Utilizator> getUtilizatori() {
		if (utilizatori == null) {
			utilizatori = new ArrayList<Utilizator>();
		}
		return utilizatori;
	}

	public String toString() {
		return utilizatori.toString() + "\n" + clase.toString() + "\n"
				+ dictionar.toString();
	}

	public ArrayList<Clasa> getClase() {
		if (clase == null) {
			clase = new ArrayList<Clasa>();
		}
		return clase;
	}
}
