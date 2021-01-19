package com.company;

public class SudokuSolver {

    /*
    Todo: ett sätt att konstrollera att vi kan placera en siffra på given position
     */

    int[][] board;

    SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean possible(int[][] board, int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == value || board[i][x] == value) return false;
        }
        int x0 = (int) Math.floor(x / 3f) * 3;
        int y0 = (int) Math.floor(y / 3f) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[y0 + i][x0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean solve() {
        //Loopa igenom alla rader och kolumner (Två nästlade loopar)
        // 0 = empty node
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (possible(board, x, y, i)) {
                            board[y][x] = i;
                            if (solve()) return true;
                            else board[y][x] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    void printOutRaw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

    void printOut() {
        System.out.println(" -----------------------------------");
        System.out.println("|          S  O  D  U  K  O         |");
        System.out.println(" -----------------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n|---|---|---|---|---|---|---|---|---|");
        }
    }


    public static void main(String[] args) {
        int[][] board =
                {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 3, 0, 8, 5},
                        {0, 0, 1, 0, 2, 0, 0, 0, 0},
                        {0, 0, 0, 5, 0, 7, 0, 0, 0},
                        {0, 0, 4, 0, 0, 0, 1, 0, 0},
                        {0, 9, 0, 0, 0, 0, 0, 0, 0},
                        {5, 0, 0, 0, 0, 0, 0, 7, 3},
                        {0, 0, 2, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 4, 0, 0, 0, 9}};

        SudokuSolver soduku = new SudokuSolver(board);

        System.out.println(soduku.solve());
        soduku.printOut();
    }
}

