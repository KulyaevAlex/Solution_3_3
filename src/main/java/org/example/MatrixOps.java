package org.example;

import java.util.Arrays;

public class MatrixOps {
    /**
     * Константа, определяющая размеры матрицы
     */
    public static int ROWS_LENGTH = 4;

    /**
     * Метод, определяющий сумму матрицы
     *
     * @param matrix - Входящая матрица
     * @return - Сумма всех элементов матрицы
     */
    public static long sumOfElements(int[][] matrix) {
        long sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    /**
     * Метод опроеделения суммы элементов главной диагонали
     *
     * @param matrix - Входящая матрица
     * @return - Сумма элементов главной диагонали
     */
    public static long sumOfMainDiag(int[][] matrix) {
        long sum = 0;
        for (int i = 0; i < ROWS_LENGTH; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    /**
     * Метод опроеделения суммы элементов побочной диагонали
     *
     * @param matrix - Входящая матрица
     * @return - Сумма элементов побочной диагонали
     */
    public static long sumOfAntiDiag(int[][] matrix) {
        long sum = 0;
        for (int i = 0; i < ROWS_LENGTH; i++) {
            sum += matrix[i][ROWS_LENGTH - 1 - i];
        }
        return sum;
    }

    /**
     * Метод определения максимального элемента в каждой строке матрицы
     *
     * @param matrix - Входящая матрица
     * @return - Массив максимальных элементов в каждой строке
     */
    public static int[] maxElementInRow(int[][] matrix) {
        int[] max = new int[ROWS_LENGTH];
        for (int i = 0; i < matrix.length; i++) {
            int maxElement = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxElement < matrix[i][j]) {
                    maxElement = matrix[i][j];
                }
            }
            max[i] = maxElement;
        }
        return max;
    }

    /**
     * Метод определения суммы в каждом столбце матрицы
     *
     * @param matrix - Входящая матрица
     * @return - Массив сумм элементов каждого столбца
     */
    public static long[] sumOfEachColumn(int[][] matrix) {
        long[] sumArray = new long[ROWS_LENGTH];
        for (int j = 0; j < matrix.length; j++) {
            long sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][j];
            }
            sumArray[j] = sum;
        }
        return sumArray;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[ROWS_LENGTH][ROWS_LENGTH];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Матрица: " + Arrays.deepToString(matrix));
        System.out.println("Сумма всех элементов матрицы: " + sumOfElements(matrix));
        System.out.println("Сумма элементов главной диагонали: " + sumOfMainDiag(matrix));
        System.out.println("Сумма элементов побочной диагонали: " + sumOfAntiDiag(matrix));
        System.out.println("Массив максимальных элементов в каждой строке матрицы: " + Arrays.toString(maxElementInRow(matrix)));
        System.out.println("Cуммы элементов в каждом столбце матрицы: " + Arrays.toString(sumOfEachColumn(matrix)));
    }
}
