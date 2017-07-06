package second_task_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import second_task.Equation;

public class EquationTest {
    @DataProvider
    public Object[][] setUpValidVariablesForExpression() {
        return new Object[][]{
                {new Double[]{1.0, 2.0, 3.0}, 0.25},
                {new Double[]{2.0, 2.0, 2.0}, -9.27},
                {new Double[]{4.0, 2.0, 3.0}, -173.32},
                {new Double[]{1.0, -2.0, 3.0}, -1.75},
                {new Double[]{0.3, 0.5, 0.9}, 4.22},
        };
    }
    @DataProvider
    public Object[][] setUpInValidVariablesForExpression() {
        return new Object[][]{
                {new Double[]{-5.0, 2.0, 3.0}, Double.NaN},
                {new Double[]{2.0,0.0, 2.0}, Double.POSITIVE_INFINITY},


        };
    }

    @Test(dataProvider = "setUpValidVariablesForExpression")
    public void testCheckNumbersSuccession(Double[] array, Double expected) {

        Equation equation = new Equation(array[0], array[1], array[2]);

        Assert.assertEquals(equation.solveEquation(), expected,0.01);
    }

    @Test(dataProvider = "setUpInValidVariablesForExpression")
    public void testCheckInvalidNumbersSuccession(Double[] array, Double expected) {

        Equation equation = new Equation(array[0], array[1], array[2]);

        Assert.assertEquals(equation.solveEquation(), expected,0.01);
    }
}
