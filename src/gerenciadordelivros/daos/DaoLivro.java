/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.daos;

import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import gerenciadordelivros.beans.Livro;
import gerenciadordelivros.util.ConexaoDb;


/**
 *
 * @author Livro
 */
public class DaoLivro {
    
    // variavel de conexão
    private final Connection c;
   
    // metodo construtor que valoriza a varivel de conexão
    public DaoLivro() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }
    
        // metodo de busca por id
    public Livro buscar (Livro lEntrada) throws SQLException {
        // select por id;
        String sql = "select * from liv_livro WHERE liv_id = ?";
        // variavel de retorno
        Livro retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,lEntrada.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            // percorre o resultset
            while (rs.next()) {
                // criando o objeto Livro
                retorno = new Livro(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        }
        c.close();
        return retorno;
    }
    
        public Livro inserir(Livro lEntrada) throws SQLException {
        // escrevo meu select
        String sql = "INSERT INTO liv_livro (liv_titulo,liv_autor,liv_editora) VALUES(?,?,?)";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,lEntrada.getTitulo());
            stmt.setString(2,lEntrada.getAutor());
            stmt.setString(3,lEntrada.getEditora());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            // carrego no bean o id que foi gerado pelo banco de dados
            if(rs.next()) {
                int id = rs.getInt(1);
                lEntrada.setId(id);
            }
        }
        c.close();
        return lEntrada;
    }

    public Livro alterar(Livro lEntrada) throws SQLException {
    // escrevo meu select
        String sql = "UPDATE liv_livro SET liv_titulo = ?,liv_autor = ?,liv_editora = ? WHERE liv_id = ?";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,lEntrada.getTitulo());
            stmt.setString(2,lEntrada.getAutor());
            stmt.setString(3,lEntrada.getEditora());
            stmt.setInt(4,lEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return lEntrada;
    }

    public Livro excluir(Livro lEntrada) throws SQLException {
        // escrevo meu select
        String sql = "delete from liv_livro WHERE liv_id = ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,lEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return lEntrada;
    }

    public List<Livro> listar(Livro lEntrada) throws SQLException {
        List<Livro> livs = new ArrayList<>();
        // escrevo meu select
        String sql = "select * from liv_livro WHERE liv_titulo like ?";
        // variavel de retorno
        Livro retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + lEntrada.getTitulo() + "%");
            // executa
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Livro
                 retorno = new Livro(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                livs.add(retorno);
            }
        }
        c.close();
        return livs;
    }

}