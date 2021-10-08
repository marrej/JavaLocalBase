import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    final List<Integer> choices = new ArrayList<>(Arrays.asList(5,2,1));

    public int minimalAmountOfActions(List<Integer> startValues) {
        return getSimplisticMinimalSteps(startValues);
    }

    private Integer getSimplisticMinimalSteps(List<Integer> startValues) {
        var sortedValues = startValues.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        Optional<Integer> lastValue = Optional.ofNullable(null);
        var gap = 0;
        var amountOfSteps = 0;

        for (var value: sortedValues) {
            if (lastValue.isEmpty()) {
                lastValue = Optional.ofNullable(value);
            } else {
                var smallerValue = lastValue.get();
                var shiftedUpperValue = (value+gap);
                var distanceSmallerToBigger = shiftedUpperValue - smallerValue;
                var stepsForThisDistance = getStepsToTakeForThis(Arrays.asList(smallerValue, shiftedUpperValue));
                gap += distanceSmallerToBigger;
                amountOfSteps += stepsForThisDistance;
                lastValue = Optional.ofNullable(shiftedUpperValue);
            }
        }

        return amountOfSteps;
    }

    public int getStepsToTakeForThis(List<Integer> pairOfSmallestValues) {
        var stepsToTakeForThisGap = 0;
        var smallestValue = pairOfSmallestValues.get(0);
        var nextInLineValue = pairOfSmallestValues.get(1);
        var gapToFillWithGivenChoices = nextInLineValue - smallestValue;
        for (var choice: choices) {
            if (choice <= gapToFillWithGivenChoices) {
                var remainderAfterRemovingChoice = gapToFillWithGivenChoices % choice;
                var stepsToTakeWithChoice = (gapToFillWithGivenChoices - remainderAfterRemovingChoice) / choice;
                stepsToTakeForThisGap += stepsToTakeWithChoice;
                gapToFillWithGivenChoices = remainderAfterRemovingChoice;
            }
        }
        return stepsToTakeForThisGap;
    }

}

