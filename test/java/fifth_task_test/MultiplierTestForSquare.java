package fifth_task_test;


import fifth_task.Multiplier;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplierTestForSquare {
    @DataProvider
    public Object[][] setUpValidVariablesForSquare() {
        return new Object[][]{
                {new Double[]{1.0},1.0},
                {new Double[]{2.0}, 4.0},
                {new Double[]{100.0}, 10000.0},
                {new Double[]{5.0}, 25.0},

        };
    }
    @DataProvider
    public Object[][] setUpInValidVariablesForSquare() {
        return new Object[][]{
                {new Double[]{0.0},0.0},
                {new Double[]{-2.0},-8.0},
                {new Double[]{Double.MAX_VALUE}, Double.POSITIVE_INFINITY},

        };
    }
    @Test(dataProvider = "setUpValidVariablesForSquare")
    public void testMultiplierForSquareNumber(Double[] array, Double expected) {

        Assert.assertEquals(Multiplier.multiply(array[0]), expected,0.01);
    }

    @Test(dataProvider = "setUpInValidVariablesForSquare")
    public void testMultiplierForIllegalSquareNumber(Double[] array, Double expected) {

        Assert.assertEquals(Multiplier.multiply(array[0]), expected,0.01);
    }
}
