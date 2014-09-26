package Liceu;

public class FactoryPattern {
	private static FactoryPattern fp = null;

	private FactoryPattern() {
	}

	public static FactoryPattern getInstance() {
		if (fp == null) {
			fp = new FactoryPattern();
		}
		return fp;
	}

	public Utilizator getUtilizator(String tipUtilizator) {
		if (tipUtilizator == null) {
			return null;
		}
		if (tipUtilizator.equals("Elev")) {
			return new Elev();
		} else if (tipUtilizator.equals("Profesor")) {
			return new Profesor();
		} else if (tipUtilizator.equals("Secretar")) {
			return new Secretar();
		} else if (tipUtilizator.equals("Administrator")) {
			return new Administrator();
		}

		return null;
	}
}
