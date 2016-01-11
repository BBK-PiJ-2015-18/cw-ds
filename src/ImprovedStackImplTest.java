public class ImprovedStackImplTest {
    public void run() {
        basicStackTest();
        improvedStackTest();
    }

    private void improvedStackTest() {
        ImprovedStack stack = new ImprovedStackImpl(new ArrayList());
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');
        stack.push('e');

        stack.remove('e');

        Assert.equals(stack.size(), 4);

        ImprovedStack reversed = stack.reverse();
        Assert.equals(reversed.top().getReturnValue(), 'a');

        Assert.equals(reversed.pop().getReturnValue(), 'a');
        Assert.equals(reversed.pop().getReturnValue(), 'b');
        Assert.equals(reversed.pop().getReturnValue(), 'c');
        Assert.equals(reversed.pop().getReturnValue(), 'd');

        Assert.equals(reversed.size(), 0);

        Assert.equals(reversed.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);
    }

    private void basicStackTest() {
        ImprovedStack stack = new ImprovedStackImpl(new ArrayList());

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

