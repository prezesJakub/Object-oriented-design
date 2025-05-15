package kategorie;

import magazyn.Towar;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class KategoriaLisc implements KategoriaKomponent {
    private String nazwa;
    private ArrayList<Towar> towary = new ArrayList<>();

    public KategoriaLisc(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodajTowar(Towar towar) {
        towary.add(towar);
    }

    @Override
    public void wypiszZawartosc(String prefix) {
        System.out.println(prefix + "Kategoria: " + nazwa);
        for (Towar t : towary) {
            System.out.println(prefix + "  - " + t.getNazwa() + ", cena: " + t.getCena());
        }
    }
}