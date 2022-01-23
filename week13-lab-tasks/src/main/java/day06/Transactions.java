package day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Transactions {

    private Map<String, TransferPerClient> transaktions = new TreeMap<>();

    public void makeTransactionsMap(Path path) {
        List<String> datas = readFile(path);
        for (String st: datas) {
            String[] transaction = st.split(",");
            String minusAzon = transaction[0];
            String plusAzon = transaction[1];
            int amount = Integer.parseInt(transaction[2]);
            TransferPerClient minusTrans = plusOrMinusTranzakcion(minusAzon);
            minusTrans.decrease(amount);
            TransferPerClient plusTrans = plusOrMinusTranzakcion(plusAzon);
            plusTrans.increase(amount);
        }
    }

    public void writeResult() {
        List<TransferPerClient> result = new ArrayList(transaktions.values());
        for (TransferPerClient st: result) {
            System.out.printf("%s %,12d %5d\n", st.getClientId(), st.getSum(), st.getNumberOfTransaction());
        }
    }

    private TransferPerClient plusOrMinusTranzakcion(String plusOrMinusAzon) {
        TransferPerClient transfer = transaktions.get(plusOrMinusAzon);
        if (transfer == null) {
            transfer =  new TransferPerClient(plusOrMinusAzon);
            transaktions.put(plusOrMinusAzon, transfer);
        }
        return transfer;
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!", ioe);
        }
    }

    public Map<String, TransferPerClient> getTransaktions() {
        return transaktions;
    }
}
