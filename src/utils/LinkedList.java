package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 * <p>
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class LinkedList <E> implements List<E> {

    //TODO : Complete Body with Data Fields, Methods and Classes

    Node<E> first;  // reference to first node in list

    Node<E> last;   // reference to last node in list

    int     size;   // counter of index in list

    public LinkedList(){
        first   = null;
        last    = null;
        size    = 0;
    }


    /**
     * Adds an item to the end of the list
     * Uses append method and updates the size
     * by 1, while checking enough spaces
     *
     * @param item is added to the end of the list
     * @return true if item is added successfully
     */
    public boolean add(E item){
        append(item);
        size++;
        return true;
    }

    /**
     * Inserts an item at a specified index in the
     * list and shifts the subsequent items to the right
     * Uses method insertBefore and append for this
     *
     * @param index is the position where the item is added to
     * @param item is the new item being added to the index
     */
    public void add(int index, E item){
        if (index == size){
            append(item);
        }
        else{
            checkIndex(index);
            insertBefore(index, item);
        }
        size++;
    }

    /**
     * Private helper method that adds element to
     * the back of the list, but does not update the
     * size of the list
     *
     * @param item is added to the end of the list
     */
    public void append( E item){
        Node<E> node = new Node<>(last, item);
        if (first == null){
            first = node;
        }
        else{
            last.next = node;
            node.prev = last;
        }
        last = node;
    }


    /**
     * Checks to see if given index is valid
     * Throws an exception if index is invalid
     *
     * @param index is checked for validity
     */
    private void checkIndex(int index){
        String message = "Invalid Index";

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(message);
        }
    }


    /**
     * Searches for a specific item within the linked structure
     *
     * @param item is searched for in the list
     * @return true if item is found in the list
     */
    public boolean contains(E item){
        for (Node<E> current = first; current != null; current = current.next){
            if(current.data.equals(item)){
                return true;
            }
        }
        return false;
    }


    /**
     * clears the entire list and sets size to 0
     */
    public void clear(){
        Node<E> node = first;
        node.next = null;
        size = 0;
    }

    /**
     * Private helper method that detaches node at a specified
     * index and returns the item
     *
     * @param index is the position where item is detached
     * @return the detached item at a given index
     */
    private E detach(int index){
        Node<E> current = first;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        if (current == first){
            first = current.next;
            current.prev = null;
        }
        else if(current == last){
            last = current.prev;
            current.next = null;
        }
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return current.data;
    }

    /**
     * Obtains the item at a specified index in a list
     *
     * @param index is the position where item is at
     * @return the item at the specified index
     */
    public E get(int index){
        checkIndex(index);

        Node<E> current;

        if (index < size / 2){
            current = first;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        }

        else{
            current = last;
            for (int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current.data;
    }

    /**
     * Searches for a specific item within the list
     * and returns the location of the first occurrence
     *
     * @param item is being searched for in the list
     * @return position (index) of item if found
     */
    public int indexOf(E item){
        if (last != null && last.data.equals(item)){
            return size - 1;
        }
        Node<E> current = first;
        int index = 0;
        for (int i = 0; i < size; i++){
            if (current.data.equals(item)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Private helper method that inserts an item
     * before the non-null node at the specified
     * index in the list. Traverses list.
     *
     * @param index will come after our added item
     * @param item is inserted before the specified index
     */
    private void insertBefore(int index, E item){
        Node<E> node = new Node<>(last, item, first);
        if (index == 0){
            node.next = first;
            first.prev = node;
            first = node;
        }
        else{
            Node<E> current = node(index);
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
        }
    }

    /**
     * Checks to see if list is empty
     *
     * @return true if there are no elements in list
     */
    public boolean isEmpty(){
        return first == null && size == 0;
    }

    /**
     * Gives access to private class LinkedIterator
     *
     * @return new LinkedIterator class
     */
    public Iterator<E> iterator(){
        return new LinkedIterator();
    }

    /**
     * Private helper method that returns a reference
     * to the node at the given position in the list.
     *
     * @param index is the position of the node
     * @return a reference to the specified position in node
     */
    private Node<E> node(int index){
        Node<E> current;
        if (index < size / 2){
            current = first;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
        }
        else{
            current = last;
            for (int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    /**
     * Removes the item at a specified index
     * checks for index beforehand, and detaches
     * the item and decreases the size by 1
     *
     * @param index is the position where removal will occur
     * @return the removed item from the list
     */
    public E remove(int index){
        checkIndex(index);
        size--;
        return detach(index);
    }

    /**
     * Removes the first occurrence of the specified
     * item from the list, if present. Shifts subsequent
     * elemnts to the right and size is reduced by 1
     *
     * @param item is searched for in the list
     * @return the index of the removed item
     */
    public boolean remove(E item){

        int indexItem = indexOf(item);

        if (indexItem > -1) {

            detach(indexItem);
            size--;
        }

        return indexItem > -1;
    }

    /**
     * Replaces the item at the specified position with
     * a new item. Checks for index first, then sets the
     * new item at the given index
     *
     * @param index is where the replacement occurs
     * @param item replaces the oldItem at a given index
     * @return the old item that was replaced
     */
    public E set(int index, E item){

        checkIndex(index);

        E oldItem = node(index).data;

        node(index).data = item;

        return oldItem;

    }

    /**
     * Returns the size of the list
     *
     * @return the number of elements in list
     */
    public int size(){
        return size;
    }

    /**
     * Displays the content of the list
     *
     * @return string/words in the list
     */
    public String toString(){
        if (isEmpty()) {
            return "[]";
        }
        else {
            StringBuilder string = new StringBuilder("[" + first.data);

            for (Node<E> node = first.next; node != null; node = node.next){
                string.append(", ").append(node.data);
            }
            return string + "]";
        }
    }


    private class LinkedIterator implements Iterator<E>{

        int position;
        Node<E> current;
        boolean isRemovable;

        public LinkedIterator(){
            position = 0;
            current = first;
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

            // store the item at the current node
            E currentItem = current.data;

            // update reference to go to the next node in sequence
            current = current.next;

            // update index position to match node location
            position++;

            // previous node can be deleted as we are now on next node
            isRemovable = true;

            // return value of previous "current" node
            return currentItem;
        }

        @Override
        public void remove() {
            String message = "Cannot remove!";

            if(!isRemovable){
                throw new IllegalStateException(message);
            }

            // go back one position and remove that node
            LinkedList.this.remove(position - 1);
            isRemovable = false;

        }
    }


    // This is an inner class that is decoupled from outer class.
    // The purpose is primarily for storage of data, prev and next
    // reference in linked sequence.
    private static class Node<E>{
        E data;             // data storage
        Node<E> next;       // self-reference after current node
        Node<E> prev;       // self-reference before current node

        private Node(Node<E> prev, E data){
            this(prev, data, null);
        }

        private Node(Node<E> prev, E data, Node<E> next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }
}
