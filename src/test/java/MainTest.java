import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private CodeWorker codeWorker;

    @BeforeEach
    public void setUp() throws Exception{
        codeWorker = new CodeWorker();
    }

    @Test
    void testMethod() {
        assertEquals(codeWorker.testMethod(), "method");
    }

    @Test
    void baseTest() {
        List<Integer> inputs = new ArrayList<>(Arrays.asList(1,2,2,4));
        var calculatedResult = this.codeWorker.minimalAmountOfActions(inputs);
        assertEquals(4, calculatedResult);
    }

    @Test
    void baseTest2() {
        List<Integer> inputs = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        var calculatedResult = this.codeWorker.minimalAmountOfActions(inputs);
        assertEquals(6, calculatedResult);
    }

    @Test
    void pushingForwardTest() {
        List<Integer> inputs = Arrays.asList(2,2,2,2,5,5,5,5);
        assertEquals(8, this.codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void pushingForwardTest2() {
        List<Integer> inputs = Arrays.asList(2,15,15,15,4,4,4); // [2,4] 1*3, [8,21] 4*3
        assertEquals(15, this.codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void stepsForPair() {
        assertEquals(1, codeWorker.getStepsToTakeForThis(Arrays.asList(0,1)));
        assertEquals(1, codeWorker.getStepsToTakeForThis(Arrays.asList(0,2)));
        assertEquals(1, codeWorker.getStepsToTakeForThis(Arrays.asList(0,5)));
        assertEquals(2, codeWorker.getStepsToTakeForThis(Arrays.asList(0,10)));
        assertEquals(2, codeWorker.getStepsToTakeForThis(Arrays.asList(0,3)));
        assertEquals(2, codeWorker.getStepsToTakeForThis(Arrays.asList(0,6)));
        assertEquals(2, codeWorker.getStepsToTakeForThis(Arrays.asList(0,7)));
        assertEquals(8, codeWorker.getStepsToTakeForThis(Arrays.asList(0,33)));
        assertEquals(2367, codeWorker.getStepsToTakeForThis(Arrays.asList(200,12031)));
    }

    @Test
    void smallTestSet() {
        List<Integer> inputs = Arrays.asList(5,17,22,24,31,36);
        assertEquals(25, codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void smallTestSet2() {
        List<Integer> inputs = Arrays.asList(1,5,5);
        assertEquals(3, codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void smallTestSet4() {
        List<Integer> inputs = Arrays.asList(1,5,5,5,5,5);
        assertEquals(6, codeWorker.minimalAmountOfActions(inputs));
    }


    @Test
    void largeTest() {
        List<Integer> inputs = Arrays.asList(53,361,188,665,786,898,447,562,272,123,229,629,670,848,994,54,822,46,208,17,449,302,466,832,931,778,156,39,31,777,749,436,138,289,453,276,539,901,839,811,24,420,440,46,269,786,101,443,832,661,460,281,964,278,465,247,408,622,638,440,751,739,876,889,380,330,517,919,583,356,83,959,129,875,5,750,662,106,193,494,120,653,128,84,283,593,683,44,567,321,484,318,412,712,559,792,394,77,711,977,785,146,936,914,22,942,664,36,400,857);
        assertEquals(10605, this.codeWorker.minimalAmountOfActions(inputs));
    }

    @Test
    void largerTests() {
        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList(902,832,837,361,531,418,245,222,445,902,424,831,497,487,90,983,873,489,61,948,707,186,228,451,396,978,780,641,394,984,15,648,816,204,10,347,622,607,921,68,861,346,251,710,185,342,45,58,183,458,6,890,644,587,341,392,917,473,34,312,458,401,960,626,605,322,326,228,281,247,296,494,945,899,556,130,241,601,188,776,59,547,666,56,134,360,448,51,833,834,363,643,235,676,622,841,350,948,69,632,547,717,126,493,616,683,975,210,636,164,338,48,711,5,456,197,365,256,248,550,91,964,194,326,640,816,519,990,116,940,974,663,657,453,508,626,488,484,188,124,0,526,172,711,883,628,260,600,237,508,151,328,824,697,6,464,865,526,807,333,466,133,348,476,586,857,454,74,693,994,551,693,872)));
        assertEquals(8049, this.codeWorker.minimalAmountOfActions(Arrays.asList(756,756,56,16,356,293,876,859,621,701,908,627,517,125,505,676,458,972,810,807,800,396,16,254,823,709,248,726,402,120,801,510,228,209,878,937,502,754,148,475,455,57,455,973,182,960,649,993,284,811,800,84,560,816,690,735,525,290,461,279,411,614,141,991,824,19,928,326,773,429,802,581,486,257,906)));
        assertEquals(1723, this.codeWorker.minimalAmountOfActions(Arrays.asList(569,907,13,854,719,813,938,279,981,629,14,506,271,475,137,34,89,278,26,265)));
        assertEquals(4810, this.codeWorker.minimalAmountOfActions(Arrays.asList(306,592,423,735,746,356,573,3,262,594,572,169,959,426,888,773,717,519,106,698,885,965,969,360,102,4,802,733,382,67,382,688,11,157,776,757,513,349,112,775,943,37,297,903,815,185,28,532,57)));
        assertEquals(12793, this.codeWorker.minimalAmountOfActions(Arrays.asList(582,942,451,552,655,554,908,809,639,290,228,373,330,240,531,106,349,44,456,462,172,751,499,469,6,314,6,386,199,415,873,781,358,324,685,13,230,945,174,869,587,402,243,918,994,126,24,344,522,832,158,694,584,9,515,942,323,874,329,874,289,202,656,999,526,693,364,757,991,538,626,578,293,221,496,287,347,873,983,870,57,141,916,993,150,784,936,826,658,265,700,299,467,708,299,345,402,15,102,393,554,81,323,847,302,820,486,2,45,470,224,102,611,492,96,114,276,384,940,286,649,640,586,468,701,237,813,455,252,268,848,158,349,523)));
        assertEquals(15252, this.codeWorker.minimalAmountOfActions(Arrays.asList(3,343,844,357,740,666,581,195,277,74,643,743,702,27,683,989,28,676,927,496,377,516,661,832,120,929,32,279,278,555,988,282,251,832,639,343,498,573,538,128,999,181,223,701,208,907,690,236,935,969,84,312,485,746,496,606,675,528,237,306,435,225,940,38,410,931,382,260,504,920,740,503,454,964,557,14,223,599,603,158,569,687,822,406,785,318,12,461,198,601,767,633,179,59,672,941,990,406,201,495,326,294,350,132,258,907,147,833,507,750,991,428,437,813,834,575,131,199,36,681,800,155,314,979,214,338,272,556,96,474,51,423,120,754,907,378,13,54,563,520,804,554,300,594,367,135,169,850,334,557,531,486,64,197,818,630,888)));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));
//        assertEquals(16980, this.codeWorker.minimalAmountOfActions(Arrays.asList()));

    }
}