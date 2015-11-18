package br.com.cwi.crescer;
import java.util.List;

public interface LinkedListsInterface<T> {

    void addFirst(T value);

    boolean isEmpty();

    List<T> list();

    void addLast(T value);

    void removeFirst();

    void remove(int index);

    void add(int index, T value);

}
