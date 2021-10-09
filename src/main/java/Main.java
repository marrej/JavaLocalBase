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
        var amountOfValuesToTheLeft = 0;
        var skipTill = 0;

        Optional<Integer> lastValueNaive = Optional.ofNullable(null);
        var gapNaive = 0;
        var amountOfStepsNaive = 0;



        for (var i = 0 ; i < sortedValues.size(); i++) {
            var value = sortedValues.get(i);
            if (lastValue.isEmpty()) {
                lastValue = Optional.ofNullable(value);
                lastValueNaive = Optional.ofNullable(value);
                amountOfValuesToTheLeft++;
            } else {
                var smallerValue = lastValue.get();
                var shiftedUpperValue = (value+gap);
                if (i > skipTill) {
                    int amountOfValuesToTheRight = getValueRepetition(sortedValues, i, value);
                    skipTill = i+amountOfValuesToTheRight-1;


                    var gapBetweenValues = shiftedUpperValue - smallerValue;

                    Optional<Integer> finalStepsForThisPair = Optional.ofNullable(null);
                    var additionalValueForTheOverflow = 0;

                    for (var q=0;q<=5;q++) {
                        var upperBound = gapBetweenValues+q;
                        var leftSideSteps =getStepsToTakeForThis(Arrays.asList(0,upperBound));
                        var rightSideSteps = getStepsToTakeForThis(Arrays.asList(0,q));

                        var actualJoinedValueSteps = ( leftSideSteps * amountOfValuesToTheRight ) + (rightSideSteps * amountOfValuesToTheLeft);

                        if (finalStepsForThisPair.isEmpty()) {
                            finalStepsForThisPair = Optional.ofNullable(actualJoinedValueSteps);
                        } else {
                            var finalSteps = finalStepsForThisPair.get();
                            if (finalSteps > actualJoinedValueSteps) {
                                finalStepsForThisPair = Optional.ofNullable(actualJoinedValueSteps);
                                additionalValueForTheOverflow = q;
                            }
                        }

                    }

                    amountOfSteps += finalStepsForThisPair.get();
                    var actualGapForPair = amountOfValuesToTheRight * (gapBetweenValues + additionalValueForTheOverflow) + amountOfValuesToTheLeft * additionalValueForTheOverflow;
                    gap += actualGapForPair;

                    var additionalGapForLastValue = amountOfValuesToTheRight > 1 ? actualGapForPair : 0;
                    lastValue = Optional.ofNullable(shiftedUpperValue + additionalGapForLastValue); // this is the problem the shift does not work correctly
                    amountOfValuesToTheLeft+= amountOfValuesToTheRight;
                    System.out.println("NonNaive");
                    System.out.println("Value:  " + value + " LastValue " + lastValue.get() + " gap: " + gap + " added gap: " + actualGapForPair + " ammountOfSteps: " + amountOfSteps);
                }
                // naive implementation
                smallerValue = lastValueNaive.get();
                shiftedUpperValue = value + gapNaive;
                var distanceSmallerToBigger = shiftedUpperValue - smallerValue;
                var stepsForThisDistance = getStepsToTakeForThis(Arrays.asList(smallerValue, shiftedUpperValue));
                gapNaive += distanceSmallerToBigger;
                amountOfStepsNaive += stepsForThisDistance;
                lastValueNaive = Optional.ofNullable(shiftedUpperValue);
                System.out.println("Naive");
                System.out.println("Value:  " + value +" LastValue " + lastValueNaive.get() + " gap: " + gapNaive + " added gap: " + distanceSmallerToBigger + " ammountOfSteps: " + amountOfStepsNaive);
            }
        }

        return amountOfSteps;
    }

    private int getValueRepetition(List<Integer> sortedValues, int i, Integer value) {
        var valueRepetition = 1;
        for (var j = i + 1; j < sortedValues.size(); j++) {
            if (sortedValues.get(j) == value) {
                valueRepetition++;
            } else {
                break;
            }
        }
        return valueRepetition;
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

