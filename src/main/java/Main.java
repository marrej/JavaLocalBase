
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
        return this.doDepthSearch(m,n,startColumn,startRow,maxMove,0);
    }

    public Integer doDepthSearch(Integer height, Integer width, Integer x, Integer y, Integer maxMove, Integer actualSteps) {
        var sum = 0;

        if (x < 0 || x >= width || y < 0 || y >= height) {
            return 1;
        }

        if (actualSteps == maxMove) {
            return 0;
        }

        if (x >= 0) {
            // left
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x-1,y,maxMove,actualSteps+1));
        }

        if (x < width) {
            // right
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x+1,y,maxMove,actualSteps+1));
        }

        if (y >= 0) {
            // top
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x,y-1,maxMove,actualSteps+1));
        }

        if (y < height) {
            // bottom
            sum = this.addAndModularize(sum, this.doDepthSearch(height,width,x,y+1,maxMove,actualSteps+1));
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
