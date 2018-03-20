package Iterators;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MultiIterator<T> implements Iterator<T>{

    private List<Iterator<T>> list;
    private T nextElement;
    private int index;

    public MultiIterator(List<Iterator<T>> iteratorList){
        if(iteratorList == null){
            throw new IllegalArgumentException("This is an invalid argument");
        }

        list = iteratorList;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        if(nextElement != null){
            return true;
        }

        return false;
    }

    @Override
    public T next() {

        Iterator<T> toReturn;
        if(hasNext()){
            toReturn = list.get(index);
            nextElement = null;
            return toReturn.next();
        }
        throw new NoSuchElementException("No such element");
    }
}
