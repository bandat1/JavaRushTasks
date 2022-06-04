package com.javarush.task.task34.task3403;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author denis
 */
public class SolutionTest {
    private Solution s;

    @BeforeEach
    public void createNewSolution(){
        s = new Solution();
    }

    @Test
    public void checkIfNumberIsPrime() {
        boolean expected1 = Solution.isPrime(7);
        boolean expected3 = Solution.isPrime(113);
        boolean expected4 = Solution.isPrime(255);
        boolean expected5 = Solution.isPrime(6);

        Assert.assertEquals(expected1, true);
        Assert.assertEquals(expected3, true);
        Assert.assertEquals(expected4, false);
        Assert.assertEquals(expected5, false);
    }

    @Test
    public void recurseShouldOutputAllPrimeNumbers(){
        String example1 = "3 5";
        String example2 = "2 2 2 2";
        String example3 = "113";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        s.recurse(15);
        String result = outputStream.toString();
        Assert.assertEquals(result, example1);

        outputStream.reset();
        s.recurse(16);
        result = outputStream.toString();
        Assert.assertEquals(result, example2);

        outputStream.reset();
        s.recurse(113);
        result = outputStream.toString();
        Assert.assertEquals(result, example3);

        outputStream.reset();
        s.recurse(0);
        result = outputStream.toString();
        Assert.assertEquals(result, "");

        stream.close();

    }
}
