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
    void getCenterElement1() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1));
        Integer centerElement = 1;
        assertEquals(centerElement, codeWorker.getCenterElement(arr));
    }

    @Test
    void getCenterElement5() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,2,5,4));
        Integer centerElement = 5;
        assertEquals(centerElement, codeWorker.getCenterElement(arr));
    }

    @Test
    void getNoCenterElement15() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,1,1,15,4));
        Integer centerElement = 15;
        assertEquals(centerElement, codeWorker.getCenterElement(arr));
    }

    @Test
    void getNoCenterElement() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,3,5,4));
        Integer centerElement = -1;
        assertEquals(centerElement, codeWorker.getCenterElement(arr));
    }

    @Test
    void isNoCenterElement() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals("NO", codeWorker.isCenterElement(arr));
    }

    @Test
    void isCenterElement() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,3));
        assertEquals("YES", codeWorker.isCenterElement(arr));
    }

    @Test
    void isCenterElement2() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,0,0,0));
        assertEquals("YES", codeWorker.isCenterElement(arr));
    }

    @Test
    void isCenterElement3() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0,0,0,2));
        assertEquals("YES", codeWorker.isCenterElement(arr));
    }

    @Test
    void isCenterElement4() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(0,2,0,0));
        assertEquals("YES", codeWorker.isCenterElement(arr));
    }

    @Test
    void isCenterElement5() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,1,4,1,1));
        assertEquals("YES", codeWorker.isCenterElement(arr));
    }

}