package myinterviewcollection.six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SixInterview {

    public static void main(String[] args) {
        System.out.println(SimpleUtils.findNaturalNumber("adere343dfd073dfdfd2"));

        SimpleUtils.printDigits("adere343dfd073dfdfd2");

        SimpleUtils.printDigitsUsingRegex("adere343dfd073dfdfd2");

        SimpleUtils.printDigitsUsingStreams("adere343dfd073dfdfd2");

    }

}

class SimpleUtils {

    public static Long findNaturalNumber(String fAlpsNum) {
        String digitsOnly = fAlpsNum.replaceAll("\\D+", "");
        return Long.parseLong(digitsOnly);
    }

    public static void printDigits(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println("Core Java: " + sb);
    }

    public static void printDigitsUsingRegex(String input) {
        Pattern p = Pattern.compile("\\d+"); // sequences of digits
        Matcher m = p.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group()); // append each digit-sequence (keeps leading zeros)
        }
        System.out.println("Pattern Matching: " + sb);
    }

    public static void printDigitsUsingStreams(String input) {
        String digitsOnly = input.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println("Java8 Stream: " + digitsOnly);
    }

}