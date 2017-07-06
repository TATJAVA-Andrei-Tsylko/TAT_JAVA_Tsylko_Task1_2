package ninth_task_test;

import ninth_task.ArrayMerger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMergerTest {
    @DataProvider
    public Object[][] setUpNaturalNumbersArray() {
        return new Object[][]{
                {new Integer[]{1,2,3,4,5,6},new Integer []{10,11,12,13,15},new Integer[]{3},new Integer[]{1,2,3,10,11,12,13,15,4,5,6}},
                {new Integer[]{-1,-2,-3,-4,-5,-6},new Integer []{1,2},new Integer[]{2},new Integer[]{-1,-2,1,2,-3,-4,-5,-6}},
                {new Integer[]{-1,-2,-3,-4,-5,-6},new Integer []{},new Integer[]{2},new Integer[]{-1,-2,-3,-4,-5,-6}},

        };
    }
    @DataProvider
    public Object[][] setUpNegativeValueForNaturalNumbersArray() {
        return new Object[][]{
                {new Integer[]{1,2,3,4,5,6},new Integer []{10,11,12,13,15},new Integer[]{7},new Integer[]{}},

        };
    }
    //    TODO Add
    @Test(dataProvider = "setUpNaturalNumbersArray")
    public void testNaturalNumberMerge(Integer[] firstArray, Integer [] secondArray , Integer[] positionInArray, Integer[] mergedArray) {
        int[] mergedArrayPrimitive = Arrays.stream(mergedArray).mapToInt(Integer::intValue).toArray();
        int[] positionInArrayPrimitive = Arrays.stream(positionInArray).mapToInt(Integer::intValue).toArray();
        int[] firstArrayPrimitive = Arrays.stream(firstArray).mapToInt(Integer::intValue).toArray();
        int[] secondArrayPrimitive = Arrays.stream(secondArray).mapToInt(Integer::intValue).toArray();


        ArrayMerger arrayMerger = new ArrayMerger(firstArrayPrimitive,secondArrayPrimitive,positionInArrayPrimitive[0]);
        Assert.assertEquals(arrayMerger.merge(),mergedArrayPrimitive);
    }

    @Test(dataProvider = "setUpNegativeValueForNaturalNumbersArray")
    public void testNegativeNaturalNumberMerge(Integer[] firstArray, Integer [] secondArray , Integer[] positionInArray, Integer[] mergedArray) {
        int[] mergedArrayPrimitive = Arrays.stream(mergedArray).mapToInt(Integer::intValue).toArray();
        int[] positionInArrayPrimitive = Arrays.stream(positionInArray).mapToInt(Integer::intValue).toArray();
        int[] firstArrayPrimitive = Arrays.stream(firstArray).mapToInt(Integer::intValue).toArray();
        int[] secondArrayPrimitive = Arrays.stream(secondArray).mapToInt(Integer::intValue).toArray();


        ArrayMerger arrayMerger = new ArrayMerger(firstArrayPrimitive,secondArrayPrimitive,positionInArrayPrimitive[0]);
        Assert.assertEquals(arrayMerger.merge(),mergedArrayPrimitive);
    }

}
