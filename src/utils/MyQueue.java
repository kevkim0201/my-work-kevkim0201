package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class MyQueue implements a FIFO data structure using a
 * Singly Linked List (SLL).
 * <p>
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class MyQueue <E> {

    //TODO : Complete Body with Data Fields, Methods and Classes

    Node<E> first;
    Node<E> last;

    int size;

    public MyQueue(){
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Places given item at back of the queue
     * Uses the append helper method and size
     * is increase by 1 at the end
     *
     * @param item is added to the back of the queue
     * @return true if item has been successfully added
     */
    public boolean add(E item){
        append(item);
        size++;
        return true;
    }

    /**
     * Private helper method that helps add an item
     * to the back of the queue. Does not update the
     * number of items in the queue
     *
     * @param item is added to the back of the queue
     */
    private void append(E item){
        Node<E> oldLast = last;

        Node<E> newNode = new Node<>(item);

        last = newNode;

        if(isEmpty()){
            first = newNode;
        }
        else{
            oldLast.next = newNode;
        }
    }

    /**
     * Private helper method that helps remove
     * the node at the front of the queue
     * and returns the deleted item
     *
     * @return the deleted item from the queue
     */
    private E detach(){
        Node<E> deletedNode = first;
        E deletedItem = deletedNode.data;
        first = first.next;
        deletedNode.next = null;
        return deletedItem;
    }

    /**
     * Checks to see if queue is empty
     *
     * @return true if there are no items in queue
     */
    public boolean isEmpty(){
        return size == 0 && first == null;
    }

    /**
     * Returns the front item of the queue without removing it
     * Null is returned if queue is empty
     *
     * @return the item in the front of the queue
     */
    public E peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return first.data;
        }
    }

    /**
     * Removes element from front of queue and reduces size of queue.
     * Exception is thrown if queue is empty
     *
     * @return the detached front item from the queue
     */
    public E remove(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            E oldItem = detach();
            size--;
            return oldItem;
        }
    }

    /**
     * Returns the size of the queue
     *
     * @return the number of elements in the queue
     */
    public int size(){
        return size;
    }

    /**
     * Display the content of the queue from front to back
     *
     * @return the string/words in the queue
     */
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        else{
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> newNode = first.next; newNode != null; newNode = newNode.next){
                result.append(", ").append(newNode.data);
            }
            return result + "]";
        }
    }

    //inner static class
    public static class Node<E>{
        E       data;
        Node<E> next;

        public Node(E data){
            this(data, null);
        }

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

}
