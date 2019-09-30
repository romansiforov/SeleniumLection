import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator;
    @Before
    public void init()
    {
        calculator = new Calculator();
    }

    @Test
    public void CheckSumOfIntegers()
    {
        int expectedSum = 11;
        int sum = calculator.GetSum(5,6);
        Assert.assertEquals("The sum of integers is incorrect",expectedSum, sum);
    }

    @Test
    public void CheckDiffOfIntegers ()
    {
        int expectedDif = -1;
        int expectedDiffPositive = -2;
        int expectedDiffZero =  8;
        int ActualDiffPositive = calculator.GetDifference(5,6);
        int ActualDiffNegative = calculator.GetDifference(-8, -6);
        int ActualDiffPozitiveAndZero = calculator.GetDifference(8, 0);
        Assert.assertEquals("The diff of Positive ints is incorrect", expectedDif, ActualDiffPositive);
        Assert.assertEquals("The diff of Negative ints is incorrect", expectedDiffPositive, ActualDiffNegative);
        Assert.assertEquals("The diff of Zero is incorrect", expectedDiffZero, ActualDiffPozitiveAndZero);
    }
}
