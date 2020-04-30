package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
<<<<<<< HEAD

import java.util.ArrayList;

import ru.fefupyjava.algodsjava.sort.SelectionSort2;
import ru.fefupyjava.algodsjava.sort.Sort;

public class TestSelectionSort2 {

    @Test
    public void testSelectionSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((int) (Math.random() * 100));
        }
        Sort sort = new SelectionSort2(arrayList);
        sort.doSort(arrayList);
        for (int i = 0; i < 10; i++) System.out.print("SelectionSort : " + arrayList.get(i) + " ");
    }
=======
import ru.fefupyjava.algodsjava.sort.Sort;
import SelectionSort2;

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


        Sort selectionSort = new SelectionSort2();
        Assert.assertEquals(compArray, selectionSort.doSort(arrayList));
    }

>>>>>>> a19da8ff89c010020f869a5d91f8f717eb83470e
}
