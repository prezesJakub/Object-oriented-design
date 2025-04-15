package pl.edu.agh.to.lab4;

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
