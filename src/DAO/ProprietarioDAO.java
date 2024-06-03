package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProprietarioDAO {
  private Connection connection;
  private PreparedStatement preparedstatament;

  public ProprietarioDAO() {
    connection = BD.getConnection();
  }

  public void buscaProprietario() {
    String sql = "SELECT * FROM proprietario";

    try {
      preparedstatament = connection.prepareStatement(sql);
      ResultSet resultset = preparedstatament.executeQuery();

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
      preparedstatament.close();

    } catch (SQLException e) {
      System.out.println("Erro: " + e.getMessage());
    }

  }

  public void inserirProprietario(String nomeUsuario, String nomePessoa, String senha, String CPF, int idEndereco) {
    String sql = "INSERT INTO proprietario(nomeUsuario, nomePessoa, senha, CPF, idEndereco) VALUES (?, ?, ?, ?, ?)";

    try {
      preparedstatament = connection.prepareStatement(sql);

      preparedstatament.setString(1, nomeUsuario);
      preparedstatament.setString(2, nomePessoa);
      preparedstatament.setString(3, senha);
      preparedstatament.setString(4, CPF);
      preparedstatament.setInt(5, idEndereco);

      preparedstatament.execute();

      preparedstatament.close();

    } catch (SQLException error) {
      System.out.println("Erro: " + error.getMessage());
    }
  }

}