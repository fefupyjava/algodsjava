package ru.fefupyjava.algodsjava.algorithms;

import java.util.HashMap;

public class FibonacciNumbers {
    public enum Kind {
        Naive,
        Recursive,
        Memoized,
        Dynamic
    }

    private static final HashMap<Integer, Integer> memoiz = new HashMap<>();

    private static int recursive(int n) {
        if (n <= 2) {
            return n < 1 ? 0 : 1;
        }

        int number = recursive(n - 1) + recursive(n - 2);
        memoiz.put(n, number);
        return number;
    }

    private static int memoized(int n) {
        return memoiz.getOrDefault(n, 0);
    }

    private static int naive(int n) {
        int fib1 = 0;
        int fib2 = 1;
        memoiz.put(0, 0);
        memoiz.put(1, 1);


        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                fib1 += fib2;
                memoiz.put(i, fib1);
            } else {
                fib2 += fib1;
                memoiz.put(i, fib2);
            }
        }

        return n % 2 == 0 ? fib1 : fib2;
    }

    private static int dynamic(int n) {
        if (n < 1) {
            return 0;
        }
        int[] fibonacciArray = new int[n + 1];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i <= n; i++)
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        memoiz.put(n, fibonacciArray[n]);

        return fibonacciArray[n];
    }

    public static int run(int n, Kind kind) {
        switch (kind) {
            case Naive:
                return naive(n);
            case Recursive:
                return n < 0 ? 0 : recursive(n);
            case Memoized:
                return memoized(n);
            case Dynamic:
                return dynamic(n);
        }
        return 0;
    }
}
