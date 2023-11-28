import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Student implements Cloneable, User {

    private final UUID uuid;
    private Name name;
    private LocalDate birthday;
    private String studClassString;
    private Map<Subjects, List<Grade>> subjectAndGradeList;
    private static List<Student> allStudentList = new ArrayList<>();
    private static List<Student> archivedStudentList = new ArrayList<>();

    public Student(Name name, String studClassString) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = generateRandomDate();
        this.studClassString = studClassString;
        this.subjectAndGradeList = new HashMap<>();
    }

    public Student(Name name, String studClassString, LocalDate birthday) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = birthday;
        this.studClassString = studClassString;
        this.subjectAndGradeList = new HashMap<>();
    }

    public Student addToList() {
        allStudentList.add(this);
        return this;
    }

    public void archive() {
        allStudentList.remove(this);
        archivedStudentList.add(this);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Map<Subjects, List<Grade>> getSubjectAndGradeList() {
        return subjectAndGradeList;
    }

    public void setSubjectAndGradeList(Map<Subjects, List<Grade>> subjectAndGradeList) {
        this.subjectAndGradeList = subjectAndGradeList;
    }

    public String getStudClassString() {
        return studClassString;
    }

    public void setStudClassString(String studClassString) {
        this.studClassString = studClassString;
    }

    public void addGrade(Subjects subject, String description, int grade) {
        if (!this.getSubjectAndGradeList().containsKey(subject)) {
            this.getSubjectAndGradeList().put(subject, new ArrayList<Grade>());
        }
        this.getSubjectAndGradeList().get(subject).add(new Grade(description, grade));
    }

    //DATA UPLOAD - INSTALLATION
    public void generateRandomGrades(int minGrade, int maxGrade) {
        //generate random descriptions
        Map<Subjects, String[]> descriptionOptionsMap = new HashMap<>();
        descriptionOptionsMap.put(Subjects.GERMAN, new String[]{"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.MATHS, new String[]{"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.HUNGARIAN, new String[]{"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.ENGLISH, new String[]{"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.HISTORY, new String[]{"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.PHYSICS, new String[]{"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.VISUAL_ARTS, new String[]{"szabadkézi rajz", "festés", "röpdolgozat", "házi feladat", "órai munka", "híres festők", "gyakorlórajz", "projektmunka", "kollázs", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.MUSIC, new String[]{"dolgozat", "felelés", "kottázás", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "éneklés", "javítódolgozat", "szorgalmi"});
        descriptionOptionsMap.put(Subjects.SPORT, new String[]{"Cooper-teszt", "kislabdadobás", "fekvőtámasz", "foci", "kézilabda", "úszás", "erőnléti felmérés", "sprint"});

//        String[] descriptionOptions = new String[]
//                {"dolgozat", "felelés", "röpdolgozat", "házi feladat", "órai munka", "témazáró", "gyakorlófeladatok", "projektmunka", "javítódolgozat", "szorgalmi"};
//        int descriptionOptionsLength = descriptionOptions.length;

//        //generate random grades
//        int minGrade = 1;
//        int maxGrade = 5;

        //generate random number of grades per subject
        int minNumberOfGrades = 4;
        int maxNumberOfGrades = 8;

        for (Subjects subject : Subjects.values()
        ) {
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(minNumberOfGrades, maxNumberOfGrades + 1); i++) {
//                this.addGrade(subject, descriptionOptions[ThreadLocalRandom.current().nextInt(0, descriptionOptionsLength)], ThreadLocalRandom.current().nextInt(minGrade, maxGrade + 1));
                this.addGrade(subject, descriptionOptionsMap.get(subject)[ThreadLocalRandom.current().nextInt(0, descriptionOptionsMap.get(subject).length)], ThreadLocalRandom.current().nextInt(minGrade, maxGrade + 1));
            }
        }
    }

    public static List<Student> getAllStudentList() {
        return allStudentList;
    }

    public static List<Student> getArchivedStudentList() {
        return archivedStudentList;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    //////////////////////////////////
    public double gradeInspector() {
        return 0;
    }

    public static LocalDate generateRandomDate() {
        long minDay = LocalDate.of(2007, 8, 31).toEpochDay();
        long maxDay = LocalDate.of(2013, 9, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    @Override
    public String toString() {
        return "Személyi adatok:" + System.lineSeparator() +
                "\t Név: " + name + System.lineSeparator() +
                "\t UserID: " + uuid + System.lineSeparator() +
                "\t születési idő: " + birthday + System.lineSeparator() +
                "\t Osztály: " + studClassString + System.lineSeparator();
    }

    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

