package ru.fefupyjava.algodsjava.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    public enum Kind {
        Naive,
        Recursive,
        Dynamic
    }

    public List<List<Integer>> Run(List<Integer> data, int size, Kind kind) {
        if (size > data.size()) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();

        Integer[] intermediate = new Integer[data.size()];
        for (int i = 0; i < data.size(); i++) {
            intermediate[i] = data.get(i);
        }

        if (kind == Kind.Naive) {
            res = Naive(intermediate, size);
        } else if (kind == Kind.Recursive) {
            Recursive(res, intermediate, size, 0, 0);
        }

        return res;
    }

    public List<List<Integer>> Run(Integer[] data, int size, Kind kind) {
        if (size > data.length) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();

        if (kind == Kind.Naive) {
            res = Naive(data, size);
        } else if (kind == Kind.Recursive) {
            Recursive(res, data, size, 0, 0);
        }

        return res;
    }

    private void Recursive(List<List<Integer>> list, Integer[] data, int k, int h, int g) {
        if (h >= k) {
            List<Integer> res = new ArrayList<>(Arrays.asList(data).subList(0, k));
            list.add(res);
            return;
        }

        for (int i = g; i < data.length; i++) {
            int buf = data[h];
            data[h] = data[i];
            data[i] = buf;

            Recursive(list, data, k, h + 1, i + 1);

            data[i] = data[h];
            data[h] = buf;
        }
    }

    private List<List<Integer>> Naive(Integer[] data, int k) {
        List<List<Integer>> res = new ArrayList<>();
        do {
            res.add(new ArrayList<>(Arrays.asList(data).subList(0, k)));

            if (++data[k - 1] <= data.length) continue;    // ?
            if (k == 1) break;

            int ind = -1;
            for (int i = k - 2; i >= 0; --i)
                if (data[i] <= data.length - k + i) {
                    ind = i;
                    break;
                }

            if (ind == -1) break;

            ++data[ind];
            for (int i = ind + 1; i < k; i++)
                data[i] = data[i - 1] + 1;
        } while (true);

        return res;
    }
}