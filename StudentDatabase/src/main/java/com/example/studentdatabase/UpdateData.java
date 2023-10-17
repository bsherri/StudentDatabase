import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class UpdateData {

    public static void Update() throws SQLException {

        String url = "jdbc:sqlserver://sql.coccork.ie:8443;databaseName=BSCao;user=brian.sheridan@coccork.ie;password=Watermill15";

        Connection conn = null;
        Statement stmt = null;

        try {
            //Getting the connection to the database
            conn = DriverManager.getConnection(url);

            //Creating the statement
            stmt = conn.createStatement();

            //Executing the SQL Query

            String sql = "UPDATE BSModuleResults SET Sname='Dunne' WHERE PPSN = '1232132A'";

            int rowsAffected = stmt.executeUpdate(sql);

            //Outputting success and alert box
            System.out.println("Rows Affected: " + rowsAffected);
            System.out.println("Update Completed");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Details Updated");
            alert.setHeaderText("Details Updated");
            alert.setContentText("You have updated this pupils details.");
            alert.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
