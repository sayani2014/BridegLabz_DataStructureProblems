public class Node<K, I> {
    K key;
    I index;
    Node<K, I> next;

    public Node(K key, I index) {
        this.key = key;
        this.index = index;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public I getIndex() {
        return index;
    }

    public void setIndex(I index) {
        this.index = index;
    }

    public Node<K, I> getNext() {
        return next;
    }

    public void setNext(Node<K, I> next) {
        this.next = (Node<K, I>) next;
    }

    @Override
    public String toString() {
        StringBuilder nodeString = new StringBuilder();
        nodeString.append("Node {" + "Key=").append(key).append(" Index=").append(index).append("} ");
        if(next != null)
            nodeString.append(" -> ").append(next);
        return nodeString.toString();
    }
}
