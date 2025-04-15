package pl.edu.agh.to.lab4.search;

import pl.edu.agh.to.lab4.suspect.Suspect;

public class NameSearchStrategy implements SearchStrategy {
    private final String name;
    private final String surname;

    public NameSearchStrategy(String name) {
        this(name, null);
    }
    public NameSearchStrategy(String name, String surname) {
        name = (name != null && name.equals("")) ? null : name;
        surname = (surname != null && surname.equals("")) ? null : surname;
        if (name == null && surname == null) {
            throw new IllegalArgumentException("Name and surname are required");
        }
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return ((name == null || suspect.getName().equals(name))
            && (surname == null || suspect.getSurname().equals(surname)));
    }
}
