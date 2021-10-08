import java.util.*;
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
    Map<Integer, Integer> valueCounts = new HashMap<>();
    TreeSet<Integer> uniqueValues = new TreeSet<>();

    public int minimalAmountOfActions(List<Integer> startValues) {

        initializeUniqueValueCountsFor(startValues);
        return getMinimalStepsForBalancedList();
    }

    private Integer getMinimalStepsForBalancedList() {
        var amountOfStepsTaken = 0;
        var gapBetweenTraversedAndNonTraversedSet = 0;
        Optional<Integer> lastValueUsed = Optional.ofNullable(null);

        var amountOfUniqueNumbersToCompareTo = uniqueValues.size() - 1;
        for ( var uniqueValuePosition = 0; uniqueValuePosition < amountOfUniqueNumbersToCompareTo; uniqueValuePosition ++) {
            List<Integer> pairOfSmallestValues = getPairOfSmallestValues(lastValueUsed, gapBetweenTraversedAndNonTraversedSet);
            var hasNoValuesToCompare = pairOfSmallestValues.size() < 2;
            if (hasNoValuesToCompare) {
                return amountOfStepsTaken;
            } else {
                var pairOfSmallestValuesWithGap = addGapToBiggerElement(pairOfSmallestValues, gapBetweenTraversedAndNonTraversedSet);
                amountOfStepsTaken += getStepsToTakeForThis(pairOfSmallestValuesWithGap);
                lastValueUsed =  getLastValueUsed(pairOfSmallestValuesWithGap);
                gapBetweenTraversedAndNonTraversedSet += getGapFromThePair(pairOfSmallestValuesWithGap);
                cleanupTheValueCountsWith(pairOfSmallestValues);
            }
        }
        return amountOfStepsTaken;
    }

    private Optional<Integer> getLastValueUsed(List<Integer> pairOfSmallestValuesWithGap) {
        var biggerValueAfterRunning = pairOfSmallestValuesWithGap.get(1);
        var biggerValueCount = Optional.ofNullable(valueCounts.get(biggerValueAfterRunning));
        return Optional.ofNullable(biggerValueCount.filter((count) -> count > 1).map((count) -> biggerValueAfterRunning + count).orElse(biggerValueAfterRunning));
    }

    private int getGapFromThePair(List<Integer> pairOfSmallestValuesWithGap) {
        var biggerCount = Optional.ofNullable(valueCounts.get(pairOfSmallestValuesWithGap.get(1)));
        var baseGapBetweenPair = pairOfSmallestValuesWithGap.get(1) - pairOfSmallestValuesWithGap.get(0);
        return biggerCount.map(count -> baseGapBetweenPair * count).orElse(baseGapBetweenPair);
    }

    private List<Integer> getPairOfSmallestValues(Optional<Integer> lastValueUsed, Integer gapBetweenTraversedAndNonTraversedSet) {
        var pairOfSmallestValues = uniqueValues.stream().limit(2).collect(Collectors.toList());
        pairOfSmallestValues = ifIsNotFirstIterationUseLastElementAsFirstValue(lastValueUsed, pairOfSmallestValues);
        return pairOfSmallestValues;
    }

    private List<Integer> ifIsNotFirstIterationUseLastElementAsFirstValue(Optional<Integer> lastValueUsed, List<Integer> pairOfSmallestValues) {
        List<Integer> newPairOfSmallestValues = new ArrayList<>(pairOfSmallestValues);
        if (lastValueUsed.isPresent() && newPairOfSmallestValues != null) {
            if (newPairOfSmallestValues.size() > 1) newPairOfSmallestValues.remove(1);
            if (newPairOfSmallestValues.size() > 0) newPairOfSmallestValues.add(0, lastValueUsed.get());
        }
        return newPairOfSmallestValues;
    }

    private List<Integer> addGapToBiggerElement(List<Integer> pairOfSmallestValues, Integer gap) {
        List<Integer> newPair = new ArrayList<>(pairOfSmallestValues);
        if (newPair.size() > 1) {
            newPair.set(1, newPair.get(1) + gap);
        }
        return newPair;
    }

    private void cleanupTheValueCountsWith(List<Integer> pairOfSmallestValues) {
        var smallestValue = pairOfSmallestValues.get(0);
        removeValueFromAllDataStructures(smallestValue);

        var biggerValue = pairOfSmallestValues.get(1);
        removeValueFromAllDataStructures(biggerValue);
    }

    private void removeBiggerValueOnlyIfItWereOccuringOnce(Integer biggerValue) {
        var biggerValueCounts = Optional.ofNullable(valueCounts.get(biggerValue));
        if (biggerValueCounts.isPresent() && biggerValueCounts.get() == 1) {
            removeValueFromAllDataStructures(biggerValue);
        }
    }

    private void removeValueFromAllDataStructures(Integer biggerValue) {
        valueCounts.remove(biggerValue);
        uniqueValues.remove(biggerValue);
    }

    private int getStepsToTakeForThis(List<Integer> pairOfSmallestValues) {
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
        Integer stepsForBiggerNumberCount = increaseGapByCountOfTheValue(pairOfSmallestValues, stepsToTakeForThisGap);
        if (stepsForBiggerNumberCount != null) return stepsForBiggerNumberCount;
        return stepsToTakeForThisGap;
    }

    private Integer increaseGapByCountOfTheValue(List<Integer> pairOfSmallestValues, int stepsToTakeForThisGap) {
        var biggerNumberOccurence = Optional.ofNullable(valueCounts.get(pairOfSmallestValues.get(1)));
        if (biggerNumberOccurence.isPresent()) {
            return biggerNumberOccurence.get()* stepsToTakeForThisGap;
        }
        return null;
    }

    private void initializeUniqueValueCountsFor(List<Integer> startValues) {
        for (var position = 0; position < startValues.size() ; position++) {
            var actualValue = startValues.get(position);
            uniqueValues.add(actualValue);
            incrementValueCountFor(actualValue);
        }
    }

    private void incrementValueCountFor(Integer actualValue) {
        var actualValueCount = Optional.ofNullable(valueCounts.get(actualValue));
        if (actualValueCount.isEmpty()) {
            valueCounts.put(actualValue, 1);
        } else {
            valueCounts.put(actualValue, actualValueCount.get()+1);
        }
    }
}

