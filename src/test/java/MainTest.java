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
    void getTheAreaSum() {
        List<List<Integer>> region = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,0,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,0,0,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,0,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,1,1
                                )
                        )
                )
        );
        assertEquals(8, codeWorker.getAreaSum(region,1,0));
    }

    @Test
    void getTheAreaSum1() {
        List<List<Integer>> region = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,0,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,0,0,1
                                )
                        )
                )
        );

        List<List<Integer>> updatedRegion = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,0,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,0,1
                                )
                        )
                )
        );
        var position = codeWorker.getAreaSum(region,1,0);
        assertEquals(2, position);
        assertEquals(updatedRegion, region);
    }

    @Test
    void getTheMaxArea() {
        List<List<Integer>> region = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1,0,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,1,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,1,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,0,0,0
                                )
                        )
                )
        );
        assertEquals(5, codeWorker.getMaxArea(region));
    }
}