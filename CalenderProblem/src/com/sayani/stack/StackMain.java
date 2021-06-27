/**
 * Display the Calender taking month and year from user using stack.
 *
 * @author: SAYANI KOLEY
 * @since: 27.06.2021
 */

package com.sayani.stack;

import java.util.ArrayList;

public class StackMain {
    public static void performStackOperation(int[] days, int d, int month) {

        ArrayList<String> arrayList = new ArrayList<>();
        String[] weekDay = {"S", "M", "Tu", "W", "Th", "F", "S"};

        //Assigning 0 to the values of the week before the month begins
        for (int i = 0; i < d; i++)
            arrayList.add(weekDay[i] + 0);
        for (int i = 1; i <= days[month]; i++) {
            arrayList.add(weekDay[d] + i);
            if(d < 6)
                d++;
            else
                d = 0;
            if(i == days[month])
                break;
        }

        StackImpl stack = new StackImpl();
        //for(int i = 0; i < arrayList.size(); i++) {
        for(int i = arrayList.size() - 1; i >= 0; i--) {
            stack.push(arrayList.get(i));
        }

        System.out.println();
        System.out.println("Display using Stack\n");
        stack.display();
    }
}
