package DataStructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class HashMap implements Map {


    class Container{
        Object key;
        Object value;
        Container next;

        public Container(Object key, Object value){
            key = key;
            value = value;
            next = null;
        }

    }

    ArrayList<Container> hashMap;


    public HashMap(){
        hashMap = new ArrayList<Container>();
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //Find the
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
