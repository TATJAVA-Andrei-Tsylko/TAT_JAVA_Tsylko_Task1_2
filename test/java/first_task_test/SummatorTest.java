package first_task_test;

import first_task.Summator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SummatorTest {
    @DataProvider
    public Object[][] validSumProvider() {
        return new Object[][]{
                new Object[]{1221},
                new Object[]{1001},
                new Object[]{9999},
                new Object[]{5454},
                new Object[]{-8888},
                new Object[]{-7575},
                new Object[]{0x22B8},

        };
    }

    @DataProvider
    public Object[][] inValidSumProvider() {
        return new Object[][]{
                new Object[]{1234},
                new Object[]{9998},
                new Object[]{1000},
                new Object[]{-10000},

        };
    }
    @DataProvider
    public Object[][] fatalSumProvider() {
        return new Object[][]{
                new Object[]{0000},
                new Object[]{999},
        };
    }



    @Test(dataProvider = "validSumProvider")
    public void testValidSum(Integer number) {
        String valid = Summator.sum(number);
        Assert.assertEquals("true", valid);
    }

    @Test(dataProvider = "inValidSumProvider")
    public void testInValidDate(Integer number) {
        String valid = Summator.sum(number);
        Assert.assertEquals("false", valid);
    }

    @Test(dataProvider = "fatalSumProvider", expectedExceptions = StringIndexOutOfBoundsException.class)
    public void testFatalDate(Integer number) {
        String valid = Summator.sum(number);
        Assert.assertEquals("false", valid);
    }
}
