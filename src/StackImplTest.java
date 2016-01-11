public class StackImplTest {
    public void run() {
        AbstractStack stack = new StackImpl(new LinkedList());

        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        Assert.equals(stack.size(), 4);
        Assert.noError(stack.top());
        Assert.equals(stack.top().getReturnValue(), 'd');

        ReturnObject popResult = stack.pop();
        Assert.noError(popResult);
        Assert.equals(popResult.getReturnValue(), 'd');
        Assert.equals(stack.size(), 3);
        Assert.equals(stack.top().getReturnValue(), 'c');
    }
}
