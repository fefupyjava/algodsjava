package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.sort.CountingSort;
import ru.fefupyjava.algodsjava.sort.Sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class TestCountingSort {
    final Random random = new Random();

    @Test
    public void testCountingSort() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int q = random.nextInt();
        for(int i = 0; i < q; i++){
            arrayList.add(random.nextInt());
        }

        ArrayList<Integer> TestArrayList = (ArrayList<Integer>)arrayList.clone() ;

       // Collections.sort(TestArrayList);
        Sort sort = new CountingSort();
        //sort.doSort(arrayList);

        Assert.assertEquals(TestArrayList, sort.doSort(arrayList));
    }
}
