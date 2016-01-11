public class ArrayList implements List {

    private final int INIT_SIZE = 10;

    private Object[] items;

    private int size;

    public ArrayList() {
        items = new Object[INIT_SIZE];
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

        return new ReturnObjectImpl(items[index]);
    }

    @Override
    public ReturnObject remove(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        if (validateIndex(index) == false) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        Object item = items[index];

        // Rebuild without item
        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }

        size = size - 1;

        return new ReturnObjectImpl(item);
    }

    private void enlargeArray() {
        Object[] newArray = new Object[size + INIT_SIZE];
        for (int i = 0; i < size; i++) {
            newArray[i] = items[i];
        }

        items = newArray;
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (validateIndex(index) == false) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        }

        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        if (size >= items.length) {
            enlargeArray();
        }

        items[index] = item;

        return new ReturnObjectImpl(null);
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        }

        if (size >= items.length) {
            enlargeArray();
        }

        items[size] = item;
        size++;

        return new ReturnObjectImpl(null);
    }
}