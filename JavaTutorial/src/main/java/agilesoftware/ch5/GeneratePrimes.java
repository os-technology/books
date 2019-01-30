package agilesoftware.ch5; /**
 * This class Generates prime numbers up to a user specified maximum.
 * the algorithm used is the Sieve of Eratosthenes.
 * <p>
 * Eratosthenes of Cyrene, b. c. 276 BC, Cyrene, Libya --
 * d. c. 194, Alexandria.  The first man to calculate the circumference
 * of the Earth.  Also known for working on calendars with leap
 * years and ran the library at Alexandria.
 * <p>
 * The algorithm is quite simple.  Given an array of integers starting
 * at 2.  Cross out all multiples of 2.  Find the next uncrossed
 * integer, and cross out all of its multiples.  Repeat until
 * you have passed the square root of the maximum value.
 *
 * @author Robert C. Martin
 * @version 9 Dec 1999 rcm
 */

import com.alibaba.fastjson.JSON;

/**
 * Class declaration
 * 版本1 。版本2 参见 PrimeGenerator.java类
 *
 * @author Robert C. Martin
 * @version %I%, %G%
 */
public class GeneratePrimes {
    /**
     * @param maxValue is the generation limit.
     */
    public static int[] generatePrimes(int maxValue) {
        if (maxValue >= 2) // the only valid case
        {
            // declarations
            int s = maxValue + 1; // size of array
            boolean[] f = new boolean[s];
            int i;

            // initialize array to true.
            for (i = 0; i < s; i++)
                f[i] = true;

            // get rid of known non-primes
            f[0] = f[1] = false;

            // sieve
            int j;
            //Math.sqrt,开平方操作，该循环是过滤所有的倍数操作
            for (i = 2; i < Math.sqrt(s) + 1; i++) {
                for (j = 2 * i; j < s; j += i)//从i=2开始，过滤从2一直到 Math.sqrt(s) + 1 范围内的数的倍数信息
                    f[j] = false; // multiple is not prime(倍数不是质数)
            }

            // how many primes are there?
            int count = 0;
            for (i = 0; i < s; i++) {
                if (f[i])
                    count++; // bump count.
            }

            int[] primes = new int[count];

            // move the primes into the result
            for (i = 0, j = 0; i < s; i++) {
                if (f[i])             // if prime
                    primes[j++] = i;
            }

            return primes;  // return the primes
        } else // maxValue < 2
            return new int[0]; // return null array if bad input.
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(101));
        System.out.println(JSON.toJSONString(generatePrimes(100)));
    }
}


