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
}
