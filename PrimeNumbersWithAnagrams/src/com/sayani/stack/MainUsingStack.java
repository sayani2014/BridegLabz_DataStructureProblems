/**
 * Add the Prime Numbers that are Anagram in the Range of 0 - 1000 in a Stack using the Linked List and Print the Anagrams.
 *
 * @author: SAYANI KOLEY
 * @since: 26.06.2021
 */

package com.sayani.stack;

import com.sayani.Anagrams.Anagrams;
import com.sayani.FindPrimeNumbers.PrimeNumbers;

import java.util.ArrayList;
import java.util.Scanner;

public class MainUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter lower bound of the interval: ");
        int lowerBound = sc.nextInt();

        System.out.print("Enter upper bound of the interval: ");
        int upperBound = sc.nextInt();

        PrimeNumbers prime = new PrimeNumbers();
        ArrayList<String> array = prime.checkPrime(lowerBound, upperBound);

        Anagrams anagramStack = new Anagrams();
        int n = array.size();
        ArrayList<String> array1 = anagramStack.findAllAnagrams(array, n);

        StackImpl stack = new StackImpl();
        for(int i = 0; i < array1.size(); i=i+2) {
            if((i+1) < array1.size())
                stack.push(array1.get(i), array1.get(i + 1));
            else
                break;
        }
        System.out.println("\nAnagrams in Stack implemented using Linked List");
        stack.display();
    }
}
