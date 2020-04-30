package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;

import ru.fefupyjava.algodsjava.sort.SelectionSort2;
import ru.fefupyjava.algodsjava.sort.Sort;

public class TestSelectionSort2 {

    @Test
    public void testSelectionSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((int) (Math.random() * 100));
        }

        ArrayList<Integer> sorted = (ArrayList<Integer>) arrayList.clone();
        sorted.sort(Comparator.naturalOrder());

        Sort sort = new SelectionSort2();
        Assert.assertEquals(sorted, sort.doSort(arrayList));
    }

}