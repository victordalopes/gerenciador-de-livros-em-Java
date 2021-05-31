/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.telas;

import gerenciadordelivros.beans.Editora;
import gerenciadordelivros.controles.ControleEditora;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ManterEditora {
    
    static int id;
    static String nome;
    static String fundacao;
    static String sede;
    static String cnpj;    
    static ControleEditora contE;
    
    public static void validar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE VALIDAR");
        nome = JOptionPane.showInputDialog("NOME");
        Editora eEntrada = new Editora(nome);
        contE = new ControleEditora();
        Editora eSaida = contE.validar(eEntrada);
        System.out.println(eSaida.toString());
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
    
    public static void listar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE LISTAR");
        nome = JOptionPane.showInputDialog("NOME");
        Editora eEntrada = new Editora(nome);
        contE = new ControleEditora();
        List<Editora> edSaida = contE.listar(eEntrada);
        edSaida.forEach((ediE) -> {
            JOptionPane.showMessageDialog(null,ediE.toString());
        });
    }
    
    public static void inserir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE INSERIR");
        nome = JOptionPane.showInputDialog("NOME");
        fundacao = JOptionPane.showInputDialog("FUNDAÇÃO");
        sede = JOptionPane.showInputDialog("SEDE");
        cnpj = JOptionPane.showInputDialog("CNPJ");
        Editora eEntrada = new Editora(nome,fundacao,sede,cnpj);
        contE = new ControleEditora();
        Editora eSaida = contE.inserir(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
        
    public static void alterar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE ALTERAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        nome = JOptionPane.showInputDialog("NOME");
        fundacao = JOptionPane.showInputDialog("FUNDAÇÃO");
        sede = JOptionPane.showInputDialog("SEDE");
        cnpj = JOptionPane.showInputDialog("CNPJ");
        Editora eEntrada = new Editora(id,nome,fundacao,sede,cnpj);
        contE = new ControleEditora();
        Editora eSaida = contE.alterar(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
        
    public static void buscar() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE BUSCAR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Editora eEntrada = new Editora(id);
        contE = new ControleEditora();
        Editora eSaida = contE.buscar(eEntrada);
        System.out.println(eSaida.toString());
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
        
    public static void excluir() throws SQLException, ClassNotFoundException {
        JOptionPane.showMessageDialog(null,"TELA DE EXCLUIR");
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Editora eEntrada = new Editora(id);
        contE = new ControleEditora();
        Editora eSaida = contE.excluir(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }    
}
