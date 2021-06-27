/**
 * Palindrome-Checker
 * I/P -> Take a String as an Input
 * Logic -> The solution to this problem will use a dequeue to store the characters of the string.
 * O/P -> Show if the String is Palindrome or not.
 *
 * @author: SAYANI KOLEY
 * @since: 26.06.2021
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;

        System.out.println("Enter the string: ");
        String value = input.next();

        for (int i = 0; i < value.length(); i++)
            if (value.charAt(i) != ' ')
                count++;

        String[] stringValue = new String[count];
        char[] input1 = value.toCharArray();
        for (int i = 0; i < count; i++)
            stringValue[i] = String.valueOf(input1[i]);

        QueueImplementation queueImpl = new QueueImplementation(stringValue.length);

        for(int i = 0; i < stringValue.length; i++)
            queueImpl.enqueue(stringValue[i]);

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("The front element is: " +queueImpl.peek());
        arrayList = queueImpl.dequeue();
        System.out.println("The front element is: " +queueImpl.peek());

        for(int i = 0; i < stringValue.length - 1; i++)
            arrayList = queueImpl.dequeue();

        if(queueImpl.isEmpty())
            System.out.println("Queue is empty");
        else
            System.out.println("Queue is not empty");

        int k=0, l=count-1;
        boolean flag = false;
        while(k < arrayList.size() && l >= 0) {
            if(stringValue[l] == arrayList.get(k)) {
                flag = true;
                k++; l--;
            }
            else
                k++; l--;
        }
        if(flag == true)
            System.out.println("String is palindrome");
        else
            System.out.println("String is not palindrome");
    }
}
