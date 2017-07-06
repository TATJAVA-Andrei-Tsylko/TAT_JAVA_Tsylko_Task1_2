package third_task_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import third_task.Triangle;

public class PerimeterTest {
    @DataProvider
    public Object[][] setUpValidVariablesForTriangle() {
        return new Object[][]{
                {new Double[]{1.0, 1.0}, 3.41},
                {new Double[]{20.0, 20.0}, 68.28},
                {new Double[]{100.0, 100.0}, 341.421},
        };
    }

    @DataProvider
    public Object[][] setUpInValidVariablesForTriangle() {
        return new Object[][]{
                {new Double[]{0.0, 0.0}, 0.0},
                {new Double[]{Double.MAX_VALUE,Double.MAX_VALUE}, Double.POSITIVE_INFINITY}
        };
    }
    @Test(dataProvider = "setUpValidVariablesForTriangle")
    public void testValidPerimeterData(Double[] array, Double result) {
        Triangle t = new Triangle(array[0], array[1]);
        Assert.assertEquals(result, t.calculatePerimeter(),0.01);
    }
    @Test(dataProvider = "setUpInValidVariablesForTriangle")
    public void testInValidPerimeterData(Double[] array, Double result) {
        Triangle t = new Triangle(array[0], array[1]);
        Assert.assertEquals(result, t.calculatePerimeter(),0.01);
    }

}
