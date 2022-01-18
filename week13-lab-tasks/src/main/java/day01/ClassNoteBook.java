package day01;

import java.util.*;

public class ClassNoteBook {

    private Map<Integer, List<Integer>> students = new TreeMap<>();


    public void addStudent(Student student) {
        students.put(student.getId(), new ArrayList<>());
    }

    public void addMark(int id, int mark) {
        for (Map.Entry me: students.entrySet()) {
            if (me.getKey().equals(id)) {
                students.put(id, Arrays.asList(mark));
            }
        }
    }

    public Map<Integer, List<Integer>> getStudents() {
        return students;
    }
}
