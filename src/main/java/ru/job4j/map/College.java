package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> resultStudent = Optional.empty();
        for (Student student : students.keySet()) {
            if (student.getAccount().equals(account)) {
                resultStudent = Optional.of(student);
                break;
            }
        }
        return resultStudent;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> resultStudent = findByAccount(account);
        Optional<Subject> resultSubject = Optional.empty();
        if (resultStudent.isPresent()) {
            Set<Subject> subjects = students.get(resultStudent.get());
            for (Subject subject : subjects) {
                if (subject.getName().equals(name)) {
                    resultSubject = Optional.of(subject);
                }
            }
        }
        return resultSubject;
    }
}