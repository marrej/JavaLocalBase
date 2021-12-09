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

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        return new Solver().solve(req_skills, people);
    }
}



class Solver {

    private SkillTransformer translator;

    public Solver() {
        this.translator = new SkillTransformer();
    }


    public int[] solve(String[] req_skills, List<List<String>> people) {
        this.skillToNumberTranscibe(req_skills);
        var matrix = this.buildHeuristicMatrix(req_skills, people);
        int[] sufficientPeople = this.findSufficientPeople(matrix);
        return sufficientPeople;
    }

    private int[] findSufficientPeople(int[][] matrix) {
        Set<Integer> ignoredPeople = new HashSet<>();
        Set<Integer> aquiredPeople = new HashSet<>();
        Set<Integer> obtainedSkills = new HashSet<>();

        while(obtainedSkills.size() < matrix.length) {
            var maxPersonValue = 0;
            var maxPerson = 0;
            for (var i = 0; i < matrix.length; i++) {
                if (!aquiredPeople.contains(i) && !ignoredPeople.contains(i)) {
                    var person= matrix[i];
                    var personValue = 0;
                    for (var j = 0; j< person.length; j++) {
                        var skill = person[j];
                        if (!obtainedSkills.contains(skill)) personValue+=skill;
                    }
                    if (personValue > maxPersonValue) {
                        maxPerson = i;
                        maxPersonValue = personValue;
                    } else if (personValue == 0) {
                        ignoredPeople.add(i);
                    }
                }
            }

            var personToClear = matrix[maxPerson];
            for (var i = 0; i< personToClear.length; i++) {
                var skill = personToClear[i];
                if (skill >= 1) obtainedSkills.add(i);
            }
            aquiredPeople.add(maxPerson);
        }

        return aquiredPeople.stream().mapToInt(Integer::intValue).toArray();
    }

    private void skillToNumberTranscibe(String[] skills) {
        for (var skill: skills) {
            this.translator.addSkill(skill);
        }
    }

    private int[][] buildHeuristicMatrix(String[] req_skills, List<List<String>> people) {
        var x = req_skills.length;
        var y = people.size();
        int[][] matrix = new int[y][x];

        for (var i=0; i<people.size(); i++) {
            var person = people.get(i);
            for (var skill: person) {
                var positionId = this.translator.getSkillId(skill);
                matrix[i][positionId] = 1;
            }
        }


        return matrix;
    }
}

class SkillTransformer {
    private Map<String, Integer> skillToNumber;
    private Integer idCounter;

    public SkillTransformer() {
        this.idCounter = 0;
        this.skillToNumber = new HashMap<>();
    }

    public void addSkill(String skill) {
        this.skillToNumber.put(skill,this.idCounter);
        this.idCounter++;
    }

    public Integer getSkillId(String skill) {
        return this.skillToNumber.get(skill);
    }
}


