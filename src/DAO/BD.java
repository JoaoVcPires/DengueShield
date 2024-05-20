package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

//classe de conexão com o banco
public class BD {
  public static final String url = "jdbc:mysql://localhost:3306/dengue_shield"; // url de conexão com o banco
  public static final String user = "root"; // usuario do banco de dados
  public static final String senha = "root";// senha do banco de dados

  public static Connection connection;// variável de conxão do banco de dados

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