package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class StudentDataProvider implements SuspectAggregate {
    private final Collection<Student> students = new ArrayList<>();

    public StudentDataProvider() {
        students.add(new Student("Janusz", "Piwosz", 2001, "798512"));
        students.add(new Student("Grzegorz", "Głupi", 2005, "732534"));
        students.add(new Student("Łukasz", "Ogarnięty", 2003, "234433"));
    }

    @Override
    public Iterator<Suspect> iterator() {
        return new ArrayList<Suspect>(students).iterator();
    }

    public Collection<Student> getAllStudentCitizens() {
        return students;
    }
}
