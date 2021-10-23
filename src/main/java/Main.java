import java.util.*;

public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

// input -> m,n map of apartments (all blocks contain apartment)
// for each block hashMap containing the true/false for a type of utility - school/work/...
// input -> list of utilities I value
// find the apartment that has the lowest distance to all my required utilities

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public ApartmentLocation getBestApartment(List<String> utilities, List<List<Map<String, Boolean>>> mapOfUtilities) {
        return new ApartmentMatcher().findMeBestApartment(utilities, mapOfUtilities);
    }
}

class ApartmentMatcher {
    public ApartmentLocation findMeBestApartment(List<String> utilities, List<List<Map<String, Boolean>>> mapOfUtilities) {
        // initialize the base distances for all utilities
        List<List<Integer>> apartmentDistanceList = new ArrayList<>();
        ApartmentLocation minLocation = null;

        for (var b = 0; b < utilities.size(); b ++) {
            List<List<Integer>> apartmentMatrixForUtility = new ArrayList<>();
            var actualUtility = utilities.get(b);
            for (var i =0; i< mapOfUtilities.size(); i++) {
                List<Integer> apartmentMatrixRow = new ArrayList<>();
                for (var j=0; j < mapOfUtilities.get(i).size(); j++) {
                    var isActualUtilityHere = mapOfUtilities.get(i).get(j).get(actualUtility);
                    if (isActualUtilityHere) {
                        apartmentMatrixRow.add(0);
                    } else {
                        var leftValue = Integer.MAX_VALUE;
                        var topValue = Integer.MAX_VALUE;
                        if (j>0) leftValue = apartmentMatrixRow.get(j-1);
                        if (i>0) topValue = apartmentMatrixForUtility.get(i-1).get(j);

                        var valueToSetOnCell = Integer.min(leftValue, topValue);
                        if (leftValue == Integer.MAX_VALUE && topValue == Integer.MAX_VALUE) {
                            apartmentMatrixRow.add(Integer.MAX_VALUE);
                        } else {
                            apartmentMatrixRow.add(valueToSetOnCell+1);
                        }



                    }
                }
                apartmentMatrixForUtility.add(apartmentMatrixRow);
            }

            for (var i =mapOfUtilities.size()-1; i>= 0; i--) {
                var apartmentMatrixRow = apartmentMatrixForUtility.get(i);
                for (var j=mapOfUtilities.get(i).size()-1; j >= 0; j--) {
                    var actualApartmentDistance = apartmentMatrixRow.get(j);

                    var rightValue = Integer.MAX_VALUE;
                    var bottomValue = Integer.MAX_VALUE;
                    if (j<mapOfUtilities.size()-1) rightValue = apartmentMatrixRow.get(j+1);
                    if (i<mapOfUtilities.size()-1) bottomValue = apartmentMatrixForUtility.get(i+1).get(j);

                    var minimumOfValues = Integer.min(rightValue, bottomValue);
                    Integer valueToSetOnCell;
                    if (minimumOfValues == Integer.MAX_VALUE) {
                        valueToSetOnCell = actualApartmentDistance;
                    } else {
                        valueToSetOnCell = Integer.min(Integer.min(rightValue, bottomValue)+1, actualApartmentDistance);
                    }


                    apartmentMatrixRow.set(j, valueToSetOnCell);
                }
                apartmentMatrixForUtility.set(i, apartmentMatrixRow);
            }
            System.out.println(apartmentMatrixForUtility);


            if (apartmentDistanceList.size() == 0) {
                apartmentDistanceList = apartmentMatrixForUtility;
            }
            var minimumValue = Integer.MAX_VALUE;
            for (var i = 0; i< mapOfUtilities.size(); i++) {
                for (var j = 0; j< mapOfUtilities.size(); j++) {
                    var actualDistance = apartmentDistanceList.get(i).get(j);
                    actualDistance = Integer.max(actualDistance, apartmentMatrixForUtility.get(i).get(j));
                    apartmentDistanceList.get(i).set(j, actualDistance);

                    // store the minimal apartment
                    if (actualDistance < minimumValue) {
                        minimumValue = actualDistance;
                        minLocation = new ApartmentLocation(i, j);
                    }
                }
            }
            System.out.println(apartmentDistanceList);
        }
        return minLocation;
    }
}




class ApartmentLocation {
    public Integer x;
    public Integer y;

    public ApartmentLocation(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}

