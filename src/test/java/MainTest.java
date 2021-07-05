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
    void isIllegalOperation() {
        int[][] originalMatrix = new int[][]{new int[]{1,2}, new int[]{3,4}};
        var rows = 1;
        var columns = 5;
        assertEquals(Arrays.equals(originalMatrix, codeWorker.getTransposedMatrix(originalMatrix, rows, columns)), true);
    }

    @Test
    void transposedToRow() {
        int[][] originalMatrix = new int[][]{new int[]{1,2}, new int[]{3,4}};
        var rows = 1;
        var columns = 4;
        int[][] trasposedMatrix = new int[][]{new int[]{1,2,3,4}};
        var outputMatrix = codeWorker.getTransposedMatrix(originalMatrix, rows, columns);
        for (var i=0;i<trasposedMatrix.length;i++) {
            for (var j=0;j<trasposedMatrix[i].length;j++) {
                System.out.println(trasposedMatrix[i][j] + "  " + outputMatrix[i][j]);
            }
        }
        assertEquals(Arrays.equals(trasposedMatrix, outputMatrix), true);
    }
}