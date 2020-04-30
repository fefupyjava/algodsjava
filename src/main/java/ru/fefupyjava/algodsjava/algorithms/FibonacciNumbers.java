package ru.fefupyjava.algodsjava.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciNumbers {
    public static HashMap<Integer, Integer> memoiz = new HashMap<>();

    public static int recursive(int n){
        if (n < 2){
            return n;
        }
        int number = recursive(n - 1) + recursive(n - 2);
        memoiz.put(n, number);
        return number;
    }
    public static int memoized(int n){
        return memoiz.getOrDefault(n, 0);
    }

    public static int run(int n, String kind) {
        switch (kind) {
            case "naive":
                int fibonacci = 0;
                int fibonacci1 = 0;
                int fibonacci2 = 1;
                for (int i = 2; i < n; i++) {
                    fibonacci = fibonacci1 + fibonacci2;
                    fibonacci1 = fibonacci2;
                    fibonacci2 = fibonacci;
                }
                memoiz.put(n, fibonacci);
                return fibonacci;
            case "recursive":
                return recursive(n);
            case "memoized":
                return memoized(n);
            case "dynamic":
                int[] fibonacciArray = new int[n];
                fibonacciArray[0] = 0;
                fibonacciArray[1] = 1;
                for (int i = 2; i < n; i++) fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
                memoiz.put(n, fibonacciArray[n - 1]);
                return fibonacciArray[n - 1];
        }
        return 0;
    }
}
