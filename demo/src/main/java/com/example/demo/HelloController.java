package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ChoiceBox<String> choiceBox1;
    @FXML
    private TextField amount;
    @FXML
    private Button button;
    @FXML
    private Label label;

    @FXML
    public void initialize() {

        // Add items to the ChoiceBox
        choiceBox.getItems().addAll("Euro", "US Dollar", "British Pound", "Japanese Yen", "Swiss Franc", "Canadian Dollar", "Australian Dollar", "Chinese Yuan", "Indian Rupee", "Brazilian Real");
        choiceBox1.getItems().addAll("Euro", "US Dollar", "British Pound", "Japanese Yen", "Swiss Franc", "Canadian Dollar", "Australian Dollar", "Chinese Yuan", "Indian Rupee", "Brazilian Real");

        // Set a default selected item
        choiceBox.setValue("Euro");
        choiceBox1.setValue("Euro");
    }
    @FXML
    private void handleButtonClick() {
        String selectedValue = choiceBox.getValue();
        Waerungsrechner w=Waerungsrechner.createWaerungsrechner();
        try{
            double value=Double.parseDouble(amount.getText());
            w.saveEur(selectedValue, value);
            selectedValue = choiceBox1.getValue();
            label.setText("" + w.umrechner(selectedValue));
        }catch (NumberFormatException e){
            label.setText("Falsches Format");
            System.err.println("NumberFormatException");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}