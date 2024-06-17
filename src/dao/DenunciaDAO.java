package dao;

import java.sql.*;

import connection.BD;
import model.Denuncia;

public class DenunciaDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public DenunciaDAO() {
    connection = BD.getConnection();
  }

  public void consultaDenuncia() {
    String sql = "SELECT * FROM denuncia";

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idDenuncia = resultSet.getInt("idDenuncia");
        String descricao = resultSet.getString("descricao");
        int idEndereco = resultSet.getInt("idEndereco");
        int idProprietario = resultSet.getInt("idProprietario");

        System.out.println(idDenuncia);
        System.out.println(descricao);
        System.out.println(idEndereco);
        System.out.println(idProprietario);
      }
      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

  public void insereDenuncia(Denuncia denuncia) {
    String sql = "INSERT INTO denuncia(descricao,idEndereco,idProprietario) values (?,?,?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, denuncia.getDescricao());
      preparedStatement.setInt(2, denuncia.getIdEndereco());
      preparedStatement.setInt(3, denuncia.getIdProprietario());

      preparedStatement.execute();

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}