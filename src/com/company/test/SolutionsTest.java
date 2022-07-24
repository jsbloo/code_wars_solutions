package com.company.test;

import com.company.Solutions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {

    @Test
    void camelCase() {
        assertEquals( "camel Casing", Solutions.camelCase("camelCasing"));
    }

    @Test
    void whoLikesIt() {
    }

    @Test
    void deleteNth() {
        Random random = new Random();
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int maxOccurrences = random.nextInt(10);
            int size = random.nextInt(100);
            int[] testData = IntStream.generate(() -> random.nextInt(size)).limit(size).toArray();
            int[] copyOfTestData = Arrays.copyOf(testData, testData.length);

            cache.clear();

            assertArrayEquals(
                    Arrays.stream(copyOfTestData)
                            .filter(el -> cache.merge(el, 1, Integer::sum) <= maxOccurrences)
                            .toArray(),
                    Solutions.deleteNth(testData, maxOccurrences));
        }
    }

    @Test
    void top3() {
        String t1 = "e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e";
        String t2 = "rr RR rr r'r h h h h zz ll l k op p p OO  p P P k a: ;d";
        String t3 = "  //wont won't won't ";

        assertEquals(Arrays.asList("e","ddd","aa"), Solutions.top3(t1));
        assertEquals(Arrays.asList("p","h","rr"), Solutions.top3(t2));
        assertEquals(Arrays.asList("won't", "wont"), Solutions.top3(t3));
    }

    @Test
    void toRoman(){
        assertEquals("MMMCCXXI", Solutions.toRoman(3221));
    }
}