package week6_TranKhacLinh_2001040121;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class isSortedTest {
    protected final int[] arr;
    protected final boolean expected;

    public isSortedTest(int[] arr, boolean expected) {
        this.arr = arr;
        this.expected = expected;
    }
    @Parameters
    public static Object[][] data() {
        return new Object[][] {
                // create test case here
                { new int[] { 0, -9, 12, 123 }, false }, { new int[] { 0, 9, 12, 123 }, true },
                { new int[] { 0, 9, 12, -123 }, false }, { new int[] { 0 }, true }
        };
    }
    @Test
    public void isSortedTest() {
        boolean actual = week6_TranKhacLinh_2001040121.Arrays.isAscSorted(arr);
        Assert.assertEquals(actual, expected);
    }
}
