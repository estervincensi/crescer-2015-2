package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> implements LinkedListsInterface<T> {

    private Node last, first;

    @Override
    public void addFirst(T value) {
        Node node = new Node(value, first);
        if (isEmpty()) {
            last = node;
        }
        first = node;

    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {

        return last.getValue();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    @Override
    public void addLast(T value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    @Override
    public void removeFirst() {
        if (first.getNext() != null) {
            first = first.getNext();
        } else {
            first = null;
        }
    }

    @Override
    public void add(int index, T value) {
        Node node = new Node(value);
        Node first = this.first;
        int i = 1;
        while (first != null) {
            if (i == index) {
                node.setNext(first.getNext());
                first.setNext(node);
                break;
            } else {
                first = first.getNext();
                i++;
            }

        }
    }

    @Override
    public void remove(int index) {
        Node tmp = getNode(index - 1);
        Node removido = tmp.getNext();
        tmp.setNext(removido.getNext());
    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public class Node {

        private T value;

        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
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

    }
}
