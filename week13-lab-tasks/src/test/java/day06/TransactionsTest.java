package day06;

import day05.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsTest {

    Transactions transactions;
    Path path;

    @BeforeEach
    void init() {
        transactions = new Transactions();
        path = Path.of("src/test/resources/transfer.csv");
        transactions.makeTransactionsMap(path);
    }

    @Test
    void cantReadFile() {
        path = Path.of("src/test/resources/transfer55.csv");
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> transactions.makeTransactionsMap(path));
        assertEquals("Can't read file!", iae.getMessage());
    }

    @Test
    void testMakeTransaction() {
        assertEquals(20, transactions.getTransaktions().size());
    }

    @Test
    void testWriteResult() {
        transactions.writeResult();
    }

}