package com.example.sudokuexam;

public class SudokuLogic {
    public static boolean esEsquina(int row, int col, int size) {
        return (row == 0 && col == 0) || (row == 0 && col == size - 1) ||
                (row == size - 1 && col == 0) || (row == size - 1 && col == size - 1);
    }

    public static boolean casillasmoradas(int row, int col) {
        if (row == 2 && col == 2) return true;
        if (row == 4 && col == 1) return true;
        if (row == 4 && col == 4) return true;
        if (row == 1 && col == 4) return true;
        return false;
    }
}