package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://projetociva.al.prodigyan.com.br:3306/forsoft";
    //public static final String URL = "jdbc:mysql://localhost:3306/forsoft";
    public static final String USER = "datasoft";
    public static final String PASS = "devdados21";

    public static Connection getConnection() {
      try {
           try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
          DriverManager.registerDriver(new Driver() {});
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Erro ao conectar ao banco de dados", ex);
      }
    }
}