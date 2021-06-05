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

    public String testIfPossible(List<List<Integer>> boxes) {
        var possible = "Possible";
        var impossible = "Impossible";

        var reducedBoxes = this.reduceBoxes(boxes);
        // check if they are really all zeroed out

        return possible;
    }

    public List<List<Integer>> reduceBoxes(List<List<Integer>> boxes) {
        var colorAmount = boxes.size();

        for (var i = 0; i < colorAmount ;i++) {
            var checkedColor = i;
            for (var j = 0; j < colorAmount ;j++) {
                var checkedBox = j;
                var box = boxes.get(checkedBox);
                var color = box.get(checkedColor);

                var isNotYetCleanColor = color != 0;
                if (isNotYetCleanColor) {
                    for (var q = checkedBox + 1; q < colorAmount; q++) {
                        var nextBox = boxes.get(q);
                        if (this.isSwapPossible(checkedColor, box, nextBox)) {
                            var swapped = this.getColorsToSwapAndProceed(checkedColor, box, nextBox);
                            boxes.set(checkedBox, swapped.get(0));
                            boxes.set(q, swapped.get(1));
                        }
                    }
                }
            }
        }

        return boxes;
    }

    public boolean isSwapPossible(Integer color, List<Integer> box1, List<Integer> box2) {
        var colorAmount = box1.get(color);
        var initialClear = this.getClearColors(box1, box2);
        var swappedBoxes = this.getColorsToSwapAndProceed(color, box1, box2);
        var afterUpdateClear = this.getClearColors(swappedBoxes.get(0), swappedBoxes.get(1));
        return afterUpdateClear > initialClear;
    }

    public List<List<Integer>> getColorsToSwapAndProceed(Integer color, List<Integer> box1, List<Integer> box2) {
        var swapableColors = this.getSwappableColors(color, box1, box2);
        return this.swapColors(color, box1, box2, swapableColors);
    }

    public List<List<Integer>> swapColors(Integer color, List<Integer> box1, List<Integer> box2, List<List<Integer>> swappable) {
        var colorToSwap = box1.get(color);
        for (var colorPair: swappable) {
            var colorToSwapForAmount = colorPair.get(0);
            var colorToSwapForPosition = colorPair.get(1);

            if (colorToSwap >= colorToSwapForAmount) {
                box2.set(colorToSwapForPosition, 0);
                box2.set(color, box2.get(color) + colorToSwapForAmount);
                box1.set(color, colorToSwap - colorToSwapForAmount);
                box1.set(colorToSwapForPosition, box1.get(colorToSwapForPosition) + colorToSwapForAmount);
                colorToSwap = box1.get(color);
            } else {
                var difference = colorToSwapForAmount - colorToSwap;
                box2.set(colorToSwapForPosition, difference);
                box2.set(color, box2.get(color) + colorToSwap);
                box1.set(colorToSwapForPosition, box1.get(colorToSwapForPosition) + colorToSwap);
                box1.set(color, 0);
                break;
            }
        }
        return new ArrayList<>(Arrays.asList(box1, box2));
    }

    public List<List<Integer>> getSwappableColors(Integer color, List<Integer> box1, List<Integer> box2) {
        List<List<Integer>> colorsToSwap = new ArrayList<>();
        for (var i = 0; i < box1.size(); i ++) {
            var colorFrom2ndBox = box2.get(i);
            if (i != color && colorFrom2ndBox != 0) {
                var colorFrom1stBox = box1.get(i);
                if (colorFrom1stBox != 0) {
                    colorsToSwap.add(new ArrayList<>(Arrays.asList(colorFrom2ndBox, i)));
                }
            }
        }
        return colorsToSwap;
    }

    public Integer getClearColors(List<Integer> box1, List<Integer> box2) {
        var zeroes = 0;
        for (var color: box1) {
            if (color == 0) {
                zeroes++;
            }
        }

        for (var color: box2) {
            if (color == 0) {
                zeroes++;
            }
        }
        return zeroes;
    }
}
