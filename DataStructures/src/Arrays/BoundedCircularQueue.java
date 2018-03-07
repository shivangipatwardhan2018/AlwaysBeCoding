package Arrays;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Implement add and remove methods for a generic bounded circular queue.
 *
 * Signature of expected methods:
 *
 * public class BoundedCircularQueue<T> implements Queue<T> {
 * 	  public BoundedCircularQueue(int capacity); // constructor
 * 	  public boolean add(T element);
 * 	  public T remove();
 * }
 *
 * You may leave the remaining methods in the Queue interface unimplemented.

 * What is a

 */

public class BoundedCircularQueue implements Queue<Integer>{
    private final int maxSize;
    private int curSize;
    private int head;
    private int tail;
    private final Integer[] queue;


    public BoundedCircularQueue(int capacity){
        maxSize = capacity;
        curSize = 0;
        head = 0;
        tail = 0;
        queue = new Integer[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(Integer element){
        if(head == tail % maxSize + 1){
            return false;
        }

        queue[tail] = element;
        tail++;
        tail %= queue.length;
        curSize++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(Integer integer) {
        return false;
    }

    @Override
    public Integer remove(){
        if(curSize == 0){
            throw new NoSuchElementException("This element does not exist");
        }
        int toReturn = queue[head];
        queue[head] = null;
        head++;
        head %= queue.length;
        curSize--;

        return toReturn;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

}
