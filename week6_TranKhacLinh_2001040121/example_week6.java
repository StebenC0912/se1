package week6_TranKhacLinh_2001040121;

import java.util.Set;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class example_week6 {

  // HashSet TreeSet LinkedHashSet EnumSet
  @Test
  public void testAdd() throws AssertionError
  // public static void main(String[] args) throws AssertionError
  {
    // Requires turning on Java’s JVM assertion support
    assert (add(1, 1) == 2) : "wrong add"; // need to run with -ea (enable assertions)

    // example
    int[][] tds1 = new int[][] { { -2, 0, 2 }, { -4, 0, 4 } };
    int[] rs = new int[] { -6, -4, -2, -1, 0, 2, 2, 4, 6 };

    // for
    assert (3 == tds1[0].length);
    assert (2 == tds1.length);
    for (int i = 0; i < tds1[0].length; i++) {
      for (int j = 0; j < tds1[1].length; j++) {
        System.out.print("");
        Assert.assertEquals(add(tds1[0][j], tds1[1][i]), rs[i * 3 + j]); // add junit 4 to classpath
      }
    }

    System.out.print("helo");
  }

  public static int add(int a, int b) {
    return a + b;
  }

}

/**
 * @overview A test driver for the <tt>Num.sqrt</tt> method.
 */
class SquareRootTest {

  /**
   * @modifies <tt>System.out</tt>
   * @effects
   * 
   *          <pre>
   *            for each test case tc = < x,e,r > 
   *              if |Num.sqrt(x)^2 - r^2| > e 
   *                throws AssertionError 
   *              else 
   *                displays Num.sqrt(x) on the standard output
   *          </pre>
   */

  public void squareRoot() throws AssertionError {
    System.out.println("================");
    System.out.println("Num.sqrt");

    // test cases
    float[] tcEps = {
        0.00002f,
        0.0001f, //
        0.009f //
    };

    float[] tcX = {
        0f, 0.001f, 0.01f, 0.09f, 0.5f, 1f, 2f,
        10f, //
        100f, //
        2147483600f
    };

    // test results
    float[] results = new float[tcX.length];
    for (int i = 0; i < tcX.length; i++) {
      results[i] = (float) (Math.sqrt(tcX[i]))
      // (float) Math.random()
      ;
    }
    ;

    float x, e, r;
    for (int i = 0; i < tcX.length; i++) {
      x = tcX[i];
      r = results[i];
      for (int j = 0; j < tcEps.length; j++) {
        System.out.println(">>Test case " + ((i * tcEps.length) + j));
        e = tcEps[j];
        float result = Num.sqrt(x, e);
        // check same sign
        assert (r * result >= 0) : "Invalid result " + result + " (expected: ) " + r;
        // check delta error (assume same delta error between the expected result and
        // our result)
        Assert.assertEquals(r * r, result * result, 2 * e);
        // assert (Math.abs(r*r -result*result) < 2 * e) : "Invalid result";

        System.out.printf("sqrt(%f,%f) = %f (expected = %f; diff = %f) %n", x, e, result, r,
            Math.abs(r * r - result * result));
      }
    }
  }
}

class Num {
  public static float sqrt(float x, float y) {
    return 0;
  }
}
