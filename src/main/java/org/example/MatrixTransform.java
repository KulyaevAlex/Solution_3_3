package org.example;

import java.util.Arrays;

public class MatrixTransform {
    /**
     * Результат поиска максимального значения матрицы
     *
     * @param max - Максимальное значение
     * @param row - Индекс по строке максимального значения
     * @param col - Индекс по столбцу масимального значения
     */
    public record MaxElementWithIndexes(int max, int row, int col) {
    }

    /**
     * Метод поиска максимального элемента матрицы со значениями его индексов
     *
     * @param matrix - Входящаяя матрица
     * @return - record из максимального элелмента, индеса по строке и столбцу
     */
    public static MaxElementWithIndexes maxElement(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Передана пустая матрица");
        }

        int max = matrix[0][0];
        int row = 0;
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return new MaxElementWithIndexes(max, row, col);
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

    /**
     * Метод транспонирования матрицы
     *
     * @param matrix - Входящая мтарица
     * @return - Транспонированная матрица
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public static void main(String[] args) {
        int[][] originalMatrix = new int[3][4];
        for (int i = 0; i < originalMatrix.length; i++) {
            for (int j = 0; j < originalMatrix[i].length; j++) {
                originalMatrix[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Начальная матрица 3x4: " + Arrays.deepToString(originalMatrix));
        System.out.println();
        int[][] transposedMatrix = transpose(originalMatrix);
        System.out.println("Транспонированная матрица 4x3: ");
        printMatrix(transposedMatrix);
        System.out.println();
        MaxElementWithIndexes maxElementWithIndexes = maxElement(transposedMatrix);
        System.out.println("Максимальный элемент матрицы равен: " + maxElementWithIndexes.max);
        System.out.println("Значение индекса строки максимального элемента: " + maxElementWithIndexes.row);
        System.out.println("Значение индекса столбца максимального элемента: " + maxElementWithIndexes.col);
    }
}
