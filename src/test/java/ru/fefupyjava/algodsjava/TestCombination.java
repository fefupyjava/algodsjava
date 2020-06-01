package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.algorithms.Combination;

import java.util.ArrayList;
import java.util.List;

public class TestCombination {
    @Test
    public void TestRecursiveCombination() throws Exception {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            data.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> buf = new ArrayList<>();
        buf.add(1);
        buf.add(2);
        res.add(buf);

        buf = new ArrayList<>();
        buf.add(1);
        buf.add(3);
        res.add(buf);

        buf = new ArrayList<>();
        buf.add(2);
        buf.add(3);
        res.add(buf);

        Combination comb = new Combination();
        Assert.assertEquals(res, comb.Run(data, 2, Combination.Kind.Recursive));
    }

    @Test
    public void TestNaiveCombination() throws Exception {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            data.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> buf = new ArrayList<>();
        buf.add(1);
        buf.add(2);
        res.add(buf);

        buf = new ArrayList<>();
        buf.add(1);
        buf.add(3);
        res.add(buf);

        buf = new ArrayList<>();
        buf.add(2);
        buf.add(3);
        res.add(buf);

        Combination comb = new Combination();
        Assert.assertEquals(res, comb.Run(data, 2, Combination.Kind.Naive));
    }
}
