/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.controles;

import gerenciadordelivros.beans.Autor;
import gerenciadordelivros.daos.DaoAutor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ControleAutor {
    
    static DaoAutor daoAut;

    public ControleAutor() throws SQLException, ClassNotFoundException {
        daoAut = new DaoAutor();
    }            

    public List<Autor> listar(Autor a) throws SQLException {
        return daoAut.listar(a);
    }

    public Autor inserir(Autor a) throws SQLException {
        return daoAut.inserir(a);
    }

    public Autor alterar(Autor a) throws SQLException {
        return daoAut.alterar(a);
    }

    public Autor excluir(Autor a) throws SQLException {
        return daoAut.excluir(a);
    }

    public Autor buscar(Autor a) throws SQLException {
        return daoAut.buscar(a);
    }
}
