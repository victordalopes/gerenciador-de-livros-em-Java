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
import gerenciadordelivros.beans.Usuario;
import gerenciadordelivros.util.ConexaoDb;

/**
 *
 * @author Usuario
 */
public class DaoUsuario {    

    // variavel de conexão
    private final Connection c;
   
    // metodo construtor que valoriza a varivel de conexão
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }

    // metodo de busca por id
    public Usuario buscar (Usuario uEntrada) throws SQLException {
        // select por id;
        String sql = "select * from usu_usuario WHERE usu_id = ?";
        // variavel de retorno
        Usuario retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,uEntrada.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            // percorre o resultset
            while (rs.next()) {
                // criando o objeto Usuario
                retorno = new Usuario(
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
    
    // método de valida por login e senha
    public Usuario validar (Usuario uEntrada) throws SQLException {
        // select por id;
        String sql = "select * from usu_usuario WHERE usu_login = ? AND usu_senha = ?";
        // variavel de retorno
        Usuario retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,uEntrada.getLogin());
            stmt.setString(2,uEntrada.getSenha());
           // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            // percorre o resultset
            while (rs.next()) {
                // criando o objeto Usuario
                retorno = new Usuario(
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

    public Usuario inserir(Usuario uEntrada) throws SQLException {
        // escrevo meu select
        String sql = "INSERT INTO usu_usuario (usu_login,usu_senha,usu_status,usu_tipo) VALUES(?,?,?,?)";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,uEntrada.getLogin());
            stmt.setString(2,uEntrada.getSenha());
            stmt.setString(3,uEntrada.getStatus());
            stmt.setString(4,uEntrada.getTipo());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            // carrego no bean o id que foi gerado pelo banco de dados
            if(rs.next()) {
                int id = rs.getInt(1);
                uEntrada.setId(id);
            }
        }
        c.close();
        return uEntrada;
    }

    public Usuario alterar(Usuario uEntrada) throws SQLException {
    // escrevo meu select
        String sql = "UPDATE usu_usuario SET usu_login = ?,usu_senha = ?,usu_status = ?,usu_tipo= ? WHERE usu_id = ?";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,uEntrada.getLogin());
            stmt.setString(2,uEntrada.getSenha());
            stmt.setString(3,uEntrada.getStatus());
            stmt.setString(4,uEntrada.getTipo());
            stmt.setInt(5,uEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return uEntrada;
    }

    public Usuario excluir(Usuario uEntrada) throws SQLException {
        // escrevo meu select
        String sql = "delete from usu_usuario WHERE usu_id = ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,uEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return uEntrada;
    }

    public List<Usuario> listar(Usuario uEntrada) throws SQLException {
        List<Usuario> usus = new ArrayList<>();
        // escrevo meu select
        String sql = "select * from usu_usuario WHERE usu_login like ?";
        // variavel de retorno
        Usuario retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + uEntrada.getLogin() + "%");
            // executa
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Usuario
                 retorno = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                usus.add(retorno);
            }
        }
        c.close();
        return usus;
    }

}