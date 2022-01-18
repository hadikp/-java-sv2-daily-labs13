package day02;

import java.util.List;

public class Racer {

    private String id;
    private String answer;

    public Racer(String id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return id + ": " + answer;
    }
}
