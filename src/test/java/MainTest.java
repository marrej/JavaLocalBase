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
    void getAmountOfPalindromes1() {
        assertEquals(4, codeWorker.getPalindromeAmounts("abbaab"));
    }

    @Test
    void getAmountOfPalindromes2() {
        assertEquals(7, codeWorker.getPalindromeAmounts("ababaab"));
    }

    @Test
    void getAmountOfPalindromes3() {
        assertEquals(877221835, codeWorker.getPalindromeAmounts("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbsactmlkomoyauuqgxomkcrhcyspeezmbyhdejfhyyrljuaslagvbpnxwkcfffrxziduubhmiohjvammfqigjvxtmopwonkgdyrpxostlpjyxyumwwteraioobereucxcnpggndgjhkjzsynlugkojzkcxpzenlkujgmgkyaazczqracebdvewozmfwqrmdyfexgbjleztekjcbbqlbnbevcxuvglmblmbdhapfywlndyybynuykqrdjcyakgddflotdennunuqccytqposgaiouoaapigdbsmbotrdzpquqwfyttblbazyjxqzdbzpibvadecgmusskjedbzjblhlnulkslomhatxjleoslcxokhdrgrqttbtrlcoafomxzpkhqtyyotzpozykcnuhdxswkxwdtxpseeirictakqomlouvvdbkuwbydkqunwfoxczhtgyxraiieapudazlfyjcmdsvlztdlyicrgpivituhuwnszewcxhilpgcxturivvpelddnstkdjnfmriqiwmskegkshiiypntzplmoyalgtlclbfbjffvicoazgxncyobbemaosqgdnsflkqnwujljzsszdywdpwhopkvdhvgdyvdfxfwqnlrrmawqqfpvusoqnqfnuwkuepobhlqwajzpqemqhaoczmdpfsqjwsnoirmxuikvzqncwycqlspnaldnzzwgkftanmssofwpmsnokzqwodbgtqjeoerkichxyzibiaxehyypxtzpoacdhzfvlxddooyvnbcgajkacishkjjqztcdkzcwomncszvxwjmlswsydpqbppnhcmttatiuqopcqofiqwkkblwuwykcwggvokvhefpkwfbhijoqrikgrsojgkcsaurqyvvpptpmllsleyltrspekttkfvjtonrdadzgtmqpfdnypjriqsvkvuufbjvablfuflvujfhgeroxfklgxhasenuivnahkwnikohpiqgnpeuv"));
    }

    @Test
    void closePosition() {
        Map<String, List<Integer>> letterPositions = new HashMap<>();
        SortedSet<Integer> closedPositions = new TreeSet<>(java.util.Collections.reverseOrder());
        Map<Integer, Integer> closedPositionAmounts = new HashMap<>();
        letterPositions.put("a", new ArrayList<>(Arrays.asList(1,2,3)));
        var letter = "a";
        var pos = 4;


        SortedSet<Integer> expectedClosedPositions = new TreeSet<>(java.util.Collections.reverseOrder());
        Map<Integer, Integer> expectedClosedPositionAmounts = new HashMap<>();
        closedPositions.add(1);
        closedPositions.add(2);
        closedPositionAmounts.put(1,2);
        closedPositionAmounts.put(2,1);

        expectedClosedPositions.add(1);
        expectedClosedPositions.add(2);
        expectedClosedPositions.add(3);
        expectedClosedPositionAmounts.put(1,3);
        expectedClosedPositionAmounts.put(2,2);
        expectedClosedPositionAmounts.put(3,1);

        codeWorker.closePosition(letter, 4, letterPositions, closedPositions, closedPositionAmounts);
        assertEquals(expectedClosedPositions, closedPositions);
        assertEquals(expectedClosedPositionAmounts, closedPositionAmounts);
    }
}