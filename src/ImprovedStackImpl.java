public class ImprovedStackImpl implements ImprovedStack {

    private List list;

    public ImprovedStackImpl(List list) {
        this.list = list;
    }

    @Override
    public ImprovedStack reverse() {
        ImprovedStack newList = new ImprovedStackImpl(new ArrayList());

        for (int i = size() - 1; i >= 0; i--) {
            newList.push(list.get(i).getReturnValue());
        }

        return newList;
    }

    @Override
    public void remove(Object object) {
        for (int i = 0; i < size(); i++) {
            if(list.get(i).getReturnValue().equals(object)) {
                list.remove(i);
                i--; // Step back one element as the next element will now have this index.
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void push(Object item) {
        list.add(item);
    }

    @Override
    public ReturnObject top() {
        if(isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return list.get(list.size() - 1);
    }

    @Override
    public ReturnObject pop() {
        if(isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return list.remove(list.size() - 1);
    }
}
