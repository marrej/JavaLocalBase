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

    public String isCenterElement(List<Integer> arr) {
        if (this.getCenterElement(arr) == -1) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public Integer getCenterElement(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr.get(0);
        }
        var leftPointer = -1;
        var leftSum = 0;
        var rightPointer = arr.size();
        var rightSum = 0;


        while (rightPointer - leftPointer > 2) {
            if (leftSum <= rightSum) {
                leftPointer++;
                leftSum += arr.get(leftPointer);
            } else {
                rightPointer--;
                rightSum += arr.get(rightPointer);
            }
        }

        if (rightSum != leftSum) {
            leftSum -= arr.get(leftPointer);
            rightSum += arr.get(rightPointer-1);
        }

        if (rightSum == leftSum) {
            return arr.get(leftPointer + 1);
        }

        return -1;
    }
}
