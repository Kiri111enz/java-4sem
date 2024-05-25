package org.prac_1;

import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Comparator<String> myComparator = (String str, String str2) -> {
            Pattern pattern = Pattern.compile("[0-9]+");
            int str1NumCounter = 0;
            Matcher matcherString1 = pattern.matcher(str);
            while (matcherString1.find()) {
                str1NumCounter += Integer.parseInt(matcherString1.group(0));
            }
            int str2NumCounter = 0;
            Matcher matcherString2 = pattern.matcher(str2);
            while (matcherString2.find()) {
                str2NumCounter += Integer.parseInt(matcherString2.group(0));
            }
            return Integer.compare(str1NumCounter, str2NumCounter);
        };
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        System.out.println(myComparator.compare(input1, input2));
    }
}