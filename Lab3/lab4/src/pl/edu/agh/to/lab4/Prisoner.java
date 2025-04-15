package pl.edu.agh.to.lab4;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;

    private final int senteceDuration;

    private final String pesel;

    public Prisoner(String name, String surname, String pesel, int judgementYear, int sentenceDuration) {
        super(name, surname);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.senteceDuration = sentenceDuration;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean isJailedNow() {
        return judgementYear + senteceDuration >= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public int getAge() {
        final int peselYear = Integer.parseInt(getPesel().substring(0, 2));
        final int peselMonth = Integer.parseInt(getPesel().substring(2, 4));

        final int birthYear = (peselMonth >= 20) ? 2000 + peselYear : 1900 + peselYear;
        final int currentYear = getCurrentYear();
        return currentYear - birthYear;
    }

    @Override
    public boolean canBeAccused() {
        return !isJailedNow() && getAge() >= 18;
    }
}
