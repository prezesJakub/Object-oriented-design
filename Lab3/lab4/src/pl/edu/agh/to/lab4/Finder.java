package pl.edu.agh.to.lab4;

import java.util.*;

public class Finder {

    private final List<SuspectAggregate> dataSources;

    public Finder(SuspectAggregate... sources) {
        this.dataSources = Arrays.asList(sources);
    }

    public void displayAllSuspectsWithName(String name) {
        List<Suspect> suspects = new ArrayList<>();

        for (SuspectAggregate source : dataSources) {
            Iterator<Suspect> iterator = source.iterator();
            while (iterator.hasNext() && suspects.size() < 10) {
                Suspect s = iterator.next();
                if (s.canBeAccused() && s.getName().equals(name)) {
                    suspects.add(s);
                }
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspects) {
            System.out.println(n.display());
        }
    }
}
