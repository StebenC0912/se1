package week6_TranKhacLinh_2001040121;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MedianTest {
    private static final double DELTA = 1e-15;
    private final double[] arr;
    private final double expected;

    public MedianTest(double[] arr, double expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // create test case here
                { new double[]{}, 0}, 
                { new double[]{1d}, 1d },
                { new double[]{2d,1d}, 1d},
                { new double[]{1d, 3d, 2d}, 2d},
                { new double[]{100d, 200d, 1d, 3d}, 3d},
                { new double[]{100d, 220d, 300d, 400d}, 220d}
        });
    }

    @Test
    public void medianTest() {
        double actual = week6_TranKhacLinh_2001040121.Arrays.median(arr);
        Assert.assertEquals(actual, expected, DELTA);
    }
}
