package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Transaction {

    private Map<String, TransferClient> transfers = new TreeMap<>();

    public List<TransferClient> readFileAndMakeTransferClient(Path path) {
        List<TransferClient> result = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                String sourceClientId = lineSplit[0];
                String targetClientId = lineSplit[1];
                int amount = Integer.parseInt(lineSplit[2]);
                result.add(new TransferClient(sourceClientId));
                result.get(counter).decrease(amount);
                result.add(new TransferClient(targetClientId));
                result.get(counter+1).increase(amount);
                counter += 2;
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!");
        }
        return result;
    }

    public void transferToMap(Path path) {
        List<TransferClient> readF = readFileAndMakeTransferClient(path);
        for (TransferClient tr: readF) {
            TransferClient transfer = transfers.get(tr.getClientId());
            if (transfer == null) {
                transfer = new TransferClient(tr.getClientId(), tr.getSum());
                transfers.put(tr.getClientId(), transfer);
            } else {
                transfer.increase(tr.getSum());
                transfers.put(tr.getClientId(), transfer);
            }
        }
    }

    public Map<String, TransferClient> getTransfers() {
        return transfers;
    }

    public void writeResult() {
        List<TransferClient> results = new ArrayList<>(transfers.values());
        for (TransferClient tr: results) {
            System.out.printf("%s %,12d %5d\n", tr.getClientId(), tr.getSum(), tr.getNumberOfTransaction());
        }
    }
}
