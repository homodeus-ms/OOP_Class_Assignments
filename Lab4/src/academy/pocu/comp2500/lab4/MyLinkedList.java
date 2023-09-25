package academy.pocu.comp2500.lab4;

public class MyLinkedList {
    private int elementCount;
    private Node head;
    private Node tail;
    private Node[] prev = new Node[2];    // [0]: created Order, [1]: LRU Order
    private Node[] next = new Node[2];

    public MyLinkedList() {
        head = new Node(null, null);
        tail = new Node(null, null);
    }

    public void addNode(Node node) {
        if (elementCount == 0) {
            linkFirstNode(head, node);
            linkSecondNode(head, node);
            linkFirstNode(node, tail);
            linkSecondNode(node, tail);
        } else {
            linkFirstNode(tail.getPrev()[0], node);
            linkSecondNode(tail.getPrev()[1], node);
            linkFirstNode(node, tail);
            linkSecondNode(node, tail);
        }
        ++elementCount;
    }
    public int getElementCount() {
        return this.elementCount;
    }

    public Node getLRUNode() {
        return head.getNext()[1];
    }
    public Node getFirstCreatedNode() {
        return head.getNext()[0];
    }
    public Node getLastCreatedNode() {
        return tail.getPrev()[0];
    }
    public void clear() {
        Node node = head;
        Node nextNode;
        while (node.getNext()[0] != null) {
            nextNode = node.getNext()[0];
            nextNode.getPrev()[0] = null;
            node.getNext()[0] = null;
            node = nextNode;
        }

        node = head;
        while (node.getNext()[1] != null) {
            nextNode = node.getNext()[1];
            nextNode.getPrev()[1] = null;
            node.getNext()[1] = null;
            node = nextNode;
        }
        elementCount = 0;
    }

    public void removeNode(Node node) {
        linkFirstNode(node.getPrev()[0], node.getNext()[0]);
        linkSecondNode(node.getPrev()[1], node.getNext()[1]);

        node.getPrev()[0] = null;
        node.getPrev()[1] = null;
        node.getNext()[0] = null;
        node.getNext()[1] = null;
        --elementCount;
    }
    public void moveUsedNodeToLast(Node node) {
        linkSecondNode(node.getPrev()[1], node.getNext()[1]);
        linkSecondNode(tail.getPrev()[1], node);
        linkSecondNode(node, tail);
    }


    private void linkFirstNode(Node prev, Node next) {
        prev.getNext()[0] = next;
        next.getPrev()[0] = prev;
    }
    private void linkSecondNode(Node prev, Node next) {
        prev.getNext()[1] = next;
        next.getPrev()[1] = prev;
    }
}
