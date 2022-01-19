package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {

    Competition competition;

    @BeforeEach
    void init() {
        String fileName = "src/test/resources/result.txt";
        competition = new Competition();
        competition.makeReacerList(fileName);
        competition.makeRacerMap();
    }

    @Test
    void testMakeRacerMap() {
        System.out.println(competition.getRacersMap());

    }

    @Test
    void testisAnswerGood() {
        assertEquals("A válasz helyes!", competition.isAnswerGood("GH1234", 1));
        assertEquals("A válasz helytelen!", competition.isAnswerGood("AB123", 2));
    }

    @Test
    void testBestPointsRacer() {
        assertEquals("GH1234", competition.bestPointsRacer());
        System.out.println(competition.getResult());

    }

}