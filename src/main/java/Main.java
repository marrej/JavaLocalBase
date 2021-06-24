
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
