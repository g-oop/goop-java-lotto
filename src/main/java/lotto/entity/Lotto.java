package lotto.entity;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers =  numbers;
    }

    public int calculateMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream().mapToInt(number -> number).filter(winningNumbers::contains).count();
    }
}
