/**
 * Created by shivangipatwardhan on 2/19/18.
 */
public class DataStructures {



    private static void testVectors() {

        Vector testVector = new Vector();
        int size = testVector.size();
        int capacity = testVector.capacity();
        testVector.push(0);
        testVector.push(1);
        testVector.push(2);
        testVector.push(3);
        testVector.push(4);
        testVector.push(5);
        testVector.push(6);
        testVector.insert(0, 1);
        testVector.insert(2, 3);
        testVector.insert(3, 5);
        testVector.insert(4, 7);
        testVector.preprend(9);
        testVector.preprend(10);
        testVector.pop();
        testVector.pop();
        testVector.pop();
        testVector.delete(0);
        testVector.delete(3);
        testVector.delete(2);
        testVector.find(2);
        testVector.find(4);
        testVector.find(7);


    }

    public static void main(String[] args){
            testVectors();
    }


}
