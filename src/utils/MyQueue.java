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

    public boolean add(E item){
        append(item);
        size++;
        return true;
    }

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

    private E detach(){
        Node<E> deletedNode = first;
        E deletedItem = deletedNode.data;
        first = first.next;
        deletedNode.next = null;
        return deletedItem;
    }

    public boolean isEmpty(){
        return size == 0 && first == null;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return first.data;
        }
    }

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


    public int size(){
        return size;
    }

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
