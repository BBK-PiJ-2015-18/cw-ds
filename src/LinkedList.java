public class LinkedList implements List {

    private Node head;

    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Boolean validateIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        return true;
    }

    @Override
    public ReturnObject get(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        if (validateIndex(index) == false) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node.getNext() == null) {
                return new ReturnObjectImpl(null);
            }

            node = node.getNext();
        }

        return new ReturnObjectImpl(node.getData());
    }

    @Override
    public ReturnObject remove(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        if (validateIndex(index) == false) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        Node node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNext();
        }

        Node toRemove = node.getNext();
        if (toRemove.hasNext()) {
            node.setNext(toRemove.getNext());
        }
        size--;

        return new ReturnObjectImpl(toRemove.getData());
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (validateIndex(index) == false) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        Node newNode = new Node(item);

        if (index == 0 && size == 1) {
            head = newNode;
            return new ReturnObjectImpl(null);
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }

        if (current.hasNext()) {
            newNode.setNext(current.getNext());
        }

        current.setNext(newNode);

        return new ReturnObjectImpl(null);
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            size++;
            return new ReturnObjectImpl(null);
        }

        Node current = head;
        while (current.hasNext()) {
            current = current.getNext();
        }

        current.setNext(newNode);
        size++;

        return new ReturnObjectImpl(null);
    }
}
