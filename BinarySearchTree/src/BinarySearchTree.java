/**
 * Purpose : Number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)! / ((n + 1)! * n!)
 * I/P : Total number of test cases
 * O/P : The number of different binary search trees that can be created using these nodes.
 *
 * @author: SAYANI KOLEY
 * @since: 02.07.2021
 */

import java.util.Scanner;

public class BinarySearchTree {
    public static int binomialCoeff(int n, int k) {
        int res = 1;
        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    public static int catalan( int n) {
        // Calculate value of 2nCn
        int c = binomialCoeff(2 * n, n);
        // return 2nCn/(n+1)
        return c / (n + 1);
    }

    public static int countBST( int n) {
        int count = catalan(n);
        return count;
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int count;
        System.out.println("Enter the number of test cases : ");
        int n = input.nextInt();

        for(int i = 1; i <= n; i++) {
            //Find count of BST
            count = countBST(i);
            System.out.println("Count of BST with "+ i +" nodes is "+ count);
        }
    }
}

