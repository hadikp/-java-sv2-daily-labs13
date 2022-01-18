package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Competition {

    private List<Racer> racerList = new ArrayList<>();

    private Map<Racer, String> racers = new TreeMap<>();
    private String goodAnswer;

    public void makeReacer(String filName) {
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

    public void sorRacerList() {
        for (Racer r: racerList) {
            if (Map<Racer, String> m: )
        }
    }

    public List<Racer> getRacerList() {
        return racerList;
    }

    public Map<Racer, String> getRacers() {
        return racers;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }
}
