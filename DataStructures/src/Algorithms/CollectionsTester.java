package Algorithms;


import java.util.ArrayList;

public class CollectionsTester {

    public void testLinkedList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.get(3);
        ArrayList<Integer> soln = (ArrayList<Integer>) list.clone();
        list.addAll(soln);
        System.out.println(list);
    }



    public static void main(String[] args){

        CollectionsTester tester = new CollectionsTester();
        tester.testLinkedList();


    }
}
