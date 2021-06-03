public class Main {
    public static void main(String[] args) {
        CodeWorker code = new CodeWorker();
        System.out.println(code.testMethod());
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public Integer getSummerGrowth(Integer actualHeight) {
        return actualHeight + 1;
    }

    public Integer getSpringGrowth(Integer actualHeight) {
        return actualHeight * 2;
    }

    public Integer getCycleGrowth(Integer cycles) {
        Integer START_HEIGHT = 1;
        var finalHeightOfTree = START_HEIGHT;
        for (var i = 0; i < cycles; i++) {
            if (i%2 != 0) {
                finalHeightOfTree = this.getSummerGrowth(finalHeightOfTree);
            } else {
                finalHeightOfTree = this.getSpringGrowth(finalHeightOfTree);
            }
        }
        return finalHeightOfTree;
    }
}
