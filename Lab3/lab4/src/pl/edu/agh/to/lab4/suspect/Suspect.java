package pl.edu.agh.to.lab4.suspect;

public abstract class Suspect {
    private final String name;
    private final String surname;

    public Suspect(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String display() {
        return name + " " + surname;
    }

    public abstract int getAge();
    public abstract boolean canBeAccused();
}
