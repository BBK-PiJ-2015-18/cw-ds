import com.sun.tools.javac.util.Assert;

public class ArrayListTest {
    public void run() {
        testEmptyArray();
        testSimpleAdd();
        testAdvancedAdd();
        testRemove();
    }

    private void testEmptyArray() {
        ArrayList arrayList = new ArrayList();

        Assert.check(arrayList.isEmpty(), "Check array is empty");
        Assert.check(arrayList.size() == 0, "Check size is 0");

        Assert.check(arrayList.get(0).getError() == ErrorMessage.EMPTY_STRUCTURE, "Check getting item returns error");

        Assert.check(arrayList.remove(0).getError() == ErrorMessage.EMPTY_STRUCTURE, "Check calling remove returns error");
    }

    private void testSimpleAdd() {
        ArrayList arrayList = new ArrayList();
        String item = "Blah 55";
        ReturnObject result = arrayList.add(item);

        Assert.check(result.getError() == ErrorMessage.NO_ERROR);
        Assert.check(arrayList.get(0).getReturnValue() == item);
    }

    private void testAdvancedAdd() {
        ArrayList arrayList = new ArrayList();
        String item = "Blah 55";
        ReturnObject result = arrayList.add(item);
        ReturnObject result1 = arrayList.add(1, item);
        ReturnObject result2 = arrayList.add(item);
        ReturnObject result3 = arrayList.add(item);

        Assert.check(result.getError() == ErrorMessage.NO_ERROR);
        Assert.check(arrayList.get(0).getReturnValue() == item);

        Assert.check(result1.getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);

        Assert.check(result2.getError() == ErrorMessage.NO_ERROR);
        Assert.check(result3.getError() == ErrorMessage.NO_ERROR);

        Assert.check(arrayList.get(2).getReturnValue() == item);

        char newItem = 'B';

        ReturnObject result4 = arrayList.add(2, newItem);
        Assert.check(arrayList.get(2).getReturnValue().equals(newItem));
    }

    private void testRemove() {
        ArrayList arrayList = new ArrayList();

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

        Assert.check(arrayList.get(6).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);
        Assert.check(arrayList.get(5).getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS);

        arrayList.remove(2);

        Assert.check(arrayList.get(2).getReturnValue().equals(item3));
        Assert.check(arrayList.get(3).getReturnValue().equals(item4));
    }
}
