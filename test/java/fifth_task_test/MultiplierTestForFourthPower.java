package fifth_task_test;


import fifth_task.Multiplier;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplierTestForFourthPower {
    @DataProvider
    public Object[][] setUpValidVariablesFourthPower() {
        return new Object[][]{
                {new Double[]{-1.0},1.0},
                {new Double[]{-2.0}, 16.0},
                {new Double[]{-6.0}, 1296.0},
                {new Double[]{-20.0}, 160000.0},

        };
    }
    @DataProvider
    public Object[][] setUpInValidVariablesFourthPower() {
        return new Object[][]{
                {new Double[]{0.0},0.0},
                {new Double[]{Double.MAX_VALUE}, Double.POSITIVE_INFINITY},

        };
    }
    @Test(dataProvider = "setUpValidVariablesFourthPower")
    public void testMultiplierForFourthPowerNumber(Double[] array, Double expected) {

        Assert.assertEquals(Multiplier.multiply(array[0]), expected,0.01);
    }

    @Test(dataProvider = "setUpInValidVariablesFourthPower")
    public void testMultiplierForIllegalFourthPowerNumber(Double[] array, Double expected) {

        Assert.assertEquals(Multiplier.multiply(array[0]), expected,0.01);
    }
}
