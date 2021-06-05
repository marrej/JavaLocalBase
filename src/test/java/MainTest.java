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
    void is2ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is2ColorImpossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );
        assertEquals("Impossible", codeWorker.testIfPossible(list));
    }

    @Test
    void is1ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        123412340
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is2HugeColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        999336263,998799923
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        998799923,999763019
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void noProperReductuionOn2Colors() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );

        assertEquals(false, codeWorker.isCorrectlyReduced(list));
    }

    @Test
    void properReductuionOn2Colors() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,0
                                )
                        )
                )
        );

        assertEquals(true, codeWorker.isCorrectlyReduced(list));
    }

    @Test
    void reduce2HugeColorsDone() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        999336263,998799923
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        998799923,999763019
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        999336263,998799923
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        998799923,999763019
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(list));
    }

    @Test
    void reduce2ColorsDone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,0
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }

    @Test
    void reduce2ColorsNone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }


    @Test
    void reduce3ColorsNone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,3,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,1,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        3,3,3
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,5
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,5,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        6,2,1
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }

    @Test
    void reduce3ColorsDone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,0,0
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,3,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        3,0,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,2
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }

    @Test
    void swapColorsWhenSwapperIsBigger() {
        var swap = codeWorker.swapColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,6
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                new ArrayList<>(
                                        Arrays.asList(
                                                6,2
                                        )
                                )
                        )
                )
        );
        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,10
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        5,9,0
                                )
                        )
                )
        );
        assertEquals(expected, swap);
    }

    @Test
    void swapColors() {
        var swap = codeWorker.swapColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                new ArrayList<>(
                                        Arrays.asList(
                                                8,2
                                        )
                                )
                        )
                )
        );
        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,11
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        5,10,1
                                )
                        )
                )
        );
        assertEquals(expected, swap);
    }

    @Test
    void doSwap() {
        var swap = codeWorker.isSwapPossible(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                )
        );

        assertEquals(true, swap);
    }

    @Test
    void getColorsToSwap() {
        var swap = codeWorker.getSwappableColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                )
        );
        List<List<Integer>> swappable = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        8,2
                                )
                        )
                )
        );
        assertEquals(swappable, swap);
    }

    @Test
    void getZeroes() {
        var clear = codeWorker.getClearColors(
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                )
        );

        assertEquals(1, clear);
    }

    @Test
    void getZeroes4() {
        var clear = codeWorker.getClearColors(
                new ArrayList<>(
                        Arrays.asList(
                                0,7,0
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,0,0
                        )
                )
        );

        assertEquals(4, clear);
    }
}