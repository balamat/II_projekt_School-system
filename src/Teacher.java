import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher implements User {

    private final String uuid;
    private static List<Teacher> allTeacherList = new ArrayList<>();
    private Name name;
    private List<Subjects> taughtSubject;

    public Teacher(Name name, Subjects subject1, Subjects subject2) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.taughtSubject = new ArrayList<Subjects>();
        this.taughtSubject.add(subject1);
        this.taughtSubject.add(subject2);
        allTeacherList.add(this);
    }

    public Teacher(Name name, Subjects subject1) {
        this.name = name;
        this.taughtSubject = new ArrayList<Subjects>();
        this.taughtSubject.add(subject1);
        this.uuid = UUID.randomUUID().toString();        //MODIFY!!!!!!
        allTeacherList.add(this);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Subjects> getTaughtSubject() {
        return taughtSubject;
    }

    public void setTaughtSubject(List<Subjects> taughtSubject) {
        this.taughtSubject = taughtSubject;
    }

    public String getUuid() {
        return uuid;
    }

    public static List<Teacher> getAllTeacherList() {
        return allTeacherList;
    }

    @Override
    public void login() {
    }

    @Override
    public void chooseMainFunction() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void logout() {

    }

    @Override
    public String toString() {
        return name.toString();
    }
}
