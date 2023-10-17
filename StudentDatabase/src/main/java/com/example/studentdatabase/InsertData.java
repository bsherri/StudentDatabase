import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InsertData {

    public static void Insert() throws SQLException {

        String url = "jdbc:sqlserver://sql.coccork.ie:8443;databaseName=BSCao;user=brian.sheridan@coccork.ie;password=Watermill15";

        Connection conn = null;
        Statement stmt = null;

        try {

            //Getting a connection to database

            conn = DriverManager.getConnection(url);

            //Creating the MYSQL statement

            stmt = conn.createStatement();

            //Executing the SQL Query

            String sql = "INSERT INTO BSModuleResults" + "(PPSN, Fname, Sname, [5N2928], [5N2929], [5N0548], [5N2434], [5N2927], [5N18396], [5N0783], [5N0690], [5N1356])"
                    + "VALUES('1122334A', 'Brian', 'Sheridan','70','80','75','90','85','76','81','80','74')";

            //Outputting info and alert box
            int numberAffectedRows = stmt.executeUpdate(sql);
            System.out.println("Rows Affected: " + numberAffectedRows);
            System.out.println("Insert Complete");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Pupil Added");
            alert.setHeaderText("Pupil Added");
            alert.setContentText("You have added a student to the records. Refresh the table to see the student's results.");
            alert.showAndWait();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(stmt != null) {
                stmt.close();
            } if (conn != null) {
                conn.close();
            }
        }

    }

}
