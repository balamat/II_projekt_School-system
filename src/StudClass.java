import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudClass {

    private static List<StudClass> allStudClassList = new ArrayList<>();
    private Teacher headTeacher;
    private String nameOfClass;
    private List<Student> studentList;
    private Map<Subjects, List<Teacher>> ClassTeachersBySubject;
    //more than 1 teacher can teach a subject for a certain class

    public StudClass(Teacher headTeacher, String nameOfClass) {
        this.headTeacher = headTeacher;
        this.nameOfClass = nameOfClass;
        this.studentList = new ArrayList<>();
        ClassTeachersBySubject = new HashMap<>();
        allStudClassList.add(this);
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Map<Subjects, List<Teacher>> getClassTeachersBySubject() {
        return ClassTeachersBySubject;
    }

    public void setClassTeachersBySubject(Map<Subjects, List<Teacher>> classTeachersBySubject) {
        ClassTeachersBySubject = classTeachersBySubject;
    }

    public static List<StudClass> getAllStudClassList() {
        return allStudClassList;
    }

    @Override
    public String toString() {
        return "Osztály: " + nameOfClass + '-' +
                "osztályfőnök: " + headTeacher;
    }
}
