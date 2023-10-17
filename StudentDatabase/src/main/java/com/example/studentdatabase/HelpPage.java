import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelpPage{

    public static void Help() {

        //Setting stage and scene
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Help and FAQ's");
        BorderPane root = new BorderPane();
        ///setting specifications of size and colour
        Scene scene = new Scene(root, 850, 850, Color.DARKGREY);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(10);
        grid.setHgap(10);
        ColumnConstraints column1 = new ColumnConstraints(50);
        ColumnConstraints column2 = new ColumnConstraints(25, 75, 150);
        column2.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().addAll(column1, column2);


        //Adding Question and answer for FQA's
        Text q1 = new Text("Search Function");
        q1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        q1.setFill(Color.BLACK);
        Text underLine = new Text("________________________________");
        Text a1 = new Text("Use the search funstion to search for a specific student you are looking for. Enter the students details and find their details and their results.");

        //Adding Question and answer for FQA's
        Text q2 = new Text("Delete Fuction");
        q2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        q2.setFill(Color.BLACK);
        Text underLine2 = new Text("________________________________");
        Text a2 = new Text("Use the delete function to delete a students details and results from the CAO points Table. This can be used to remove students information.");

        //Adding Question and answer for FQA's
        Text q3 = new Text("Add Pupil Function");
        q3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        q3.setFill(Color.BLACK);
        Text underLine3 = new Text("________________________________");
        Text a3 = new Text("Use this function if you wish to add a student to the CAO table. Enter the students details and their results and they will be added to the table.");

        //Adding Question and answer for FQA's
        Text q4 = new Text("Update Details");
        q4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        q4.setFill(Color.BLACK);
        Text underLine4 = new Text("________________________________");
        Text a4 = new Text("Use this function if you wish to change a students details or make changes to their results. You can enter the new details you want to add \nand these changes will be reflected when the table is refreshed.");

        //Adding Question and answer for FQA's
        Text q5 = new Text("View CAO points.");
        q5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        q5.setFill(Color.BLACK);
        Text underLine5 = new Text("________________________________");
        Text a5 = new Text("This function can be used to check how many points are required for each course.");

        //Setting the position of each question
        GridPane.setHalignment(q1, HPos.LEFT);
        grid.add(q1, 0, 1);
        GridPane.setHalignment(underLine, HPos.LEFT);
        grid.add(underLine, 0, 2);
        GridPane.setHalignment(a1, HPos.LEFT);
        grid.add(a1, 0, 3);
        GridPane.setHalignment(q2, HPos.LEFT);
        grid.add(q2, 0, 5);
        GridPane.setHalignment(underLine2, HPos.LEFT);
        grid.add(underLine2, 0, 6);
        GridPane.setHalignment(a2, HPos.LEFT);
        grid.add(a2, 0, 7);
        GridPane.setHalignment(q3, HPos.LEFT);
        grid.add(q3, 0, 9);
        GridPane.setHalignment(underLine3, HPos.LEFT);
        grid.add(underLine3, 0, 10);
        GridPane.setHalignment(a3, HPos.LEFT);
        grid.add(a3, 0, 11);
        GridPane.setHalignment(q4, HPos.LEFT);
        grid.add(q4, 0, 13);
        GridPane.setHalignment(underLine4, HPos.LEFT);
        grid.add(underLine4, 0, 14);
        GridPane.setHalignment(a4, HPos.LEFT);
        grid.add(a4, 0, 15);
        GridPane.setHalignment(q5, HPos.LEFT);
        grid.add(q5, 0, 17);
        GridPane.setHalignment(underLine5, HPos.LEFT);
        grid.add(underLine5, 0, 18);
        GridPane.setHalignment(a5, HPos.LEFT);
        grid.add(a5, 0, 19);


        //Adding style to the page
        FlowPane topBanner = new FlowPane();
        topBanner.setAlignment(Pos.TOP_LEFT);
        topBanner.setPrefHeight(40);
        String backgroundStyle =
                "-fx-background-color: dimgrey;"
                        + "-fx-background-radius: 3px;"
                        + "-fx-background-inset: 5px;";
        topBanner.setStyle(backgroundStyle);

        FlowPane bottomBanner = new FlowPane();
        bottomBanner.setAlignment(Pos.BOTTOM_LEFT);
        bottomBanner.setPrefHeight(20);
        String backgroundStyle2 =
                "-fx-background-color: dimgrey;"
                        + "-fx-background-radius: 3px;"
                        + "-fx-background-inset: 5px;";
        bottomBanner.setStyle(backgroundStyle2);

        Text contactText = new Text("Help and FAQ's");
        contactText.setFill(Color.DARKORANGE);

        Text endText = new Text("Help and FAQ's");
        endText.setFill(Color.DARKORANGE);


        Font serif = Font.font("Proxima Nova", 30);
        contactText.setFont(serif);
        endText.setFont(serif);
        bottomBanner.getChildren().addAll(endText);
        topBanner.getChildren().addAll(contactText);

        root.setTop(topBanner);
        root.setCenter(grid);
        root.setBottom(bottomBanner);

        primaryStage.setScene(scene);

        primaryStage.show();
    }





}

