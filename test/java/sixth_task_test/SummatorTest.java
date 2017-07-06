package sixth_task_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sixth_task.Summator;

public class SummatorTest {
    @DataProvider
    public Object[][] setUpValidVariablesForArray() {
        return new Object[][]{
                {new Double[]{1.0, 2.0, 3.0}, 4.0},
                {new Double[]{-2.0, 2.0, 4.0}, 2.0},
                {new Double[]{0.0, 0.0, 0.0}, 0.0},
                {new Double[]{-100.0, -2.0, 100.0}, 0.0},
                {new Double[]{0.0, 0.5, 0.4}, 0.5},
        };
    }
    @DataProvider
    public Object[][] setUpInValidVariablesForArray() {
        return new Object[][]{
                {new Double[]{0.000000000000000000000000001, 0.000000000000000000000000002, 0.000000000000000000000000003}, 0.000000000000000000000000004},
                {new Double[]{Double.MAX_VALUE,Double.MIN_VALUE, 2.0}, 1.7976931348623157E308},


        };
    }

    @Test(dataProvider = "setUpValidVariablesForArray")
    public void testCheckSummatorWithCorrectValue(Double[] array, Double expected) {

       Summator summator = new Summator(array[0],array[1],array[2]);

        Assert.assertEquals(summator.makeSum(), expected,0.01);
    }

    @Test(dataProvider = "setUpInValidVariablesForArray")
    public void testCheckSummatorWithInCorrectValue(Double[] array, Double expected) {

        Summator summator = new Summator(array[0],array[1],array[2]);

        Assert.assertEquals(summator.makeSum(), expected,0.000000000000000000000000001);
    }

}
