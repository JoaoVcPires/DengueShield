package dao;

import java.sql.*;

import connection.BD;
import model.Endereco;

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

  public void insereEndereco(Endereco endereco) {
    String sql = "INSERT INTO endereco(logradouro, numCasa, focoDengue, idBairro) values (?,?,?,?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, endereco.getLogradouro());
      preparedStatement.setInt(2, endereco.getNumCasa());
      preparedStatement.setInt(3, endereco.isFocoDengue() == true ? 1 : 0);
      preparedStatement.setInt(4, endereco.getIdBairro());

      preparedStatement.execute();

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}