package Liceu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Profesor extends Utilizator implements IProfesor {

	private Materie materie;

	public SituatieMaterieBaza getSituatieMaterieBaza(Materie materie) {
		return new SituatieMaterieBaza(materie);
	}

	@Override
	public String listareElevi(Clasa c) {
		return c.afisareElevi();
	}

	@Override
	public void ordonareElevi(Clasa clasa, Comparator<Elev> comp) {
		Collections.sort(clasa.getElevi(), comp);
	}

	@Override
	public void addNotaSem1(Integer nota) {
		SituatieMaterieBaza s = getSituatieMaterieBaza(this.materie);
		s.addNotaSemestru1(nota);
	}

	@Override
	public void addNotaSem2(Integer nota) {
		SituatieMaterieBaza s = getSituatieMaterieBaza(this.materie);
		s.addNotaSemestru2(nota);
	}

	@Override
	public Float modificareMedii() {
		SituatieMaterieBaza s = getSituatieMaterieBaza(this.materie);
		return s.medieGenerala();
	}

	@Override
	public void adaugareAbsente(String status, String d) {
		SituatieMaterieBaza s = getSituatieMaterieBaza(this.materie);
		s.addAbsenta(status, d);
	}

	@Override
	public void modificareStatusAbsente(String status, String d, int i) {
		SituatieMaterieBaza s = getSituatieMaterieBaza(this.materie);
		s.modificareAbsenta(status, d, i);
	}

	@Override
	public void vizualizareElev(Elev e) {
		System.out.println(e.afisareDatePersonale(e));
		System.out.println(e
				.afisareAbsente(getSituatieMaterieBaza(this.materie)));
		System.out.println(e.afisareNote(getSituatieMaterieBaza(this.materie)));
		System.out
				.println(e.afisareMedie(getSituatieMaterieBaza(this.materie)));
	}

}
