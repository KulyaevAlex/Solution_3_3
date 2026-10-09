package org.example;

public class GameBoard {
    /**
     * Константа, определяющая размер доски
     */
    public static final int SIZE_OF_BOARD = 8;

    /**
     * Метод вывода шахматной доски
     *
     * @param board - Входной двумерный массив
     */
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf("%2c ", board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Метод для проверки, бьют ли ферзи друг друга по горизонтали.
     *
     * @param board - Входящий двумерный массив, определяющий доску
     * @return - true, если ферзи бьют друг друга по горизонтали
     */
    public static boolean checkQueenAttackHorizontal(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int queenCount = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    queenCount++;
                }
            }
            if (queenCount > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[SIZE_OF_BOARD][SIZE_OF_BOARD];
        for (int i = 0; i < SIZE_OF_BOARD; i++) {
            for (int j = 0; j < SIZE_OF_BOARD; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = '.';
                } else {
                    board[i][j] = '#';
                }
            }
        }
        printBoard(board);
        System.out.println();
        System.out.println("Добавим ферзей на первую строку");
        System.out.println();
        for (int j = 0; j < SIZE_OF_BOARD; j++) {
            board[0][j] = 'Q';
        }
        printBoard(board);
        System.out.println();
        System.out.println("Бьют ли ферзи друг друга по горизонтали?");
        System.out.println(checkQueenAttackHorizontal(board) ? "Да, бьют" : "Нет, не бьют");
    }
}
