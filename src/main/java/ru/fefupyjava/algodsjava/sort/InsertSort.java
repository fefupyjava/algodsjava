package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertSort extends Sort {

    @Override
    public List doSort(ArrayList<Integer> arrayList) {

        for (int i = 1; i < arrayList.size(); i++) {
            int tmp = arrayList.get(i);
            int j = i - 1;

            while (j >= 0 && tmp < arrayList.get(j)) {
                arrayList.set(j + 1, arrayList.get(j));
                j--;
            }

            arrayList.set(j + 1, tmp);
        }

        return arrayList;
    }
}