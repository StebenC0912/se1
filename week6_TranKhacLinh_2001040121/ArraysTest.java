package week6_TranKhacLinh_2001040121;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArraysTest {
    protected final int[] arr;
    protected final int expected;

    @Parameters
    public static Collection<Object[]> dataNegative() {
        return Arrays.asList(new Object[][] {
                // create test case here
                { new int[] { 0, -9, 12, 123 }, 1 }, { new int[] { 0, 9, 12, 123 }, 0 },
                { new int[] { 0, 9, 12, -123 }, 1 }
        });
    }

    public ArraysTest(int[] arr, int expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Test
    public void countNegativeTest() {
        int actual = week6_TranKhacLinh_2001040121.Arrays.countNegative(arr);
        Assert.assertEquals(actual, expected);
    }

    
}
