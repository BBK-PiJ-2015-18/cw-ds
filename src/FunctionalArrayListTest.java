public class FunctionalArrayListTest extends ListTester {
    public FunctionalArrayListTest() {
        super(new FunctionalArrayList());
    }

    public void run() {
        runImpl();

        testHeadAndRest();
    }

    private void testHeadAndRest() {
        FunctionalArrayList list = new FunctionalArrayList();

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
