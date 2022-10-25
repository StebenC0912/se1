package week6_TranKhacLinh_2001040121;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class lengthTest {
    private final char[] arr;
    private final int expected;

    public lengthTest(char[] arr, int expected) {
        this.arr = arr;
        this.expected = expected;
    }
    @Parameters
    public static Object[][] data() {
        return new Object[][] {
                // create test case here
                { new char[] { 'h', 'e', 'l', 'l', 'o', '\u0000', 'w'}, 5 }, { new char[] {'\u0000'}, 0 },
                { new char[] { '0','1','g' }, 3 }, { new char[] { '0' }, 1 }
        };
    }
    @Test
    public void lengthTest() {
        int actual = week6_TranKhacLinh_2001040121.Arrays.length(arr);
        Assert.assertEquals(actual, expected);
    }
}
