package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.BD;
import model.Proprietario;

public class ProprietarioDAO {
  private Connection connection;
  private PreparedStatement preparedstatement;

  public ProprietarioDAO() {
    connection = BD.getConnection();
  }

  public void buscarProprietario() {
    String sql = "SELECT * FROM proprietario";

    try {
      preparedstatement = connection.prepareStatement(sql);
      ResultSet resultset = preparedstatement.executeQuery();

      while (resultset.next()) {
        int id = resultset.getInt("idProprietario");
        String usuario = resultset.getString("nomeUsuario");
        String pessoa = resultset.getString("nomePessoa");
        String senha = resultset.getString("senha");
        String cpf = resultset.getString("CPF");
        int idEnd = resultset.getInt("idEndereco");

        System.out.println("ID: " + id);
        System.out.println("Usuario: " + usuario);
        System.out.println("Nome da pessoa: " + pessoa);
        System.out.println("senha: " + senha);
        System.out.println("cpf: " + cpf);
        System.out.println("id do endereço: " + idEnd);
      }
      preparedstatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }

  }

  public Proprietario buscarProprietarioPorNomeDeUsuario(String nomeUsuario) {
    String sql = "SELECT * FROM proprietario WHERE nomeUsuario = ?";
    Proprietario proprietario = null;

    try {
      preparedstatement = connection.prepareStatement(sql);
      preparedstatement.setString(1, nomeUsuario);

      ResultSet resultset = preparedstatement.executeQuery();

      while (resultset.next()) {
        int id = resultset.getInt("idProprietario");
        String usuario = resultset.getString("nomeUsuario");
        String nome = resultset.getString("nomePessoa");
        String senha = resultset.getString("senha");
        String cpf = resultset.getString("CPF");
        int idEnd = resultset.getInt("idEndereco");

        proprietario = new Proprietario(nome, cpf, usuario, senha, id, idEnd);
      }
      preparedstatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }

    return proprietario;
  }

  public Proprietario buscarProprietarioParaValidarLogin(String nomeUsuario, String senhaUsuario) {
    String sql = "SELECT * FROM proprietario WHERE nomeUsuario = ? AND senha = ?";
    Proprietario proprietario = null;

    try {
      preparedstatement = connection.prepareStatement(sql);
      preparedstatement.setString(1, nomeUsuario);
      preparedstatement.setString(2, senhaUsuario);

      ResultSet resultset = preparedstatement.executeQuery();

      while (resultset.next()) {
        int id = resultset.getInt("idProprietario");
        String usuario = resultset.getString("nomeUsuario");
        String nome = resultset.getString("nomePessoa");
        String senha = resultset.getString("senha");
        String cpf = resultset.getString("CPF");
        int idEnd = resultset.getInt("idEndereco");

        proprietario = new Proprietario(nome, cpf, usuario, senha, id, idEnd);
      }
      preparedstatement.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }

    return proprietario;
  }

  public void inserirProprietario(Proprietario proprietario) {
    String sql = "INSERT INTO proprietario(nomeUsuario, nomePessoa, senha, CPF, idEndereco) VALUES (?, ?, ?, ?, ?)";

    try {
      preparedstatement = connection.prepareStatement(sql);

      preparedstatement.setString(1, proprietario.getNomeUsuario());
      preparedstatement.setString(2, proprietario.getNome());
      preparedstatement.setString(3, proprietario.getSenha());
      preparedstatement.setString(4, proprietario.getCpf());
      preparedstatement.setInt(5, proprietario.getIdEndereco());

      preparedstatement.execute();

      preparedstatement.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

}