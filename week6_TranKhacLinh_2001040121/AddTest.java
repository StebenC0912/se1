package week6_TranKhacLinh_2001040121;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddTest {

    // private final example_week6 test;
    private final int first;
    private final int second;
    private final int expectedSum;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // create test case here
                { -2, 0, -2 }, { 4, 1, 5 }, { 0, 5, 4 } // first, second, expectedSum
        });
    }

    public AddTest(int first,
            int second,
            int expectedSum) {

        // this.test = new example_week6();
        this.first = first;
        this.second = second;
        this.expectedSum = expectedSum;
    }

    @Test // Annotation for run test function recognition
    public void UnitTest() {

        int actualSum = example_week6.add(first, second);
        Assert.assertEquals(actualSum, expectedSum);
    }
}
