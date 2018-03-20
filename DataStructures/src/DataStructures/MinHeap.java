package DataStructures;


import java.util.ArrayList;

public class MinHeap {

    public ArrayList<Integer> elements;

//     leftchild = 2 * index + 1
//     rightchild = 2 * index + 2

    public MinHeap(ArrayList<Integer> input){
        elements = input;
        buildHeap();

    }

    //Add element
    public void add(int element){
        elements.add(element);
        //If the added element is larger than the parent when swap
        //Need function to get index of parent
        int index = elements.size() - 1;
        int parentIndex = parent(index);
        while(elements.get(parentIndex) < elements.get(index) &&
                parentIndex != index){

            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    //Build heap
    private void buildHeap() {
        for(int i = elements.size()/2; i >= 0; i--){
            heapify(i);
        }
    }

    public int extractMin(){

        if(elements.size() == 0){
            throw new IllegalStateException("Empty MinHeap");
        }else if(elements.size() == 1){
            int min = elements.remove(0);
            return min;
        }

        int min = elements.get(0);
        int lastItem = elements.remove(elements.size() - 1);
        elements.set(0, lastItem);

        // Push the element down such that the MinHeap property is still maintained
        heapify(0);

        return min;
    }



    //heapify
    public void heapify(int rootIndex){
        int smallest = -1;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if(left < elements.size() && elements.get(rootIndex) > elements.get(left)){
            smallest = left;
        }else{
            smallest = rootIndex;
        }

        if(right < elements.size() && elements.get(rootIndex) < elements.get(right)){
            smallest = right;
        }

        if(smallest != rootIndex){
            swap(rootIndex, smallest);
            heapify(smallest);
        }

    }

    public void decreaseKey(int i, int key){

        if(elements.get(i) < key){
            throw new IllegalArgumentException("Key larger than original");
        }

        elements.set(i, key);
        int parent = parent(i);

        while(i > 0 && elements.get(parent) > elements.get(i)){
            swap(i, parent);
            i = parent;
            parent = parent(parent);
        }

    }


    private int parent(int i ){
        if(i%2 == 1){
            //left child
            return i /2;
        }
        //right child
        return (i-1)/2;
    }

    public int getMin() {

        return elements.get(0);
    }

    public boolean isEmpty(){
        return elements.size() == 0;
    }

    private void swap(int i, int parent) {
        int temp = elements.get(parent);
        elements.set(parent, elements.get(i));
        elements.set(i, temp);
    }

}
