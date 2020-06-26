package ru.fefupyjava.algodsjava.sort;

import com.sun.scenario.effect.Merge;
import org.omg.CORBA.ARG_IN;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort extends Sort {
    @Override
    public List doSort(ArrayList<Integer> arrayList) {

        if (arrayList.size() < 2)  {
            return arrayList;
        }

        int mid = arrayList.size()/2;

        ArrayList left = new ArrayList(arrayList.subList(0,mid));
        ArrayList right = new ArrayList(arrayList.subList(mid,arrayList.size()));

        return merged(doSort(left), doSort(right));
    }

    private List merged(List<Integer> left, List<Integer> right) {

        int leftIndex = 0;
        int rightIndex = 0;

        List<Integer> merged = new ArrayList<Integer>();

        while (leftIndex < left.size() && rightIndex < right.size()) {

            if (left.get(leftIndex) < right.get(rightIndex)) {
                merged.add(left.get(leftIndex++));
            }

            else {
                merged.add(right.get(rightIndex++));
            }
        }

        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));

        return merged;
    }

}


