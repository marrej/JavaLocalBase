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

    public Long getMaximum(List<Long> array, Long modulo) {
        SortedSet<Long> set = new TreeSet<>();
        set.add(Long.valueOf(0));
        Long maximum = Long.valueOf(0);
        Long prefix = Long.valueOf(0);


        for (var i = 0 ; i < array.size(); i ++) {
            var actualNumber = array.get(i);
            prefix = Long.remainderUnsigned(Long.sum(actualNumber, prefix), modulo);
            maximum = Long.max(prefix, maximum);
            var lowerBound = this.binarySearchOnSet(prefix + 1, set);
            if (Long.compare(-1L, lowerBound) != 0) {
                maximum = Long.max(maximum, Long.sum(Long.sum(prefix, -lowerBound), modulo));
            }
            set.add(prefix);
        }
        return maximum;
    }

    public Long binarySearchOnSet(Long prefix, SortedSet<Long> set) {
        if (set.last() < prefix) {
            return -1L;
        }
        return set.tailSet(prefix).first();
    }
}
