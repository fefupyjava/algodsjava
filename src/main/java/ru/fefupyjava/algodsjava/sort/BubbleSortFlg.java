package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortFlg extends Sort {
    @Override
    public List doSort(ArrayList<Integer> arrayList) {
        if (arrayList == null) { return null; }
        boolean flag = false;
        int buff;
        while (!flag) {
            flag = true;
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i) > arrayList.get(i + 1)) {
                    buff = arrayList.get(i);
                    arrayList.set(i + 1, arrayList.get(i + 1));
                    arrayList.set(i + 1, buff);
                    flag = false;
                }
            }
        }
        return arrayList;
    }
}
