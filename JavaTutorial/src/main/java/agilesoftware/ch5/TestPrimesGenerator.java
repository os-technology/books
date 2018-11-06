package agilesoftware.ch5;/*--- formatted by Jindent 2.1, (www.c-lab.de/~jindent) ---*/

import junit.framework.TestCase;

public class TestPrimesGenerator extends TestCase
{
  public TestPrimesGenerator(String name)
  {
    super(name);
  }

  public void testPrimes()
  {
//    int[] nullArray = PrimeGenerator.generatePrimes(0);
//    assertEquals(nullArray.length, 0);
//
//    int[] minArray = PrimeGenerator.generatePrimes(2);
//    assertEquals(minArray.length, 1);
//    assertEquals(minArray[0], 2);
//
//    int[] threeArray = PrimeGenerator.generatePrimes(3);
//    assertEquals(threeArray.length, 2);
//    assertEquals(threeArray[0], 2);
//    assertEquals(threeArray[1], 3);

    int[] centArray = PrimeGenerator.generatePrimes(100);
    assertEquals(centArray.length, 25);
    assertEquals(centArray[24], 97);
  }
}
