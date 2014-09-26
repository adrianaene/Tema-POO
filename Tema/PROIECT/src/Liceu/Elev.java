 package Liceu;


public class Elev extends Utilizator implements IElev {

	private String CNP;
	private String data_nastere;

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getData_nastere() {
		return data_nastere;
	}

	public void setData_nastere(String data_nastere) {
		this.data_nastere = data_nastere;
	}

	@Override
	public String afisareDatePersonale(Elev e) {
		return e.CNP + " " + e.data_nastere;
	}

	@Override
	public String afisareNote(SituatieMaterieBaza m) {
		return m.noteSemestre();
	}

	@Override
	public String afisareMedie(SituatieMaterieBaza m) {
		return m.medieGenerala().toString();
	}

	@Override
	public String afisareAbsente(SituatieMaterieBaza m) {
		return m.afisareAbsente();
	}
}
