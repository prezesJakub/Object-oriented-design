package pl.edu.agh.to.lab4.util;

import pl.edu.agh.to.lab4.suspect.Suspect;

import java.util.*;

public class FlatIterator<T extends Suspect> implements Iterator<Suspect> {
    private final Iterator<Collection<T>> outerIterator;
    private Iterator<T> innerIterator = Collections.emptyIterator();

    public FlatIterator(Map<String, Collection<T>> map) {
        this.outerIterator = map.values().iterator();
        advanceToNextNonEmptyInner();
    }

    @Override
    public boolean hasNext() {
        while(!innerIterator.hasNext() && outerIterator.hasNext()) {
            innerIterator = outerIterator.next().iterator();
        }
        return innerIterator.hasNext();
    }

    @Override
    public Suspect next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return innerIterator.next();
    }

    private void advanceToNextNonEmptyInner() {
        while(outerIterator.hasNext()) {
            innerIterator = outerIterator.next().iterator();
            if(innerIterator.hasNext()) {
                break;
            }
        }
    }
}
