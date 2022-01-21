package day05;

public class TransferClient {

    private String clientId;
    private int sum;
    private int numberOfTransaction;

    public TransferClient(String clientId) {
        this.clientId = clientId;
    }

    public TransferClient(String clientId, int sum) {
        this(clientId);
        this.sum = sum;
        this.numberOfTransaction = 1;
    }

    public void increase(int amount) {
        this.sum += amount;
        this.numberOfTransaction++;
    }

    public void decrease(int amount) {
        this.sum -= amount;
        this.numberOfTransaction++;
    }

    public String getClientId() {
        return clientId;
    }

    public int getSum() {
        return sum;
    }

    public int getNumberOfTransaction() {
        return numberOfTransaction;
    }

    @Override
    public String toString() {
        return clientId + ", sum=" + sum +"," + numberOfTransaction;
    }
}
