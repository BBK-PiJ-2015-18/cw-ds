public class Main {

    public static void main(String[] args) {
	    testReturnObjectImpl();

        ArrayListTest arrayListTest = new ArrayListTest();
        arrayListTest.run();

        LinkedListTest linkedListTest = new LinkedListTest();
        linkedListTest.run();
    }

    private static void testReturnObjectImpl() {
        // Null both
        ReturnObject returnObjectAllNull = new ReturnObjectImpl(null);
        Assert.check(returnObjectAllNull.hasError() == false, "hasError false");
        Assert.check(returnObjectAllNull.getError() == ErrorMessage.NO_ERROR, "Has no error");
        Assert.check(returnObjectAllNull.getReturnValue() == null, "Has no returnValue");

        // Error only
        ReturnObject returnObjectErr = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        Assert.check(returnObjectErr.hasError(), "hasError true");
        Assert.check(returnObjectErr.getError() == ErrorMessage.INDEX_OUT_OF_BOUNDS, "Should have correct error value");
        Assert.check(returnObjectErr.getReturnValue() == null, "Has no returnValue");

        // Value only
        Object retVal = new Object();
        ReturnObject returnObjectVal = new ReturnObjectImpl(retVal);
        Assert.check(returnObjectVal.hasError() == false, "hasError false");
        Assert.check(returnObjectVal.getError() == ErrorMessage.NO_ERROR, "Should have null error value");
        Assert.check(returnObjectVal.getReturnValue() == retVal, "Has correct returnValue");

        // Both error
        ReturnObject returnObjectValAndErr = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        Assert.check(returnObjectValAndErr.hasError() == true, "hasError true");
        Assert.check(returnObjectValAndErr.getError() == ErrorMessage.INVALID_ARGUMENT, "Should have correct error value");
        Assert.check(returnObjectValAndErr.getReturnValue() == null, "Has null returnValue");
    }
}
