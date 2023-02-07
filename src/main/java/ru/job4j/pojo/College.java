package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Петров Петр Петрович");
        student.setGroup("ММ-556");
        student.setEnrollDate(new Date());

        System.out.println("A student " + student.getFullName()
                + " was enrolled on " + student.getEnrollDate()
                + " to group " + student.getGroup() + ".");
    }
}
