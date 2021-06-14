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
    void getMapAndSetFromInput() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,3,5,6));
        Set<Integer> outSet = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,5,6)));
        Map<Integer, Integer> outMap = new HashMap<>();
        outMap.put(1,1);
        outMap.put(2,1);
        outMap.put(3,2);
        outMap.put(5,1);
        outMap.put(6,1);
        MapSet output = new MapSet(outMap, outSet);
        assertEquals(true, output.equals(codeWorker.getMapSet(input)));
    }

    @Test
    void getDiffSum4() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,3,5,6));
        int diff = 1;
        assertEquals(4, codeWorker.getDiffSum(input, diff));
    }

    @Test
    void getDiffSum10() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,2,2,3,3,5,6));
        int diff = 1;
        assertEquals(10, codeWorker.getDiffSum(input, diff));
    }

    @Test
    void getDiffSum5() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,2,2,3,3,5,6));
        int diff = 3;
        assertEquals(5, codeWorker.getDiffSum(input, diff));
    }

    @Test
    void getDiff1For3() {
        Set<Integer> outSet = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,5,6)));
        Map<Integer, Integer> outMap = new HashMap<>();
        outMap.put(1,1);
        outMap.put(2,1);
        outMap.put(3,2);
        outMap.put(5,1);
        outMap.put(6,1);
        MapSet mapSet = new MapSet(outMap, outSet);
        int difference = 1;
        int findFor = 3;
        assertEquals(0, codeWorker.getDiff(mapSet, difference, findFor));
    }

    @Test
    void getDiff2For3() {
        Set<Integer> outSet = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,5,6)));
        Map<Integer, Integer> outMap = new HashMap<>();
        outMap.put(1,1);
        outMap.put(2,1);
        outMap.put(3,2);
        outMap.put(5,1);
        outMap.put(6,1);
        MapSet mapSet = new MapSet(outMap, outSet);
        int difference = 2;
        int findFor = 3;
        assertEquals(2, codeWorker.getDiff(mapSet, difference, findFor));
    }

    @Test
    void getDiff6For2() {
        Set<Integer> outSet = new HashSet<>(new ArrayList<>(Arrays.asList(1,2,3,5,6)));
        Map<Integer, Integer> outMap = new HashMap<>();
        outMap.put(1,1);
        outMap.put(2,3);
        outMap.put(3,2);
        outMap.put(5,1);
        outMap.put(6,1);
        MapSet mapSet = new MapSet(outMap, outSet);
        int difference = 1;
        int findFor = 2;
        assertEquals(6, codeWorker.getDiff(mapSet, difference, findFor));
    }
}