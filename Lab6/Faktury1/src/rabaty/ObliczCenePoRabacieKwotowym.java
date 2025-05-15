package rabaty;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie {
    private double kwota;

    public ObliczCenePoRabacieKwotowym(double kwota) {
        this.kwota = kwota;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        return Math.max(0, cena - kwota);
    }
}
