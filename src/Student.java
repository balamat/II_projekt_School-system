import java.time.LocalDate;
import java.util.*;

public class Student {

//    private final String uuid;
    private StudClass studClass;
    private Name name;
//    private Map<Subjects, List<Grade>> subjectAndGradeList;

    public Student(Name name, StudClass studClass) {
//        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.studClass = studClass;
//        this.studClass.getStudentList().add(this);        //ez okozta a StackOverFlow-t
//        this.subjectAndGradeList = new HashMap<>();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

//    public String getUuid() {
//        return uuid;
//    }


//    public Map<Subjects, List<Grade>> getSubjectAndGradeList() {
//        return subjectAndGradeList;
//    }
//
//    public void setSubjectAndGradeList(Map<Subjects, List<Grade>> subjectAndGradeList) {
//        this.subjectAndGradeList = subjectAndGradeList;
//    }

    public StudClass getStudClass() {
        return studClass;
    }

    public void setStudClass(StudClass studClass) {
        this.studClass = studClass;
    }

//    public void addGrade(Subjects subject, String[] grades) {
//        if (!this.getSubjectAndGradeList().containsKey(subject)) {
//            this.getSubjectAndGradeList().put(subject, new ArrayList<Grade>());
//        }
//        this.getSubjectAndGradeList().get(subject).add(new Grade(grades[0], Integer.parseInt(grades[1])));
////        this.getSubjectAndGradeList().getOrDefault(subject, new ArrayList<Grade>()).add(new Grade(grades[0], Integer.parseInt(grades[1])));
//    }

    @Override
    public String toString() {
        return "Student{" +
                "studClass=" + studClass +
                ", name=" + name +
//                ", uuid='" + uuid + '\'' +
//                ", subjectAndGradeList=" + subjectAndGradeList +
                '}';
    }
}

