public abstract class ListTester {

    private List list;

    public ListTester(List list) {
        this.list = list;
    }

    public void runImpl() {
        testEmptyArray();
        testSimpleAdd();
        testAdvancedAdd();
        testLargeAdd();
        testRemove();
    }

    private List createInstance() {
        String name = list.getClass().getName();
        List newInstance = null;
        try {
            Class cls = Class.forName(name);
            newInstance = (List) cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return newInstance;
    }

    private void testEmptyArray() {
        List arrayList = createInstance();

        Assert.equals(arrayList.isEmpty(), true);
        Assert.equals(arrayList.size(), 0);

        Assert.equals(arrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);

        Assert.equals(arrayList.remove(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
    }

    private void testSimpleAdd() {
        List arrayList = createInstance();
        String item = "Blah 55";
        ReturnObject result = arrayList.add(item);

        Assert.equals(result.getError(), ErrorMessage.NO_ERROR);
        Assert.equals(arrayList.get(0).getReturnValue(), item);
    }

    private void testAdvancedAdd() {
        List arrayList = createInstance();
        String item = "Blah 55";
        ReturnObject result = arrayList.add(item);
        ReturnObject result1 = arrayList.add(1, item);
        ReturnObject result2 = arrayList.add(item);
        ReturnObject result3 = arrayList.add(item);

        Assert.equals(result.getError(), ErrorMessage.NO_ERROR);
        Assert.equals(arrayList.get(0).getReturnValue(), item);

        Assert.equals(result1.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        Assert.equals(result2.getError(), ErrorMessage.NO_ERROR);
        Assert.equals(result3.getError(), ErrorMessage.NO_ERROR);

        Assert.equals(arrayList.get(2).getReturnValue(), item);

        char newItem = 'B';

        ReturnObject result4 = arrayList.add(2, newItem);
        Assert.equals(arrayList.get(2).getReturnValue(), newItem);
    }

    private void testLargeAdd() {
        LinkedList linkedList = new LinkedList();
        char obj1 = 'A';
        ReturnObject result1 = linkedList.add(obj1);

        Assert.noError(result1);
        Assert.equals(linkedList.size(), 1);

        String obj2 = "Lol12";
        ReturnObject result2 = linkedList.add(obj2);

        Assert.noError(result2);
        Assert.equals(linkedList.size(), 2);

        // Replace index 1
        String obj3 = "Lol13";
        ReturnObject result3 = linkedList.add(1, obj3);

        Assert.noError(result3);
        Assert.equals(linkedList.size(), 2);
        Assert.equals(linkedList.get(1).getReturnValue(), obj3);

        for (int i = 2; i < 50; i++) {
            linkedList.add("blahblah" + i);
        }

        Assert.equals(linkedList.size(), 50);

        linkedList.add(34, "new34");
        Assert.equals(linkedList.get(34).getReturnValue(), "new34");
        Assert.equals(linkedList.size(), 50);
    }

    private void testRemove() {
        List arrayList = createInstance();

        String item = "Blah 55";
        ReturnObject result = arrayList.add(item);

        String item1 = "Abc";
        ReturnObject result1 = arrayList.add(item1);

        String item2 = "123";
        ReturnObject result2 = arrayList.add(item2);

        String item3 = "456";
        ReturnObject result3 = arrayList.add(item3);

        String item4 = "789";
        ReturnObject result4 = arrayList.add(item4);

        String item5 = "987";
        ReturnObject result5 = arrayList.add(item5);

        String item6 = "654";
        ReturnObject result6 = arrayList.add(item6);

        arrayList.remove(6);
        arrayList.remove(5);

        Assert.equals(arrayList.get(6).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        Assert.equals(arrayList.get(5).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        arrayList.remove(2);

        Assert.equals(arrayList.get(2).getReturnValue(), item3);
        Assert.equals(arrayList.get(3).getReturnValue(), item4);
    }
}
