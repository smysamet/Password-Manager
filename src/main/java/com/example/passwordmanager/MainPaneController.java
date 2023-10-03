package com.example.passwordmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

public class MainPaneController {

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button generatePasswordButton;

    @FXML
    private Pane mainPane;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Label websiteLabel;

    @FXML
    private TextField websiteTextField;

    @FXML
    private void onSaveButtonClicked() {
        if (areTextFieldsEmpty()) {
            createAlert(AlertType.WARNING, "Warning", "Some Fields Are Empty!", "Please dont leave empty fields!");
            return;
        }

        String website = websiteTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        PasswordEntry passwordEntry = new PasswordEntry(website, email, password);

        PasswordEntryManager.savePasswordEntry(passwordEntry);
    }

    @FXML
    private void onGeneratePasswordButtonClicked() {
        passwordTextField.setText(PasswordCreator.createPassword());
    }

    private boolean areTextFieldsEmpty() {
        return websiteTextField.getText().isBlank() || passwordTextField.getText().isBlank()
                || emailTextField.getText().isBlank();
    }

    private void createAlert(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
