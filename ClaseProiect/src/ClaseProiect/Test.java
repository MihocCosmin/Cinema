package ClaseProiect;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Film> catalogFilme = new ArrayList<Film>();
		Film f1 = new Film(1, "Star Wars", "nr 7", 120);
		Film f2 = new Film(2, "Avengers", "Partea 1", 125);
		catalogFilme.add(f1);
		catalogFilme.add(f2);
		
		List<Sala> listaSali = new ArrayList<Sala>();
		Sala s1 = new Sala(1, 80);
		Sala s2 = new Sala(2, 80);
		listaSali.add(s1);
		listaSali.add(s2);
		
        List<Ecranizare> ecranizari = new ArrayList<Ecranizare>();
        Ecranizare e1 = new Ecranizare(1);
        Ecranizare e2 = new Ecranizare(2);
        e1.adaugaFilm(f1);
        e1.adaugaSala(s2);
        e2.adaugaFilm(f2);
        e2.adaugaSala(s1);
        ecranizari.add(e1);
        ecranizari.add(e2);
        
        List<Loc> locuri = new ArrayList<Loc>();
        Loc l1 = new Loc(1, 5, 8);
        Loc l2 = new Loc(2, 10, 4);
        l1.adaugaSala(s1);
        l2.adaugaSala(s2);
        locuri.add(l1);
        locuri.add(l2);
        
        List<Angajat> angajati = new ArrayList<Angajat>();
        Angajat a1 = new Angajat(1, "Marius");
        angajati.add(a1);
        
        List<TipRezervare> tipuri = new ArrayList<TipRezervare>();
        TipRezervare tr1 = new TipRezervare(1, "online");
        TipRezervare tr2 = new TipRezervare(2, "fizic");
        tipuri.add(tr1);
        tipuri.add(tr2);
        
        List<Rezervare> rezervari = new ArrayList<Rezervare>();
        RezervareOnline ro1 = new RezervareOnline(1, true, "Vlad", 16.00);
        ro1.adaugaEcranizare(e1);
        ro1.adaugaTipRezervare(tr1);
        RezervareFizica rf1 = new RezervareFizica(2, true, "Alex", 22);
        rf1.adaugaEcranizare(e2);
        rf1.adaugaTipRezervare(tr2);
        rf1.adaugaAngajat(a1);
        rf1.getValoarePret();
        rezervari.add(ro1);
        rezervari.add(rf1);
        
        List<LocRezervat> locuriR = new ArrayList<LocRezervat>();
        LocRezervat lr1 = new LocRezervat(1);
        lr1.adaugaLoc(l1);
        lr1.adaugaEcranizare(e1);
        lr1.adaugaRezervare(ro1);
        locuriR.add(lr1);
        
        System.out.println(lr1.getId());
        
	}

}
