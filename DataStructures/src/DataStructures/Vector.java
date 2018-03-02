package DataStructures;

import java.util.Arrays;

/**
 * Created by shivangipatwardhan on 2/19/18.
 */
public class Vector {

    private int[] array;
    private int arrayLength;
    private int arrayCapacity;

    public Vector(){
        array = new int[1];
        arrayCapacity = 1;
        arrayLength = 0;
    }

    public int size(){
        return arrayLength;
    }

    public int capacity(){
        return arrayCapacity;
    }

    public boolean is_empty(){
        return (arrayLength == 0) ? true : false;
    }

    public int at(int index){
        if(index < arrayLength){
            return array[index];
        }else{
            throw new IllegalAccessError("This index does not exist");
        }
    }

    public void push(int element){
        int[] newArray;

        if(arrayLength >= arrayCapacity){
            arrayCapacity *= 2;
            newArray = new int[arrayCapacity];
            Arrays.fill(newArray, 0);

            for(int i = 0; i < arrayLength; i++){
                newArray[i] = array[i];
            }
            newArray[arrayLength] = element;
            array = newArray;
        }else{
            array[arrayLength] = element;
        }
        arrayLength += 1;
    }

    public void insert(int element, int index){
        int[] newArray;
        arrayLength += 1;
        if(arrayLength >= arrayCapacity){
            arrayCapacity *= 2;
            newArray = new int[arrayCapacity];
            Arrays.fill(newArray, 0);

            for(int i = 0; i < index; i++){
                newArray[i] = array[i];
            }

            newArray[index] = element;

            for(int j = index + 1; j < arrayLength; j++){
                newArray[j] = array[j-1];
            }

            array = newArray;

        }else{

            for(int i = arrayLength+1; i > index; --i){
                array[i] = array[i-1];
            }
            array[index] = element;
        }
    }

    public void preprend(int element){
        insert(element, 0);
    }

    public int pop(){

        if(arrayLength == 0){
            throw new IllegalAccessError("This index does not exist");
        }
        int returnValue = array[arrayLength-1];
        arrayLength--;

        if(arrayLength < arrayCapacity/2){
            int[] newArray;
            newArray = new int[arrayCapacity/2];
            arrayCapacity /= 2;

            for(int i = 0; i < arrayLength; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }else{
            array[arrayLength] = 0;
        }

        return returnValue;
    }

    public int delete(int index){

        if(arrayLength == 0 || arrayLength <= index){
            throw new IllegalAccessError("No such element exists");
        }

        int removedValue = array[index];

        for(int i = index; i < arrayLength - 1; i++){
            array[i] = array[i+1];
        }
        arrayLength--;

        return removedValue;
    }

    public void remove(int element){
        for(int i = 0; i < arrayLength; i++){
            if(array[i] == element){
                delete(i);
            }
        }
    }



    public int find(int element){
        for(int i = 0; i < arrayLength; i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public void printVector(){
        for(int i = 0; i < arrayLength; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }




}
