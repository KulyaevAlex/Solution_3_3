package org.example;

import java.util.Arrays;

public class PascalTriangle {
    /**
     * Количество строк для треугольника
     */
    private static int sizeOfTriangle = 8;

    private static void printTriangle(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            int spaces = (sizeOfTriangle - 1 - i) * 3; //Определение количества пробелов для красивого вывода с коэффициентом 3
            for (int k = 0; k < spaces; k++) {
                System.out.print(' ');
            }

            for (int j = 0; j < triangle[i].length; j++) {
                System.out.printf("%3d   ", triangle[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Метод, проверяющий равна ли сумма элементов каждой строки и 2 в степени номера строки
     *
     * @param triangle - Входящий зубчатый массив
     * @return - true, если равна сумма элементов каждой строки и 2 в степени номера строки
     */
    public static boolean isCheckSum(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            long sum = 0;
            for (int element : triangle[i]) {
                sum += element;
            }
            long degreeOfLineNumber = 1;
            for (int j = 0; j < i; j++) {
                degreeOfLineNumber *= 2;
            }
            if (sum != degreeOfLineNumber) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] pascalTriangle = new int[sizeOfTriangle][];

        for (int i = 0; i < pascalTriangle.length; i++) {
            pascalTriangle[i] = new int[i + 1];
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
        printTriangle(pascalTriangle);
        System.out.println("Cумма элементов каждой строки равна 2 в степени номера строки: " + (isCheckSum(pascalTriangle) ? "Да" : "Нет"));
    }
}