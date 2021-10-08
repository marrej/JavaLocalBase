import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
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
    void baseTest() {
        List<Integer> inputs = new ArrayList<>(Arrays.asList(1,2,2,4));
        var calculatedResult = this.codeWorker.minimalAmountOfActions(inputs);
        assertEquals(3, calculatedResult);
    }

    @Test
    void baseTest2() {
        List<Integer> inputs = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        var calculatedResult = this.codeWorker.minimalAmountOfActions(inputs);
        assertEquals(6, calculatedResult);
    }
}