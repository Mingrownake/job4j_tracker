package ru.job4j.ood.parkinglot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Field;
import java.util.Vector;

public class Test {
    public static void main(String[] args) throws Exception {
    //    List<Integer> integerList = new ArrayList<>(3);
        int a = 1;
        //integerList.add(a);
//        System.out.println(integerList.size());
//        System.out.println(getCapacity(integerList));

        Vector<Integer> vector = new Vector<>(2);
        vector.add(a);

        System.out.println(vector.capacity());
        System.out.println(vector.size());


    }

//        static int getCapacity(List<Integer> list) throws Exception {
//            Field field = ArrayList.class.getDeclaredField("elementData");
//            field.setAccessible(true);
//            return ((Object[]) field.get(list)).length;
//        }
    }

