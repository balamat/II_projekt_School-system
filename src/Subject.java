import java.util.ArrayList;
import java.util.List;

public enum Subject {
    MATHS("Matematika", new ArrayList<>()),
    HUNGARIAN("Magyar", new ArrayList<>()),
    ENGLISH("Angol", new ArrayList<>()),
    GERMAN("Német", new ArrayList<>()),
    HISTORY("Történelem", new ArrayList<>()),
    PHYSICS("Fizika", new ArrayList<>()),
    VISUAL_ARTS("Rajz", new ArrayList<>()),
    MUSIC("Ének", new ArrayList<>()),
    SPORT("Testnevelés", new ArrayList<>()),
    ;

    Subject(String subjectName, List<Teacher> teacherList) {
        this.subjectName = subjectName;
        this.teacherList = teacherList;
    }

    private String subjectName;
    private List<Teacher> teacherList;


}
