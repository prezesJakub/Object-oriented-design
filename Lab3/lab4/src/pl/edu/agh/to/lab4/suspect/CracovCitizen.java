package pl.edu.agh.to.lab4.suspect;

public class CracovCitizen extends Suspect {

    private int age;

    public CracovCitizen(String name, String surname, int age) {
        super(name, surname);
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused() {
        return getAge() >= 18;
    }
}
