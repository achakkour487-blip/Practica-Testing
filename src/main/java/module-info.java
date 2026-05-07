module com.example.sudokuexam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sudokuexam to javafx.fxml;
    exports com.example.sudokuexam;
}