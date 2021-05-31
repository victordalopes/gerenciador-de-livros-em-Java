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
import gerenciadordelivros.beans.Editora;
import gerenciadordelivros.util.ConexaoDb;

/**
 *
 * @author Usuario
 */
public class DaoEditora {
    
    // variavel de conexão
    private final Connection c;
    
    // metodo construtor que valoriza a varivel de conexão
    public DaoEditora() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }
    
    // metodo de busca por id
    public Editora buscar (Editora eEntrada) throws SQLException {
        // select por id;
        String sql = "select * from edi_editora WHERE edi_id = ?";
        // variavel de retorno
        Editora retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,eEntrada.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            // percorre o resultset
            while (rs.next()) {
                // criando o objeto Editora
                retorno = new Editora(
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
    
    public Editora validar (Editora eEntrada) throws SQLException {
        // select por id;
        String sql = "select * from edi_editora WHERE edi_nome = ?";
        // variavel de retorno
        Editora retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,eEntrada.getNome());
           // executa
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            // percorre o resultset
            while (rs.next()) {
                // criando o objeto Editora
                retorno = new Editora(
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
    
    public Editora inserir(Editora eEntrada) throws SQLException {
        // escrevo meu select
        String sql = "INSERT INTO edi_editora (edi_nome,edi_fundacao,edi_sede,edi_cnpj) VALUES(?,?,?,?)";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,eEntrada.getNome());
            stmt.setString(2,eEntrada.getFundacao());
            stmt.setString(3,eEntrada.getSede());
            stmt.setString(4,eEntrada.getCnpj());
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            // carrego no bean o id que foi gerado pelo banco de dados
            if(rs.next()) {
                int id = rs.getInt(1);
                eEntrada.setId(id);
            }
        }
        c.close();
        return eEntrada;
    }

    public Editora alterar(Editora eEntrada) throws SQLException {
    // escrevo meu select
        String sql = "UPDATE edi_editora SET edi_nome = ?,edi_fundacao = ?,edi_sede = ?,edi_cnpj= ? WHERE edi_id = ?";
        // variavel de retorno
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,eEntrada.getNome());
            stmt.setString(2,eEntrada.getFundacao());
            stmt.setString(3,eEntrada.getSede());
            stmt.setString(4,eEntrada.getCnpj());
            stmt.setInt(5,eEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return eEntrada;
    }

    public Editora excluir(Editora eEntrada) throws SQLException {
        // escrevo meu select
        String sql = "delete from edi_editora WHERE edi_id = ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,eEntrada.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return eEntrada;
    }

    public List<Editora> listar(Editora eEntrada) throws SQLException {
        List<Editora> edis = new ArrayList<>();
        // escrevo meu select
        String sql = "select * from edi_editora WHERE edi_nome like ?";
        // variavel de retorno
        Editora retorno;
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + eEntrada.getNome() + "%");
            // executa
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto Editora
                 retorno = new Editora(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                edis.add(retorno);
            }
        }
        c.close();
        return edis;
    }
}

