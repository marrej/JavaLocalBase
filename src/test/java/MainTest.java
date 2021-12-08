import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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
    void test() {
        List<String> schedule1 = Arrays.asList("10:00-11:30", "15:10-16:20");
        List<String> schedule2 = Arrays.asList("8:00-9:30", "12:00-16:00", "17:20-18:00");
        List<List<String>> schedules = Arrays.asList(schedule1, schedule2);
        List<String> bounds = Arrays.asList("8:00","18:00");
        String meetingLength = "0:45";

        assertEquals(Arrays.asList("16:20-17:20"),codeWorker.getPossibleScheduleTimes(schedules, bounds, meetingLength));
    }

    @Test
    void test2() {
        List<String> schedule1 = Arrays.asList("10:15-11:30", "15:10-16:20");
        List<String> schedule2 = Arrays.asList("8:45-9:30", "12:00-16:00", "17:10-17:15");
        List<List<String>> schedules = Arrays.asList(schedule1, schedule2);
        List<String> bounds = Arrays.asList("8:00","18:00");
        String meetingLength = "0:45";

        assertEquals(Arrays.asList("8:00-8:45","9:30-10:15","16:20-17:20","17:15-18:00"),codeWorker.getPossibleScheduleTimes(schedules, bounds, meetingLength));
    }
}