package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuSolverTest {

    int[][] board =
            {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                    {0, 7, 4, 1, 0, 0, 0, 8, 0},
                    {8, 3, 2, 0, 0, 0, 4, 0, 0},
                    {2, 0, 5, 3, 0, 0, 7, 4, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 6},
                    {1, 4, 3, 0, 0, 0, 2, 0, 0},
                    {0, 0, 7, 0, 9, 0, 6, 0, 0},
                    {0, 2, 1, 7, 5, 6, 8, 9, 0},
                    {6, 5, 9, 2, 3, 0, 0, 7, 4}};

    @Test
    void isPossible() {
        SudokuSolver soduku = new SudokuSolver(board);
        assertTrue(soduku.possible(board, 3, 2, 5));
    }

    @Test
    void isNotPossible() {
        SudokuSolver soduku = new SudokuSolver(board);
        assertFalse(soduku.possible(board, 3, 2, 1));
    }

    @Test
    void isSmallGridNotPossible() {
        SudokuSolver soduku = new SudokuSolver(board);
        assertFalse(soduku.possible(board, 0, 1, 3));
    }

}
