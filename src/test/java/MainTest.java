import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void getSummerGrow3() {
        Integer actualHeight = 2;
        assertEquals(3, codeWorker.getSummerGrowth(actualHeight));
    }

    @Test
    void getSummerGrow4() {
        Integer actualHeight = 3;
        assertEquals(4, codeWorker.getSummerGrowth(actualHeight));
    }

    @Test
    void getSpringGrow6() {
        Integer actualHeight = 3;
        assertEquals(6, codeWorker.getSpringGrowth(actualHeight));
    }

    @Test
    void getSpringGrow12() {
        Integer actualHeight = 6;
        assertEquals(12, codeWorker.getSpringGrowth(actualHeight));
    }

    @Test
    void getGrowthFor1Cycles() {
        Integer cycles = 1;
        assertEquals(2, codeWorker.getCycleGrowth(cycles));
    }

    @Test
    void getGrowthFor2Cycles() {
        Integer cycles = 2;
        assertEquals(3, codeWorker.getCycleGrowth(cycles));
    }

    @Test
    void getGrowthFor4Cycles() {
        Integer cycles = 4;
        assertEquals(7, codeWorker.getCycleGrowth(cycles));
    }

    @Test
    void getGrowthFor5Cycles() {
        Integer cycles = 5;
        assertEquals(14, codeWorker.getCycleGrowth(cycles));
    }

    @Test
    void getGrowthFor0Cycles() {
        Integer cycles = 0;
        assertEquals(1, codeWorker.getCycleGrowth(cycles));
    }
}