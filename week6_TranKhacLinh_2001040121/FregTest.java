package week6_TranKhacLinh_2001040121;

import java.util.Collection;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FregTest {
    private final double[] arr;
    private final int[] expected;

    public FregTest(double[] arr, int[] expected) {
        this.arr = arr;
        this.expected = expected;
    }
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            { new double[] {1,2,3}, new int[]{1,1,1}},
            { new double[] {1,2,3,1,2,3}, new int[] {2,2,2,2,2,2}},
            { new double[] {1}, new int[]{1}}
        });
    }
    @Test
    public void fregTest(){
        int[] actual = week6_TranKhacLinh_2001040121.Arrays.freq(arr);
        Assert.assertArrayEquals(actual, expected);
    }
}
