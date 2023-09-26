package academy.pocu.comp2500.lab4;

import java.util.ArrayList;

public class Node<K, V> {
    private K key;
    private V value;

    private ArrayList<Node<K, V>> prev = new ArrayList<>(2);
    private ArrayList<Node<K, V>> next = new ArrayList<>(2);

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    public Node<K, V> getPrev(int index) {
        return this.prev.get(index);
    }
    public Node<K, V> getNext(int index) {
        return this.next.get(index);
    }
    public void setPrev(int index, Node<K, V> value) {
        if (this.prev.size() <= 2) {
            this.prev.add(index, value);
            return;
        }
        this.prev.set(index, value);
    }
    public void setNext(int index, Node<K, V> value) {
        if (this.next.size() <= 2) {
            this.next.add(index, value);
            return;
        }
        this.next.set(index, value);
    }
}
