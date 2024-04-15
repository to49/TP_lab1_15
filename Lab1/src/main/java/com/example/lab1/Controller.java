package com.example.lab1;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.lab1.functions.FileDragAndDrop;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.*;
import lab1.Charco;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button;

    @FXML
    private TextField inputField;

    @FXML
    private TextField outputField;

    @FXML
    void initialize() throws IOException {
        Charco charco = new Charco();
        assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert inputField != null : "fx:id=\"inputField\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert outputField != null : "fx:id=\"outputField\" was not injected: check your FXML file 'hello-view.fxml'.";
        FileDragAndDrop textField = new FileDragAndDrop();
        textField.Drag(inputField);

        button.setOnAction(event -> { String Finalname = inputField.getText();
            int x = 0;
            try {
                x = charco.charCo(Finalname);


            }
            catch (FileNotFoundException e) {
                Alert alert = new Alert(AlertType.ERROR);
                System.out.println("ОШИБКА! ФАЙЛ НЕ НАЙДЕН");
                alert.setTitle("Ошибка");
                alert.setHeaderText("Ошибка при выполнении операции");
                alert.setContentText("Произошла ошибка. Файл не найден!");
                alert.showAndWait();
            }
            catch (IOException e){
                System.out.println("ОШИБКА! ПРИ ЧТЕНИИ ФАЙЛА");
            }
            outputField.setText(String.valueOf(x));



        });
    }



}
