package DAO;

import java.sql.*;

public class EnderecoDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public EnderecoDAO() {
    connection = BD.getConnection();
  }

  public void consultaEndereco() {
    String sql = "SELECT * FROM endereco";

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idEndereco = resultSet.getInt("idEndereco");
        String logradouro = resultSet.getString("logradouro");
        String numCasa = resultSet.getString("numCasa");
        boolean focoDengue = resultSet.getBoolean("focoDengue");
        int idBairro = resultSet.getInt("idBanco");

        System.out.println(idEndereco);
        System.out.println(logradouro);
        System.out.println(numCasa);
        System.out.println(focoDengue);
        System.out.println(idBairro);
      }
      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

  public void insereEndereco(String logradouro, int numCasa, int focoDengue, int idBairro) {
    String sql = "INSERT INTO endereco(logradouro, numCasa, focoDengue, idBairro) values (?,?,?,?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, logradouro);
      preparedStatement.setInt(2, numCasa);
      preparedStatement.setInt(3, focoDengue);
      preparedStatement.setInt(4, idBairro);

      preparedStatement.execute();

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}