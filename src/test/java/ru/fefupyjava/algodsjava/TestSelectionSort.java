package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import ru.fefupyjava.algodsjava.sort.SelectionSort;
import ru.fefupyjava.algodsjava.sort.Sort;

public class TestSelectionSort {

    @Test
    public void testSelectionSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((int) (Math.random() * 100));
        }
        Sort sort = new SelectionSort(arrayList);
        sort.doSort(arrayList);
        for (int i = 0; i < 10; i++) System.out.print("SelectionSort : " + arrayList.get(i) + " ");
    }
}
