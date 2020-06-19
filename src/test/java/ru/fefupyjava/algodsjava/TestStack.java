package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.data_structure.Stack;

public class TestStack {
    @Test
    public void testStackInt() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertEquals(0, stack.size());

        stack.push(1);
        Assert.assertEquals(1, stack.size());

        int a = stack.pop();
        Assert.assertEquals(1, a);
        Assert.assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.size());

        a = stack.pop();
        Assert.assertEquals(2, a);
        Assert.assertEquals(1, stack.size());

        a = stack.pop();
        Assert.assertEquals(1, a);
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void testStackChar() {
        Stack<Character> stack = new Stack<>();
        Assert.assertEquals(0, stack.size());

        stack.push('a');
        Assert.assertEquals(1, stack.size());

        char a = stack.pop();
        Assert.assertEquals('a', a);
        Assert.assertEquals(0, stack.size());

        stack.push('a');
        stack.push('b');
        Assert.assertEquals(2, stack.size());

        a = stack.pop();
        Assert.assertEquals('b', a);
        Assert.assertEquals(1, stack.size());

        a = stack.pop();
        Assert.assertEquals('a', a);
        Assert.assertEquals(0, stack.size());
    }
}
