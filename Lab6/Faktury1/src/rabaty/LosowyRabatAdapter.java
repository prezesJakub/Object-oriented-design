package rabaty;

import rabatlosowy.LosowyRabat;

public class LosowyRabatAdapter implements ObliczCenePoRabacie {
    private LosowyRabat losowyRabat;

    public LosowyRabatAdapter() {
        this.losowyRabat = new LosowyRabat();
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        double rabatProcentowy = losowyRabat.losujRabat();
        return cena * (1 - rabatProcentowy);
    }
}
