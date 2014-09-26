package Liceu;

import java.util.Collections;
import java.util.Comparator;

public class Administrator extends Utilizator implements IAdministrator {

	@Override
	public String listareElevi(Clasa c) {
		return c.afisareElevi();
	}

	@Override
	public Float modificareMedii() {
		return 0f;
	}

	@Override
	public void adaugareAbsente(String s, String d) {
	}

	@Override
	public void modificareStatusAbsente(String status, String d, int i) {
	}

	@Override
	public void vizualizareElev(Elev e) {
		System.out.println(e.afisareDatePersonale(e));
	}

	@Override
	public void addClasa(Clasa c) {
		Centralizator.getInstance().getClase().add(c);
	}

	@Override
	public void delClasa(Clasa c) {
		Centralizator.getInstance().getClase().remove(c);
	}

	@Override
	public void addMaterie(Materie m, Clasa c) {
		c.getMaterii().add(m);
	}

	@Override
	public void delMaterie(Materie m, Clasa c) {
		c.getMaterii().remove(m);
	}

	@Override
	public void addElev(Clasa c, Elev e) {
		c.getElevi().add(e);
	}

	@Override
	public void delElev(Clasa c, Elev e) {
		c.getElevi().remove(e);
	}

	@Override
	public float medieGenerala(Elev e, Clasa c, Materie m) {
		return c.getCatalog().getHash().get(e).get(m).medieGenerala();
	}

	@Override
	public void addUtilizator(Utilizator u) {
		Centralizator c = Centralizator.getInstance();
		c.getUtilizatori().add(u);

	}

	@Override
	public void delUtilizator(Utilizator u) {
		Centralizator c = Centralizator.getInstance();
		c.getUtilizatori().remove(u);
	}

	@Override
	public String listareUtilizatori() {
		Centralizator c = Centralizator.getInstance();
		return c.getUtilizatori().toString();
	}

	@Override
	public void ordonareElevi(Clasa clasa, Comparator<Elev> comp) {
		Collections.sort(clasa.getElevi(), comp);
	}

	@Override
	public void addNotaSem1(Integer nota) {
	}

	@Override
	public void addNotaSem2(Integer nota) {
	}

	}