package academy.pocu.comp2500.lab4;

import java.util.ArrayList;

public class MyLinkedList<K, V> {
    private int elementCount;
    private Node<K, V> head;
    private Node<K, V> tail;
    private ArrayList<Node<K, V>> prev = new ArrayList<>(2);    // [0]: created Order, [1]: LRU Order
    private ArrayList<Node<K, V>> next = new ArrayList<>(2);

    public MyLinkedList() {
        head = new Node<K, V>(null, null);
        tail = new Node<K, V>(null, null);
    }

    public void addNode(Node<K, V> node) {
        if (elementCount == 0) {
            linkFirstNode(head, node);
            linkSecondNode(head, node);
            linkFirstNode(node, tail);
            linkSecondNode(node, tail);
        } else {
            linkFirstNode(tail.getPrev(0), node);
            linkSecondNode(tail.getPrev(1), node);
            linkFirstNode(node, tail);
            linkSecondNode(node, tail);
        }
        ++elementCount;
    }
    public int getElementCount() {
        return this.elementCount;
    }

    public Node<K, V> getLRUNode() {
        return head.getNext(1);
    }
    public Node<K, V> getFirstCreatedNode() {
        return head.getNext(0);
    }
    public Node<K, V> getLastCreatedNode() {
        return tail.getPrev(0);
    }

    public void clear() {
        Node<K, V> node = head;
        Node<K, V> nextNode;
        while (node.getNext(0) != null) {
            nextNode = node.getNext(0);
            nextNode.setPrev(0, null);
            node.setNext(0, null);
            node = nextNode;
        }

        node = head;
        while (node.getNext(1) != null) {
            nextNode = node.getNext(1);
            nextNode.setPrev(1, null);
            node.setNext(1, null);
            node = nextNode;
        }
        elementCount = 0;
    }

    public void removeNode(Node<K, V> node) {
        linkFirstNode(node.getPrev(0), node.getNext(0));
        linkSecondNode(node.getPrev(1), node.getNext(1));

        node.setPrev(0, null);
        node.setPrev(1, null);
        node.setNext(0, null);
        node.setNext(1, null);
        --elementCount;
    }
    public void moveUsedNodeToLast(Node<K, V> node) {
        linkSecondNode(node.getPrev(1), node.getNext(1));
        linkSecondNode(tail.getPrev(1), node);
        linkSecondNode(node, tail);
    }


    private void linkFirstNode(Node<K, V> prev, Node<K, V> next) {
        prev.setNext(0, next);
        next.setPrev(0, prev);
    }
    private void linkSecondNode(Node<K, V> prev, Node<K, V> next) {
        prev.setNext(1, next);
        next.setPrev(1, prev);
    }
}
