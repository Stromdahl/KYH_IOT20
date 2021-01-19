package kyh.lectures.lecture11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lists {
    public static void manageLists() {
        Integer[] ints = new Integer[5];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;
        ints[4] = 5;
        for(int i: ints) {
            System.out.println(i);
        }
        System.out.println("---Med listor---");
        List<Integer> ints2 = new ArrayList<Integer>();

        ints2.add(1);
        ints2.add(2);
        ints2.add(3);
        ints2.add(4);
        ints2.add(5);
        ints2.remove(3);
        ints2.set(2, 10);
        for(int i: ints2) {
            System.out.println(i);
        }
    }

    public static void swap(List<String> l, int i, int j) {
        String tmp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, tmp);
    }


    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Purple");
        swap(colors, 3, 4);
        for(String color: colors) {
            System.out.println(color);
        }
    }
}
