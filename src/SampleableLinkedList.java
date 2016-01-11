public class SampleableLinkedList extends LinkedList implements SampleableList {
    @Override
    public SampleableList sample() {
        if (isEmpty()) {
            return new SampleableLinkedList();
        }

        SampleableList sampleableList = new SampleableLinkedList();

        for (int i = 0; i < size(); i = i + 2) {
            sampleableList.add(get(i).getReturnValue());
        }

        return sampleableList;
    }
}
