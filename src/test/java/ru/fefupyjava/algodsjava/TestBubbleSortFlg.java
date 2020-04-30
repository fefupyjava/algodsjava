package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.sort.BubbleSortFlg;
import ru.fefupyjava.algodsjava.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TestBubbleSortFlg {
    final Random random = new Random();

    @Test
    public void testBubbleSortFlg() throws Exception {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < random.nextInt(); i++) {
            arrayList.add(random.nextInt());
        }

        for (Integer integer : arrayList) {
            System.out.println("List: " + integer);
        }

        ArrayList<Integer> TestArrayList = arrayList;

        for (Integer integer : arrayList) {
            System.out.println("TestList: " + integer);
        }

        Sort sort = new BubbleSortFlg();
        Collections.sort(TestArrayList);
        sort.doSort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("TestList: " + arrayList.get(i) + " == List: " + TestArrayList.get(i));
        }

        Assert.assertEquals(TestArrayList, arrayList);
    }
}
