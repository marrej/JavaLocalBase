
public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return this.doDepthSearch(m,n,startColumn,startRow,maxMove);
    }

    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        // +2 to have the boundary padding
        var currentTable = new int[m+2][n+2];
        var pastTable = new int[m+2][n+2];
        for (var i = 1; i<=m; i++) {
            pastTable[i][1] += 1;
            pastTable[i][n] += 1;
        }

        // this is the table for the distance 1
        for (var i = 1; i<=n; i++) {
            pastTable[1][i] += 1;
            pastTable[m][i] += 1;
        }
        var answer = pastTable[startRow+1][startColumn+1];

        for (var i = 1; i < maxMove; i++) {
            for (var j = 1; j<=m; j++) {
                for (var q = 1; q<=n; q++) {
                    currentTable[j][q] = this.addAndModularize(this.addAndModularize(this.addAndModularize(pastTable[j-1][q], pastTable[j+1][q]), pastTable[j][q - 1]), pastTable[j][q+1]);
                }
            }
            answer = this.addAndModularize(answer, currentTable[startRow+1][startColumn+1]);
            pastTable = currentTable;
            // can not forget to clear the current table -> because we are passing refferences around
            currentTable = new int[m+2][n+2];
        }


        return answer;
    }

    public Integer doDepthSearch(Integer height, Integer width, Integer x, Integer y, Integer maxMove) {
        var sum = 0;

        if (x < 0 || x >= width || y < 0 || y >= height) {
            return 1;
        }

        if (x+maxMove < width && x-maxMove >= 0 && y+maxMove < height && y-maxMove >= 0) {
            return 0;
        }

        if (maxMove == 0) {
            return 0;
        }

        if (x >= 0) {
            // left
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x-1,y,maxMove-1));
        }

        if (x < width) {
            // right
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x+1,y,maxMove-1));
        }

        if (y >= 0) {
            // top
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x,y-1,maxMove-1));
        }

        if (y < height) {
            // bottom
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x,y+1,maxMove-1));
        }


        return sum;
    }

    public Integer addAndModularize(Integer sum, Integer adder) {
        var modulo = 1000000007;
        var possibleSum = sum + adder;

        if (possibleSum < 0 || possibleSum > modulo) {
            var diff = sum - modulo;
            return adder + diff;
        }

        return possibleSum;
    }
}
