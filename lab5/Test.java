package lab5;

import java.util.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        BitSequence bitSequence = new BitSequence(new int[]{5, 6, 7});

        System.out.println("Count of set bits in each number:");
        bitSequence.countSetBits().forEach(System.out::println);

        // 5 = 00000000000000000000000000000101
        // 6 = 00000000000000000000000000000110
        // 7 = 00000000000000000000000000000111
        System.out.println("\nStream of positions of set bits:");
        bitSequence.streamSetBitPositions().forEach(System.out::println);

        Optional<Integer> result = bitSequence.findX();
        result.ifPresentOrElse(
            x -> System.out.println("\nNumber x satisfying the condition: " + x),
            () -> System.out.println("\nNo such number found.")
        );

        Map<Integer, List<Integer>> groupedPositions = bitSequence.streamSetBitPositions()
                .collect(Collectors.groupingBy(pos -> pos / 32));

        System.out.println("\nGrouped positions:");
        groupedPositions.forEach((key, value) -> System.out.println("Group " + key + ": " + value));
    }
}
