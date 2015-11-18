package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;


public class LinkedListTest {

    @Test
    public void test() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.getFirst(), "terceiro");
        // assertEquals(linkedList.getLast(), "primeiro");
    }

}
