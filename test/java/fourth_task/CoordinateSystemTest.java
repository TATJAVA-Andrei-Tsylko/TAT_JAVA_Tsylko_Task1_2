package fourth_task;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CoordinateSystemTest {
    @DataProvider
    public Object[][] setUpValidPoints() {
        return new Object[][]{
                {new Integer[]{1, 2}, true},
                {new Integer[]{-1, -2}, true},
                {new Integer[]{0, -2}, true},
                {new Integer[]{0, 2}, true},
                {new Integer[]{0, -3}, true},
                {new Integer[]{0, 4}, true},
                {new Integer[]{-4, -3}, true},
                {new Integer[]{4, -3}, true},
                {new Integer[]{-2, 4}, true},
                {new Integer[]{2, 4}, true},
                {new Integer[]{0, 0}, true},
        };
    }

    @DataProvider
    public Object[][] setUpInValidPoints() {
        return new Object[][]{
                {new Integer[]{-4, -4}, false},
                {new Integer[]{4, 1}, false},
                {new Integer[]{-3, 4}, false},
                {new Integer[]{0, 5}, false},
                {new Integer[]{3, 5}, false},
                {new Integer[]{0, -4}, false},
        };
    }
    @Test(dataProvider = "setUpValidPoints")
    public void testValidPoints(Integer[] array, boolean result) {
       CoordinatSystem cS = new CoordinatSystem(array[0],array[1]);
        Assert.assertEquals(result, cS.checkMatches());
    }

    @Test(dataProvider = "setUpInValidPoints")
    public void testInValidPoints(Integer[] array, boolean result) {
        CoordinatSystem cS = new CoordinatSystem(array[0],array[1]);
        Assert.assertEquals(result, cS.checkMatches());
    }

}
