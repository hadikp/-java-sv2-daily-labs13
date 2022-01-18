package day01;

import java.util.*;

public class ClassNoteBook {

    private Map<Student, List<Integer>> students = new TreeMap<>();


    public void addStudent(Student student) {
        students.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark) {
        for (Map.Entry<Student, List<Integer>> me: students.entrySet()) {
            if (me.getKey().getId() == id) {
                me.getValue().add(mark);
            }
        }
    }

    public Map<Student, List<Integer>> getStudents() {
        return students;
    }
}
