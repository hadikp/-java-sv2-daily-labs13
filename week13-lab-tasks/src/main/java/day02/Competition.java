package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Competition {

    private List<Racer> racerList = new ArrayList<>();

    private Map<String, String> racersMap = new TreeMap<>();
    private Map<String, Integer > result = new TreeMap<>();
    private String goodAnswer;

    public void makeReacerList(String filName) {
        try(BufferedReader br = Files.newBufferedReader(Path.of(filName))) {
            String line;
            setGoodAnswer(br.readLine());
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                racerList.add(new Racer(lineSplit[0], lineSplit[1]));
            }
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Can't read file!");
        }
    }

    public void makeRacerMap() {
        for (Racer r: racerList) {
            if (racersMap.containsKey(r.getId())) {
                String value = racersMap.get(r.getId());
                racersMap.put(r.getId(), value.concat(r.getAnswer()));
            } else {
                racersMap.put(r.getId(), r.getAnswer());
            }
        }
    }

    public String isAnswerGood(String racer, int question) {
        String value = racersMap.get(racer);
        char goodAnswerChar = goodAnswer.charAt(question-1);
        if (value.charAt(question-1) == goodAnswerChar) {
            return "A válasz helyes!";
        } else {
            return "A válasz helytelen!";
        }
    }

    public String bestPointsRacer() {
        for (Map.Entry<String, String> m: racersMap.entrySet()) {
            result.put(m.getKey(), countRacerPoints(m));
        }
        int max = 0;
        String bestRacer = "";
        for (Map.Entry<String, Integer> mi: result.entrySet()) {
            if (mi.getValue() > max) {
                max = mi.getValue();
                bestRacer = mi.getKey();
            }
        }
        return bestRacer;
    }

    private int countRacerPoints(Map.Entry<String, String> m) {
        int points = 0;
        String value = m.getValue();
        for (int i = 0; i < 5; i++) {
            if (value.charAt(i) == goodAnswer.charAt(i)) {
                points += i + 1;
            } else if (value.charAt(i) == 'X') {
                points += 0;
            } else {
                points -= 2;
            }
        }
        return points;
    }

    public List<Racer> getRacerList() {
        return racerList;
    }

    public Map<String, String> getRacersMap() {
        return racersMap;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
