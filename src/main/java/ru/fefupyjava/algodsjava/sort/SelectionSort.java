package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort extends Sort {
    @Override
    public List doSort(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int min = arrayList.get(i);
            int minInd = i;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (min > arrayList.get(j)) {
                    min = arrayList.get(j);
                    minInd = j;
                }
            }
            int temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(minInd));
            arrayList.set(minInd, temp);
        }
        return arrayList;
    }
}

