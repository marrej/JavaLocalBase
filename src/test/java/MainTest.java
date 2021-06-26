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
    void testJoiningFromTwoSubGraphs() {
        int[][] edges = new int[10][2];
        edges[0] = new int[]{9,10};
        edges[1] = new int[]{5,8};
        edges[2] = new int[]{2,6};
        edges[3] = new int[]{1,5};
        edges[4] = new int[]{3,8};
        edges[5] = new int[]{4,9};
        edges[6] = new int[]{8,10};
        edges[7] = new int[]{4,10};
        edges[8] = new int[]{6,8};
        edges[9] = new int[]{7,9};

        var expected = new int[]{4,10};
        var resEdge = codeWorker.findRedundantConnection(edges);
        assertEquals(expected[0], resEdge[0]);
        assertEquals(expected[1], resEdge[1]);
    }
}