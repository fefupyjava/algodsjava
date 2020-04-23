package ru.fefupyjava.algodsjava.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BucketSort extends Sort {
    @Override
    public List doSort(ArrayList<Integer> arrayList) {

        final int numberOfBuckets = arrayList.size() / 2;

        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        int max = findMax(arrayList);

        for (int item : arrayList) {
            buckets.get(hash(item, max, numberOfBuckets)).add(item);
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();

        for (List<Integer> bucket : buckets) {
            bucket.sort(comparator);
        }

        ArrayList<Integer> sorted = new ArrayList<>();

        for (List<Integer> bucket : buckets) {
            sorted.addAll(bucket);
        }

        return sorted;
    }

    private int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }

    private int findMax(List<Integer> input) {
        int m = Integer.MIN_VALUE;
        for (int i : input) {
            m = Math.max(i, m);
        }
        return m;
    }
}
