package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {
  public static final String url = "jdbc:mysql://localhost:3306/dengue_shield";
  public static final String user = "root";
  public static final String senha = "root";

  public static Connection connection;

  public static Connection getConnection() {
    try {
      if (connection == null) {
        connection = DriverManager.getConnection(url, user, senha);
        System.out.println("Conectado!");
        return connection;
      } else {
        System.out.println("Ja esta conectado!");
        return connection;
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }
}
