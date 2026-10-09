package org.example;

import java.util.Arrays;

public class PascalTriangle {
    /**
     * Количество строк для треугольника
     */
    public static int SIZE_OF_TRIANGLE = 8;

    private static void printTriangle(int[][] triangle) {
        for (int i = 0; i < SIZE_OF_TRIANGLE; i++) {
            int spaces = (SIZE_OF_TRIANGLE - 1 - i) * 3;
            for (int k = 0; k < spaces; k++) {
                System.out.print(' ');
            }

            for (int j = 0; j < triangle[i].length; j++) {
                System.out.printf("%3d   ", triangle[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] pascalTriangle = new int[SIZE_OF_TRIANGLE][];

        for (int i = 0; i < SIZE_OF_TRIANGLE; i++) {
            pascalTriangle[i] = new int[i + 1];
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
        printTriangle(pascalTriangle);
    }
}
