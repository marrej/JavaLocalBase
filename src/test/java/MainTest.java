import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private CodeWorker codeWorker;

    @BeforeEach
    public void setUp() throws Exception{
        codeWorker = new CodeWorker();
    }

    @Test
    void testMethod() {
        assertEquals(codeWorker.testMethod(), "method");
    }

    @Test
    void getAbsoluteValFromNegative() {
        Integer input = -5;
        assertEquals(5, codeWorker.getAbsoluteValue(input));
    }

    @Test
    void getAbsoluteValFromPosititve() {
        Integer input = 7;
        assertEquals(7, codeWorker.getAbsoluteValue(input));
    }

    @Test
    void getMagicDiff() {
        List<List<Integer>> inputSquare = new ArrayList<>(Arrays.asList(Arrays.asList(4,9,2),Arrays.asList(3,5,7),Arrays.asList(8,1,5)));
        List<List<Integer>> testSquare = new ArrayList<>(Arrays.asList(Arrays.asList(6,1,8),Arrays.asList(7,5,3),Arrays.asList(2,9,4)));
        assertEquals(39, codeWorker.getMagicDiff(inputSquare, testSquare));
    }

    @Test
    void getSimpleMagicDiff() {
        List<List<Integer>> inputSquare = new ArrayList<>(Arrays.asList(Arrays.asList(4,9,2),Arrays.asList(3,5,7),Arrays.asList(8,1,5)));
        assertEquals(1, codeWorker.applyMagic(inputSquare));
    }
}