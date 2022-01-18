package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    Student peter;
    Student eniko;
    Student jani;
    Student andi;
    ClassNoteBook classNote;

    @BeforeEach
    void init() {
        peter = new Student(3, "Péter");
        eniko = new Student(4, "Enikő");
        jani = new Student(1, "János");
        andi = new Student(2, "Andi");
        classNote = new ClassNoteBook();
        classNote.addStudent(peter);
        classNote.addStudent(eniko);
        classNote.addStudent(jani);
        classNote.addStudent(andi);
    }

    @Test
    void testAddStudent() {
        assertEquals(4, classNote.getStudents().size());
    }

    @Test
    void testAddMark() {
        classNote.addMark(1, 5);
        System.out.println(classNote.getStudents());




    }

}