package com.example.lab1.functions;

import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;


public class FileDragAndDrop{

    public TextField Drag(TextField textField) {
        textField.setOnDragOver(event -> {
            if (event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);}});

        textField.setOnDragDropped((DragEvent event) -> {
            String filePath = event.getDragboard().getFiles().get(0).getAbsolutePath();
            textField.setText(filePath);
            event.setDropCompleted(true);
            event.consume();
        });
        return textField;
    }


}