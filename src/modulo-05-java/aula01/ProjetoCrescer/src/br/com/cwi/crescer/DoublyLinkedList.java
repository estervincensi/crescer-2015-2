package br.com.cwi.crescer;

import java.util.List;

public class DoublyLinkedList<T> implements LinkedListsInterface<T> {

    private Node first, last;

    @Override
    public void addFirst(T value) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<T> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addLast(T value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(int index, T value) {
        // TODO Auto-generated method stub

    }
    private class Node {

        private T value;
        private Node next, previous;

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

    }
}
