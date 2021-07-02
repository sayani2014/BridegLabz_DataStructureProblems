/**
 * Hashing Function to search a Number in a slot
 * Desc -> Create a Slot of 10 to store Chain of Numbers that belong to each Slot to efficiently search a number from a given set of number
 * I/P -> read a set of numbers from a file and take user input to search a number
 * Logic -> Firstly store the numbers in the Slot. Since there are 10 Numbers divide each number by 11 and the reminder put in the appropriate slot.
 * If a number searched is found then pop it or else push it.
 * d. O/P -> Save the numbers in a file
 *
 * @author : SAYANI KOLEY
 * @since : 02.07.2021
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTableMain {
    public static void main(String[] args) throws IOException {
        HashTableImpl<String, Integer> hashImpl = new HashTableImpl();
        Scanner input = new Scanner(System.in);
        ReadWriteData readWriteData = new ReadWriteData();
        ArrayList<String> dataArray = readWriteData.readFile();

        //convert the arraylist into array to pass it to the generic class
        //String to String[] conversion.
        //Split the words when a white space comes up.
        //Convert all the words in lowercase
        String[] messageArray = new String[dataArray.size()];
        messageArray = dataArray.toArray(messageArray);

        //Iterate within the array
        for(String word: messageArray) {
            //Search for the word in the hashtable
            Integer value =  hashImpl.get(word);
            hashImpl.add(word , value);
        }
        //Display the hashtable
        System.out.println(hashImpl);

        System.out.println();
        //Take input from the user to search for the word
        System.out.print("Enter the word you want to search from the file: ");
        String value = input.next();

        System.out.println("Element found " +hashImpl.searchHashTable(value));

        //Element found remove the element from hashtable, else add the element in the hashtable
        if(hashImpl.searchHashTable(value) == true) {
            hashImpl.remove(value);
            System.out.println("\nDeleted element from Hashtable!\n");
        }
        else {
            Integer index =  hashImpl.get(value);
            hashImpl.add(value , index);
            System.out.println("\nDeleted element from Hashtable!\n");
        }
        //Display the hashtable
       // System.out.println(hashImpl);

        //Write the hashtable output in a file
        ArrayList<String> data = new ArrayList<>();
        data.add(hashImpl.toString());
        readWriteData.writeFile(data);
    }
}
