package com.example.goolagoondb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LockerTransactionsController {

    @FXML
    private Button btnOTBack;
    @FXML
    private TextField txtRLTicketNumber;
    @FXML
    private Button btnRLProceed;
    @FXML
    private Label lblOutput;
    @FXML
    private MenuButton mnLockerSize;
    @FXML
    private MenuItem mnSmallSize;
    @FXML
    private MenuItem mnMediumSize;
    @FXML
    private MenuItem mnLargeSize;
    @FXML
    private Button btnRLBack;

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/waterparkdb";
    private static final String USER = "root";
    private static final String PASS = "12345";

    private String selectedSizeCode = null;

    @FXML
    public void initialize() {
        mnSmallSize.setOnAction(e -> {
            mnLockerSize.setText("Small");
            selectedSizeCode = "S";
        });

        mnMediumSize.setOnAction(e -> {
            mnLockerSize.setText("Medium");
            selectedSizeCode = "M";
        });

        mnLargeSize.setOnAction(e -> {
            mnLockerSize.setText("Large");
            selectedSizeCode = "L";
        });

        lblOutput.setText("");
    }

    @FXML
    private void rentLocker() {
        lblOutput.setText("");
        String ticketNumberText = txtRLTicketNumber.getText();

        if (ticketNumberText.isEmpty() || selectedSizeCode == null) {
            lblOutput.setText("Please enter a Ticket No. and select a Locker Size.");
            return;
        }

        int ticketNo;
        try {
            ticketNo = Integer.parseInt(ticketNumberText);
        } catch (NumberFormatException e) {
            lblOutput.setText("Invalid Ticket Number format.");
            return;
        }

        String selectSql = "SELECT locker_no FROM locker WHERE size = ? AND availability_status = TRUE LIMIT 1";

        String updateSql = "UPDATE locker SET availability_status = FALSE, ticket_no = ? WHERE locker_no = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            int lockerNo = -1;
            try (PreparedStatement ps = conn.prepareStatement(selectSql)) {
                ps.setString(1, selectedSizeCode);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        lockerNo = rs.getInt("locker_no");
                    }
                }
            }

            if (lockerNo == -1) {
                lblOutput.setText("No available lockers of size: " + mnLockerSize.getText());
                return;
            }

            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {
                ps.setInt(1, ticketNo);
                ps.setInt(2, lockerNo);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    lblOutput.setStyle("-fx-text-fill: green;");
                    lblOutput.setText("Locker #" + lockerNo + " rented successfully for Ticket #" + ticketNo + ".");
                } else {
                    lblOutput.setText("Failed to rent locker.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            lblOutput.setText("Database error: Could not complete transaction.");
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            switchScene(event, "Main-Menu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/goolagoondb/" + fxmlFile));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}