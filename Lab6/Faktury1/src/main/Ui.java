package main;

import java.util.Iterator;
import java.util.Calendar;

import kategorie.KategoriaLisc;
import kategorie.Podkategoria;
import magazyn.Towar;

import dokumenty.Faktura;
import dokumenty.Pozycja;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;
import rabaty.LosowyRabatAdapter;
import rabaty.ObliczCenePoRabacieKwotowym;
import rabaty.ObliczCenePoRabacieProcentowym;
import wydruki.DrukowanieFaktury;
import wydruki.DrukowanieFakturyPelna;
import wydruki.DrukowanieFakturyUproszczona;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");

		konfiguracja.Konfiguracja.getInstancja().setStrategiaRabatu(new ObliczCenePoRabacieProcentowym(0.2));
		konfiguracja.Konfiguracja.getInstancja().setStrategiaDrukowania(new DrukowanieFakturyPelna());
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);

		DrukowanieFaktury drukowanie = konfiguracja.Konfiguracja.getInstancja().getStrategiaDrukowania();
		drukowanie.drukujFakture(f);

		Towar laptop = new Towar(3500, "Laptop");
		Towar myszka = new Towar(100, "Myszka");
		Towar koszulka = new Towar(50, "Koszulka");
		Towar bluza = new Towar(120, "Bluza");
		Towar banan = new Towar(5, "Banan");
		Towar mleko = new Towar(3, "Mleko");

		KategoriaLisc elektronika = new KategoriaLisc("Elektronika");
		elektronika.dodajTowar(laptop);
		elektronika.dodajTowar(myszka);

		KategoriaLisc ubrania = new KategoriaLisc("Ubrania");
		ubrania.dodajTowar(koszulka);
		ubrania.dodajTowar(bluza);

		KategoriaLisc owoc = new KategoriaLisc("Owoc");
		owoc.dodajTowar(banan);

		KategoriaLisc nabial = new KategoriaLisc("Nabial");
		nabial.dodajTowar(mleko);

		Podkategoria jedzenie = new Podkategoria("Jedzenie");
		jedzenie.dodaj(owoc);
		jedzenie.dodaj(nabial);

		Podkategoria wszystkieKategorie = new Podkategoria("Wszystkie Produkty");
		wszystkieKategorie.dodaj(elektronika);
		wszystkieKategorie.dodaj(ubrania);
		wszystkieKategorie.dodaj(jedzenie);

		wszystkieKategorie.wypiszZawartosc("");
	}
}
