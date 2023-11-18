import java.time.LocalDate;
import java.util.*;

public class ClassDiary {
    private final String uuid;
    private static List<ClassDiary> allClassDiary = new ArrayList<>();
    private LocalDate date;
    private ClassSerial classSerial;
    private Subjects subject;
    private Teacher teacher;
    private StudClass studClass;
    //1 - uuid os student, 2 - reason of absence
    private Map<String, String> absentStudents;

    public ClassDiary(LocalDate date, ClassSerial classSerial, Subjects subject, Teacher teacher, StudClass studClass) {
        this.uuid = UUID.randomUUID().toString();
        this.date = date;
        this.classSerial = classSerial;
        this.subject = subject;
        this.teacher = teacher;
        this.studClass = studClass;
        this.absentStudents = new HashMap<>();
        allClassDiary.add(this);
    }

    public void addAbsentStudent(int absentNumber) {
        for (int i = 0; i < absentNumber; i++) {
            String[] absentAnswers = UserInterface.absentScan();
            Student student = Menu.studentSearch(absentAnswers[0]);
            this.absentStudents.put(student.getUuid(), absentAnswers[1]);
        }
    }

    public static List<ClassDiary> getAllClassDiary() {
        return allClassDiary;
    }

    public static void setAllClassDiary(List<ClassDiary> allClassDiary) {
        ClassDiary.allClassDiary = allClassDiary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ClassSerial getClassSerial() {
        return classSerial;
    }

    public void setClassSerial(ClassSerial classSerial) {
        this.classSerial = classSerial;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StudClass getStudClass() {
        return studClass;
    }

    public void setStudClass(StudClass studClass) {
        this.studClass = studClass;
    }

    public Map<String, String> getAbsentStudents() {
        return absentStudents;
    }

    public void setAbsentStudents(Map<String, String> absentStudents) {
        this.absentStudents = absentStudents;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "ClassDiary{" +
                "date=" + date + System.lineSeparator() +
                ", classSerial=" + classSerial + System.lineSeparator() +
                ", subject=" + subject + System.lineSeparator() +
                ", teacher=" + teacher + System.lineSeparator() +
                ", studClass=" + studClass + System.lineSeparator() +
                ", absentStudents=" + absentStudents +
                '}' + System.lineSeparator();
    }
}
