package com.example.studentdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ModuleBrowser extends Application {
    List<ModuleDisplay> list = new ArrayList<>();
    // List of contact table properties
    float totalPoints = 0;
    TableView<ModuleDisplay> contactsTable = new TableView<>();

    private final GridPane gridPane = new GridPane();
    private final Label lblName = new Label("Search by Name");
    private ObservableList<ModuleDisplay> observableNames;
    TableView<ModuleDisplay> contactTableView = new TableView<>();

    public ModuleBrowser() {
        //Loading teh JDBC Driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("JDBC driver loaded");
        } catch (Exception err) {
            System.err.println("Error loading JDBC driver");
            err.printStackTrace(System.err);
            System.exit(0);
        }
        Connection databaseConnection = null;
        try {
            //Trying to connect to the Database
            //Login details are hard coded so entry is not blocked
            String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8443;databaseName=BSCao;user=brian.sheridan@coccork.ie;password=Watermill15";
            System.out.println(connectionUrl);

            //successfully connected to Database
            databaseConnection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to the database");

            System.out.println("Database Connected");

            String queryString = "select * from BSModuleResults";
            System.out.println(queryString);
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
            ResultSet rset = preparedStatement.executeQuery();

            while (rset.next()) {
                String name = rset.getString("PPSN");

                String cname = rset.getString("Fname");
                //setting all the details for the students and their results
                //adding all the total points to a total tally to display at the end.
                System.out.println(name + " " + cname);
                ModuleDisplay p = new ModuleDisplay();
                p.setPpsn(rset.getString("PPSN"));
                p.setFname(rset.getString("Fname"));
                p.setSname(rset.getString("Sname"));
                p.setMod1(rset.getFloat("5N2928"));
                totalPoints = addTotal(rset.getFloat("5N2928"));
                p.setMod2(rset.getFloat("5N2929"));
                totalPoints = addTotal(rset.getFloat("5N2929"));
                p.setMod3(rset.getFloat("5N0548"));
                totalPoints = addTotal(rset.getFloat("5N0548"));
                p.setMod4(rset.getFloat("5N2434"));
                totalPoints = addTotal(rset.getFloat("5N2434"));
                p.setMod5(rset.getFloat("5N2927"));
                totalPoints = addTotal(rset.getFloat("5N2927"));
                p.setMod6(rset.getFloat("5N18396"));
                totalPoints = addTotal(rset.getFloat("5N18396"));
                p.setMod7(rset.getFloat("5N0783"));
                totalPoints = addTotal(rset.getFloat("5N0783"));
                p.setMod8(rset.getFloat("5N0690"));
                totalPoints = addTotal(rset.getFloat("5N0690"));
                p.setMod9(rset.getFloat("5N1356"));
                totalPoints = addTotal(rset.getFloat("5N1356"));
                p.setTotpts(totalPoints);

                list.add(p);
                totalPoints = 0;
                System.out.println("found one ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblName.setTextFill(Color.web("#0076a3"));
        observableNames = FXCollections.observableArrayList(list);
    }

    @Override
    public void start(Stage primaryStage) {
        observableNames = FXCollections.observableArrayList(list);

        //Adding the results to the table to be displayed as a table on our GUI
        TableColumn<ModuleDisplay, String> ppsn = new TableColumn<>("Personal No");
        contactsTable.getColumns().add(ppsn);
        ppsn.setCellValueFactory(new PropertyValueFactory<>("ppsn"));
        ppsn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<ModuleDisplay, String> fname = new TableColumn<>("First Name");
        contactsTable.getColumns().add(fname);
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        fname.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<ModuleDisplay, String> sname = new TableColumn<>("Last Name");
        contactsTable.getColumns().add(sname);
        sname.setCellValueFactory(new PropertyValueFactory<>("sname"));
        sname.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<ModuleDisplay, Float> mod1 = new TableColumn<>("Oper Sys");
        contactsTable.getColumns().add(mod1);
        mod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));

        TableColumn<ModuleDisplay, Float> mod2 = new TableColumn<>("Networking");
        contactsTable.getColumns().add(mod2);
        mod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));

        TableColumn<ModuleDisplay, Float> mod3 = new TableColumn<>("Hardware");
        contactsTable.getColumns().add(mod3);
        mod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));

        TableColumn<ModuleDisplay, Float> mod4 = new TableColumn<>("Virtualisation");
        contactsTable.getColumns().add(mod4);
        mod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));

        TableColumn<ModuleDisplay, Float> mod5 = new TableColumn<>("Programming");
        contactsTable.getColumns().add(mod5);
        mod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));

        TableColumn<ModuleDisplay, Float> mod6 = new TableColumn<>("Maths for IT");
        contactsTable.getColumns().add(mod6);
        mod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));

        TableColumn<ModuleDisplay, Float> mod7 = new TableColumn<>("Database");
        contactsTable.getColumns().add(mod7);
        mod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));

        TableColumn<ModuleDisplay, Float> mod8 = new TableColumn<>("Communications");
        contactsTable.getColumns().add(mod8);
        mod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));

        TableColumn<ModuleDisplay, Float> mod9 = new TableColumn<>("Work Experience");
        contactsTable.getColumns().add(mod9);
        mod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));

        TableColumn<ModuleDisplay, Float> totpts = new TableColumn<>("Total Points");
        contactsTable.getColumns().add(totpts);
        totpts.setCellValueFactory(new PropertyValueFactory<>("totpts"));

        contactsTable.setItems(observableNames);
        contactsTable.setEditable(true);
        primaryStage.setTitle("Student Names");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 650, 400, true);

        gridPane.add(contactsTable, 0, 0);
        gridPane.setBackground(new Background(new BackgroundFill(Color.DIMGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        //Adding buttons and labels to the screen for different functionality.
        Button btnDelete = new Button("      Delete         ");
        btnDelete.setTextFill(Color.DARKORANGE);
        Button btnSearch = new Button("      Search         ");
        btnSearch.setTextFill(Color.DARKORANGE);
        Button btnAdd = new Button("    Add Pupil      ");
        btnAdd.setTextFill(Color.DARKORANGE);
        Button btnUpdate = new Button("Update Details  ");
        btnUpdate.setTextFill(Color.DARKORANGE);
        Button btnViewCao = new Button("View Cao Points");
        btnViewCao.setTextFill(Color.DARKORANGE);
        Button btnHelp = new Button("          Help        ");
        btnHelp.setTextFill(Color.DARKORANGE);
        Label SearchLbl = new Label("");
        Label lbl2 = new Label("");
        Label lbl3 = new Label("");
        Label lbl4 = new Label("");
        Label lbl5 = new Label("");
        Label lbl6 = new Label("");

        //Adding teh buttons and labels to the positions i want them at on the screen.
        gridPane.add(btnSearch, 1, 2);
        gridPane.add(btnDelete, 1, 4);
        gridPane.add(btnAdd, 1, 6);
        gridPane.add(btnUpdate, 1, 8);
        gridPane.add(btnViewCao, 1, 10);
        gridPane.add(btnHelp, 1, 12);
        gridPane.add(SearchLbl, 1, 1);
        gridPane.add(lbl2, 1, 3);
        gridPane.add(lbl3, 1, 5);
        gridPane.add(lbl4, 1, 7);
        gridPane.add(lbl5, 1, 9);
        gridPane.add(lbl6, 1, 11);

        //Adding function to the button when pressed
        btnDelete.setOnAction(e -> {
            try {
                DeleteData.Delete();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        //Adding function to the button when pressed
        btnAdd.setOnAction(e -> {
            try {
                InsertData.Insert();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        //Adding function to the button when pressed
        btnUpdate.setOnAction(e -> {
            try {
                UpdateData.Update();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        //Adding function to the button when pressed
        btnViewCao.setOnAction(e -> {
            try {
                ShowPoints.ShowPoint();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        //Adding function to the button when pressed
        btnHelp.setOnAction(e -> {
            HelpPage.Help();
        });

        borderPane.setCenter(contactsTable);
        borderPane.setLeft(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Method for calculating the grade and the points gicen for that grade.
    private float addTotal(float grade) {
        if (grade >= 80) {
            totalPoints += 38.75;
        } else if (grade >= 65) {
            totalPoints += 32.5;
        } else if (grade >= 50) {
            totalPoints += 16.35;
        }

        return totalPoints;

    }
}