package week05$arraylists;

import week08$iterators.IntArrayListIterator;

/**
 * CODING EXAMPLE
 * This is an example of a class that stores an
 * ArrayList of integers.
 * -----------------------------------
 * TODO: Use this example to build a Generic ArrayList<E>.
 * -----------------------------------
 * data fields are encapsulated.
 * methods must be in alphabetical order.
 */

public class IntArrayList {
    private int[] data;   //stores internal array of integers.
    private int size;     //stores the number of elements in list.

    public static final int DEFAULT_CAPACITY = 10;

    /**
     * overloaded constructor. constructs list with default capacity.
     */
    public IntArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * constructs an empty list with the specified capacity.
     * @param capacity of list.
     */
    public IntArrayList(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * appends value to the end of the list.
     * @param value to be added.
     */
    public void add(int value){
        data[size] = value;
        size++;
    }

    /**
     * inserts a given value at the index specified, shifting
     * subsequent values to the right.
     * @param index for insertion
     * @param value to place at index location in list.
     */
    public void add(int index, int value){
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    /**
     * appends another list to current list.
     * @param other list
     */
    public void addAll(IntArrayList other){
        ensureCapacity(size + other.size);
        for (int i = 0; i < other.size; i++) {
            add(other.data[i]);
        }
    }

    /**
     * checks if the current index is valid.
     * @param index of value
     */
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
    }


    /**
     * clears elements in list.
     */
    public void clear(){
        size = 0;
    }

    /**
     * returns true if value is in list, false otherwise.
     * @param value to search for in list.
     * @return boolean value
     */
    public boolean contains(int value){
        for (int i = 0; i < size; i++) {
            if(data[i] == value){
                return true;
            }
        }
        return false;      //NOT FOUND
    }

    /**
     * expands the size of the current list to a larger one if capacity has been
     * exceeded.
     * @param targetCapacity of list.
     */
    public void ensureCapacity(int targetCapacity){
        if(targetCapacity > data.length){
            int newCapacity = Math.max(targetCapacity, 2 * data.length + 1);
            int[] newArray = new int[newCapacity];

            for (int i = 0; i < size; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }

    /**
     * returns the value at the index specified.
     * @param index in list
     * @return value at index specified.
     */
    public int get(int index){
        return data[index];
    }


    /**
     * returns the index of the first occurrence of the value specified.
     * If value not found, returns -1.
     * @param value to find.
     * @return index at which value is found or -1.
     */
    public int indexOf(int value){
        for (int i = 0; i < size; i++) {
            if(data[i] == value){
                return i;
            }
        }
        return -1;      //NOT FOUND
    }

    /**
     * returns true if list is empty, false otherwise.
     * @return if list is empty.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * constructs an iterator that iterates over current list.
     * @return iterator object to iterate over list.
     */
    public IntArrayListIterator iterator(){
        return new IntArrayListIterator(this);
    }

    /**
     * removes the value at the index specified,
     * by shifting values left.
     * @param index of value in list.
     */
    public void remove(int index){
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * replaces value at index with the given value
     * @param index to update
     * @param value to replace current value.
     */
    public void set(int index, int value){
        checkIndex(index);
        data[index] = value;
    }


    /**
     * returns the current number of elements in the list.
     * @return number of elements in list.
     */
    public int size(){
        return size;
    }

    /**
     * returns a string representation of the list.
     * @return string representation.
     */
    public String toString(){
        if(isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[" + data[0]);
            for (int i = 1; i < size; i++) {
                result.append(", ").append(data[i]);
            }
            return result.append("]").toString();
        }
    }

}
