package utils;

public class SinglyLinkedList<T> {
    Node<T> first;  //reference to first item in list
    int     size;   //counter

    public SinglyLinkedList(){
        first = null;
        size  = 0;
    }

    /**
     * Adds an item to the end of the list
     *
     * @param item is added to the back of the list
     * @return true if item is successfully added
     */
    public boolean add(T item){
        append(item);    // operation to append to back
        size++;          // update counter with added node

        return true;
    }

    /**
     * Inserts elements at a given location
     * in the list, front, middle and end.
     * Uses helper method append and insertBefore
     * to accomplish the task
     *
     * @param index is position of where item will be added
     * @param item is added to the specified index
     */
    public void add(int index, T item){

        if (index == 0) {
            first = new Node<>(item, first);
        }
        else if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        else if (index == size){
            append(item);
        }
        else{
            insertBefore(index, item);
        }
        size++;

    }

    /**
     * Helper method that appends items
     * to the "end" of the list.
     *
     * @param item is added to the end of the list
     */
    private void  append(T item){
        Node<T> currentLast = node(size - 1);   // find the last location
        Node<T> newNode     = new Node<>(item);       // made new node with item to append

        if(isEmpty())
            first = newNode;                            // assign first reference to new node
        else
            currentLast.next    = newNode;              // attach new node to the back
    }


    /**
     * Checks to see if index is valid
     * Throws an exception if index is invalid
     *
     * @param index is checked to see if valid
     */
    private void checkIndex(int index){
       String message = "Invalid Index";

       if (index < 0 || index >= size){
           throw new IndexOutOfBoundsException(message);
       }
    }

    /**
     * Private helper method that detaches the
     * node at the specified index from list
     *
     * @param index is position in list where detachment occurs
     * @return the value of the detached data
     */
    private T detach(int index){
        Node<T> target;

        if (index == 0){
            target = first;
            first = first.next;
        }
        else {
            Node<T> nodeBefore = node(index - 1);
            target = nodeBefore.next;               //stores target node's address
            nodeBefore.next = target.next;          //this reassignment updates the order of the list
            target.next = null;                     //detaches the node from the linked list
        }
        return target.data;
    }

    /**
     * Obtains the item at a specified index in the list
     *
     * @param index is position of where the item is located
     * @return the item at the specified index
     */
    public T get(int index){
        checkIndex(index);
        Node<T> target = node(index);
        return target.data;
    }

    /**
     * Private helper method that inserts an item before
     * the non-null node at the specified index in the list.
     *
     * @param index will come after our added item
     * @param item is inserted before the specified index
     */
    private void insertBefore(int index, T item){

        Node<T> node = new Node<>(item);

        if (index == 0){
            node.next = first;
            first = node;
        }
        else {
            Node<T> nodeBefore = node(index - 1);
            node.next = nodeBefore.next;
            nodeBefore.next = node;
        }

    }

    /**
     * Checks to see if list is empty
     *
     * @return true if list contains no items
     */
    public boolean isEmpty(){
        return first == null && size == 0;
    }

    /**
     * Private helper class counter for finding the node address at
     * the index location in SLL
     *
     * @param index is the position of where item is located
     * @return the address of the node at a given position
     */
    private Node<T> node(int index){
        Node<T> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Removes and returns the item at an indicated index
     *
     * @param index is where the item is at
     * @return the removed item from the list
     */
    public T remove(int index){
        checkIndex(index);
        T oldItem = detach(index);
        size--;
        return oldItem;
    }

    /**
     * Replaces the item at the specified
     * position with the new item
     *
     * @param index is where the replacement occurs
     * @param item is the new item that will replace the old item
     * @return the replaced item from the list
     */
    public T set(int index, T item){
        checkIndex(index);
        Node<T> target = node(index);
        T oldItem = target.data;
        target.data = item;
        return oldItem;
    }

    /**
     * Returns the size of the list
     *
     * @return number of elements in the list
     */
    public int size(){
        return size;
    }

    /**
     * Displays the contents of the list.
     *
     * @return the words/strings inside the list
     */
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        else{

            StringBuilder result = new StringBuilder("[" + first.data);

            for (Node<T> node = first.next; node != null; node = node.next){
                result.append(", ").append(node.data);
            }

            return result + "]";
        }

    }


    // This is an inner class that is decoupled from outer class.
    // The purpose is primarily for storage of data and next reference in linked
    // sequence.
    private static class Node<E>{
        E data;             // data storage
        Node<E> next;       // self-reference

        private Node(E data){
            this(data, null);
        }

        private Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }

    }

}
