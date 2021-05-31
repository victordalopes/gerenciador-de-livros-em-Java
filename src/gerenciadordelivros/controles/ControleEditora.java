/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.controles;

import java.util.List;
import java.sql.SQLException;
import gerenciadordelivros.beans.Editora;
import gerenciadordelivros.daos.DaoEditora;
/**
 *
 * @author Usuario
 */

//onde agora é 'eEntrada' antes era só um 'e'; se der merda, reverter isto

public class ControleEditora {
    
    static DaoEditora daoEdi;
    
    public ControleEditora() throws SQLException, ClassNotFoundException {
        daoEdi = new DaoEditora();
    }
    
    public Editora validar(Editora eEntrada) throws SQLException {
        return daoEdi.validar(eEntrada);
    }

    public List<Editora> listar(Editora eEntrada) throws SQLException {
        return daoEdi.listar(eEntrada);
    }

    public Editora inserir(Editora eEntrada) throws SQLException {
        return daoEdi.inserir(eEntrada);
    }

    public Editora alterar(Editora eEntrada) throws SQLException {
        return daoEdi.alterar(eEntrada);
    }

    public Editora excluir(Editora eEntrada) throws SQLException {
        return daoEdi.excluir(eEntrada);
    }

    public Editora buscar(Editora eEntrada) throws SQLException {
        return daoEdi.buscar(eEntrada);
    }
}
