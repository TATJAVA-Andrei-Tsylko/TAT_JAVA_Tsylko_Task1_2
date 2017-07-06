package tenth_task_test;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tenth_task.MatrixCreator;

import java.util.Arrays;

public class tenth_task_test {
    @DataProvider
    public Object[][] setUpNaturalResultsArraysAndSize() {
        return new Object[][]{
                {new Integer[][]{{1, 2, 3}, {3, 2, 1}, {1, 2, 3}}, 3},
                {new Integer[][]{{1, 2, 3, 4}, {4, 3, 2, 1}, {1, 2, 3, 4}, {4, 3, 2, 1}}, 4},


        };
    }
    @DataProvider
    public Object[][] setUpNegativeValuesForArray() {
        return new Object[][]{
                {new Integer[][]{}, 0},
                {new Integer[][]{}, -5},


        };
    }

    //    TODO Add negative test
    @Test(dataProvider = "setUpNaturalResultsArraysAndSize")
    public void testMatrix(Integer[][] resultArray, Integer size) {

        MatrixCreator creator = new MatrixCreator(size);

        int[][] resultArrayForAssert = castIntegerArrayToInt(resultArray);
        int[][] arrayFromMethodCreate = creator.create();

        for (int i = 0; i < arrayFromMethodCreate.length; i++) {
            Assert.assertArrayEquals(arrayFromMethodCreate[i], resultArrayForAssert[i]);
        }

    }

    @Test(dataProvider = "setUpNegativeValuesForArray")
    public void testNegativeCasesForMatrix(Integer[][] resultArray, Integer size) {

        MatrixCreator creator = new MatrixCreator(size);

        int[][] resultArrayForAssert = castIntegerArrayToInt(resultArray);
        int[][] arrayFromMethodCreate = creator.create();

        if(arrayFromMethodCreate != null ){
            for (int i = 0; i < arrayFromMethodCreate.length; i++) {
                Assert.assertArrayEquals(arrayFromMethodCreate[i], resultArrayForAssert[i]);
            }
        }else {
            Assert.assertTrue(arrayFromMethodCreate == null);
        }


    }

    private static int[][] castIntegerArrayToInt(Integer[][] array) {
           int[][]  resultArray = null;
        if (array.length>0){
            resultArray = new int[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    resultArray[i][j] = array[i][j];

                }

            }
        }

        return resultArray;
    }


}
