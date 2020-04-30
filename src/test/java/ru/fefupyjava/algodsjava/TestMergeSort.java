package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.sort.BucketSort;
import ru.fefupyjava.algodsjava.sort.MergeSort;
import ru.fefupyjava.algodsjava.sort.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TestMergeSort {
    @Test
    public void testMergeSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            arrayList.add(random.nextInt(100));
        }

        ArrayList<Integer> sorted = (ArrayList<Integer>) arrayList.clone();
        sorted.sort(Comparator.naturalOrder());

        Sort sort = new MergeSort();
        Assert.assertEquals(sorted, sort.doSort(arrayList));
    }
}
