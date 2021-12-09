import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void smallestSufficientTeam() {
        var optimilizedPeople = codeWorker.smallestSufficientTeam(new String[]{"java","nodejs","reactjs"}, Arrays.asList(Arrays.asList("java"),Arrays.asList("nodejs"),Arrays.asList("nodejs","reactjs")));
        assertArrayEquals(new int[]{0,2},optimilizedPeople);
    }
}