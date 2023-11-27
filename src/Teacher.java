import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher implements Cloneable, User{

    private final UUID uuid;
    private static List<Teacher> allTeacherList = new ArrayList<>();
    private Name name;
    private List<Subjects> taughtSubject;

    public Teacher(Name name, Subjects subject1, Subjects subject2) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.taughtSubject = new ArrayList<Subjects>();
        this.taughtSubject.add(subject1);
        this.taughtSubject.add(subject2);
    }

    public Teacher addToList() {
        allTeacherList.add(this);
        return this;
    }

    public Teacher(Name name, Subjects subject1) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.taughtSubject = new ArrayList<Subjects>();
        this.taughtSubject.add(subject1);
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

    public UUID getUuid() {
        return uuid;
    }

    public static List<Teacher> getAllTeacherList() {
        return allTeacherList;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public Teacher clone() {
        try {
            return (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
