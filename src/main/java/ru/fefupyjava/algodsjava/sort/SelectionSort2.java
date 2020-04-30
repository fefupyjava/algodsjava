package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort2 extends Sort {
<<<<<<< HEAD

    public SelectionSort2(ArrayList<Integer> arrayList) {
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
=======
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

>>>>>>> a19da8ff89c010020f869a5d91f8f717eb83470e
