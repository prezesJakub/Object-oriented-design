package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.providers.PersonDataProvider;
import pl.edu.agh.to.lab4.providers.PrisonersDataProvider;
import pl.edu.agh.to.lab4.providers.StudentDataProvider;
import pl.edu.agh.to.lab4.search.NameSearchStrategy;
import pl.edu.agh.to.lab4.util.CompositeAggregate;
import pl.edu.agh.to.lab4.util.Finder;

public class Application {

    public static void main(String[] args) {
        CompositeAggregate aggregate = new CompositeAggregate();
        aggregate.addAggregate(new PersonDataProvider());
        aggregate.addAggregate(new PrisonersDataProvider());
        aggregate.addAggregate(new StudentDataProvider());

        Finder suspects = new Finder(aggregate);
        suspects.display(new NameSearchStrategy("Janusz"));
    }
}
