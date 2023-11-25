public class Calculator {

    public static double calculateStudentAvgBySubject(Student student, Subjects subject) {
        return student.getSubjectAndGradeList().containsKey(subject) ?
                student.getSubjectAndGradeList().get(subject).stream().mapToDouble(grade -> grade.getGrade()).average().orElse(0) : 0;
    }

    /**
     * Calculates the average grade of the student by the existing listed subjects -
     * which from student have at least 1 grade
     *
     * @param student
     * @return double the average of the subject averages
     */
    public static double calculateStudentAvg(Student student) {
        int[] count = new int[]{0};
        double[] sumOfAvg = new double[]{0};
        student.getSubjectAndGradeList().forEach((sub, gradeLs) -> {
            double avg = calculateStudentAvgBySubject(student, sub);
            sumOfAvg[0] += avg;
            if (avg != 0) {
                //if there is no grade, then it is not counted in the average - in case of deleting grade
                count[0]++;
            }
        });
        return count[0] > 0 ? sumOfAvg[0] / count[0] : 0;
    }

    public static double calculateSubjectAvg(Subjects subject, StudClass studClass) {
        int[] count = new int[]{0};
        double[] sumOfAvg = new double[]{0};
        Student.getAllStudentList().stream()
                .filter(student -> student.getStudClassString().equals(studClass.getNameOfClass()))
                .forEach(student -> {
                    double avg = calculateStudentAvgBySubject(student, subject);
                    sumOfAvg[0] += avg;
                    if (avg != 0) {
                        //if there is no grade, then it is not counted in the average - in case of deleting grade
                        count[0]++;
                    }
                });
        return count[0] > 0 ? sumOfAvg[0] / count[0] : 0;
    }

    public static double calculateStudClassAvg(StudClass studClass) {
        int[] count = new int[]{0};
        double[] sumOfAvg = new double[]{0};

        for (Subjects subject : Subjects.values()
        ) {
            double avg = Calculator.calculateSubjectAvg(subject, studClass);
            sumOfAvg[0] += avg;
            if (avg != 0) {
                //if there is no grade, then it is not counted in the average - in case of deleting grade
                count[0]++;
            }
        }
        return count[0] > 0 ? sumOfAvg[0] / count[0] : 0;
    }


}
