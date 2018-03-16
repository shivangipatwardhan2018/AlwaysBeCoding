package DataStructures;

/**
 * Created by shivangipatwardhan on 2/22/18.
 */
public class HashTable {

    LinkedList<Number>[] hashTable;

    public int hashKey(String key){
        return key.hashCode();
    }


    private class Data{
        String key;
        int value;

        public Data(String keyInput, int valueInput){
            key = keyInput;
            value = valueInput;
        }
    }


}
