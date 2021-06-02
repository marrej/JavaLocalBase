import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    void getPositionForLetterA() {
        assertEquals(0, codeWorker.getPositionOfLetter('a'));
    }

    @Test
    void getPositionForLetterB() {
        assertEquals(1, codeWorker.getPositionOfLetter('b'));
    }

    @Test
    void getPositionForLetterZ() {
        assertEquals(25, codeWorker.getPositionOfLetter('z'));
    }

    @Test
    void getMaxHeightOfWord7() {
        String word = "zaba";
        List<Integer> heights = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7));
        assertEquals(7, codeWorker.getMaxHeightofWord(word, heights));
    }

    @Test
    void getMaxHeightOfWord3() {
        String word = "azba";
        List<Integer> heights = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,2));
        assertEquals(3, codeWorker.getMaxHeightofWord(word, heights));
    }

    @Test
    void getTheRectangleSize28() {
        String word = "zaba";
        List<Integer> heights = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7));
        assertEquals(28, codeWorker.getRectanleSize(word, heights));
    }

    @Test
    void getTheRectangleSize15() {
        String word = "azbaa";
        List<Integer> heights = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,2));
        assertEquals(15, codeWorker.getRectanleSize(word, heights));
    }
}