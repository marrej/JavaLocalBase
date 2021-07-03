import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void kClosestToNegative(){
        var k = 3;
        var x = -1;
        var array = new int[]{1,2,3,4,5};
        var result = new ArrayList<Integer>(Arrays.asList(1,2,3));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kClosestToHighest(){
        var k = 3;
        var x = 6;
        var array = new int[]{1,2,3,4,5};
        var result = new ArrayList<Integer>(Arrays.asList(3,4,5));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kClosestToCenter(){
        var k = 3;
        var x = 4;
        var array = new int[]{1,2,3,4,5,6,7};
        var result = new ArrayList<Integer>(Arrays.asList(3,4,5));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kClosestToCenter1(){
        var k = 4;
        var x = 3;
        var array = new int[]{1,2,3,4,5};
        var result = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kClosestToCenter2(){
        var k = 1;
        var x = 9;
        var array = new int[]{1,1,1,10,10,10};
        var result = new ArrayList<Integer>(Arrays.asList(10));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kAll(){
        var k = 3;
        var x = 4;
        var array = new int[]{1,2,3};
        var result = new ArrayList<Integer>(Arrays.asList(1,2,3));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kOne(){
        var k = 1;
        var x = 4;
        var array = new int[]{1,2,3};
        var result = new ArrayList<Integer>(Arrays.asList(3));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kOne2(){
        var k = 1;
        var x = 4;
        var array = new int[]{1,2,5};
        var result = new ArrayList<Integer>(Arrays.asList(5));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }

    @Test
    void kOne3(){
        var k = 1;
        var x = 3;
        var array = new int[]{1,2,5};
        var result = new ArrayList<Integer>(Arrays.asList(2));
        assertEquals(result, codeWorker.findClosestElements(array,k,x));
    }
}