package agilesoftware.ch5;

/**
 * This class Generates prime numbers up to a user specified
 * maximum.  The algorithm used is the Sieve of Eratosthenes.
 * Given an array of integers starting at 2:
 * Find the first uncrossed integer, and cross out all its
 * multiples.  Repeat until there are no more multiples
 * in the array.
 * <p>
 * 版本2 。版本1 参见GeneratePrimes.java类
 *
 * 假设一个数不是素数的话，那么它就是合数，即意味着这个数可以由两个自然数相乘得到，
 * 其中一个大于或等于它的平方根，另一个小于或等于它的平方根。并且成对出现。因此，
 * 判断一个数是否为素数，只需判断从2开始到该整数的平方根范围内是否有整数能整除该数，
 * 有则为合数，无则为素数。
 */

public class PrimeGenerator {
    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2)
            return new int[0];
        else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = 2; i <= limit; i++)
            if (notCrossed(i))
                crossOutMultiplesOf(i);
    }

    private static int determineIterationLimit() {
        // Every multiple in the array has a prime factor that
        // is less than or equal to the root of the array size,
        // so we don't have to cross of multiples of numbers
        // larger than that root.
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i;
             multiple < crossedOut.length;
             multiple += i)
            crossedOut[multiple] = true;
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    /**
     * 功能一：计算了数组中最终没有被过滤掉的整数的数目，并创建了一个同样大小的数组来存放这些结果
     * 功能二：把那些没有被过滤掉的证书搬移到结果数组中。
     */
    private static void putUncrossedIntegersIntoResult() {
        //创建了一个同样大小的数组来存放这些结果
        result = new int[numberOfUncrossedIntegers()];
        //把那些没有被过滤掉的整数搬移到结果数组中。
        for (int j = 0, i = 2; i < crossedOut.length; i++) {
            System.out.println(crossedOut[i]);
            if (notCrossed(i))
                result[j++] = i;
        }
    }

    /**
     * 计算了数组中最终没有被过滤掉的整数的数目 并进行返回
     *
     * @return
     */
    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                count++;

        return count;
    }
}