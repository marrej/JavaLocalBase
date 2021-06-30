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
    void getConsecutiveOnes() {
        int[] arr = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        // 0,0,1,1,1*,1*,1,1,1,1*,1,1,0,0,0,1,1,1,1
        assertEquals(10, codeWorker.longestOnes(arr,3));
    }

    @Test
    void getConsecutiveOnes3() {
        int[] arr = new int[]{1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        // 1,1,1,0,0,1*,1,1,1,1,1*
        assertEquals(25, codeWorker.longestOnes(arr,8));
    }

    @Test
    void getConsecutiveOnes2() {
        int[] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        // 1,1,1,0,0,1*,1,1,1,1,1*
        assertEquals(6, codeWorker.longestOnes(arr,2));
    }

    @Test
    void getConsecutiveOnesSimple() {
        int[] arr = new int[]{1,1,1};
        assertEquals(3, codeWorker.longestOnes(arr,2));
    }

    @Test
    void getConsecutiveOnesSimple2() {
        int[] arr = new int[]{0,1,1,1,0};
        assertEquals(5, codeWorker.longestOnes(arr,2));
    }

    @Test
    void getConsecutiveOnesSimple3() {
        int[] arr = new int[]{0,1,1,1,0};
        assertEquals(4, codeWorker.longestOnes(arr,1));
    }

    @Test
    void getConsecutiveOnesSimple4() {
        int[] arr = new int[]{0,1,0,0,1,1,0};
        assertEquals(3, codeWorker.longestOnes(arr,1));
    }
}