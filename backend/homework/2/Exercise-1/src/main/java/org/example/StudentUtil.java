package org.example;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        if (studentIdList == null || studentsGrades == null || studentIdList.length != studentsGrades.length) {
            return null;
        }

        double[] total = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            int totalPoint = 0;
            int totalCourses = studentsGrades[i].length;

            for (char grade : studentsGrades[i]) {
                switch (grade) {
                    case 'A':
                        totalPoint = totalPoint+ 4;
                        break;
                    case 'B':
                        totalPoint =totalPoint +3;
                        break;
                    case 'C':
                        totalPoint =totalPoint+ 2;
                        break;
                    default:
                        System.out.println("Invalid Grade");
                }
            }

            total[i] = (double) totalPoint / totalCourses;
        }

        return total;
    }

    public static int[] getStudentsByGPA(double l, double h, int[] studentIdList, char[][] studentsGrades) {
        if (l < 0 || h < 0 || l > h|| studentIdList == null || studentsGrades == null || studentIdList.length != studentsGrades.length) {
            return null;
        }

        double[] gpas = calculateGPA(studentIdList, studentsGrades);

        if (gpas == null) {
            return null;
        }

        int count = 0;
        for (double gpa : gpas) {
            if (gpa >= l && gpa <= h) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < gpas.length; i++) {
            if (gpas[i] >= l && gpas[i] <= h) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
}

