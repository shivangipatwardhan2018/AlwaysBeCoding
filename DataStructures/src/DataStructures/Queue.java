package DataStructures;

/**
 * Created by shivangipatwardhan on 2/22/18.
 */
public class Queue {

    Node head;
    Node tail;

    public void enqueue(int element){
        Node temphead = head;
        if(temphead == null && tail == null){
            head = new Node(element, null);
            tail = head;
        }else{
            Node newElement = new Node(element, head);
            while(temphead.next != null){
                temphead = temphead.next;
            }
            temphead.next = newElement;
            tail = newElement;
        }
    }

    public Node dequeue(){
        if(head == tail){
            throw new IllegalAccessError("No more elements to remove");
        }
        Node retval = head;
        head = head.next;
        return retval;
    }

    public boolean empty(){
        return head == tail;
    }

    public void printQueue(){
        Node tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.val);
            tempNode = tempNode.next;
        }
        System.out.println("");
    }

    private class Node{

        int val;
        Node next;
        Node prev;

        public Node(int valinput, Node previnput){
            val = valinput;
            prev = previnput;
            next = null;
        }


    }
}
