package org.example;

public class Main {
    public static void main(String[] args) {

        StudentUtil student = new StudentUtil();
        int []SID={1001,1002};
        char[][] grades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };
        double[] d = StudentUtil.calculateGPA( SID,grades);

        int[] result = StudentUtil.getStudentsByGPA(3.2,3.5,SID,grades);
        for(int i=0;i< result.length;i++) {
            System.out.println(result[i]);
        }

    }
}