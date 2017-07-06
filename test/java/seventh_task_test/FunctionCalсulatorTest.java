package seventh_task_test;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import seventh_task.FunctionCalculator;

import java.util.*;

public class FunctionCalсulatorTest {
    @DataProvider
    public Object[][] setUpValidVariablesForCalculator() {
        return new Object[][]{
                {new Double[]{2.0, 5.0, 1.0}, new Double[]{2.0, 3.0, 4.0, 5.0}, new Double[]{1.480465431295418, -0.9402554299755491,0.7182500507129203, 1.7586072936146786}},
                {new Double[]{-2.0, 5.0, 2.0}, new Double[]{-2.0, 0.0, 2.0, 4.0}, new Double[]{1.480465431295418, -1.0, 1.480465431295418, 0.7182500507129203}},
                {new Double[]{100.0, 1000.0,300.0}, new Double[]{100.0, 400.0, 700.0, 1000.0}, new Double[]{-0.23078151251050882,  1.1721912698262384, -0.11228820913532561, 1.051189323651247}},
        };
    }
    @DataProvider
    public Object[][] setUpInValidVariablesForCalculator() {
        return new Object[][]{
                {new Double[]{2.0, 5.0, 0.0}, new Double[]{}, new Double[]{}},
                {new Double[]{2.0, 6.0, -1.0}, new Double[]{}, new Double[]{}},
        };
    }



    @Test(dataProvider = "setUpValidVariablesForCalculator")
    public void testCalculatorWithPositiveValue(Double[] initParams, Double[] step,Double[]result) {

        FunctionCalculator calculator = new FunctionCalculator(initParams[0],initParams[1],initParams[2]);

        Assert.assertEquals(calculator.calculate(), castTwoArraysToMap(step,result));


    }
    @Test(dataProvider = "setUpInValidVariablesForCalculator")
    public void testCalculatorWithNegativeValue(Double[] initParams, Double[] step,Double[]result) {

        FunctionCalculator calculator = new FunctionCalculator(initParams[0],initParams[1],initParams[2]);

        Assert.assertEquals(calculator.calculate(), castTwoArraysToMap(step,result));


    }

    public static Map castTwoArraysToMap(Double[] keyArray,Double[] valueArray){
        Map<Double,Double> map = new TreeMap<>();
        Iterator<Double> i1 = Arrays.asList(keyArray).iterator();
        Iterator<Double> i2 = Arrays.asList(valueArray).iterator();
        while (i1.hasNext() || i2.hasNext()) map.put(i1.next(), i2.next());
        return map;
    }


}
