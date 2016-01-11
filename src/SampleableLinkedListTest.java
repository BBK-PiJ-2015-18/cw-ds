public class SampleableLinkedListTest extends ListTester {
    public SampleableLinkedListTest() {
        super(new SampleableLinkedList());
    }

    public void run() {
        runImpl();

        testSample();
    }

    private void testSample() {
        SampleableLinkedList sampleableLinkedList = new SampleableLinkedList();
        for (int i = 0; i < 16; i++) {
            sampleableLinkedList.add("Item" + (i + 1));
        }

        SampleableList sampleableList = sampleableLinkedList.sample();
        Assert.equals(sampleableList.size(), 8);

        Assert.equals(sampleableList.get(0).getReturnValue(), "Item1");
        Assert.equals(sampleableList.get(1).getReturnValue(), "Item3");
        Assert.equals(sampleableList.get(2).getReturnValue(), "Item5");
        Assert.equals(sampleableList.get(3).getReturnValue(), "Item7");
        Assert.equals(sampleableList.get(4).getReturnValue(), "Item9");
        Assert.equals(sampleableList.get(5).getReturnValue(), "Item11");
        Assert.equals(sampleableList.get(6).getReturnValue(), "Item13");
        Assert.equals(sampleableList.get(7).getReturnValue(), "Item15");
        Assert.equals(sampleableList.get(8).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }
}
