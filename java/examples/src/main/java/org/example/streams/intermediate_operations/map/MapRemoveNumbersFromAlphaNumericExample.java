package org.example.streams.intermediate_operations.map;

import java.util.List;
import java.util.stream.Collectors;

public class MapRemoveNumbersFromAlphaNumericExample {
    public static void main(String[] args) {
        List<String> alphanumericList = List.of("a12b", "34xyz", "56", "abc", "78d90");
        List<Integer> result = alphanumericList.stream()
                .map(ele -> ele.replaceAll("\\D", ""))
                .filter(ele -> !ele.isBlank())
                .map(Integer::parseInt)
                .toList();

        // alternate way, if we dont know about replaceALL regex.
        List<Integer> result2 = alphanumericList.stream()
                .map(word ->
                        word.chars()
                                .filter(Character::isDigit)
                                .mapToObj(chr -> String.valueOf((char) chr))
                                .collect(Collectors.joining()))
                .filter(ele -> !ele.isBlank())
                .map(Integer::parseInt)
                .toList();

        // alternate way if dont know about isDigit
        List<Integer> result3 = alphanumericList.stream()
                .map(word -> word.chars()
                        .filter(chr -> (chr <= '9' && chr >= '0'))
                        .mapToObj(chr -> String.valueOf((char) chr))
                        .collect(Collectors.joining()))
                .filter(word -> !word.isBlank())
                .map(Integer::parseInt)
                .toList();

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);


    }
}
