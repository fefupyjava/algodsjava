package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Sort {
    public static void main(String[] args) {
        int[] a = {3,5,1};
        SortUnsorted(a, 0, a.length-1);
    }


    private static void SortUnsorted(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        SortUnsorted(a, lo, mid);
        SortUnsorted(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
