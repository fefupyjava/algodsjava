package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestListExample {
    @Test
    public void testList() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListExample listExample = new ListExample(arrayList);
        Assert.assertEquals(arrayList, listExample.getData());
    }

    @Test
    public void testListPrint() throws  Exception {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListExample listExample = new ListExample(arrayList);
        Assert.assertEquals(arrayList.toString(), listExample.getData().toString());
    }
}
