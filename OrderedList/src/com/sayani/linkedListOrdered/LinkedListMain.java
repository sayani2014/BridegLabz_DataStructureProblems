/**
 * Ordered List
 * Desc -> Read .a List of Numbers from a file and arrange it ascending Order in a Linked List.
 * Take user input for a number, if found then pop the number out of the list else perform insertion
 * I/P -> Read from file the list of Numbers and take user input for a new number
 * Logic -> Create a Ordered Linked List having Numbers in ascending order.
 * O/P -> The List of Numbers to a File.
 *
 * @author: SAYANI KOLEY
 * @since: 25.06.2021
 */

package com.sayani.linkedListOrdered;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        ReadWriteData readWriteData = new ReadWriteData();
        ArrayList<String> dataArray = readWriteData.readFile();

        //convert the arraylist into array to pass it to the generic class
        String[] array = new String[dataArray.size()];
        array = dataArray.toArray(array);

        LinkedListOrderedImplementation<String> unorderedImplementation = new LinkedListOrderedImplementation<>(array);
        unorderedImplementation.insertBefore();
        unorderedImplementation.insertEnd();
        unorderedImplementation.insertAt();
        System.out.print("List after insertion in the linked list: ");
        unorderedImplementation.display();

        System.out.println();
        //Take input from the user to search for the word
        System.out.print("Enter the word you want to search from the file: ");
        String value = input.next();

        System.out.println("Element found " +unorderedImplementation.search(value));
        if(unorderedImplementation.search(value) == true)
            unorderedImplementation.deleteNode(value);
        else
            unorderedImplementation.appendAtEnd(value);

        //sort the linked list
        unorderedImplementation.sortList();

        System.out.print("New list: ");
        ArrayList<String> data = unorderedImplementation.display();
        readWriteData.writeFile(data);
    }
}
