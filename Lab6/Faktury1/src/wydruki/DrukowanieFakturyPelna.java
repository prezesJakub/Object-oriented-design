package wydruki;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public class DrukowanieFakturyPelna extends DrukowanieFaktury {

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FAKTURA z dnia: " + faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        System.out.println("Pozycje:");
        Iterator<Pozycja> iteratorPozycji = faktura.getIteratorPozycji();
        while (iteratorPozycji.hasNext()) {
            Pozycja pozycja = iteratorPozycji.next();
            System.out.println("Towar: " + pozycja.getNazwa() +
                    " | Ilość: " + pozycja.getIlosc() +
                    " | Cena: " + pozycja.getCena() +
                    " | Wartosc: " + pozycja.getWartosc());
        }
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Suma: " + faktura.getSuma());
        System.out.println("=====================================================");
    }
}
