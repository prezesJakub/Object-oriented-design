package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Student extends Suspect {

    private final String index;
    private final int birthYear;

    public Student(String name, String surname, int birthYear, String index) {
        super(name, surname);
        this.birthYear = birthYear;
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public int getAge() {
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    @Override
    public boolean canBeAccused() {
        return getAge() >= 18;
    }
}
