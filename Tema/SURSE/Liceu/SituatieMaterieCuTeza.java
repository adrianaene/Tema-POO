package Liceu;

public class SituatieMaterieCuTeza extends SituatieMaterieBaza {
	private Integer notaTeza;

	public SituatieMaterieCuTeza(Materie materie) {
		super(materie);
	}

	@Override
	public Float medieGenerala() {
		int s = 0;
		for (Integer i : super.noteSem1())
			s += i;
		return (float) (notaTeza / 4 + (3 * s) / 4);
	}

	@Override
	public String toString() {
		return super.toString() + "\nMedia generala:"
				+ medieGenerala().toString();
	}
}
