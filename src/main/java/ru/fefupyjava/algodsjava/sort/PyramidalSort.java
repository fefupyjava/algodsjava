package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class PyramidalSort extends Sort {
    private int Left(int i) {
        return i * 2 + 1;
    }

    private int Right(int i) {
        return i * 2 + 2;
    }

    private void swap(ArrayList<Integer> list, int a, int b) {
        int t = list.get(a);
        list.set(a, list.get(b));
        list.set(b, t);
    }

    private void SiftingDown(ArrayList<Integer> list, int heapSize, int i) {
        int l = Left(i);
        int r = Right(i);
        int largest;

        if (l < heapSize && list.get(l) > list.get(i))
            largest = l;
        else
            largest = i;
        if (r < heapSize && list.get(r) > list.get(largest))
            largest = r;

        if (largest != i) {
            swap(list, i, largest);
            SiftingDown(list, heapSize, largest);
        }
    }

    private void BuildHeap(ArrayList<Integer> list) {
        for (int i = list.size() / 2; i >= 0; i--)
            SiftingDown(list, list.size(), i);
    }

    @Override
    public List doSort(ArrayList<Integer> arrayList) {
        ArrayList<Integer> list = new ArrayList<>(arrayList);
        int N = arrayList.size();

        BuildHeap(list);
        for (int i = N - 1; i > -1; i--) {
            SiftingDown(list, i + 1, 0);
            swap(list, i, 0);
        }
        return list;
    }
}
