package DataStructures;

/**
 * Created by shivangipatwardhan on 2/19/18.
 */
public class DataStructures {

//    private static void testVectors() {
//
//        Vector testVector = new Vector();
//        int size = testVector.size();
//        int capacity = testVector.capacity();
//        testVector.push(0);
//        testVector.push(1);
//        testVector.push(2);
//        testVector.push(3);
//        testVector.push(4);
//        testVector.push(5);
//        testVector.push(6);
//        testVector.insert(0, 1);
//        testVector.insert(2, 3);
//        testVector.insert(3, 5);
//        testVector.insert(4, 7);
//        testVector.preprend(9);
//        testVector.preprend(10);
//        testVector.pop();
//        testVector.pop();
//        testVector.pop();
//        testVector.delete(0);
//        testVector.delete(3);
//        testVector.delete(2);
//        testVector.find(2);
//        testVector.find(4);
//        testVector.find(7);
//
//
//    }
//
//    private static void testReverseWords( ){
//        ReverseWords rw = new ReverseWords();
//        rw.reverseWords("  ");
//        rw.reverseWords(" s ");
//        rw.reverseWords(" a b");
//        rw.reverseWords(" the sky is blue ");
//        rw.reverseWords("the sky is blue ");
//    }

    private static void verifyPowerNumber() {
        PowerNumber pn = new PowerNumber();
        System.out.println(pn.isPowerNumber(49));
        System.out.println(pn.isPowerNumber(8));
        System.out.println(pn.isPowerNumber(10));
        System.out.println(pn.isPowerNumber(1000));
        System.out.println(pn.isPowerNumber(10000));
    }

    // Adds two log probs.
    private static float sumLogProbs(float a, float b) {

        if (a == Float.NEGATIVE_INFINITY)
            return b;

        if (b == Float.NEGATIVE_INFINITY)
            return a;

        if (a < b) {
            return (float) (b + StrictMath.log1p(StrictMath.exp(a - b)));
        }

        return (float) (a + StrictMath.log1p(StrictMath.exp(b - a)));
    }


    public static float checkSum() {
        float soln = Float.NEGATIVE_INFINITY;
        float start = (float)-2.0794415;

        for (int i = 0; i < 11; i++) {
            soln = sumLogProbs(soln, start);
        }
        return soln;
    }

    private static void testQueue() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.printQueue();
        q.enqueue(6);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.printQueue();
    }



    public static void main(String[] args){
        System.out.println(checkSum());
    }


}
