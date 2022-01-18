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
        competition.makeReacer(fileName);
    }

    @Test
    void testsortRaecerList() {
        competition.sorRacerList();

    }

}