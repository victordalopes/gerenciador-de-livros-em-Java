/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.controles;

import java.util.List;
import java.sql.SQLException;
import gerenciadordelivros.beans.Usuario;
import gerenciadordelivros.daos.DaoUsuario;
/**
 *
 * @author Usuario
 */

public class ControleUsuario {
    
        static DaoUsuario daoUsu; 
    
    public ControleUsuario () throws SQLException, ClassNotFoundException {
        daoUsu = new DaoUsuario();
    }
    
    public Usuario validar(Usuario uEntrada) throws SQLException {
        return daoUsu.validar(uEntrada);
    }
             
    public Usuario buscar(Usuario uEntrada) throws SQLException {
        return daoUsu.buscar(uEntrada);
    }

    public List<Usuario> listar(Usuario uEntrada) throws SQLException {
        return daoUsu.listar(uEntrada);
    }

    public Usuario inserir(Usuario uEntrada) throws SQLException {
        return daoUsu.inserir(uEntrada);
    }

    public Usuario alterar(Usuario uEntrada) throws SQLException {
        return daoUsu.alterar(uEntrada);
    }

    public Usuario excluir(Usuario uEntrada) throws SQLException {
        return daoUsu.excluir(uEntrada);
    }
}
