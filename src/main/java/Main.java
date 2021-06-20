import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public Integer ifIsConnectedGoDeeper(List<List<Integer>> region, Integer x, Integer y) {
        if (region.get(y).get(x) == 1) {
            return this.getAreaSum(region, x, y);
        }
        return 0;
    }

    public Integer getMaxArea(List<List<Integer>> region) {
        var height = region.size();
        var width = region.get(0).size();
        var maxArea = 0;

        for (var i = 0; i < height; i++) {
            var row = region.get(i);
            for (var j = 0; j < width; j++) {
                var col = row.get(j);
                if (col == 1) {
                    var area = this.getAreaSum(region, j, i);
                    maxArea = maxArea > area ? maxArea : area;
                }
            }
        }
        return maxArea;
    }

    public boolean isLeft(Integer x) {
        return x > 0;
    }

    public boolean isRight(List<Integer> row, Integer x) {
        return x < row.size() - 1;
    }

    public Integer getAreaSum(List<List<Integer>> region, Integer x, Integer y) {
        var actualRow = region.get(y);
        actualRow.set(x, 0); // remove the actual element
        var addedArea = 1;
        //LEFT
        if (this.isLeft(x)) {
            addedArea += this.ifIsConnectedGoDeeper(region, x - 1, y);
        }

        //RIGHT
        if (this.isRight(actualRow, x)) {
            addedArea += this.ifIsConnectedGoDeeper(region, x + 1, y);
        }

        //TOP
        if (y > 0) {
            addedArea += this.ifIsConnectedGoDeeper(region, x, y - 1);
            //TOP LEFT
            if (this.isLeft(x)) {
                addedArea += this.ifIsConnectedGoDeeper(region, x - 1, y - 1);
            }
            //TOP RIGHT
            if (this.isRight(actualRow, x)) {
                addedArea += this.ifIsConnectedGoDeeper(region, x + 1, y - 1);
            }
        }
        //BOTTOM

        if (y < region.size() - 1) {
            addedArea += this.ifIsConnectedGoDeeper(region, x, y + 1);
            //BOT LEFT
            if (this.isLeft(x)) {
                addedArea += this.ifIsConnectedGoDeeper(region, x - 1, y + 1);
            }
            //BOT RIGHT
            if (this.isRight(actualRow, x)) {
                addedArea += this.ifIsConnectedGoDeeper(region, x + 1, y + 1);
            }

        }
        return addedArea;
    }
}
