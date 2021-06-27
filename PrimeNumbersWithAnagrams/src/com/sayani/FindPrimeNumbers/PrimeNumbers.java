package com.sayani.FindPrimeNumbers;

import java.util.ArrayList;

public class PrimeNumbers {
    public static ArrayList checkPrime(int lowerBound, int upperBound) {
        int flag = 0;
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            if (i == 1 || i == 0)
                continue;
            flag = 1;

            for (int j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                arrayList.add(Integer.toString(i));
            }
        }
        return arrayList;
    }
}
