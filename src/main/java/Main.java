import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public int[][] getTransposedMatrix(int[][] inputMatrix,Integer rows,Integer columns) {
        var matrixHeight = inputMatrix.length;
        if (matrixHeight == 0) {
            return inputMatrix;
        }
        var matrixWidth = inputMatrix[0].length;
        var originalMatrixSize = matrixHeight*matrixWidth;
        var newMatrixSize = rows*columns;
        var isTheNewMatrixLegal = originalMatrixSize == newMatrixSize;
        if (!isTheNewMatrixLegal) {
            return inputMatrix;
        }

        var deserializedMatrix = this.getDeserializedMatrix(inputMatrix);
        var updatedMatrix = this.buildNewMatrixFromList(deserializedMatrix, rows, columns);
        return updatedMatrix;
    }

    public int[][] buildNewMatrixFromList(List<Integer> deserializedList, Integer rows, Integer columns) {
        var newMatrix = new int[rows][columns];
        for (var i=0;i<rows;i++) {
            for (var j=0;j<columns;j++) {
                var rowAndColumnOffset = i*columns + j;
                newMatrix[i][j] = deserializedList.get(rowAndColumnOffset);
            }
        }
        return newMatrix;
    }

    private List<Integer> getDeserializedMatrix(int[][] inputMatrix) {
        List<Integer> deserializedMatrix = new ArrayList<>();
        for (var row: inputMatrix) {
            for (var column: row) {
                deserializedMatrix.add(column);
            }
        }
        return deserializedMatrix;
    }
}
