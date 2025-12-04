import java.sql.*;
public class JDBConnectivity {
    public static void main(String[] args){
        try{
            // load or register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create a connection to the DB
            Connection con = DriverManager.getConnection("jdbc:myqsl://localhost:3306/school", "root", "password");

            // create a statemennt that will be used to execute a query
            String sql = "INSERT INTO SCHOOL('id', 'name', 'age') VALUES(?,?) ";
            Statement stmt = con.createStatement();

            // execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // process the result set
            while(rs.next()){
                System.out.println(rs.getInt("id" + " " + rs.getString("name") + " " + rs.getInt("age")));
            }
            // close the connection after the work s done
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}