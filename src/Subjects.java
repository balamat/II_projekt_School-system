public enum Subjects {
    GERMAN("Német"),
    MATHS("Matematika"),
    HUNGARIAN("Magyar"),
    ENGLISH("Angol"),
    HISTORY("Történelem"),
    PHYSICS("Fizika"),
    VISUAL_ARTS("Rajz"),
    MUSIC("Ének"),
    SPORT("Testnevelés"),
    ;

    Subjects(String subjectName) {
        this.subjectName = subjectName;

    }

    private final String subjectName;

    public String getSubjectName() {
        return subjectName;
    }
}