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
    void returnEncryptedString() {
        var input = "have a nice day";
        var output = "hae and via ecy";
        assertEquals(output, codeWorker.encrypt(input));
    }

    @Test
    void returnEncryptedString2() {
        var input = "feedthedog";
        var output = "fto ehg ee dd";
        assertEquals(output, codeWorker.encrypt(input));
    }

    @Test
    void returnEncryptedString3() {
        var input = "feedthedo";
        var output = "fde etd eho";
        assertEquals(output, codeWorker.encrypt(input));
    }

    @Test
    void testMethod() {
        assertEquals(codeWorker.testMethod(), "method");
    }

    @Test
    void stripSpaces() {
        String input = "and it done";
        String output = "anditdone";
        assertEquals(output, codeWorker.strip(input));
    }

    @Test
    void getRowAndColSize() {
        String input = "anditdone";
        List<Integer> rowAndCol = new ArrayList<>(Arrays.asList(
                3,3
        ));
        assertEquals(rowAndCol, codeWorker.getRowAndColumn(input));
    }

    @Test
    void getRowAndColSize2nd() {
        String input = "anditdoneasdfga";
        List<Integer> rowAndCol = new ArrayList<>(Arrays.asList(
                4,4
        ));
        assertEquals(rowAndCol, codeWorker.getRowAndColumn(input));
    }

    @Test
    void getRowAndColSize3rd() {
        String input = "anditdoneasdf";
        List<Integer> rowAndCol = new ArrayList<>(Arrays.asList(
                4,4
        ));
        assertEquals(rowAndCol, codeWorker.getRowAndColumn(input));
    }

    @Test
    void getRowAndColSize4th() {
        String input = "anditdoneasd";
        List<Integer> rowAndCol = new ArrayList<>(Arrays.asList(
                3,4
        ));
        assertEquals(rowAndCol, codeWorker.getRowAndColumn(input));
    }

    @Test
    void rowXcolHasToBeEqualOrBiggerThanTheStrippedString() {
        Integer stringLength = 11;
        Integer lowRoot = 3;
        Integer highRoot = 4;
        List<List<Integer>> roots = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3,4)),
                new ArrayList<>(Arrays.asList(4,4))
        ));
        assertEquals(roots, codeWorker.getCombinationsBiggerOrEqualThanStringLength(11,3,4));
    }

    @Test
    void ifMultipleColRowConfigurationsAreFoundUseTheOneWithSmallestArea() {
        List<List<Integer>> combinations = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(3,4)),
                new ArrayList<>(Arrays.asList(4,4))
        ));
        List<Integer> expected = new ArrayList<>(Arrays.asList(3,4));
        assertEquals(expected, codeWorker.getSmallestArea(combinations));
    }

    @Test
    void splitTheTextInTheColRowMatrix() {
        var input = "haveaniceday";
        List<Integer> rowAndCol = new ArrayList<>(Arrays.asList(3,4));
        List<List<String>> expectedMatrix = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("h","a","v","e")),
                new ArrayList<>(Arrays.asList("a","n","i","c")),
                new ArrayList<>(Arrays.asList("e","d","a","y"))
        ));
        assertEquals(expectedMatrix,codeWorker.getEncryptMatrix(input, rowAndCol));
    }
}