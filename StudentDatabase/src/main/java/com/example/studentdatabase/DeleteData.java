import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class DeleteData {

    public static void Delete() throws SQLException {

        String url = "jdbc:sqlserver://sql.coccork.ie:8443;databaseName=BSCao;user=brian.sheridan@coccork.ie;password=Watermill15";
        Connection conn = null;
        Statement stmt = null;

        try {

            //Getting a connection to the database.
            conn = DriverManager.getConnection(url);

            // Creating the statement
            stmt = conn.createStatement();

            //Executing the SQL Query
            String sql = "DELETE FROM BSModuleResults WHERE PPSN = '1122334A'";

            int numberAffectedRows = stmt.executeUpdate(sql);
            System.out.println("Rows Affected: " + numberAffectedRows);
            System.out.println("Delete Complete");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Record Deleted");
            alert.setHeaderText("Record Deleted");
            alert.setContentText("You have deleted this student record. Refresh for new table.");
            alert.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stmt != null) {
                stmt.close();
            }if(conn != null) {
                conn.close();
            }
        }

    }

}
