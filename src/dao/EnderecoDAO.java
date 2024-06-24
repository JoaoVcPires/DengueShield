package dao;

import java.sql.*;
import java.util.ArrayList;

import connection.BD;
import model.Endereco;

public class EnderecoDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;
  ArrayList<Endereco> listaEnderecos;

  public EnderecoDAO() {
    connection = BD.getConnection();
  }

  public Endereco buscarEnderecoPorIdEndereco(int idEnderecoEscolhido) {
    String sql = "SELECT * FROM endereco WHERE idEndereco = ?";
    Endereco endereco = null;

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idEnderecoEscolhido);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idEndereco = resultSet.getInt("idEndereco");
        String logradouro = resultSet.getString("logradouro");
        int numCasa = resultSet.getInt("numCasa");
        boolean focoDengue = resultSet.getInt("focoDengue") == 1;
        int idBairro = resultSet.getInt("idBairro");

        endereco = new Endereco(idEndereco, logradouro, numCasa, idBairro, focoDengue);
      }

      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }

    return endereco;
  }

  public Endereco buscarEnderecoPorIdEnderecoEIdBairro(int idEnderecoEscolhido, int idBairroDoAgente) {
    String sql = "SELECT * FROM endereco WHERE idEndereco = ? AND idBairro = ?";
    Endereco endereco = null;

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idEnderecoEscolhido);
      preparedStatement.setInt(2, idBairroDoAgente);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idEndereco = resultSet.getInt("idEndereco");
        String logradouro = resultSet.getString("logradouro");
        int numCasa = resultSet.getInt("numCasa");
        boolean focoDengue = resultSet.getInt("focoDengue") == 1;
        int idBairro = resultSet.getInt("idBairro");

        endereco = new Endereco(idEndereco, logradouro, numCasa, idBairro, focoDengue);
      }

      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }

    return endereco;
  }

  public ArrayList<Endereco> buscarListaDeEnderecoPorBairro(int idBairroEscolhido) {
    String sql = "SELECT * FROM endereco WHERE idBairro = ?";
    listaEnderecos = new ArrayList<>();

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idBairroEscolhido);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idEndereco = resultSet.getInt("idEndereco");
        String logradouro = resultSet.getString("logradouro");
        int numCasa = resultSet.getInt("numCasa");
        boolean focoDengue = resultSet.getInt("focoDengue") == 1;
        int idBairro = resultSet.getInt("idBairro");

        Endereco endereco = new Endereco(idEndereco, logradouro, numCasa, idBairro, focoDengue);
        listaEnderecos.add(endereco);
      }

      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }

    return listaEnderecos;
  }

  public ArrayList<Endereco> buscarListaDeEndereco() {
    String sql = "SELECT * FROM endereco";
    listaEnderecos = new ArrayList<>();

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idEndereco = resultSet.getInt("idEndereco");
        String logradouro = resultSet.getString("logradouro");
        int numCasa = resultSet.getInt("numCasa");
        boolean focoDengue = resultSet.getInt("focoDengue") == 1;
        int idBairro = resultSet.getInt("idBairro");

        Endereco endereco = new Endereco(idEndereco, logradouro, numCasa, idBairro, focoDengue);
        listaEnderecos.add(endereco);
      }

      preparedStatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }

    return listaEnderecos;
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