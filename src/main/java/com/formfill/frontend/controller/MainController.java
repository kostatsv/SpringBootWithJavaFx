package com.formfill.frontend.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

@Component
public class MainController implements Initializable {

  @FXML
  private Button buttonTest;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    buttonTest.setOnAction(e -> {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Test Button Click");
      alert.setHeaderText("Complete");
      alert.show();
    });

  } // initialize

}
