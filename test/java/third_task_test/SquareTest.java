package third_task_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import third_task.Triangle;

public class SquareTest {
    @DataProvider
    public Object[][] setUpValidVariablesForTriangleSquare() {
        return new Object[][]{
                {new Double[]{2.0, 2.0}, 2.0},
                {new Double[]{15.0, 20.0}, 150.0},
                {new Double[]{100.0, 30.0}, 1500.0},
        };
    }

    @DataProvider
    public Object[][] setUpInValidVariablesForTriangleSquare() {
        return new Object[][]{
                {new Double[]{0.0, 0.0}, 0.0},
                {new Double[]{Double.NaN, 1.0}, Double.NaN},
                {new Double[]{Double.MAX_VALUE,Double.MAX_VALUE}, Double.POSITIVE_INFINITY}
        };
    }
    @Test(dataProvider = "setUpValidVariablesForTriangleSquare")
    public void testValidSquareData(Double[] array, Double result) {
        Triangle t = new Triangle(array[0], array[1]);
        Assert.assertEquals(result, t.calculateSquare(),0.01);
    }
    @Test(dataProvider = "setUpInValidVariablesForTriangleSquare")
    public void testInValidSquareData(Double[] array, Double result) {
        Triangle t = new Triangle(array[0], array[1]);
        Assert.assertEquals(result, t.calculateSquare(),0.01);
    }
}
