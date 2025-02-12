package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class Waerungsrechner {
    @FXML
    private Label waerung;

    @FXML
    protected void chosenWaerung(ActionEvent event) {
        waerung.setText(waerung.getText() + " ");
    }
}
