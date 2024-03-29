import java.util.*;
import java.util.stream.Collectors;

public class StudClass {

    private static List<StudClass> allStudClassList = new ArrayList<>();
    private static List<StudClass> archivedStudClassList = new ArrayList<>();
    private Teacher headTeacher;
    private String nameOfClass;
    private Map<Subjects, List<Teacher>> ClassTeachersBySubject;
    //more than 1 teacher can teach a subject for a certain class

    public StudClass(Teacher headTeacher, String nameOfClass) {
        this.headTeacher = headTeacher;
        this.nameOfClass = nameOfClass;
        ClassTeachersBySubject = new HashMap<>();
    }

    public StudClass addToList() {
        allStudClassList.add(this);
        return this;
    }

    public void archive() {
        allStudClassList.remove(this);
        archivedStudClassList.add(this);
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

    public Map<Subjects, List<Teacher>> getClassTeachersBySubject() {
        return ClassTeachersBySubject;
    }

    public void setClassTeachersBySubject(Map<Subjects, List<Teacher>> classTeachersBySubject) {
        ClassTeachersBySubject = classTeachersBySubject;
    }

    public static List<StudClass> getAllStudClassList() {
        return allStudClassList;
    }

    public static List<StudClass> getArchivedStudClassList() {
        return archivedStudClassList;
    }

    @Override
    public String toString() {
        int[] index = new int[]{1};
        StringBuilder sbStudent = new StringBuilder();
        StringBuilder sbTeacher = new StringBuilder();

        Student.getAllStudentList().stream()
                .filter(student -> student.getStudClassString().equals(this.nameOfClass))
                .map(student -> student.getName())
                .sorted(Comparator.comparing(Name::getLastName))
                .forEach(i -> sbStudent.append("\t\t " + index[0]++ + "." + i + System.lineSeparator()));

        getClassTeachersBySubject().keySet().stream()
                .sorted(Comparator.comparing(Subjects::getSubjectName))
                .forEach(key -> {
                    sbTeacher.append("\t\t " + key.getSubjectName() + ": ");
                    getClassTeachersBySubject().get(key).forEach(teacher -> sbTeacher.append(teacher + ", "));
                    sbTeacher.delete(sbTeacher.length() - 2, sbTeacher.length() - 1);
                    sbTeacher.append(System.lineSeparator());
                });

        return "Osztály: " + nameOfClass + System.lineSeparator() +
                "\t Osztályfőnök: " + headTeacher + System.lineSeparator() +
                "\t Tanárok: " + System.lineSeparator() + sbTeacher + System.lineSeparator() +
                "\t Tanulók: " + System.lineSeparator() + sbStudent + System.lineSeparator();
    }
}
