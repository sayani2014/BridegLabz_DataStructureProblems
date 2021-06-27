/**
 * Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.
 * Extend the above program to find the prime numbers that are Anagram and Palindrome
 *
 * @author: SAYANI KOLEY
 * @since: 25.06.2021
 */

package com.sayani.twoDArray;

import com.sayani.Anagrams.Anagrams;
import com.sayani.FindPrimeNumbers.PrimeNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter lower bound of the interval: ");
        int lowerBound = sc.nextInt();

        System.out.print("Enter upper bound of the interval: ");
        int upperBound = sc.nextInt();

        PrimeNumbers prime = new PrimeNumbers();
        ArrayList<String> array = prime.checkPrime(lowerBound, upperBound);

        int arr[][] = new int[upperBound][upperBound];
        System.out.print("2D Array of Prime Numbers: ");
        for(int i=lowerBound; i<upperBound; i++) {
            for(int j = 0; j < upperBound; j++) {
                if(j < array.size()){
                    int value = Integer.parseInt(array.get(j));
                    arr[i][value] = value;
                    System.out.print(arr[i][value] + " ");
                }
                else
                    break;
            }
            break;
        }
        System.out.println();

        Anagrams anagram2DArray = new Anagrams();
        int n = array.size();
        ArrayList<String> array1 = anagram2DArray.findAllAnagrams(array, n);
        //System.out.println(array1);

        System.out.print("Anagrams are: ");
        for(int i=0; i<array1.size(); i++) {
            for(int j = 0; j < array1.size(); j++) {
                arr[i][j] = Integer.parseInt(array1.get(j));
                System.out.print(arr[i][j] + " ");
            }
            break;
        }
        System.out.println();

        System.out.print("Non-anagrams are: ");
        Set<String> array2 = new HashSet<>();
        for(int i=0; i< array.size(); i++) {
            for (int j = 0; j < array1.size(); j++) {
                if (array.get(i) != array1.get(j)) {
                    array2.add(array.get(i));
                }
            }
        }
        System.out.println(array2);
    }
}
