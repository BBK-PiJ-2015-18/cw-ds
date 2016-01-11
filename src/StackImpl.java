public class StackImpl extends AbstractStack {
    public StackImpl(List list) {
        super(list);
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public void push(Object item) {
        internalList.add(item);
    }

    @Override
    public ReturnObject top() {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return internalList.get(size() - 1);
    }

    @Override
    public ReturnObject pop() {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return internalList.remove(size() - 1);
    }
}