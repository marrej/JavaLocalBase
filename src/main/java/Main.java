import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {

    private List<Integer> list;
    private Integer searchValue;

    public String testMethod() {
        return "method";
    }

    public Integer binarySearch(List<Integer> list, Integer searchingValue) {
        this.list = list;
        this.searchValue = searchingValue;
//        return this.recursiveBinary(0, list.size() - 1);
        return this.iterativeBinary();
    }


    private Integer iterativeBinary() {
        var l = 0;
        var r = this.list.size() -1;
        while (l <= r) {
            var mid = l + ((r - l)/2);
            var midValue = this.list.get(mid);
            if (midValue == this.searchValue) {
                return midValue;
            } else if (midValue < this.searchValue) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }

        return null;
    }






    private Integer recursiveBinary(Integer left, Integer right) {
        if (left > right) {return null;};
        var mid = left+((right-left)/2);

        var midValue = list.get(mid);
        if (midValue == this.searchValue) {
            return midValue;
        } else if (midValue < this.searchValue) {
            return this.recursiveBinary(mid + 1, right);
        } else {
            return this.recursiveBinary(left, mid - 1);
        }
    }
}

