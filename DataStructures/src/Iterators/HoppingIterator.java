package Iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HoppingIterator implements Iterator<Integer> {

    private Iterator<Integer> integerIterator;
    private int hopStep;
    private Integer nextElement;
    private boolean first;

    public HoppingIterator(Iterator<Integer> iteratorInput, int skipInput) throws Exception {
        if(iteratorInput == null){
            throw new Exception("Iterator specified as null");
        }
            integerIterator = iteratorInput;
            hopStep = skipInput;
            first = true;
    }

    @Override
    public boolean hasNext() {
        if(nextElement != null){
            return true;
        }

        if(!first){
            for(int hop = 0; hop < hopStep && integerIterator.hasNext(); hop++){
                integerIterator.next();
            }
        }

        if(integerIterator.hasNext()){
            nextElement = integerIterator.next();
            first = false;
        }

        return nextElement != null;

    }

    @Override
    public Integer next() {

        if(!hasNext()){
            throw new NoSuchElementException("No more elements");
        }

        Integer toReturn = nextElement;
        nextElement = null;
        return toReturn;
    }
}
