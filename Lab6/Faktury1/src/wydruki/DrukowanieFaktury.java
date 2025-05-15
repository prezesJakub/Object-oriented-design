package wydruki;

import dokumenty.Faktura;

public abstract class DrukowanieFaktury {
    public void drukujFakture(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujStopke(faktura);
    }

    protected abstract void drukujNaglowek(Faktura faktura);
    protected abstract void drukujPozycje(Faktura faktura);
    protected abstract void drukujStopke(Faktura faktura);
}
