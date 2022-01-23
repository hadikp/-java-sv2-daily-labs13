package day04;

import java.util.Map;
import java.util.TreeMap;

public class EnglishText {

    private Map<Character, Integer> vowels = new TreeMap<>();

    public void makeMapFromText(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i));
        }
    }
}
