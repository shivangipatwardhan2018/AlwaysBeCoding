package DataStructures;

/**
 * Created by shivangipatwardhan on 2/22/18.
 */
public class Stack {
    //LIFO
    private Node head;


    public void push(int element){
        if (head == null){
            head = new Node(element, element, element);
        }else{
            Node oldHead = head;

            int min = head.minVal;
            int max = head.maxVal;

            if(min > element){
                min = element;
            }
            if(max < element){
                max = element;
            }

            head = new Node(element, min, max, head);
        }

    }


    public int pop(){
        int val = head.val;
        head = head.nextNode;
        return val;
    }

    public int peek(int element){
        return head.val;
    }

    public int getMin(){
        return head.minVal;
    }


    public int getMax(){
        return head.maxVal;
    }

    private class Node{
        int val;
        Node nextNode;
        int minVal;
        int maxVal;


        public Node(int element, int min, int max){
            val = element;
            nextNode = null;
            minVal = min;
            maxVal = max;
        }

        public Node(int element, int min, int max, Node next){
            val = element;
            nextNode = next;
            minVal = min;
            maxVal = max;
        }

    }


}
