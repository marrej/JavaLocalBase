import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    void testMethod2() {
        Map<String, Boolean> exists = new HashMap<>();
        Map<String, Boolean> NotExists = new HashMap<>();
        exists.put("school",true);
        NotExists.put("school", false);

        var Location = codeWorker.getBestApartment(Arrays.asList("school"), Arrays.asList(Arrays.asList(exists,NotExists,NotExists),Arrays.asList(NotExists,NotExists,NotExists),Arrays.asList(exists,exists,NotExists)));


        assertEquals(Location.x, 0);
        assertEquals(Location.y, 0);
    }


    @Test
    void testMethod3() {
        Map<String, Boolean> exists = new HashMap<>();
        Map<String, Boolean> NotExists = new HashMap<>();
        Map<String, Boolean> None = new HashMap<>();
        exists.put("school",true);
        exists.put("hospital",false);
        NotExists.put("school", false);
        NotExists.put("hospital",true);
        None.put("school", false);
        None.put("hospital",false);


        var Location = codeWorker.getBestApartment(
                Arrays.asList("school", "hospital"),
                Arrays.asList(
                        Arrays.asList(None,None,None,None,None,None),
                        Arrays.asList(None,exists,None,None,None,None),
                        Arrays.asList(None,None,None,None,None,None),
                        Arrays.asList(NotExists,None,exists,None,None,NotExists)
                )
        );


        assertEquals(Location.x, 3);
        assertEquals(Location.y, 1);
    }
}