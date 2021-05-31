/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador.de.livros;

import gerenciadordelivros.telas.ManterLivro;
import gerenciadordelivros.telas.ManterAutor;
import gerenciadordelivros.telas.ManterEditora;
import gerenciadordelivros.telas.ManterUsuario;
import gerenciadordelivros.telas.ManterLivroAutor;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class GerenciadorDeLivros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            
            JOptionPane.showMessageDialog(null,"1 - MANTER LIVRO, 2 - MANTER AUTOR, 3 - MANTER EDITORA, 4 - MANTER USUÁRIO, 5 - MANTER LIVRO AUTOR");
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("OPCAO"));
        
            if(opcao == 1) {
                ManterLivro.listar();
                ManterLivro.inserir();
                ManterLivro.alterar();
                ManterLivro.buscar();
                ManterLivro.excluir();
    }
            if(opcao == 2) {
                ManterAutor.listar();
                ManterAutor.inserir();
                ManterAutor.alterar();
                ManterAutor.buscar();
                ManterAutor.excluir();
            }

            if(opcao == 3) {
                ManterEditora.validar();
                ManterEditora.listar();
                ManterEditora.inserir();
                ManterEditora.alterar();
                ManterEditora.buscar();
                ManterEditora.excluir();
            }
            
            if(opcao == 4) {
                ManterUsuario.validar();
                ManterUsuario.listar();
                ManterUsuario.inserir();
                ManterUsuario.alterar();
                ManterUsuario.buscar();
                ManterUsuario.excluir();
            }
            
            if(opcao == 5) {
                ManterLivroAutor.listar();                
                ManterLivroAutor.alterar();
                ManterLivroAutor.buscar();
                ManterLivroAutor.excluir();
            }
    }
}
