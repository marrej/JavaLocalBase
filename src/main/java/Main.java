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
        int[] sufficientPeople = this.findSufficientPeople2(matrix);
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

    // iterates only on the remainder of skills and people
    private int[] findSufficientPeople2(int[][] matrix) {
        Set<Integer> peopleToCheck = new HashSet<>();
        Set<Integer> skillsToCheck = new HashSet<>();
        Set<Integer> aquiredPeople = new HashSet<>();


        for (var i=0;i<matrix.length;i++) {
            peopleToCheck.add(i);
        }

        for (var i=0;i<matrix[0].length;i++) {
            skillsToCheck.add(i);
        }


        while(skillsToCheck.size() > 0) {
            var maxPersonValue = 0;
            var maxPerson = 0;
            var actualPeopleToCheck = new HashSet<>(peopleToCheck);
            for (var person: actualPeopleToCheck) {
                var personValue = 0;
                for (var skill: skillsToCheck) {
                    personValue= matrix[person][skill];
                }
                if (personValue == 0) peopleToCheck.remove(person);
                else if (personValue > maxPersonValue) {
                    maxPerson = person;
                    maxPersonValue = personValue;
                }
            }

            aquiredPeople.add(maxPerson);
            peopleToCheck.remove(maxPerson);
            var actualSkillsToCheck = new HashSet<>(skillsToCheck);
            for (var skill: actualSkillsToCheck) {
                var hasSkill = matrix[maxPerson][skill] == 1;
                if (hasSkill) skillsToCheck.remove(skill);
            }
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


class Solver2 {

    private SkillTransformer translator;

    public Solver2() {
        this.translator = new SkillTransformer();
    }


    public int[] solve(String[] req_skills, List<List<String>> people) {
        this.skillToNumberTranscibe(req_skills);
        List<Person> persons = this.retrievePeople(people);
        int[] sufficientPeople = this.findSufficientPeople(persons, req_skills.length);
        return sufficientPeople;
    }

    private int[] findSufficientPeople(List<Person> people, Integer skillNumber) {
        List<Person> sufficientPeople = new ArrayList<>();
        Set<Integer> obtainedSkills = new HashSet<>();

        for (var skillId = 0; skillId < skillNumber; skillId++) {
            if (!obtainedSkills.contains(skillId)) {


                var viablePersons = new ArrayList<Person>();
                for (var person: people) {
                    if(person.skills.contains(skillId)) {
                        var updatedPersonSkillSet = new HashSet<>(person.skills);
                        if (obtainedSkills.size() <= updatedPersonSkillSet.size()) {
                            for (var obtainedSkill: obtainedSkills) {
                                if (person.skills.contains(obtainedSkill)){
                                    updatedPersonSkillSet.remove(obtainedSkill);
                                }
                            }
                        } else {
                            for (var personSkill: person.skills) {
                                if (obtainedSkills.contains(personSkill)){
                                    updatedPersonSkillSet.remove(personSkill);
                                }
                            }
                        }
                        if (updatedPersonSkillSet.size() == 0)  {
                            people.remove(person);
                        } else {
                            person.skills = updatedPersonSkillSet;
                            viablePersons.add(person);
                        }
                    }
                }

                Person personToUse = null;
                var maxPersonSkills = 0;
                for (var person: viablePersons) {
                    var hasMoreSkills = person.skills.size() >= maxPersonSkills;
                    if (hasMoreSkills) {
                        maxPersonSkills = person.skills.size();
                        personToUse = person;
                    }
                }

                for (var skill: personToUse.skills) {
                    obtainedSkills.add(skill);
                }
                sufficientPeople.add(personToUse);
                people.remove(personToUse);
            }
        }
        return sufficientPeople.stream().mapToInt(p -> p.id).toArray();
    }

    private List<Person> retrievePeople(List<List<String>> people) {
        var personIdCounter = 0;
        List<Person> allPeople = new ArrayList<>();
        for (var person: people) {
            List<Integer> skills= new ArrayList<>();
            for (var skill: person) {
                skills.add(this.translator.getSkillId(skill));
            }
            allPeople.add(new Person(personIdCounter, skills));
            personIdCounter++;
        }
        return allPeople;
    }


    private void skillToNumberTranscibe(String[] skills) {
        for (var skill: skills) {
            this.translator.addSkill(skill);
        }
    }


}

class Person {
    public Integer id;
    public Set<Integer> skills;

    public Person(Integer id, List<Integer> skills) {
        this.id = id;
        this.skills = new TreeSet<>(skills);
    }

    public String toString() {
        return this.id + " " + this.skills;
    }
}

