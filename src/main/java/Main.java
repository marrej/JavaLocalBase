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

    public Integer longestOnes(int[] arr, int k) {
        List<Integer> consequtiveOneGroups = new ArrayList<>();
        List<Integer> consequtiveZeroGroups = new ArrayList<>();

        boolean firstOnes = false;
        boolean addingOnes = false;
        var amountOfZerosLeft = k;
        var maxLength = 0;
        var actualLength = 0;
        for (var i=0; i< arr.length; i++) {
            var element = arr[i];
            var isOne = element == 1;
            if (i == 0) {
                addingOnes = isOne;
                firstOnes = isOne;
            }
            if (isOne) {
                if (isOne == addingOnes) {
                    if (consequtiveOneGroups.size() == 0) {
                        consequtiveOneGroups.add(1);
                    } else {
                        consequtiveOneGroups.set(consequtiveOneGroups.size() - 1,consequtiveOneGroups.get(consequtiveOneGroups.size()-1)+1);
                    }
                } else {
                    // was adding zeroes now adding 1
                    if (actualLength == 0) {
                        actualLength = k - amountOfZerosLeft;
                    }
                    consequtiveOneGroups.add(1);
                }
                actualLength++;
            } else {
                if (!isOne == !addingOnes) {
                    if (consequtiveZeroGroups.size() == 0) {
                        consequtiveZeroGroups.add(1);
                    } else {
                        if (!(consequtiveZeroGroups.size() == 1 && amountOfZerosLeft == 0)) {
                            consequtiveZeroGroups.set(consequtiveZeroGroups.size() - 1,consequtiveZeroGroups.get(consequtiveZeroGroups.size()-1)+1);
                        }
                    }
                } else {
                    // was adding ones now adding 0
                    consequtiveZeroGroups.add(1);
                }
                if (amountOfZerosLeft == 0) {
                    if (firstOnes && consequtiveZeroGroups.size() == 1) {
                        actualLength = 0;
                        //remove all the ones uptill this point
                        consequtiveOneGroups = new ArrayList<>();
                    } else {
                        var firstZeroGroup = consequtiveZeroGroups.get(0) - 1;
                        if (firstOnes && consequtiveOneGroups.size() > 0) {
                            actualLength-=consequtiveOneGroups.get(0);
                            consequtiveOneGroups.remove(0);
                            firstOnes = false;
                        }
                        if (firstZeroGroup == 0) {
                            consequtiveZeroGroups.remove(0);
                            firstOnes = true;
                        } else {
                            consequtiveZeroGroups.set(0, firstZeroGroup);
                        }
                    }

                } else {
                    amountOfZerosLeft--;
                    actualLength++;
                }
            }

//            System.out.println("------");
//            System.out.print(consequtiveOneGroups);
//            System.out.print(consequtiveZeroGroups);
            addingOnes = isOne; // update what we are adding
//            System.out.println("addingOnes: " + addingOnes + "  first Ones: " + firstOnes + " actual Length: " + actualLength);
            maxLength = maxLength < actualLength ? actualLength : maxLength;
        }

        return maxLength;
    }
}
