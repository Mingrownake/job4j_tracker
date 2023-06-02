package ru.job4j.hmap;

import java.util.*;
import java.util.function.BiFunction;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double res = 0;
        int subjectsAmount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                res += subject.score();
                subjectsAmount++;
            }
        }
        return res / subjectsAmount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        for (Pupil pupil : pupils) {
            double res = 0;
            int subjectsAmount = 0;
            for (Subject subject : pupil.subjects()) {
                res += subject.score();
                subjectsAmount++;
            }
            Label label = new Label(pupil.name(), res / subjectsAmount);
            labelList.add(label);
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> func1 =
                (oldValue, newValue) -> oldValue + newValue;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), func1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue() / pupils.size();
            labelList.add(new Label(entry.getKey(), score));
        }
        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        for (Pupil pupil : pupils) {
            double res = 0;
            for (Subject subject : pupil.subjects()) {
                res += subject.score();
            }
            Label label = new Label(pupil.name(), res);
            labelList.add(label);
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labelList = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        BiFunction<Integer, Integer, Integer> function =
                (oldValue, newValue) -> oldValue + newValue;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), function);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int score = entry.getValue();
            labelList.add(new Label(entry.getKey(), score));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}

