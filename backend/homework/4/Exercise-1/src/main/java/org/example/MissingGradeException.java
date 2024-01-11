package org.example;

class MissingGradeException extends Exception{
    private final int studentId;
    public int getStudentId()
    {
        return studentId;
    }
    MissingGradeException(int studentId){
        this.studentId = studentId;
    }
}
