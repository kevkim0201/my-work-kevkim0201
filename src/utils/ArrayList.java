package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class ArrayList implements a contiguous block of data
 * using an array.
 * <p>
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class ArrayList <E> implements List<E> {

    //TODO : Complete Body with Data Fields, Methods and Classes
    public static final int DEFAULT_CAPACITY = 10;

    E[] data;

    int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException();
        } else {
            data = (E[]) new Object[capacity];
            size = 0;
        }
    }

    public boolean add(E item) {
        // creating a placeholder for the current size
        int oldSize = size;

        // allows the size of array to grow if size > length
        ensureCapacity(size + 1);

        // appends to back of list = first vacant spot
        data[size] = item;

        // increments size = updated number of occupied spots
        size++;

        //returns true if size updated by 1
        return size == (oldSize + 1);

    }

    public void add(int index, E item){
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
            ensureCapacity(size + 1);
            shiftRight(index);
            data[index] = item;
            size++;
    }

    public void checkIndex (int index){
        String message = "Invalid Index:" + index;

        if (index < 0 || index >= size ){
            throw new IndexOutOfBoundsException(message);
        }
    }

    public void clear(){
        for (int i = 0; i<size; i++){
            data[i] = null;
        }
        size = 0;
    }

    public boolean contains(E item){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
            return false;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int targetCapacity) {
        // checks if needed capacity > current array length
        if (targetCapacity > data.length) {

            // select the larger of the two (double length or target size)
            int newCapacity = Math.max(targetCapacity, 2 * data.length + 1);

            //make a new array with the larger size
            E[] newArray = (E[]) new Object[newCapacity];

            //copy the values in to the new array
            System.arraycopy(data, 0, newArray, 0, data.length);

            // re-assign underlying array reference to new array
            data = newArray;
        }
    }

    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E item){
        for (int i = 0; i < size; i++){
                if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }


    // returns true if list has no occupied items
    public boolean isEmpty(){
        return size == 0;
    }

    public Iterator<E> iterator(){
        return new ArrayIterator();
    }

    public E remove (int index){
        checkIndex(index);
        E oldItem = data[index];
        shiftLeft(index);
        data[size-1] = null;
        size--;
        return oldItem;
    }

    public boolean remove(E item){
        for (int i = 0; i < size; i++){
            if (data[i].equals(item)){
                data[i] = null;
                shiftLeft(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public E set(int index, E item){
        checkIndex(index);
        E oldItem = data[index];
        data[index] = item;
        return oldItem;
    }


    private void shiftLeft (int index){
        for (int i = index; i < size -1; i++){
            data[i] = data[i+1];
        }
    }

    private void shiftRight(int index){
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
    }

    public int size(){
        return size;
    }

    //prints out the values in sequence from 0 to length - 1
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        else {
            StringBuilder result = new StringBuilder(" [" + data[0]);

            for (int i = 1; i < size; i++) {
                result.append(", ").append(data[i]);
            }
            return result + "]";
        }
    }

    private class ArrayIterator implements Iterator<E>{

        int position;
        boolean isRemovable;

        public ArrayIterator(){
            position = 0;
            isRemovable = false;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public E next() {
            String message = "There are no more elements on the left!";

            if (!hasNext()){
                throw new NoSuchElementException(message);
            }

            E currentItem = data[position];

            position = position++;

            position++;

            isRemovable = true;

            return currentItem;

        }

        @Override
        public void remove() {
            String message = "Cannot remove!";

            if(!isRemovable){
                throw new IllegalStateException(message);
            }
            ArrayList.this.remove(position - 1);
            isRemovable = false;

        }
    }

}


