package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort extends Sort {
    @Override
    public List doSort(ArrayList<Integer> arrayList) {
        int i, j, buf;
        j = arrayList.size();
        while (j > 1)
        {
            for (i = 0; i <= j-2; i++)
            {
                if (arrayList.get(i) > arrayList.get(i+1))
                {
                    buf = arrayList.get(i+1);
                    arrayList.set(i+1, arrayList.get(i));
                    arrayList.set(i, buf);
                }
            }
            j--;
        }
        return arrayList;
    }
}