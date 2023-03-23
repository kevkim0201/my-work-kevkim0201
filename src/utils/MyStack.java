package utils;

import java.util.EmptyStackException;

/*****************************************************************
 * This class MyStack implements a LIFO data structure using a
 * Singly Linked List (SLL).
 * <p>
 * TODO : Please Complete the Following
 *        1. Comment all steps in your methods used for its
 *           implementation. Be clear and precise.
 *        2. Your comments must clearly explain the step to
 *           the satisfaction of the instructor (in brief).
 *        3. Use JavaDoc Comments above each method.
 *****************************************************************/

public class MyStack <E> {

    //TODO : Complete Body with Data Fields, Methods and Classes

    Node<E> first;
    Node<E> last;

    int     size;

    public MyStack(){
        first = null;
        last  = null;
        size  = 0;
    }

    private E detach(){
        Node<E> removeNode = last;

        E deletedItem = removeNode.data;
        last = last.next;
        removeNode.next = null;
        return deletedItem;
    }

    public boolean isEmpty(){
        return last == null && size == 0;
    }

    public E peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        else{
            return last.data;
        }
    }

    public E pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }

        E topNode = detach();
        size--;
        return topNode;
    }


    public E push(E item){
        Node<E> newNode = new Node<> (item, last);

        last = newNode;

        if(isEmpty()){
            first = newNode;
        }

        size++;

        return last.data;

    }

    public int size(){
        return size;
    }

    public String toString(){
        if (isEmpty()){
            return "[]";
        }
        else{
            ArrayList<E> list = new ArrayList<>();
            for (Node<E> node = last; node != null; node = node.next) {
                list.add(0,node.data);
            }
            return list.toString().trim();
        }
    }


    //static inner class

    public static class Node<E>{
        E       data;
        Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

}
