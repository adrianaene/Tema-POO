package Liceu;

import java.io.Serializable;
import java.util.Hashtable;

public class Catalog implements Serializable {
	private Hashtable<Elev, Hashtable<Materie, SituatieMaterieBaza>> hash;

	public Catalog(Hashtable<Elev, Hashtable<Materie, SituatieMaterieBaza>> hash) {
		this.hash = hash;
	}

	public String toString() {
		return hash.toString();
	}

	public Hashtable<Elev, Hashtable<Materie, SituatieMaterieBaza>> getHash() {
		return hash;
	}

}
