package dao;

import java.sql.*;
import java.util.ArrayList;

import connection.BD;
import model.Denuncia;
import statusEnum.StatusDeDenuncia;
import statusEnum.StatusDeDenuncia.SelectStatus;

public class DenunciaDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;
  ArrayList<Denuncia> listaDeDenuncias;

  public DenunciaDAO() {
    connection = BD.getConnection();
  }

  public ArrayList<Denuncia> buscarListaDeDenunciasPorProprietario(int idProprietarioDaDenuncia) {
    String sql = "SELECT * FROM denuncia WHERE idProprietario = ?";
    listaDeDenuncias = new ArrayList<>();

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idProprietarioDaDenuncia);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idDenuncia = resultSet.getInt("idDenuncia");
        String descricao = resultSet.getString("descricao");
        int idEndereco = resultSet.getInt("idEndereco");
        int idProprietario = resultSet.getInt("idProprietario");
        String status = resultSet.getString("status");

        StatusDeDenuncia.SelectStatus statusDaDenuncia = StatusDeDenuncia.SelectStatus.getStatus(status);

        Denuncia denuncia = new Denuncia(idDenuncia, descricao, idEndereco, idProprietario, statusDaDenuncia);
        listaDeDenuncias.add(denuncia);
      }
      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }

    return listaDeDenuncias;
  }

  public void buscarListaDeDenuncias() {
    String sql = "SELECT * FROM denuncia";

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idDenuncia = resultSet.getInt("idDenuncia");
        String descricao = resultSet.getString("descricao");
        int idEndereco = resultSet.getInt("idEndereco");
        int idProprietario = resultSet.getInt("idProprietario");
        String status = resultSet.getString("status");

        System.out.println(idDenuncia);
        System.out.println(descricao);
        System.out.println(idEndereco);
        System.out.println(idProprietario);
        System.out.println(status);
      }
      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

  public void insereDenuncia(Denuncia denuncia) {
    String sql = "INSERT INTO denuncia(descricao,idEndereco,idProprietario,status) values (?,?,?,?)";

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, denuncia.getDescricao());
      preparedStatement.setInt(2, denuncia.getIdEndereco());
      preparedStatement.setInt(3, denuncia.getIdProprietario());
      preparedStatement.setString(4, denuncia.getStatusDenuncia().getDescricao());

      preparedStatement.execute();

      preparedStatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }
  }
}