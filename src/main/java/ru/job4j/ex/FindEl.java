package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < values.length; index++) {
            if (Objects.equals(values[index], key)) {
                rsl = index;
                break;
            }
        } if (rsl == -1) {
            throw new ElementNotFoundException("The array should contain the element");
        }
        return rsl;
    }

    public static boolean sent(String values, String[] abuses) throws ElementAbuseException {
        /* if contains throw ElementAbuseException */
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        /*}  catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();*/
        }  catch (Exception e) {
            e.printStackTrace();
        } /*catch (Throwable th) {
            th.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"a"}, "q");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}