package com.example.sudokuexam;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import java.util.function.UnaryOperator;

public class HelloController {

    @FXML
    private GridPane sudokuGrid;

    private static final int SIZE = 6;
    private TextField[][] cells = new TextField[SIZE][SIZE];

    private final int[][] referenceBoard = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 9, 0},
            {0, 0, 8, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 4, 0, 0, 3, 0},
            {0, 0, 0, 0, 0, 0}
    };

    @FXML
    public void initialize() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                TextField cell = new TextField();
                cells[row][col] = cell;

                // ¡El ID que añadiste perfectamente!
                cell.setId("celda_" + row + "_" + col);

                cell.getStyleClass().add("celda");
                if (col == 2) cell.getStyleClass().add("grosor-derecho");
                if (row == 2) cell.getStyleClass().add("grosor-izquierdo");

                cell.setMinSize(0, 0);
                cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                cell.styleProperty().bind(
                        Bindings.concat("-fx-font-size: ", cell.heightProperty().multiply(0.5))
                );

                filtradodelnumero(cell);

                int val = referenceBoard[row][col];

                // AQUI CAMBIAMOS: Llamamos a la lógica externa
                if (SudokuLogic.esEsquina(row, col, SIZE)) {
                    cell.setText("");
                    cell.setEditable(true);
                    cell.getStyleClass().add("celda-error");
                }
                // AQUI CAMBIAMOS: Llamamos a la lógica externa
                else if (SudokuLogic.casillasmoradas(row, col)) {
                    cell.setText(String.valueOf(val));
                    cell.setEditable(false);
                    cell.getStyleClass().add("celda-inmutable");
                }
                else {
                    cell.setText("");
                    cell.setEditable(true);
                }

                sudokuGrid.add(cell, col, row);
            }
        }
    }

    private void filtradodelnumero(TextField cell) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getControlNewText();
            if (text.matches("[1-9]?")) return change;
            return null;
        };
        cell.setTextFormatter(new TextFormatter<>(filter));
    }
}