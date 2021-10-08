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

    @Test
    void pushingForwardTest() {
        List<Integer> inputs = Arrays.asList(2,15,15,15);
        assertEquals(12, this.codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void pushingForwardTest2() {
        List<Integer> inputs = Arrays.asList(2,15,15,15,4,4,4); // [2,4] 1*3, [8,21] 4*3
        assertEquals(15, this.codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void pushingForwardTest3() {
        List<Integer> inputs = Arrays.asList(1,23,23,40,40,101,101,200,200); // [1,23] 5*4 + 2 => 5 * 2, [23+ (23-1) = 45, 40 + (23 -1)*2 = 84] 7*5 + 2*2 = 9 * 2, [123,223]
        assertEquals(150, this.codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void largeTest() {
        List<Integer> inputs = Arrays.asList(53,361,188,665,786,898,447,562,272,123,229,629,670,848,994,54,822,46,208,17,449,302,466,832,931,778,156,39,31,777,749,436,138,289,453,276,539,901,839,811,24,420,440,46,269,786,101,443,832,661,460,281,964,278,465,247,408,622,638,440,751,739,876,889,380,330,517,919,583,356,83,959,129,875,5,750,662,106,193,494,120,653,128,84,283,593,683,44,567,321,484,318,412,712,559,792,394,77,711,977,785,146,936,914,22,942,664,36,400,857);
        assertEquals(10605, this.codeWorker.minimalAmountOfActions(inputs));
    }
}