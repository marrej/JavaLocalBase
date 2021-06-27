import java.util.ArrayList;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {


    public Integer getCandyTotal(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        var countAtPosition = new ArrayList<Integer>();
        var sum = 0;

        var lastPeakPosition = -1;
        var growthCounter = 0;
        var descendingCounter = 0;
        for (var i = 0; i < ratings.length ; i++) {
            var actual = ratings[i];
//            System.out.println("----");
//            System.out.println(actual);
            if (i+1 < ratings.length) {
                var next = ratings[i+1];
//                System.out.println(next);
                if (actual < next) {
//                    System.out.println("GROW");
                    // growing here
                    // if the growth counter is already rising just add another and store the value
                    // if we have descending counter, then clear the descending counter and start growing
                    if (descendingCounter > 0) {
                        var descendedCount = 1 + descendingCounter;
                        countAtPosition.add(descendedCount);
                        descendingCounter = 0;
                        if (lastPeakPosition != -1) { // ensures that the peak has the maximum candies it needs
                            var peak = countAtPosition.get(lastPeakPosition);
                            var bottom = countAtPosition.get(i);
                            var max = Math.max(peak, 1+bottom);
//                            System.out.println(peak + " " + bottom + 1 + " " + max);
                            countAtPosition.set(lastPeakPosition,max);
                        }
                    } else {
                        countAtPosition.add(1 + growthCounter);
                    }
                    growthCounter++;
                } else if (actual > next) {
                    // dropping here
                    if (growthCounter > 0) {
                        countAtPosition.add(1 + growthCounter);
                        growthCounter = 0;

//                        System.out.println("LAST PEAK " + lastPeakPosition);
                    } else {
                        countAtPosition.add(1 + descendingCounter);
                        descendingCounter++;
                    }

                    if (descendingCounter == 0) {
                        lastPeakPosition = i;
                    }
                } else {
                    if (growthCounter > 0) {
                        countAtPosition.add(1 + growthCounter);
                        growthCounter = 0;
                    } else {
                        countAtPosition.add(1 + descendingCounter);
                        descendingCounter = 0;
                        if (lastPeakPosition != -1) { // ensures that the peak has the maximum candies it needs
                            var peak = countAtPosition.get(lastPeakPosition);
                            var bottom = countAtPosition.get(i);
                            var max = Math.max(peak, 1+bottom);
//                            System.out.println(peak + " " + bottom + 1 + " " + max);
                            countAtPosition.set(lastPeakPosition,max);
                        }
                    }
                    lastPeakPosition=-1;
                }
            } else {
                // the last element
                countAtPosition.add(1 + descendingCounter + growthCounter);
                if (descendingCounter > 0) {
                    if (lastPeakPosition != -1) { // ensures that the peak has the maximum candies it needs
                        var peak = countAtPosition.get(lastPeakPosition);
                        var bottom = countAtPosition.get(i);
                        var max = Math.max(peak, 1+bottom);
                        countAtPosition.set(lastPeakPosition,max);
                    }
                }
            }
//            System.out.println(countAtPosition);
        }

        for (var item: countAtPosition) {
            sum += item;
        }

//        System.out.println(countAtPosition);

        return sum;
    }
}
