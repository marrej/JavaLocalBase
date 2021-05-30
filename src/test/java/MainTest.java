import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    void getTheElementBreakdown() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,1,2,3,1,2));
        ElementBreakdown elementBreakdown = codeWorker.getElementBreakdown(arr);

        List<Integer> breakdownArray = new ArrayList<>(Arrays.asList(1,2,3));
        Map<Integer, Integer> breakdownMap = new HashMap<>();
        breakdownMap.put(1,2);
        breakdownMap.put(2,3);
        breakdownMap.put(3,1);
        ElementBreakdown newElementBreakdown = new ElementBreakdown(breakdownArray, breakdownMap);
        assertEquals(elementBreakdown.getBreakdownList(), newElementBreakdown.getBreakdownList());
        assertEquals(elementBreakdown.getBreakdownMap(), newElementBreakdown.getBreakdownMap());
    }

    @Test
    void getMaxLengthFromBreakdown() {
        List<Integer> breakdownArray = new ArrayList<>(Arrays.asList(1,2,3));
        Map<Integer, Integer> breakdownMap = new HashMap<>();
        breakdownMap.put(1,2);
        breakdownMap.put(2,3);
        breakdownMap.put(3,1);
        ElementBreakdown newElementBreakdown = new ElementBreakdown(breakdownArray, breakdownMap);
        assertEquals(5, codeWorker.getBreakdownMaxLength(newElementBreakdown));
    }

    @Test
    void getTheMaxSubarray() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,1,2,3,1,2));
        var subArrayLength = codeWorker.getMaxSubArraylength(arr);
        assertEquals(5, subArrayLength);
    }

    @Test
    void getTheMaxSubarray2() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,2,2,4,4,5,5,5));
        var subArrayLength = codeWorker.getMaxSubArraylength(arr);
        assertEquals(5, subArrayLength);
    }

    @Test
    void getTheMaxSubarray3() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4,6,7,6,1,2,1,8,3,4,4,10,5,5,9,4));
        var subArrayLength = codeWorker.getMaxSubArraylength(arr);
        assertEquals(6, subArrayLength);
    }
}