import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private CodeWorker codeWorker;

    @BeforeEach
    public void setUp() throws Exception{
        codeWorker = new CodeWorker();
    }

    @Test
    void is2ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is4ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        997612619,934920795,998879231,999926463
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        960369681,997828120,999792735,979622676
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        999013654,998634077,997988323,958769423
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        997409523,999301350,940952923,993020546
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is9ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        993263231,806455183,972467746,761846174,226680660,667393859,815298761,790313908,997845516
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        873142072,579210472,996344520,999601755,904458846,663577990,980240637,713052540,963408591
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        551159221,873763794,752756532,798803609,670921889,995259612,981339960,763904498,499472207
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        975980611,999974039,729219884,834636710,973988213,969888254,846967495,687204298,511348404
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(993232608,998103218,857820670,995587240,817798750,773950980,824882180,797565274,887424441

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(847857578,768853671,916073200,982234748,986511977,733420232,997714976,819799716,891570083

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(733197334,985682497,612123868,971798655,999905357,710092446,997494889,683312998,850074746

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(799093993,543648222,944524289,814951921,981087922,997222915,506561779,997697933,652807674

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(989362549,973516812,891706714,786904549,982329176,376575034,993535504,984745483,777613376
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is8ColorImpossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(46243313,92616295,67710591,64815435,54972858,72243452,43981963,98839842

                                )
                        ),new ArrayList<>(
                                Arrays.asList(92051933,89794374,13448199,23493279,82268795,11069706,82550576,19654929

                                )
                        ),new ArrayList<>(
                                Arrays.asList(81743395,56456242,80407875,99464396,95594850,44919631,12483256,54576390

                                )
                        ),new ArrayList<>(
                                Arrays.asList(31379865,35550507,13850344,82310457,35039216,11977132,44906966,58819635

                                )
                        ),new ArrayList<>(
                                Arrays.asList(10544893,81324309,69520528,81983330,45347555,78383273,77715274,86346533

                                )
                        ),new ArrayList<>(
                                Arrays.asList(78482611,37125744,47756688,70062813,86629089,81735741,38208033,80479682

                                )
                        ),new ArrayList<>(
                                Arrays.asList(59164275,5441347,85517562,78736923,59124243,51404960,24474089,27179427

                                )
                        ),new ArrayList<>(
                                Arrays.asList(48097170,61680833,13467922,1371525,59776803,85694885,96662368,52983154
                                )
                        )
                )
        );
        assertEquals("Impossible", codeWorker.testIfPossible(list));
    }

    @Test
    void is4ColorPossible2nd() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(990446736,997114107,981378365,996304832

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(998069384,997117556,999915673,983059005

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(977726971,997275340,996964137,999686661

                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(999000949,999267170,999903443,992602611
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is8ColorImpossible2nd() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(95191218,87409555,42950393,42038751,84631134,48464787,59894151,72209295

                                )
                        ),new ArrayList<>(
                                Arrays.asList(10208942,40165003,24468583,74313769,78553469,12298347,92465316,98013853

                                )
                        ),new ArrayList<>(
                                Arrays.asList(11962063,97319173,32772008,57537234,47515651,96327283,13026475,6272697

                                )
                        ),new ArrayList<>(
                                Arrays.asList(15196842,74022651,40230895,29947691,22917615,13671399,53857449,59913669

                                )
                        ),new ArrayList<>(
                                Arrays.asList(12346213,63160025,19794975,11420503,11101182,7020704,99262506,99345314

                                )
                        ),new ArrayList<>(
                                Arrays.asList(63048552,59405595,80841813,57114539,698590,30758610,35361024,19021664

                                )
                        ),new ArrayList<>(
                                Arrays.asList(48021465,59401215,33812089,32481698,38580652,37607783,66478344,64808679

                                )
                        ),new ArrayList<>(
                                Arrays.asList(21875586,87926772,98872000,19211740,76777430,661772,86446637,49124189
                                )
                        )
                )
        );
        assertEquals("Impossible", codeWorker.testIfPossible(list));
    }

    @Test
    void is5ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(979032185,977330496,624547097,994815517,999577525

                                )
                        ),new ArrayList<>(
                                Arrays.asList(539128031,998016416,976111699,872522746,999964658

                                )
                        ),new ArrayList<>(
                                Arrays.asList(997364357,998086547,951266271,999938891,821877010

                                )
                        ),new ArrayList<>(
                                Arrays.asList(988421608,997815396,999690278,997717508,566289150

                                )
                        ),new ArrayList<>(
                                Arrays.asList(999245153,797284221,998318595,710308158,998035207
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }


    @Test
    void is2ColorImpossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );
        assertEquals("Impossible", codeWorker.testIfPossible(list));
    }

    @Test
    void is1ColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        123412340
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void is2HugeColorPossible() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        999336263,998799923
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        998799923,999763019
                                )
                        )
                )
        );
        assertEquals("Possible", codeWorker.testIfPossible(list));
    }

    @Test
    void noProperReductuionOn2Colors() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );

        assertEquals(false, codeWorker.isCorrectlyReduced(list));
    }


    @Test
    void properReductuionOn2Colors() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,0
                                )
                        )
                )
        );

        assertEquals(true, codeWorker.isCorrectlyReduced(list));
    }

    @Test
    void swapIsPossible() {
        var swap = codeWorker.isSwapPossible(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,1998136186
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                1998136186,426756
                        )
                )
        );
        assertEquals(true, swap);
    }

    @Test
    void getHugeColorsToSwap() {
        var swap = codeWorker.getSwappableColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,1998136186
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                1998136186,426756
                        )
                )
        );
        List<List<Integer>> swappable = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1998136186,0
                                )
                        )
                )
        );
        assertEquals(swappable, swap);
    }

    @Test
    void reduce5Colors() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(979032185,977330496,624547097,994815517,999577525

                                )
                        ),new ArrayList<>(
                                Arrays.asList(539128031,998016416,976111699,872522746,999964658

                                )
                        ),new ArrayList<>(
                                Arrays.asList(997364357,998086547,951266271,999938891,821877010

                                )
                        ),new ArrayList<>(
                                Arrays.asList(988421608,997815396,999690278,997717508,566289150

                                )
                        ),new ArrayList<>(
                                Arrays.asList(999245153,797284221,998318595,710308158,998035207
                                )
                        )
                )
        );
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, codeWorker.reduceBoxes(list));
    }

    @Test
    void reduce2HugeColorsDone() {
        List<List<Integer>> list = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        999336263,998799923
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        998799923,999763019
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1998136186,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1998562942
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(list));
    }

    @Test
    void reduce2ColorsDone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,0
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }

    @Test
    void reduce2ColorsNone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }


    @Test
    void reduce3ColorsNone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        1,3,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,1,2
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        3,3,3
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,5
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,5,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        6,2,1
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }

    @Test
    void reduce3ColorsDone() {
        List<List<Integer>> boxes = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,2,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        1,1,1
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        2,0,0
                                )
                        )
                )
        );

        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        3,0,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,3,0
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,2
                                )
                        )
                )
        );
        assertEquals(expected, codeWorker.reduceBoxes(boxes));
    }

    @Test
    void swapColorsWhenSwapperIsBigger() {
        var swap = codeWorker.swapColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,6
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                new ArrayList<>(
                                        Arrays.asList(
                                                6,2
                                        )
                                )
                        )
                )
        );
        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,1,10
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        5,9,0
                                )
                        )
                )
        );
        assertEquals(expected, swap);
    }

    @Test
    void swapColors() {
        var swap = codeWorker.swapColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                new ArrayList<>(
                                        Arrays.asList(
                                                8,2
                                        )
                                )
                        )
                )
        );
        List<List<Integer>> expected = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        0,0,11
                                )
                        ),
                        new ArrayList<>(
                                Arrays.asList(
                                        5,10,1
                                )
                        )
                )
        );
        assertEquals(expected, swap);
    }

    @Test
    void doSwap() {
        var swap = codeWorker.isSwapPossible(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                )
        );

        assertEquals(true, swap);
    }

    @Test
    void getColorsToSwap() {
        var swap = codeWorker.getSwappableColors(
                1,
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                )
        );
        List<List<Integer>> swappable = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(
                                Arrays.asList(
                                        8,2
                                )
                        )
                )
        );
        assertEquals(swappable, swap);
    }

    @Test
    void getZeroes() {
        var clear = codeWorker.getClearColors(
                new ArrayList<>(
                        Arrays.asList(
                                0,7,4
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,3,8
                        )
                )
        );

        assertEquals(1, clear);
    }

    @Test
    void getZeroes4() {
        var clear = codeWorker.getClearColors(
                new ArrayList<>(
                        Arrays.asList(
                                0,7,0
                        )
                ),
                new ArrayList<>(
                        Arrays.asList(
                                5,0,0
                        )
                )
        );

        assertEquals(4, clear);
    }
}