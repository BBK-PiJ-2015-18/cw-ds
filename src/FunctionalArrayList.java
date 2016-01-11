public class FunctionalArrayList extends ArrayList implements FunctionalList {
    @Override
    public ReturnObject head() {
        if(isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        }

        return get(0);
    }

    @Override
    public FunctionalList rest() {
        if(isEmpty()) {
            return new FunctionalArrayList();
        }

        FunctionalArrayList list = new FunctionalArrayList();

        int i = 1;
        while(i < size()) {
            list.add(get(i).getReturnValue());
            i++;
        }

        return list;
    }
}