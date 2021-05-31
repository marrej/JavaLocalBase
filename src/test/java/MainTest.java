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
    void getSet() {
        List<Integer> ranked = new ArrayList<>(Arrays.asList(80,20,60,40,20,60,30,80));
        Set<Integer> rankedSet = new HashSet<>(Arrays.asList(80,20,60,40,30));
        assertEquals(rankedSet, codeWorker.getRankedSet(ranked));
    }

    @Test
    void getSortedList() {
        Set<Integer> rankedSet = new HashSet<>(Arrays.asList(80,20,60,40,30));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        assertEquals(sortedList, codeWorker.getSortedList(rankedSet));
    }

    @Test
    void getPlayerPosition1st() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        Integer playerScore = 105;
        Integer expectedPosition = 1;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition1stWhenThereIs1Ranked() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(100));
        Integer playerScore = 105;
        Integer expectedPosition = 1;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition2ndWhenThereIs1Ranked() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(100));
        Integer playerScore = 99;
        Integer expectedPosition = 2;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition6st() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        Integer playerScore = 12;
        Integer expectedPosition = 6;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition3rdWhenTheScoreIsTheSame() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        Integer playerScore = 40;
        Integer expectedPosition = 3;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition3rdWithBST() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        Integer playerScore = 45;
        Integer expectedPosition = 3;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition5rdWithBST() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        Integer playerScore = 21;
        Integer expectedPosition = 5;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPosition3rdWithBSTv2() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        Integer playerScore = 59;
        Integer expectedPosition = 3;
        assertEquals(expectedPosition, codeWorker.getPlayerPositon(playerScore, rankedSortedScore));
    }

    @Test
    void getPlayerPositions() {
        List<Integer> rankedSortedScore = new ArrayList<>(Arrays.asList(80,60,40,30,20));
        List<Integer> playerScores = new ArrayList<>(Arrays.asList(87,33,29,3,61));
        List<Integer> expectedPositions = new ArrayList<>(Arrays.asList(1,4,5,6,2));
        assertEquals(expectedPositions, codeWorker.getPlayerPositons(playerScores, rankedSortedScore));
    }
}