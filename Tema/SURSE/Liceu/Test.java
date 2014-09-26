package Liceu;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
//functie in acre testez functionalitatea claselor din pachetul Liceu
public class Test {

    public static void main(String[] args) throws IOException {
	FactoryPattern fp = FactoryPattern.getInstance();
	Elev elev1 = (Elev) fp.getUtilizator("Elev");
	Elev elev2 = (Elev) fp.getUtilizator("Elev");
	Profesor profesorBio = (Profesor) fp.getUtilizator("Profesor");
	Secretar secretar = (Secretar) fp.getUtilizator("Secretar");
	Administrator administrator = (Administrator) fp
		.getUtilizator("Administrator");
	// setare date utilizatori
	profesorBio.setNume("Ilie");
	profesorBio.setPrenume("Manuela");
	profesorBio.setNumeUtilizator("ProfesorBio");
	profesorBio.setParola("2765");
	administrator.setNume("Popescu");
	administrator.setPrenume("Andreea");
	administrator.setNumeUtilizator("Administrator");
	administrator.setParola("3159");	
	elev1.setData_nastere("09.05.1993");
	elev1.setCNP("23456722909");
	elev1.setNume("Ene");
	elev1.setNumeUtilizator("Elev1");
	elev1.setParola("1234");
	elev1.setPrenume("Adriana");
	Materie m1 = new Materie("Biologie");
	m1.setNumarOreSaptamana(2);
	m1.setAreTeza(false);
	SituatieMaterieBaza sb1 = new SituatieMaterieBaza(m1);
	sb1.addAbsenta("nemotivata", "04.10.2013");
	sb1.addNotaSemestru1(10);
	sb1.addNotaSemestru1(7);
	sb1.addNotaSemestru2(8);
	sb1.addNotaSemestru2(9);

	// verificare functii

	Hashtable<Materie, SituatieMaterieBaza> materie_situatie = new Hashtable<>();
	materie_situatie.put(m1, sb1);
	Hashtable<Elev, Hashtable<Materie, SituatieMaterieBaza>> dictionar_catalog = new Hashtable<>();
	dictionar_catalog.put(elev1, materie_situatie);
	Catalog c = new Catalog(dictionar_catalog);
	
	System.out.println(c.getHash().get(elev1).get(m1).afisareAbsente());   
	
	Clasa c1 = new Clasa("5A");

	ArrayList<Materie> mat = new ArrayList<>();
	mat.add(m1);
	c1.addElev(elev1);
	c1.setCatalog(c);
	c1.setMaterii(mat);

	secretar.setNume("Matache");
	secretar.setNumeUtilizator("Secretar");
	secretar.setParola("5678");
	secretar.setPrenume("Delia");

	elev2.setNume("Banu");
	elev2.setNumeUtilizator("Elev2");
	elev2.setParola("578");
	elev2.setPrenume("Mihai");

	 secretar.addElev(c1, elev2);

	Elev e2 = (Elev) fp.getUtilizator("Elev");
	e2.setNumeUtilizator("Elev1");

	Elev elev3 = (Elev) fp.getUtilizator("Elev");
	elev3.setNume("Zamfir");
	elev3.setNumeUtilizator("Elev3");
	elev3.setParola("5278");
	elev3.setPrenume("Zmf");

	secretar.addElev(c1, elev3);
	Comparator<Elev> comparatorDupaNume = new Comparator<Elev>() {

	    @Override
	    public int compare(Elev arg0, Elev arg1) {
		return arg0.getNume().compareTo(arg1.getNume());
	    }
	};

	profesorBio.ordonareElevi(c1, comparatorDupaNume);

	System.out.println(profesorBio.listareElevi(c1));

	// salvare date in fisier binar
	File f = new File("data");
	if (f.exists() == false) {// daca fisierul nu exista, adaugam datele la
				  // centralizator si le serializam

	    // adaugare date la centralizator
	    administrator.addUtilizator(elev1);
	    administrator.addUtilizator(elev2);
	    administrator.addUtilizator(profesorBio);
	    administrator.addUtilizator(secretar);
	    administrator.addUtilizator(administrator);
	    administrator.addClasa(c1);
	    ObjectOutputStream stream = new ObjectOutputStream(
		    new FileOutputStream("data"));
	    stream.writeObject(Centralizator.getInstance());
	}

	secretar.delElev(c1, elev3);

	System.out.println(c1.afisareElevi());
	System.out.println(secretar.medieGenerala(elev1, c1, m1));
	System.out.println(c1);

	System.out.println(Centralizator.getInstance().getUtilizatori());
    }
}