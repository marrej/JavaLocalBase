import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Arrays;
import java.util.Deque;

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
    void moveAllBlocksToLastSpike() {
        Deque<Integer> tower1 = new ArrayDeque<>();
        Deque<Integer> tower2 = new ArrayDeque<>();
        Deque<Integer> tower3 = new ArrayDeque<>();

        Deque<Integer> tower12 = new ArrayDeque<>();
        Deque<Integer> tower32 = new ArrayDeque<>();

        for (var i = 1; i <= 9; i ++) tower1.add(i);

        List<Deque<Integer>> baselayout = Arrays.asList(
                tower1,
                tower2,
                tower3
        );

        List<Deque<Integer>> expectedLayout = Arrays.asList(
                tower12,
                tower2,
                tower32
        );

        var updatedLayout = codeWorker.solveHanoiTowers(baselayout);

        assertEquals(expectedLayout, updatedLayout);

    }
}