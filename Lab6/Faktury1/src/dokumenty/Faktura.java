package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import magazyn.Towar;
import rabaty.ObliczCenePoRabacie;


public class Faktura {
	Date dataSprzedazy;
	String kontrahent;
	ArrayList<Pozycja> pozycje;
	double suma;
	private ObliczCenePoRabacie obliczanieRabatu;

	public Faktura(Date dataSprzedazy,String kontrahent)
	{
		this.dataSprzedazy=dataSprzedazy;
		this.kontrahent=kontrahent;
		pozycje=new ArrayList<Pozycja>();
		suma=0;
		this.obliczanieRabatu = konfiguracja.Konfiguracja.getInstancja().getStrategiaRabatu();
	}
	public void dodajPozycje(Towar towar, double ilosc)
	{
		double cenaZRabatem = towar.getCena();
		if(obliczanieRabatu != null) {
			cenaZRabatem = obliczanieRabatu.obliczCenePoRabacie(cenaZRabatem);
		}
		Pozycja p = new Pozycja(towar, ilosc);
		p.setCena(cenaZRabatem);
		pozycje.add(p);
		this.przeliczSume();
	}
	public double getSuma()
	{
		return suma;
	}
	public Date getDataSprzedazy()
	{
		return dataSprzedazy;
	}

	//jak sie zmieni cos na fakturze to trzeba wywolac te metode
	private void przeliczSume()
	{
		Iterator<Pozycja> iteratorPozycji=pozycje.iterator();
		Pozycja pozycja;
		suma=0;
		while(iteratorPozycji.hasNext())
		{
			pozycja = iteratorPozycji.next();
			suma+=pozycja.getWartosc();
		}
	}
	public Iterator<Pozycja> getIteratorPozycji()
	{
		return pozycje.iterator();
	}
	public String getKontrahent()
	{
		return this.kontrahent;
	}

	public void setStrategiaRabatu(ObliczCenePoRabacie strategia) {
		this.obliczanieRabatu = strategia;
	}
}
