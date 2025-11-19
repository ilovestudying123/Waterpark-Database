package com.example.goolagoondb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Types; // Import for setNull

public class TicketTransactionsController {

    @FXML private TextField txtOTCustomerNumber;
    @FXML private TextField txtOTFirstName;
    @FXML private TextField txtOTLastName;
    @FXML private TextField txtOTPhone;
    @FXML private TextField txtOTEmail;
    @FXML private TextField txtOTAge;
    @FXML private CheckBox chkOTPWD;
    @FXML private Button btnOTBack;
    @FXML private Button btnOTProceed;
    @FXML private Label lblOutput;

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/waterparkdb";
    private static final String USER = "root";
    private static final String PASS = "12345";

    private static final int CHILD_AGE_LIMIT = 13;

    @FXML
    public void initialize() {
        lblOutput.setText("");
    }

    @FXML
    private void orderTicket() {
        lblOutput.setText("");
        lblOutput.setStyle("-fx-text-fill: red;");

        if (!validateInput()) {
            return;
        }

        String firstName = txtOTFirstName.getText().trim();
        String lastName = txtOTLastName.getText().trim();
        String phoneNo = txtOTPhone.getText().trim();
        String email = txtOTEmail.getText().trim();
        boolean isPWD = chkOTPWD.isSelected();
        int age = Integer.parseInt(txtOTAge.getText().trim());

        String ticketType = (age >= CHILD_AGE_LIMIT) ? "Adult" : "Child";

        String datePurchased = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Connection conn = null;
        int newTicketId = -1;
        int newCustomerNo = -1;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
            newCustomerNo = insertNewCustomer(conn, firstName, lastName, phoneNo, email, age, isPWD);
            newTicketId = insertTicket(conn, newCustomerNo, ticketType, datePurchased);

            conn.commit();

            lblOutput.setStyle("-fx-text-fill: green;");
            lblOutput.setText("Ticket #" + newTicketId + " (" + ticketType + ") ordered successfully. Customer ID: #" + newCustomerNo + ".");
            clearFields();

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("Transaction rolled back successfully.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Failed to rollback transaction: " + rollbackEx.getMessage());
                }
            }

            System.err.println("SQL State: " + e.getSQLState() + " | Error Code: " + e.getErrorCode());
            e.printStackTrace();

            if (e.getSQLState().startsWith("23")) {
                lblOutput.setText("Database integrity error. Check console for details.");
            } else {
                lblOutput.setText("Database error: Transaction failed.");
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException closeEx) {
                    System.err.println("Failed to close connection: " + closeEx.getMessage());
                }
            }
        }
    }

    private int insertNewCustomer(Connection conn, String firstName, String lastName,
                                  String phoneNo, String email, int age, boolean isPWD) throws SQLException {

        String insertSql = "INSERT INTO customer (last_name, first_name, phone_number, email, number_of_visits, is_PWD, age) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement insertPs = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

            insertPs.setString(1, lastName);
            insertPs.setString(2, firstName);
            insertPs.setString(3, phoneNo);
            insertPs.setString(4, email);
            insertPs.setInt(5, 1);
            insertPs.setBoolean(6, isPWD);
            insertPs.setInt(7, age);

            int rowsAffected = insertPs.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertPs.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating customer failed, no generated ID obtained.");
                }
            }
        }
    }

    /**
     * Inserts a new ticket record, linked to the provided customerNo.
     * Non-UI Fields Default: date_of_use is set to NULL.
     */
    private int insertTicket(Connection conn, int customerNo, String ticketType, String datePurchased) throws SQLException {
        String insertSql = "INSERT INTO ticket (customer_no, ticket_type, date_purchased, date_of_use) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, customerNo);
            ps.setString(2, ticketType);
            ps.setString(3, datePurchased);

            ps.setNull(4, Types.TIMESTAMP);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating ticket failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the auto-generated ticket_no
                } else {
                    throw new SQLException("Creating ticket failed, no ID obtained.");
                }
            }
        }
    }


    private void clearFields() {
        txtOTCustomerNumber.clear();
        txtOTFirstName.clear();
        txtOTLastName.clear();
        txtOTPhone.clear();
        txtOTEmail.clear();
        txtOTAge.clear();
        chkOTPWD.setSelected(false);
    }

    /**
     * Performs basic input validation.
     */
    private boolean validateInput() {
        if (    txtOTFirstName.getText().trim().isEmpty() ||
                txtOTLastName.getText().trim().isEmpty() ||
                txtOTPhone.getText().trim().isEmpty() ||
                txtOTEmail.getText().trim().isEmpty() ||
                txtOTAge.getText().trim().isEmpty()) {

            lblOutput.setText("All text fields must be filled out.");
            return false;
        }

        try {
            int age = Integer.parseInt(txtOTAge.getText().trim());
            if (age < 0 || age > 120) {
                lblOutput.setText("Age must be between 0 and 120.");
                return false;
            }
        } catch (NumberFormatException e) {
            lblOutput.setText("Age must be a valid number.");
            return false;
        }

        return true;
    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Transactions-View.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Transactions Menu");
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading Transactions-View.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }
}