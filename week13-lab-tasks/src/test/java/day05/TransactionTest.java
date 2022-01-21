package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    Transaction transaction;
    Path path;

    @BeforeEach
    void init() {
        transaction = new Transaction();
        path = Path.of("src/test/resources/transfer2.csv");
        transaction.readFileAndMakeTransferClient(path);
        transaction.transferToMap(path);
    }

    @Test
    void testreadFile() {

        transaction.writeResult();


    }

}