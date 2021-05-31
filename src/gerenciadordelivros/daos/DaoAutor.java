/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.daos;

import gerenciadordelivros.beans.Autor;
import gerenciadordelivros.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DaoAutor {
    
        // variavel de conexão
    private final Connection c;
    
       // metodo construtor que valoriza a varivel de conexão
    public DaoAutor() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }
    
            // metodo de busca por id
    public Autor buscar (Autor aEntrada) throws SQLException {
        // select por id;
        String sql = "select * from aut_autor WHERE aut_id = ?";
        // variavel de retorno
        Autor retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,aEntrada.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            // percorre o resultset
            while (rs.next()) {
                // criando o objeto Autor
                retorno = new Autor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        }
        c.close();
        return retorno;
    }
    
        public Autor inserir(Autor aEntrada) throws SQLException {
        // escrevo meu select
        String sql = "INSERT INTO aut_autor (aut_nome,aut_idade,aut_editora,aut_genero) VALUES(?,?,?,?)";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,aEntrada.getNome());
            stmt.setString(2,aEntrada.getIdade());
            stmt.setString(3,aEntrada.getEditora());
            stmt.setString(4,aEntrada.getGenero());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            // carrego no bean o id que foi gerado pelo banco de dados
            if(rs.next()) {
                int id = rs.getInt(1);
                aEntrada.setId(id);
            }
        }
        c.close();
        return aEntrada;
    }

    public Autor alterar(Autor aEntrada) throws SQLException {
    // escrevo meu select
        String sql = "UPDATE aut_autor SET aut_nome = ?,aut_idade = ?,aut_editora = ?,aut_genero= ? WHERE aut_id = ?";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,aEntrada.getNome());
            stmt.setString(2,aEntrada.getIdade());
            stmt.setString(3,aEntrada.getEditora());
            stmt.setString(4,aEntrada.getGenero());
            stmt.setInt(5,aEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return aEntrada;
    }

    public Autor excluir(Autor aEntrada) throws SQLException {
        // escrevo meu select
        String sql = "delete from aut_autor WHERE aut_id = ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,aEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return aEntrada;
    }

    public List<Autor> listar(Autor aEntrada) throws SQLException {
        List<Autor> auts = new ArrayList<>();
        // escrevo meu select
        String sql = "select * from aut_autor WHERE aut_nome like ?";
        // variavel de retorno
        Autor retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + aEntrada.getNome() + "%");
            // executa
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Autor
                 retorno = new Autor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                auts.add(retorno);
            }
        }
        c.close();
        return auts;
    }
}