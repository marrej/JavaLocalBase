import java.io.IOException;
import java.math.BigInteger;

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

    public BigInteger getFactorial(Integer input) {
        if (input == 0) {
            return new BigInteger("0");
        }
        BigInteger bigInteger = new BigInteger("1");
        for (var i = 1 ; i <= input; i++ ) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }
}
