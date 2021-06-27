/**
 * UnOrdered List
 * Desc -> Read the Text from a file, split it into words and arrange it as Linked List. Take a user input to search a Word in the List.
 * If the Word is not found then add it to the list, and if it found then remove the word from the List.
 * In the end save the list into a file
 * I/P -> Read from file the list of Words and take user input to search a Text
 * Logic -> Create a Unordered Linked List. The Basic Building Block is the Node Object.
 * Each node object must hold at least two pieces of information. One ref to the data field and second the ref to the next node object.
 * O/P -> The List of Words to a File.
 *
 * @author: SAYANI KOLEY
 * @since: 25.06.2021
 */

package com.sayani.linkedListUnordered;

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

        LinkedListUnorderedImplementation<String> unorderedImplementation = new LinkedListUnorderedImplementation<>(array);
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

        System.out.print("New list: ");
        ArrayList<String> data = unorderedImplementation.display();

        readWriteData.writeFile(data);
    }
}
