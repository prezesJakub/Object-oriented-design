package kategorie;

import java.util.ArrayList;

public class Podkategoria implements KategoriaKomponent {
    private String nazwa;
    private ArrayList<KategoriaKomponent> podkategorie = new ArrayList<>();

    public Podkategoria(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodaj(KategoriaKomponent komponent) {
        podkategorie.add(komponent);
    }

    @Override
    public void wypiszZawartosc(String prefix) {
        System.out.println(prefix + "Podkategoria: " + nazwa);
        for (KategoriaKomponent k : podkategorie) {
            k.wypiszZawartosc(prefix + " ");
        }
    }
}