package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.algorithms.FibonacciNumbers;

import java.util.Random;

public class TestFibonacciNumber {

    @Test
    public void testFibonacciNumbersNaive() throws Exception {
        Random randomInt = new Random();
        int randomNumberOfFib = randomInt.nextInt(15);
        int fib = getFibonacci(randomNumberOfFib);

        Assert.assertEquals(fib, FibonacciNumbers.run(randomNumberOfFib, FibonacciNumbers.Kind.Naive));
    }

    @Test
    public void testFibonacciNumbersRecursive() throws Exception {
        Random randomInt = new Random();
        int randomNumberOfFib = randomInt.nextInt(15);
        int fib = getFibonacci(randomNumberOfFib);

        Assert.assertEquals(fib, FibonacciNumbers.run(randomNumberOfFib, FibonacciNumbers.Kind.Recursive));
    }

    @Test
    public void testFibonacciNumbersMemoized() throws Exception {
        int f1 = FibonacciNumbers.run(10, FibonacciNumbers.Kind.Naive);
        Assert.assertEquals(f1, FibonacciNumbers.run(10, FibonacciNumbers.Kind.Memoized));
        int f2 = FibonacciNumbers.run(7, FibonacciNumbers.Kind.Recursive);
        Assert.assertEquals(f2, FibonacciNumbers.run(7, FibonacciNumbers.Kind.Memoized));
        int f3 = FibonacciNumbers.run(19, FibonacciNumbers.Kind.Dynamic);
        Assert.assertEquals(f3, FibonacciNumbers.run(19, FibonacciNumbers.Kind.Dynamic));
    }

    @Test
    public void testFibonacciNumbersDynamic() throws Exception {
        Random randomInt = new Random();
        int randomNumberOfFib = randomInt.nextInt(15);
        int fib = getFibonacci(randomNumberOfFib);

        Assert.assertEquals(fib, FibonacciNumbers.run(randomNumberOfFib, FibonacciNumbers.Kind.Dynamic));
    }

    private int getFibonacci(int n) {
        int fib1 = 0;
        int fib2 = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                fib1 += fib2;
            } else {
                fib2 += fib1;
            }
        }

        return n % 2 == 0 ? fib1 : fib2;
    }
}
