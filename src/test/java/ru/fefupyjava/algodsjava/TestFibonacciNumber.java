package ru.fefupyjava.algodsjava;

import org.junit.Assert;
import org.junit.Test;
import ru.fefupyjava.algodsjava.algorithms.FibonacciNumbers;

import java.util.HashMap;
import java.util.Random;

public class TestFibonacciNumber {
    FibonacciNumbers algorithmOfFib = new FibonacciNumbers();
    @Test
    public void testFibonacciNumbersNaive() throws Exception{
        Random randomInt = new Random();
        int randomNumberOfFib = randomInt.nextInt(15);
        int FIBONACCI = 0;
        int FIBONACCI1 = 0;
        int FIBONACCI2 = 1;
        for(int i = 2; i < randomNumberOfFib; i++){
            FIBONACCI = FIBONACCI1 + FIBONACCI2;
            FIBONACCI1 = FIBONACCI2;
            FIBONACCI2 = FIBONACCI;
        }
        Assert.assertEquals(FIBONACCI, algorithmOfFib.run(randomNumberOfFib, "naive"));
    }
    @Test
    public void testFibonacciNumbersRecursive() throws Exception{
        Random randomInt = new Random();
        int randomNumberOfFib = randomInt.nextInt(15);
        int FIBONACCI = 0;
        int FIBONACCI1 = 0;
        int FIBONACCI2 = 1;
        for(int i = 2; i < randomNumberOfFib; i++){
            FIBONACCI = FIBONACCI1 + FIBONACCI2;
            FIBONACCI1 = FIBONACCI2;
            FIBONACCI2 = FIBONACCI;
        }
        Assert.assertEquals(FIBONACCI, algorithmOfFib.run(randomNumberOfFib - 1, "recursive"));
    }
    @Test
    public void testFibonacciNumbersMemoized() throws Exception{
        int f1 = algorithmOfFib.run(10, "naive");
        Assert.assertEquals(f1, algorithmOfFib.run(10, "memoized"));
        int f2 = algorithmOfFib.run(7, "recursive");
        Assert.assertEquals(f2, algorithmOfFib.run(7, "memoized"));
        int f3 = algorithmOfFib.run(19, "dynamic");
        Assert.assertEquals(f3, algorithmOfFib.run(19, "dynamic"));
    }
    @Test
    public void testFibonacciNumbersDynamic() throws Exception{
        Random randomInt = new Random();
        int randomNumberOfFib = randomInt.nextInt(15);
        int FIBONACCI = 0;
        int FIBONACCI1 = 0;
        int FIBONACCI2 = 1;
        for(int i = 2; i < randomNumberOfFib; i++){
            FIBONACCI = FIBONACCI1 + FIBONACCI2;
            FIBONACCI1 = FIBONACCI2;
            FIBONACCI2 = FIBONACCI;
        }
        Assert.assertEquals(FIBONACCI, algorithmOfFib.run(randomNumberOfFib, "dynamic"));
    }
}
