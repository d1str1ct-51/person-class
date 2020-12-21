package models;


import enums.Degree;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private Degree Degree;

    public Degree getAcademicDegree() {
        return Degree;
    }

    public void setAcademicDegree(Degree Degree) {
        this.Degree = Degree;
    }

    public Teacher(String name, String surname, int age,int id) {
        super(name, surname, age,id);
    }

    public Teacher(String name, String surname, int age, Degree degree,int id) {
        super(name, surname, age,id);
        this.Degree = degree;
    }

    @Override
    public String toString() {
        return super.toString()
                + "academicDegree='" + Degree;

    }
}
