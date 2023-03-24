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

    E[] data;              // reference for an array of type E

    int size;              // stores the number of elements in an array

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

    /**
     * appends the item specified to the end of the list
     * and updates the number of elements
     *
     * @param item of the node to be added
     * @return the updated size of the ArrayList with added item
     */
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

    /**
     * Inserts an item at a specified index in the list
     * Makes sure there is enough capacity and shifts the
     * indexes to the right using helper method
     *
     * @param index that will serve as the location
     * @param item of the node to be added to the specified index
     */
    public void add(int index, E item) {
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
            ensureCapacity(size + 1);
            shiftRight(index);
            data[index] = item;
            size++;
    }

    /**
     *
     * Checks if an index is valid in the list
     * Throws an exception if less than 0 or
     * is bigger or equal to the size
     *
     * @param index is checked to see if it is valid
     */
    public void checkIndex (int index) {
        String message = "Invalid Index:" + index;

        if (index < 0 || index >= size ){
            throw new IndexOutOfBoundsException(message);
        }
    }


    /**
     * Clears the entire arrayList
     *
     */
    public void clear() {
        for (int i = 0; i<size; i++){
            data[i] = null;
        }
        size = 0;
    }


    /**
     * Checks if a list contains a specific item
     * Returns true if the item is in the list
     *
     * @param item is checked to see if it exists in a list
     * @return false if the list contains a specified item
     */
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
            return false;
    }

    /**
     * Doubles the capacity if targetCapacity exceeds the capacity
     * of the list. Ensures that capacity is never full
     *
     * @param targetCapacity is checked to see if it exceeds list capacity
     */
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

    /**
     * Gets the data/item that is at the specified index of a list
     *
     * @param index is the specified position in list to obtain data
     * @return the item at the specified index
     */
    public E get(int index) {
        checkIndex(index);      // checks if index is valid
        return data[index];     // returns item at specified index
    }

    /**
     * Searches for a specific item within the linked structure
     * and returns the first occurrence
     *
     * @param item is searched within the list
     * @return the index of where the item is located at
     */
    public int indexOf(E item) {
        for (int i = 0; i < size; i++){
                if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }


    /**
     * Checks to see if the list is empty
     *
     * @return true if list has no occupied items
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gives access to private class ArrayIterator
     *
     * @return new ArrayIterator class
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /**
     * Removes item at a given index in the list
     * Stores the item to be removed, shifts the
     * index to the left, and decreases size by 1
     *
     * @param index is where the item/data will be removed
     * @return the removed item from the list
     */
    public E remove (int index) {
        checkIndex(index);             // checks if index is valid
        E oldItem = data[index];       // stores item at a specified index
        shiftLeft(index);              // shift elements to the left
        data[size-1] = null;           // remove item from the list
        size--;                        // decrease size of list by 1
        return oldItem;                // returns the removed item
    }

    /**
     * removes the first occurrence of the item
     * specified from the list, if present
     *
     * @param item is removed from the list
     * @return true if item exists and is removed
     */
    public boolean remove(E item) {
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

    /**
     * replaces the item at the specified position
     * with the one specified.
     *
     * @param index is the position of data
     * @param item is replaced at given position
     * @return the removed item from the list
     */
    public E set(int index, E item) {
        checkIndex(index);             // checks if index is valid
        E oldItem = data[index];       // stores oldItem at a given index
        data[index] = item;            // assigns the new item at a given index
        return oldItem;                // returns the oldItem that was replaced
    }

    /**
     * Helper method that shifts elements of
     * internal array left to index location
     *
     * @param index is position elements are shifted to
     */
    private void shiftLeft (int index) {
        for (int i = index; i < size -1; i++){
            data[i] = data[i+1];
        }
    }

    /**
     * Helper method that shifts elements of
     * internal array right to index location
     *
     * @param index is position elements are shifted to
     */
    private void shiftRight(int index) {
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
    }

    /**
     * Returns the number of elements in a list
     *
     * @return size of list
     */
    public int size() {
        return size;
    }

    /**
     * Prints out the words/content in the list
     *
     * @return String content of the list
     */
    public String toString() {
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

            // stores the item at current node
            E currentItem = data[position];

            // update index location to match node position
            position++;

            // previous node can be deleted as we are now on the next node
            isRemovable = true;

            // return value of previous node
            return currentItem;

        }

        @Override
        public void remove() {
            String message = "Cannot remove!";

            if(!isRemovable){
                throw new IllegalStateException(message);
            }

            // go back one position and remove that item
            ArrayList.this.remove(position - 1);
            isRemovable = false;

        }
    }

}


