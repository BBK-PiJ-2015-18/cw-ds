public class FunctionalLinkedListTest extends ListTester {
    public FunctionalLinkedListTest() {
        super(new FunctionalLinkedList());
    }

    public void run() {
        runImpl();

        testHeadAndRest();
    }

    private void testHeadAndRest() {
        FunctionalLinkedList list = new FunctionalLinkedList();

        char obj = 'B';
        list.add(obj);

        list.add("A");
        list.add("B");
        list.add("C");

        Assert.equals(list.size(), 4);

        Assert.equals(list.head().getReturnValue(), obj);

        FunctionalList rest = list.rest();

        Assert.equals(rest.size(), 3);
        Assert.equals(rest.get(0).getReturnValue(), "A");
        Assert.equals(rest.get(1).getReturnValue(), "B");
        Assert.equals(rest.get(2).getReturnValue(), "C");
        Assert.equals(rest.get(3).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }
}

