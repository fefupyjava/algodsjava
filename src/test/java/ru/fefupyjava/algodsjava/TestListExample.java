package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.sort.QuickSort;
import ru.fefupyjava.algodsjava.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class TestListExample {
    @Test
    public void testQuickSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 3, 5, -1, 576, 8));
        Sort sort = new QuickSort();
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
