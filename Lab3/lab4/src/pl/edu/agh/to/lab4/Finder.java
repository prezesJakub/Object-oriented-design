package pl.edu.agh.to.lab4;

import java.sql.SQLOutput;
import java.util.*;

public class Finder {

    private final SuspectAggregate dataSources;

    public Finder(SuspectAggregate dataSource) {
        this.dataSources = dataSource;
    }

    public void display(SearchStrategy strategy) {
        Collection<Suspect> results = new ArrayList<>();
        Iterator<Suspect> iterator = dataSources.iterator();
        while (iterator.hasNext()) {
            Suspect suspect = iterator.next();
            if(suspect.canBeAccused() && strategy.filter(suspect)) {
                results.add(suspect);
            }
        }
        int t = results.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect n : results) {
            System.out.println(n.display());
        }
    }
}
