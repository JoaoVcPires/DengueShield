package dao;

import java.sql.*;
import java.util.ArrayList;

import connection.BD;
import model.Caso;
import model.InformacaoDetalhadaDeCaso;

public class CasoDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;

  public CasoDAO() {
    connection = BD.getConnection();
  }

  public void BuscarCasos() {
    String sql = "SELECT * FROM caso";

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int idCaso = resultSet.getInt("idcaso");
        String descricao = resultSet.getString("descricao");
        int idEndereco = resultSet.getInt("idendereco");

        System.out.println("ID do Caso" + idCaso);
        System.out.println("Descricao do caso" + descricao);
        System.out.println("ID do Endereco" + idEndereco);

      }
      preparedStatement.close();
    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

  }

  public void inserirCaso(Caso caso) {
    String sql = "INSERT INTO caso (descricao, idEndereco) VALUES (?, ?)";
    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setString(1, caso.getDescricao());
      preparedStatement.setInt(2, caso.getIdEndereco());

      preparedStatement.execute();

      preparedStatement.close();

      System.out.println("Caso cadastrado com sucesso!");
    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

  public ArrayList<InformacaoDetalhadaDeCaso> buscarListaDeCasos() {
    String sql = "SELECT caso.idCaso, caso.descricao, endereco.logradouro, endereco.numCasa, bairro.descricao as bairro FROM caso, endereco, bairro WHERE caso.idEndereco = endereco.idEndereco AND endereco.idBairro = bairro.idBairro ORDER BY caso.idCaso DESC;";
    ArrayList<InformacaoDetalhadaDeCaso> listaDeCasos = new ArrayList<>();

    try {
      preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idCaso = resultSet.getInt("idcaso");
        String descricao = resultSet.getString("descricao");
        String logradouro = resultSet.getString("logradouro");
        String bairroNome = resultSet.getString("bairro");
        int numeroDaCasa = resultSet.getInt("numCasa");

        InformacaoDetalhadaDeCaso informacaoDetalhadaDeCaso = new InformacaoDetalhadaDeCaso(idCaso, descricao,
            logradouro, bairroNome, numeroDaCasa);
        listaDeCasos.add(informacaoDetalhadaDeCaso);
      }
      preparedStatement.close();
    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

    return listaDeCasos;
  }

  public int realizarContagemDeCasosDeUmBairro(int idBairro) {
    String sql = "SELECT count(idCaso) as quantidadeDeCasos FROM caso, endereco WHERE endereco.idBairro = ? AND caso.idEndereco = endereco.idEndereco;";
    int quantidadeDeCasos = 0;

    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idBairro);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        quantidadeDeCasos = resultSet.getInt("quantidadeDeCasos");
      }
      preparedStatement.close();
    } catch (SQLException e) {
      System.out.println((" Error:" + e.getMessage()));
    }

    return quantidadeDeCasos;
  }

  public void atualizarQuantidadeDeCasosTotalNoBairro(int idBairro) {
    String sql = "UPDATE bairro SET casosTotal = ? WHERE idBairro = ?";

    int quantidadeDeCasos = realizarContagemDeCasosDeUmBairro(idBairro);

    try {
      preparedStatement = connection.prepareStatement(sql);

      preparedStatement.setInt(1, quantidadeDeCasos);
      preparedStatement.setInt(2, idBairro);

      preparedStatement.execute();

      preparedStatement.close();
    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

}