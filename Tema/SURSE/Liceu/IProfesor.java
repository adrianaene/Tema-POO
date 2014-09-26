package Liceu;

import java.util.ArrayList;
import java.util.Comparator;

public interface IProfesor {
	public String listareElevi(Clasa c);
	public void addNotaSem1(Integer nota);
	public void addNotaSem2(Integer nota);
	public Float modificareMedii();
	public void adaugareAbsente(String s,String d);
	public void modificareStatusAbsente(String status,String d,int i);
	public void vizualizareElev(Elev e);
	public void ordonareElevi(Clasa clasa, Comparator<Elev> comp);
}
