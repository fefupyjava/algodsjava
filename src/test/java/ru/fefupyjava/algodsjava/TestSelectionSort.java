package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.sort.Sort;
import ru.fefupyjava.algodsjava.sort.SelectionSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TestSelectionSort {
    @Test
    public void testQuickSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();

        Random randomInt = new Random();

        for(int i = 0; i < 15; i++) {
            arrayList.add(randomInt.nextInt(20));
        }

        ArrayList<Integer> compArray = new ArrayList<Integer>();
        compArray.addAll(0, arrayList);
        compArray.sort(Comparator.naturalOrder());


        Sort selectionSort = new SelectionSort();
        Assert.assertEquals(compArray, selectionSort.doSort(arrayList));
    }

}
