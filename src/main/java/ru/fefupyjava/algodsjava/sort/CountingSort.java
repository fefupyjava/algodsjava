package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class CountingSort extends Sort{
    @Override
    public List doSort(ArrayList<Integer> arrayList) {
        int max = arrayList.get(0);
        int min = arrayList.get(0);
        for (int i : arrayList ) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        int sdvig = -min;
        int numCounts[] = new int[max - min + 1];
        for (int i : arrayList)
            numCounts[i + sdvig]++;
        int currentSortedIndex = 0;
        ArrayList<Integer> NewArrayList = new ArrayList<>();
        for(int i = 0; i < numCounts.length; i++){
            while (numCounts[i]!=0){
                NewArrayList.add( i - sdvig);
                numCounts[i]--;
                currentSortedIndex++;
            }
        }
        return NewArrayList;
    }
}


