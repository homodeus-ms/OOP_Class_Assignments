package academy.pocu.comp2500.lab4;

public class Node<K, V> {
    private K key;
    private V value;

    private Node[] prev = new Node[2];
    private Node[] next = new Node[2];

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
    public Node[] getPrev() {
        return this.prev;
    }
    public Node[] getNext() {
        return this.next;
    }
}
