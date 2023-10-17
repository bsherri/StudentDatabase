import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ShowPoints {

    public static void ShowPoint() throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://sql.coccork.ie:8443;databaseName=BSCao;user=brian.sheridan@coccork.ie;password=Watermill15");

            stmt = conn.createStatement();

            result = stmt.executeQuery("SELECT * FROM BSCaoPoints");

            while(result.next()) {
                System.out.println(result.getString("CourseCode") + ", " + result.getString("CourseName") + "," + result.getString("Points"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                result.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

}
