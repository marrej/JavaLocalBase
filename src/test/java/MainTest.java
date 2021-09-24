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
    void testSlotReturnal2() {
        assertEquals(codeWorker.getPositionWhereWeCanBuild(0,1),2);
    }

    @Test
    void testSlotReturnal0() {
        assertEquals(codeWorker.getPositionWhereWeCanBuild(1,2),0);
    }

    @Test
    void testSlotReturnal1() {
        assertEquals(codeWorker.getPositionWhereWeCanBuild(0,2),1);
    }

    @Test
    void moveAllBlocksToLastSpike() throws Exception {
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


        for (var i = 1; i <= 9; i ++) tower32.add(i);

        List<Deque<Integer>> expectedLayout = Arrays.asList(
                tower12,
                tower2,
                tower32
        );

        var updatedLayout = codeWorker.solveHanoiTowers(baselayout);
        assertEquals(this.testTowers(expectedLayout, updatedLayout), true);
    }

    @Test
    void move1BlockToLastSpike() throws Exception {
        Deque<Integer> tower1 = new ArrayDeque<>();
        Deque<Integer> tower2 = new ArrayDeque<>();
        Deque<Integer> tower3 = new ArrayDeque<>();

        Deque<Integer> tower12 = new ArrayDeque<>();
        Deque<Integer> tower32 = new ArrayDeque<>();

        for (var i = 1; i <= 1; i ++) tower1.add(i);

        List<Deque<Integer>> baselayout = Arrays.asList(
                tower1,
                tower2,
                tower3
        );


        for (var i = 1; i <= 1; i ++) tower32.add(i);

        List<Deque<Integer>> expectedLayout = Arrays.asList(
                tower12,
                tower2,
                tower32
        );

        var updatedLayout = codeWorker.solveHanoiTowers(baselayout);
        assertEquals(this.testTowers(expectedLayout, updatedLayout), true);
    }

    public boolean testTowers(List<Deque<Integer>> a, List<Deque<Integer>> b) {
        if (a.size() != b.size()) return false;
        for (var i = 0; i < a.size(); i++) {
            if(!this.testDeques(a.get(i), b.get(i))) return false;
        }
        return true;
    }

    public boolean testDeques(Deque<Integer> a, Deque<Integer> b) {
        if (a.size() != b.size()) return false;
        for (var i = 0; i < a.size(); i++ ) {
            var elementFromA = a.pop();
            var elementFromB = b.pop();
            if (elementFromA != elementFromB) return false;
        }
        return true;
    }


    @Test
    void move2BlockToLastSpike() throws Exception {
        Deque<Integer> tower1 = new ArrayDeque<>();
        Deque<Integer> tower2 = new ArrayDeque<>();
        Deque<Integer> tower3 = new ArrayDeque<>();

        Deque<Integer> tower12 = new ArrayDeque<>();
        Deque<Integer> tower32 = new ArrayDeque<>();

        for (var i = 1; i <= 2; i ++) tower1.add(i);

        List<Deque<Integer>> baselayout = Arrays.asList(
                tower1,
                tower2,
                tower3
        );


        for (var i = 1; i <= 2; i ++) tower32.add(i);

        List<Deque<Integer>> expectedLayout = Arrays.asList(
                tower12,
                tower2,
                tower32
        );

        var updatedLayout = codeWorker.solveHanoiTowers(baselayout);
        assertEquals(this.testTowers(expectedLayout, updatedLayout), true);

    }


    @Test
    void move3BlockToLastSpike() throws Exception {
        Deque<Integer> tower1 = new ArrayDeque<>();
        Deque<Integer> tower2 = new ArrayDeque<>();
        Deque<Integer> tower3 = new ArrayDeque<>();

        Deque<Integer> tower12 = new ArrayDeque<>();
        Deque<Integer> tower32 = new ArrayDeque<>();

        for (var i = 1; i <= 3; i ++) tower1.add(i);

        List<Deque<Integer>> baselayout = Arrays.asList(
                tower1,
                tower2,
                tower3
        );


        for (var i = 1; i <= 3; i ++) tower32.add(i);

        List<Deque<Integer>> expectedLayout = Arrays.asList(
                tower12,
                tower2,
                tower32
        );

        var updatedLayout = codeWorker.solveHanoiTowers(baselayout);
        assertEquals(this.testTowers(expectedLayout, updatedLayout), true);
    }
}