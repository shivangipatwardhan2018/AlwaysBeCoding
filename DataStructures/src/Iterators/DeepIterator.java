package Iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * Created by shivangipatwardhan on 3/1/18.
 */
public class DeepIterator<Object> implements Iterator<Integer>{

    Integer nextElement = null;
    Stack<Object> iteratorStack = new Stack<>();

//    Constructor
    public DeepIterator(Collection<Object> coll){
        if(coll == null){
            throw new ExceptionInInitializerError("no collection specified");
        }

        iteratorStack.push((Object) coll.iterator());
    }

    @Override
    public boolean hasNext() {

        while(!iteratorStack.empty()){

            Object topElement = iteratorStack.peek();
            if(topElement instanceof Integer){
                nextElement = (Integer) topElement;
            }else{
                //Its a new iterator
                
            }


        }
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {

    }
}
