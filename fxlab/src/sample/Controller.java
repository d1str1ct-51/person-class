package sample;

import variables.Variables;
import enums.Degree;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Person;
import models.Student;
import models.Teacher;
import serializators.PersonSerialization;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    @FXML
    private Button SerializationButton;

    @FXML
    private Button DeserializationButton;

    @FXML
    private TextField teacherName;

    @FXML
    private Button createTeacher;

    @FXML
    private TextField teacherSurname;

    @FXML
    private TextField teacherAge;

    @FXML
    private TextField teacherDegree;

    @FXML
    private TextField teacherCourseWorkId;

    @FXML
    private TextField studentName;

    @FXML
    private TextField studentSurname;

    @FXML
    private TextField studentAge;

    @FXML
    private TextField studentTeaccherId;

    @FXML
    private TextField studentCourseWork;

    @FXML
    private Button createStudent;

    @FXML
    private TextField teacherId;

    @FXML
    private TextField studentId;


    @FXML
    void initialize() {
        createTeacher.setOnAction(event -> {
            if (!teacherId.getText().isEmpty() && !teacherName.getText().isEmpty() && !teacherSurname.getText().isEmpty()
                    && !teacherAge.getText().isEmpty() && !teacherDegree.getText().isEmpty() && !teacherCourseWorkId.getText().isEmpty()) {
                Variables.personList.Add(new Teacher(teacherName.getText(), teacherSurname.getText()
                        , Integer.parseInt(teacherAge.getText()), Degree.PhD, Integer.parseInt(teacherId.getText())));
                System.out.println("Create new Teacher");
                ArrayList<TextField> teacherFields = new ArrayList<>();
                teacherFields.add(teacherAge);
                teacherFields.add(teacherName);
                teacherFields.add(teacherSurname);
                teacherFields.add(teacherDegree);
                teacherFields.add(teacherCourseWorkId);
                teacherFields.add(teacherId);
                this.clearFields(teacherFields);
            } else {
                System.out.println("Empty data");
            }
        });
        //Student
        createStudent.setOnAction(event -> {
            if (!studentId.getText().isEmpty() && !studentName.getText().isEmpty() && !studentSurname.getText().isEmpty()
                    && !studentAge.getText().isEmpty() && !studentTeaccherId.getText().isEmpty() && !studentId.getText().isEmpty()) {
                Variables.personList.Add(new Student(studentName.getText(), studentSurname.getText()
                        , Integer.parseInt(studentAge.getText()), Integer.parseInt(studentTeaccherId.getText()), Integer.parseInt(studentId.getText())));
                System.out.println("q3123333");
                ArrayList<TextField> studentFields = new ArrayList<>();
                studentFields.add(studentAge);
                studentFields.add(studentName);
                studentFields.add(studentSurname);
                studentFields.add(studentTeaccherId);
                studentFields.add(studentId);
                studentFields.add(studentCourseWork);
                this.clearFields(studentFields);
                System.out.println("Create new Student");
            } else {
                System.out.println("Empty data");
            }
        });
        SerializationButton.setOnAction(event -> {
            PersonSerialization personSerialization = new PersonSerialization();
            // Serialization
            for (Person person : Variables.personList.getPersonList()) {
                if (person instanceof Teacher) {
                    personSerialization.Serialization(new File(Variables.rootFolder + "students" + '\\' + person.getName() + person.getId() + ".ser"), person);
                }
                if (person instanceof Student) {
                    personSerialization.Serialization(new File(Variables.rootFolder + "teachers" + '\\' + person.getName() + person.getId() + ".ser"), person);
                }
            }
        });
        DeserializationButton.setOnAction(event -> {
            // Deserialization
            PersonSerialization personSerialization = new PersonSerialization();
            personSerialization.Deserialization(new File(Variables.rootFolder + "students"));
            personSerialization.Deserialization(new File(Variables.rootFolder + "teachers"));
        });
    }

    private void clearFields(ArrayList<TextField> fields) {
        for (TextField textField : fields) {
            textField.setText("");
        }
    }

}
