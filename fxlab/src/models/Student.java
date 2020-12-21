package models;

import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Student extends Person implements Serializable {

    private Teacher teacher;
    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Student(String name, String surname, int age, int id) {
        super(name, surname, age,id);
    }
    public Student(String name, String surname, int age, Teacher teacher,int id) {
        super(name, surname, age,id);
        this.teacher = teacher;
    }
    public Student(String name, String surname, int age, int teacherId,int id) {
        super(name, surname, age,id);
        this.teacherId = teacherId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
