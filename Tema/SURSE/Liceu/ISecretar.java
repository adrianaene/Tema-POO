package Liceu;

public interface ISecretar {
	public void addClasa(Clasa c);

	public void delClasa(Clasa c);

	public void addMaterie(Materie m, Clasa c);

	public void delMaterie(Materie m, Clasa c);

	public void addElev(Clasa c, Elev e);

	public void delElev(Clasa c, Elev e);

	public float medieGenerala(Elev e, Clasa c, Materie m);

}
