package LinkedLists;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(Object element, int offset) {


    }

    @Override
    public void addFirst(T element) {

        Node<T> newNode = new Node<T>(element);

        newNode.setNext(head);
        head = newNode;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<T>(element);

        if(tail != null){
            tail.setNext(newNode);
        }

        tail = newNode;
        if(head == null){
            head = tail;
        }

        size++;
    }

    @Override
    public T removeFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }

        Node<T> oldHead = head;

        if(head == tail){
            head = tail = null;
        }else{
            head = head.getNext();
        }

        size--;
        return oldHead.value;
    }

    @Override
    public T removeLast() {
        if(head == null){
            throw new NoSuchElementException();
        }

        Node<T> oldTail = tail;

        if(head == tail){
            head = tail = null;
            return oldTail.value;
        }

        Node<T> iter = head;
        while(iter.getNext() != tail){
            iter = iter.getNext();
        }

        iter.setNext(null);
        tail = iter;
        size--;
        return oldTail.value;
    }

    @Override
    public T remove(int offset) {
        if(offset >= size || offset < 0 || head == null){
            throw new NoSuchElementException("cannot find object");
        }

        if(offset == 0){
            return removeFirst();
        }

        if(offset == size - 1){
            return removeLast();
        }

        Node<T> prev = null, current = head;
        int count = 0;

        while(count < offset){
            count++;
            prev = current;
            current = current.getNext();
        }

        Node<T> offsetNode = current;
        prev.setNext(current.getNext());

        size--;
        return offsetNode.value;

    }

    @Override
    public void remove(Object element, Comparator comparator) {
        if(head == null){
            throw new NoSuchElementException();
        }

        if (comparator == null) {
            throw new NullPointerException("You passed a null comparator");
        }

        Node<T> prev = head;
        Node<T> current = head;
        while(current != null){

            if(current.getValue() == element){
                prev.setNext(current.getNext());
                size--;
            }

            prev = current;
            if(current != null){
                current = current.getNext();
            }

        }
    }

    @Override
    public boolean search(Object element) {
        return false;
    }

    @Override
    public T get(int offset) {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void reverse() {

    }





    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node() {
        }

        public Node(E value) {
            this(value, null);
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (value != null) {
                return value.toString();
            }

            return "null";
        }

    }

}
