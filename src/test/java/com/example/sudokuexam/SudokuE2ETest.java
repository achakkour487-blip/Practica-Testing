package com.example.sudokuexam;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.*;

public class SudokuE2ETest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        // Esto arranca la aplicación para el test
        new HelloApplication().start(stage);
    }

    @Test
    void caso1_EscribirNumeroEnCeldaVacia() {
        // Hace click en la celda 0,1 y escribe un 5
        clickOn("#celda_0_1").write("5");
        TextField celda = lookup("#celda_0_1").queryAs(TextField.class);
        assertEquals("5", celda.getText());
    }

    @Test
    void caso2_CeldaMoradaNoEsEditable() {
        // Verifica que no se puede editar una celda morada (2,2)
        TextField celda = lookup("#celda_2_2").queryAs(TextField.class);
        assertFalse(celda.isEditable());
    }

    @Test
    void caso3_CeldaEsquinaTieneEstiloDeError() {
        // Verifica que la celda 0,0 (esquina) inicia con la clase 'celda-error'
        TextField celda = lookup("#celda_0_0").queryAs(TextField.class);
        assertTrue(celda.getStyleClass().contains("celda-error"));
    }
}