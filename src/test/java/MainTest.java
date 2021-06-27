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
    void dropSlope() {
        int[] ratings = new int[]{7,5,4,4,4};
        var candyTotal = 8;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void equalSlope() {
        int[] ratings = new int[]{4,4,4};
        var candyTotal = 3;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void noSlope() {
        int[] ratings = new int[]{4};
        var candyTotal = 1;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void descendingSlope() {
        int[] ratings = new int[]{4,3,2,1};
        var candyTotal = 4 + 6;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void outtertest() {
        int[] ratings = new int[]{1,3,2,2,1};
        var candyTotal = 7;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void slowGrowSlope() {
        int[] ratings = new int[]{1,2,2,3,3,2,2};
        var candyTotal = 10;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void largetest() {
        int[] ratings = new int[]{1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4};
        var total= 47;
        assertEquals(total, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void reallyLargeTest() {
        int[] r = new int[]{58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
        var total = 208;
        assertEquals(total, codeWorker.getCandyTotal(r));
    }

    @Test
    void ascendingSlope() {
        int[] ratings = new int[]{1,2,3,4,5};
        var candyTotal = 15;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }

    @Test
    void rapidlyDescendingSlope() {
        int[] ratings = new int[]{1,5,10,9,8,7,6,5,4,3};
        var candyTotal = 10 + 1 + 7 +6 +5 +4 +3 +2 +1;
        assertEquals(candyTotal, codeWorker.getCandyTotal(ratings));
    }
}