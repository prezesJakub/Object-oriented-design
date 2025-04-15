package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate implements SuspectAggregate {
    private final List<SuspectAggregate> aggregates = new ArrayList<>();

    public void addAggregate(SuspectAggregate aggregate) {
        aggregates.add(aggregate);
    }

    @Override
    public Iterator<Suspect> iterator() {
        List<Suspect> allSuspects = new ArrayList<>();
        for (SuspectAggregate aggregate : aggregates) {
            Iterator<Suspect> it = aggregate.iterator();
            while (it.hasNext()) {
                allSuspects.add(it.next());
            }
        }
        return allSuspects.iterator();
    }
}
