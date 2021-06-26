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

    public List<Integer> getCounts(int[] input) {
        List<Integer> sortedPrevious = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for (var i = input.length - 1; i >= 0 ; i--) {
            var in = input[i];
            var inputtedIn = this.insertSort(sortedPrevious, in);
            while (inputtedIn > 2) {
                if (sortedPrevious.get(inputtedIn - 1) == in) {
                    inputtedIn--;
                } else {
                    break;
                }
            }
            output.add(inputtedIn);
//            System.out.println(inputtedIn + " " + in);
//            System.out.println(sortedPrevious);
        }
        Arrays.sort(input);
//        System.out.print("[");
//        for (var i: input) {
//            System.out.print(i + ", ");
//        }
//        System.out.println("-");
//        System.out.println(sortedPrevious);
        Collections.reverse(output);
        return output;
    }

    public Integer insertSort(List<Integer> sorted, Integer input) {
        if (sorted.size() == 0) {
            sorted.add(input);
            return 0;
        }
        var left = 0;
        var right = sorted.size()-1;
        if (sorted.get(left) >= input) {
            sorted.add(0, input);
            return 0;
        }
        if (sorted.get(right) <= input) {
            sorted.add(input);
            return sorted.size() - 1;
        }

        while (right - left > 1) {
            var rightMove = (right - left)/2 + left;
            var rightTry = sorted.get(rightMove);
//            System.out.println(rightMove + " " + rightTry + " " + left + " " + right);
            if (rightTry == input) {
                sorted.add(rightMove,input);
                return rightMove;
            }
            if (rightTry < input) {
                left = rightMove;
            } else {
                right = rightMove;
            }
            if (right - left == 1) {
                sorted.add(right, input);
                return right;
            }
        }
        sorted.add(right, input);
        return right;
    }
}
