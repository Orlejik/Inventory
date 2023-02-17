import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnetor {
    private static Connection connection=null;
    private static PreparedStatement pStatement= null;
    private static ResultSet resultSet = null;
    private static final String userName = "artiom";

    public static Connection getConnection() {
        return connection;
    }
    public static void setConnection(Connection connection) {
        MysqlConnetor.connection = connection;
    }
    public static PreparedStatement getpStatement() {
        return pStatement;
    }
    public static void setpStatement(PreparedStatement pStatement) {
        MysqlConnetor.pStatement = pStatement;
    }
    public static ResultSet getResultSet() {
        return resultSet;
    }
    public static void setResultSet(ResultSet resultSet) {
        MysqlConnetor.resultSet = resultSet;
    }
    private static final String password = "admin";

    public static Connection mysqlConnection(String dbName){
        String dbUrl = "jdbc:mysql://10.20.193.237:3306/"+dbName+"?useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try{
                setConnection(DriverManager.getConnection(dbUrl, userName, password));
                System.out.println("Connection established!");
            }catch (Exception e){
                System.out.println("Connection is not successful!" +e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
