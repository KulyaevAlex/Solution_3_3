package org.example;

import java.util.Arrays;

public class MatrixTransform {
    /**
     * Результат поиска максимального значения матрицы
     *
     * @param max    - Максимальное значение
     * @param indexX - Индекс по строке максимального значения
     * @param indexY - Индекс по столбцу масимального значения
     */
    public record MaxElementWithIndexes(int max, int indexX, int indexY) {
    }

    /**
     * Метод поиска максимального элемента матрицы со значениями его индексов
     *
     * @param matrix - Входящаяя матрица
     * @return - record из максимального элелмента, индеса по строке и столбцу
     */
    public static MaxElementWithIndexes maxElement(int[][] matrix) {
        int max = matrix[0][0];
        int indexX = 0;
        int indexY = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    indexX = i;
                    indexY = j;
                }
            }
        }
        return new MaxElementWithIndexes(max, indexX, indexY);
    }

    /**
     * Метод отображения матрицы
     *
     * @param matrix - Входящая мтарица
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] originalMatrix = new int[3][4];
        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[i].length; j++) {
                originalMatrix[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Начальная матрица 3x4: " + Arrays.deepToString(originalMatrix));
        int[][] transposedMatrix = new int[originalMatrix[0].length][originalMatrix.length];
        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[i].length; j++) {
                transposedMatrix[j][i] = originalMatrix[i][j];
            }
        }
        System.out.println("Транспонированная матрица 4x3: ");
        printMatrix(transposedMatrix);
        System.out.println("Максимальный элемент матрицы равен: " + maxElement(transposedMatrix).max);
        System.out.println("Значение индекса строки максимального элемента: " + maxElement(transposedMatrix).indexX);
        System.out.println("Значение индекса столбца максимального элемента: " + maxElement(transposedMatrix).indexY);
    }
}
