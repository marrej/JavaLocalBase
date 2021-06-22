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
    void getAmounOfPalindromes() {
        assertEquals(5, codeWorker.getPalindromeAmounts("abbaab"));
    }

    @Test
    void closePosition() {
        Map<String, List<Integer>> letterPositions = new HashMap<>();
        SortedSet<Integer> closedPositions = new TreeSet<>(java.util.Collections.reverseOrder());
        Map<Integer, Integer> closedPositionAmounts = new HashMap<>();
        letterPositions.put("a", new ArrayList<>(Arrays.asList(1,2,3)));
        var letter = "a";
        var pos = 4;


        SortedSet<Integer> expectedClosedPositions = new TreeSet<>(java.util.Collections.reverseOrder());
        Map<Integer, Integer> expectedClosedPositionAmounts = new HashMap<>();
        closedPositions.add(1);
        closedPositions.add(2);
        closedPositionAmounts.put(1,2);
        closedPositionAmounts.put(2,1);

        expectedClosedPositions.add(1);
        expectedClosedPositions.add(2);
        expectedClosedPositions.add(3);
        expectedClosedPositionAmounts.put(1,3);
        expectedClosedPositionAmounts.put(2,2);
        expectedClosedPositionAmounts.put(3,1);

        codeWorker.closePosition(letter, 4, letterPositions, closedPositions, closedPositionAmounts);
        assertEquals(expectedClosedPositions, closedPositions);
        assertEquals(expectedClosedPositionAmounts, closedPositionAmounts);
    }
}