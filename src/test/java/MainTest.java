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
    void canJumpWithoutPotion() {
        Integer jumpStrength = 7;
        List<Integer> hurdles = new ArrayList<>(Arrays.asList(1,5,2,4,6,2,7));
        assertEquals(0, codeWorker.getAmountOfSips(jumpStrength, hurdles));
    }

    @Test
    void canJumpWithoutPotionWithLowerHurdles() {
        Integer jumpStrength = 7;
        List<Integer> hurdles = new ArrayList<>(Arrays.asList(1,5,2,4,6,2));
        assertEquals(0, codeWorker.getAmountOfSips(jumpStrength, hurdles));
    }

    @Test
    void needs2SipsOfPotion() {
        Integer jumpStrength = 2;
        List<Integer> hurdles = new ArrayList<>(Arrays.asList(1,2,4,2,3));
        assertEquals(2, codeWorker.getAmountOfSips(jumpStrength, hurdles));
    }
}