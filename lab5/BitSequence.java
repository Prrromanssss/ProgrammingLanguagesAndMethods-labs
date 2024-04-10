package lab5;

import java.util.*;
import java.util.stream.*;

public class BitSequence {
    private final int[] sequence;

    public BitSequence(int[] sequence) {
        this.sequence = sequence;
    }

    public Stream<Integer> countSetBits() {
        return Arrays.stream(sequence)
                .mapToObj(Integer::bitCount);
    }

    public Stream<Integer> streamSetBitPositions() {
        return IntStream.range(0, sequence.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, 32)
                        .filter(j -> (sequence[i] & (1 << j)) != 0)
                        .mapToObj(j -> 32 * i + j));
    }
    
    public Optional<Integer> findX() {
        return IntStream.range(0, sequence.length)
                .filter(i -> Arrays.stream(sequence).allMatch(y -> (sequence[i] | y) == sequence[i]))
                .findFirst()
                .stream()
                .boxed()
                .findFirst();
    }    
}
