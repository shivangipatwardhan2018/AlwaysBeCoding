package Iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.Consumer;


public class DeepIterator<T> implements Iterator<Integer>{

    Integer nextElement = null;
    private final Stack<Iterator<?>> iteratorStack = new Stack<>();

//    Constructor
    public DeepIterator(Collection<Object> coll){
        if(coll == null){
            throw new ExceptionInInitializerError("no collection specified");
        }

        iteratorStack.push(coll.iterator());
    }

    @Override
    public boolean hasNext() {
        if(nextElement != null){
            return true;
        }

        while(!iteratorStack.empty()){

            Iterator<?> nextIterator = iteratorStack.peek();

            if(nextIterator.hasNext()){
                Object item = nextIterator.next();
                if(nextIterator instanceof Collection<?>){

                    //Push on an iterator for that object
                    iteratorStack.push(((Collection<?>) nextIterator).iterator());

                }else{
                    nextElement = (Integer) item;
                    return true;
                }

            }else {

                //Remove the element
                iteratorStack.pop();
            }

        }
        return false;
    }

    @Override
    public Integer next() {
       Integer returnValue;
       if(hasNext()){
           returnValue = nextElement;
           nextElement = null;
           return returnValue;
       }

       throw new NoSuchElementException("No next element");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        throw new UnsupportedOperationException();
    }
}
