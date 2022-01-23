package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnglishTextTest {

    @Test
    void testMakeMapFromText() {
        EnglishText englishText = new EnglishText();
        englishText.makeMapFromText("specialist");
        System.out.println(englishText.getVowels());
    }

}