package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.LinkedList.Node;

public class DoublyLinkedList<T> implements LinkedListsInterface<T> {

    private Node first, last;

    @Override
    public void addFirst(T value) {
    	Node node = new Node(value,first,null);
    	if(isEmpty()){
    		first = node;
    		last = node;
    	}else{
    		first.setPrevious(node);
    		first = node;
    	}
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public List<T> list() {
    	ArrayList<T> lista = new ArrayList<T>();
    	Node node = first;
    	while(node!=null){
    		lista.add(node.getValue());
    		node = node.getNext();
    	}
        return lista;
    }

    @Override
    public void addLast(T value) {
    	if(isEmpty()){
    		addFirst(value);
    	}else{
    		Node node = new Node(value);
    		this.last.setNext(node);
    		node.setPrevious(this.last);
    		this.last = node;
    	}
    }

    public T getFirst() {
		return first.getValue();
	}

	public T getLast() {
		return last.getValue();
	}

	@Override
    public void removeFirst() {
       if(first.getNext()!=null){
    	   first = first.getNext();
       }else{
    	   first = null;
       }

    }

    @Override
    public void remove(int index) {
        Node tmp = getNode(index-1);
        Node remove = tmp.getNext();
        if(remove==last){
        	tmp.setNext(null);
        	last = tmp;
        }else{
        	Node next = remove.getNext();
            tmp.setNext(next);
            next.setPrevious(tmp);
        }
    }

    @Override
    public void add(int index, T value) {
        if(index==0){
        	this.addFirst(value);
        }else{
        	Node previous = getNode(index-1);
        	Node next = previous.getNext();
        	Node node = new Node(value, next,previous);
        	previous.setNext(node);
        	next.setPrevious(node);
        }

    }
    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
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
