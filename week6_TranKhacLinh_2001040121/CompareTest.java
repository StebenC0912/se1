package week6_TranKhacLinh_2001040121;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CompareTest {
    private final double[] arr;
    private final double[] arr2;
    private final int expected;

    public CompareTest(double[] arr, double[] arr2, int expected) {
        this.arr = arr;
        this.arr2 = arr2;
        this.expected = expected;
    }
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // create test case here
                { new double[] { 0, -9, 12, 123 }, new double[] { 0, -9, 12, 123 }, 0 },
                { new double[] { 0, 9, 12, 123 }, new double[] { 0, 9, 12, 123 }, 0 },
                { new double[] { 0, 9, 12, -123 }, new double[] { 0, 9, 12 }, 1 },
                { new double[] { 0, 9, 12, -123 }, new double[] { 1, 2, 3 }, -2 },
                { new double[] { 0, 9, 12, -123 }, new double[] { 0, 9 }, 1 },
                { new double[] { 0, 9, 12, -123 }, new double[] { 0, 9, 3, 4 }, 2 }
        });
    }

    @Test
    public void compareTest() {
        int actual = week6_TranKhacLinh_2001040121.Arrays.compare(arr, arr2);
        Assert.assertEquals(actual, expected);
    }
}
