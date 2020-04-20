package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import java.util.Collections;
import ru.fefupyjava.algodsjava.sort.PyramidalSort;
import ru.fefupyjava.algodsjava.sort.Sort;

import java.util.ArrayList;
import java.util.Random;

public class TestPyramidalSort {
    @Test
    public void testPyramidalSort() {
        Sort sort = new PyramidalSort();
        ArrayList<Integer> actualList = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 15; i++)
            actualList.add(rnd.nextInt(100));

        ArrayList<Integer> expectedList = (ArrayList<Integer>) actualList.clone();
        Collections.sort(expectedList);

        sort.doSort(actualList);
        Assert.assertEquals(expectedList, actualList);
    }
}
