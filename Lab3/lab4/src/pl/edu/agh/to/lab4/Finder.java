package pl.edu.agh.to.lab4;

import java.util.*;

public class Finder {

    private final SuspectAggregate dataSources;

    public Finder(SuspectAggregate dataSource) {
        this.dataSources = dataSource;
    }

    public void displayAllSuspectsWithName(String name) {
        List<Suspect> suspects = new ArrayList<>();
        Iterator<Suspect> iterator = dataSources.iterator();

        while (iterator.hasNext() && suspects.size() < 10) {
            Suspect s = iterator.next();
            if (s.canBeAccused() && s.getName().equals(name)) {
                suspects.add(s);
            }
        }

        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : suspects) {
            System.out.println(n.display());
        }
    }
}
