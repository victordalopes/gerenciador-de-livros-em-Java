/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.telas;

import gerenciadordelivros.beans.Usuario;
import gerenciadordelivros.controles.ControleUsuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManterUsuario {
    
    static int id;
    static String login;
    static String senha;
    static String status;
    static String tipo;
    static ControleUsuario contU;
    
    public static void validar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE VALIDAR");
        login = JOptionPane.showInputDialog("LOGIN");
        senha = JOptionPane.showInputDialog("SENHA");
        Usuario uEntrada = new Usuario(login,senha);
        contU = new ControleUsuario();
        Usuario uSaida = contU.validar(uEntrada);
        System.out.println(uSaida.toString());
        JOptionPane.showMessageDialog(null,uSaida.toString());
    }
    
    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE BUSCAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario uEntrada = new Usuario(id);
        contU = new ControleUsuario();
        Usuario uSaida = contU.buscar(uEntrada);
        System.out.println(uSaida.toString());
        JOptionPane.showMessageDialog(null,uSaida.toString());
    }

    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE LISTAR");
        login = JOptionPane.showInputDialog("LOGIN");
        Usuario uEntrada = new Usuario(login);
        contU = new ControleUsuario();
        List<Usuario> usSaida = contU.listar(uEntrada);
        usSaida.forEach((usuL) -> {
            JOptionPane.showMessageDialog(null,usuL.toString());
        });
    }

    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE INSERIR");
        login = JOptionPane.showInputDialog("LOGIN");
        senha = JOptionPane.showInputDialog("SENHA");
        status = JOptionPane.showInputDialog("STATUS");
        tipo = JOptionPane.showInputDialog("TIPO");
        Usuario uEntrada = new Usuario(login,senha,status,tipo);
        contU = new ControleUsuario();
        Usuario uSaida = contU.inserir(uEntrada);
        JOptionPane.showMessageDialog(null,uSaida.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE ALTERAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        login = JOptionPane.showInputDialog("LOGIN");
        senha = JOptionPane.showInputDialog("SENHA");
        status = JOptionPane.showInputDialog("STATUS");
        tipo = JOptionPane.showInputDialog("TIPO");
        Usuario uEntrada = new Usuario(id,login,senha,status,tipo);
        contU = new ControleUsuario();
        Usuario uSaida = contU.alterar(uEntrada);
        JOptionPane.showMessageDialog(null,uSaida.toString());
    }

    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE EXCLUIR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario uEntrada = new Usuario(id);
        contU = new ControleUsuario();
        Usuario uSaida = contU.excluir(uEntrada);
        JOptionPane.showMessageDialog(null,uSaida.toString());
    }
}
