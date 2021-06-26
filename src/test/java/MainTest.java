import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
    void getTheCounts() {
        int[] input = new int[]{5,2,6,1};
        List<Integer> output = new ArrayList<>(Arrays.asList(2,1,1,0));
        assertEquals(output, codeWorker.getCounts(input));
    }

    @Test
    void getTheCounts0() {
        int[] input = new int[]{1,1,1,1,1,1};
        List<Integer> output = new ArrayList<>(Arrays.asList(0,0,0,0,0,0));
        assertEquals(output, codeWorker.getCounts(input));
    }

    @Test
    void getTheCounts2() {
        int[] input = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        List<Integer> output = new ArrayList<>(Arrays.asList(10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0));
        assertEquals(output, codeWorker.getCounts(input));
    }

    @Test
    void getTheCounts3() {
        int[] input = new int[]{26,78,27,100,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        List<Integer> output = new ArrayList<>(Arrays.asList(10,27,10,35,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0));
        assertEquals(output, codeWorker.getCounts(input));
    }


    @Test
    void insertSort1() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,1,2,4));
        var inputVal = 1;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,2,3,4));
        var inputVal = 3;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort5() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,6,7));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,2,5,6,7));
        var inputVal = 5;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,3,6,7));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,2,3,6,7));
        var inputVal = 2;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }
    @Test
    void insertSort10() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,3,6,9,11));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,3,6,9,10,11));
        var inputVal = 10;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort4() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,2,4,4));
        var inputVal = 4;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort1Neg() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> output = new ArrayList<>(Arrays.asList(-1,1,2,4));
        var inputVal = -1;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort8() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,4));
        List<Integer> output = new ArrayList<>(Arrays.asList(1,2,4,8));
        var inputVal = 8;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }

    @Test
    void insertSort8Empty() {
        List<Integer> input = new ArrayList<>(Arrays.asList());
        List<Integer> output = new ArrayList<>(Arrays.asList(8));
        var inputVal = 8;
        codeWorker.insertSort(input,inputVal);
        assertEquals(output, input);
    }
}