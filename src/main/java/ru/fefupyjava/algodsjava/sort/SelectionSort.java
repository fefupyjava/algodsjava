package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort extends Sort {

    public SelectionSort(ArrayList<Integer> arrayList) {
        super();
    }

    @Override
    public List doSort(ArrayList<Integer> arrayList) {

            int i, j;
            int min, temp;

            for (i = 0; i < arrayList.size() - 1; i++) {

                min = i;

                for (j = i + 1; j < arrayList.size(); j++) {

                    if (arrayList.get(j) < arrayList.get(min))
                        min = j;

                }

                if (min != i) {

                    temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(min));
                    arrayList.set(min, temp);

                }

            }

            return arrayList;

        }

    }
