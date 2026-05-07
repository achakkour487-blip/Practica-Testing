package com.example.sudokuexam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuLogicTest {

    @Test
    void testEsEsquina() {
        assertTrue(SudokuLogic.esEsquina(0, 0, 6)); // Comprueba que la 0,0 sí es esquina
        assertFalse(SudokuLogic.esEsquina(1, 1, 6)); // Comprueba que la 1,1 NO es esquina
    }

    @Test
    void testCasillasMoradas() {
        assertTrue(SudokuLogic.casillasmoradas(2, 2)); // Comprueba que la 2,2 es morada
        assertFalse(SudokuLogic.casillasmoradas(0, 1)); // Comprueba que la 0,1 NO es morada
    }
}