package Liceu;

public class Secretar extends Utilizator implements ISecretar {

	@Override
	public void addClasa(Clasa c) {
		Centralizator.getInstance().getClase().add(c);
	}

	@Override
	public void delClasa(Clasa c) {
		c = null;
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

}
