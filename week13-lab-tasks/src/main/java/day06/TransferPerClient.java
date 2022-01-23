package day06;

public class TransferPerClient {

    private String clientId;
    private int sum;
    private int numberOfTransaction;

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
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
        return clientId +", sum=" + sum +", " + numberOfTransaction;
    }
}
