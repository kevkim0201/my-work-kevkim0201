package utils;

import java.util.NoSuchElementException;

/*****************************************************************
 * This class LinkedList implements linked data structures using
 * a Doubly Linked List (DLL).
 *
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


    public boolean add(E item){
        append(item);
        size++;
        return true;
    }

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

    private void checkIndex(int index){
        String message = "Invalid Index";

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(message);
        }
    }


    public boolean contains(E item){
        for (Node<E> current = first; current != null; current = current.next){
            if(current.data.equals(item)){
                return true;
            }
        }
        return false;
    }


    public void clear(){
        Node<E> node = first;
        node.next = null;
        size = 0;
    }

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

    public boolean isEmpty(){
        return first == null && size == 0;
    }

    public Iterator<E> iterator(){
        return new LinkedIterator();
    }

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

    public E remove(int index){
        checkIndex(index);
        size--;
        return detach(index);
    }

    public boolean remove(E item){
        if (first == null){
            return false;
        }
        Node<E> current;

        for (current = first; current != null; current = current.next){
            if(current.data.equals(item)){
                if (current == first){
                    first = current.next;
                    if (first != null){
                        first.prev = null;
                    }
                    else{
                        last = null;
                    }
                }
                else if(current == last){
                    last = current.prev;
                    if (last != null){
                        last.next = null;
                    }
                    else{
                        first = null;
                    }
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public E set(int index, E item){

        checkIndex(index);
        Node<E> current = first;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        E newItem = current.data;
        current.data = item;

        return newItem;

    }

    public int size(){
        return size;
    }

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

            E currentItem = current.data;
            current = current.next;
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
