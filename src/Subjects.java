public enum Subjects {
    MATHS("Matematika"),
    HUNGARIAN("Magyar"),
    ENGLISH("Angol"),
    GERMAN("Német"),
    HISTORY("Történelem"),
    PHYSICS("Fizika"),
    VISUAL_ARTS("Rajz"),
    MUSIC("Ének"),
    SPORT("Testnevelés"),
    ;

    Subjects(String subjectName) {
        this.subjectName = subjectName;

    }

    private String subjectName;

    public String getSubjectName() {
        return subjectName;
    }
}