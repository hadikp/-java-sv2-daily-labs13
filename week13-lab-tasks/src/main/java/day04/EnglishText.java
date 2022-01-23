package day04;

import java.util.Map;
import java.util.TreeMap;

public class EnglishText {

    private Map<Character, Integer> vowels = new TreeMap<>();

    public void makeMapFromText(String text) {
        for (int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);
           if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
               Integer  value = vowels.get(letter);
               if (value == null) {
                   vowels.put(letter, 1);
               } else {
                   vowels.put(letter, value+1);
               }
           }
        }
    }

    public Map<Character, Integer> getVowels() {
        return vowels;
    }
}
