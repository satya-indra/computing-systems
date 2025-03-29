package org.example.streams.terminal_operations.reduce;

import org.example.streams.models.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Find frequency map
 * the find the minimum or max frequeny element
 *
 */
public class ReduceMostFrequentCharacterInStringExample {
    public static void main(String[] args) {
        String input = "Hhelloo";

        Map<Character, Long> freqMap = input.toLowerCase().strip().chars()
                .filter(c -> (char) c != ' ')
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                c -> c, Collectors.counting()));


        Character result = freqMap.entrySet().stream()
                .reduce(
                        BinaryOperator.minBy(Map.Entry.comparingByValue()))
                .get()
                .getKey();

        System.out.println(result);
    }
}
