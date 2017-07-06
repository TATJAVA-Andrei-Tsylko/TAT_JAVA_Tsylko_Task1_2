package eighth_task_test;


import eighth_task.CustomArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class NaturalNumberTest {
    @DataProvider
    public Object[][] setUpNaturalNumbersArray() {
        return new Object[][]{
                {new Integer[]{5,10,8,7,15,19},new Integer[]{5,30}},
                {new Integer[]{21,10,8,7,15,19,7},new Integer[]{7,35}},
                {new Integer[]{21,10,-8,7,16,19,-24},new Integer[]{4,-16}},


        };
    }
    @DataProvider
    public Object[][] setUpNegativeValueForNaturalNumbersArray() {
        return new Object[][]{
                {new Integer[]{},new Integer[]{5,0}},
                {new Integer[]{21,10,8,7,15,19,7},new Integer[]{0,0}},

        };
    }



    @Test(dataProvider = "setUpNaturalNumbersArray")
    public void testNaturalNumberSum(Integer[] array, Integer [] condition) {
        CustomArray customArray = new CustomArray(condition[0], Arrays.stream(array).mapToInt(Integer::intValue).toArray());
        Assert.assertEquals(customArray.findSum(),(int)condition[1]);


    }

    @Test(dataProvider = "setUpNegativeValueForNaturalNumbersArray")
    public void testNegativeNaturalNumbers(Integer[] array, Integer [] condition) {
        CustomArray customArray = new CustomArray(condition[0], Arrays.stream(array).mapToInt(Integer::intValue).toArray());
        Assert.assertEquals(customArray.findSum(),(int)condition[1]);


    }


}
