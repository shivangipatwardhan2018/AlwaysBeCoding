package Iterators;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteringIterator<T> implements Iterator<Integer> {

    private Integer nextElement;
    private final Predicate<Integer> predicate;
    private final Iterator<Integer> iterator;

    //A Predicate in Java is a functional interface that can be used to hold a lambda function

    public FilteringIterator(Iterator<Integer> iteratorInput, Predicate<Integer> predicateInput) {
        predicate = predicateInput;
        iterator = iteratorInput;
        nextElement = null;
    }

    @Override
    public boolean hasNext() {
        if(nextElement != null){
            return true;
        }

        while(iterator.hasNext()){
            Integer value = iterator.next();
            if(predicate.test(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException("This element does not exist");
        }

        Integer toReturn = nextElement;
        nextElement = null;
        return toReturn;
    }

    @Override
    public void remove() {
        throw new NotImplementedException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new NotImplementedException();
    }
}
