package wydruki;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public class DrukowanieFakturyUproszczona extends DrukowanieFaktury {

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("FAKTURA dla: " + faktura.getKontrahent());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        System.out.println("Pozycje:");
        Iterator<Pozycja> iteratorPozycji = faktura.getIteratorPozycji();
        while (iteratorPozycji.hasNext()) {
            Pozycja pozycja = iteratorPozycji.next();
            System.out.println("Towar: " + pozycja.getNazwa() +
                    " | Ilość: " + pozycja.getIlosc());
        }
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Suma: " + faktura.getSuma());
        System.out.println("=====================================================");
    }
}
