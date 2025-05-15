package konfiguracja;

import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieProcentowym;
import wydruki.DrukowanieFaktury;

public class Konfiguracja {
    private static Konfiguracja instancja = null;
    private ObliczCenePoRabacie strategiaRabatu;
    private DrukowanieFaktury strategiaDrukowania;

    private Konfiguracja() {
        this.strategiaRabatu = new ObliczCenePoRabacieProcentowym(0.10);
    }

    public static Konfiguracja getInstancja() {
        if (instancja == null) {
            instancja = new Konfiguracja();
        }
        return instancja;
    }

    public ObliczCenePoRabacie getStrategiaRabatu() {
        return strategiaRabatu;
    }

    public DrukowanieFaktury getStrategiaDrukowania() {
        return strategiaDrukowania;
    }

    public void setStrategiaRabatu(ObliczCenePoRabacie strategia) {
        this.strategiaRabatu = strategia;
    }

    public void setStrategiaDrukowania(DrukowanieFaktury strategia) {
        this.strategiaDrukowania = strategia;
    }
}
