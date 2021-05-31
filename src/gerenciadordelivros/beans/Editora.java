/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadordelivros.beans;

/**
 *
 * @author Usuario
 */
public class Editora {
    
    int id;
    String nome;
    String fundacao;
    String sede;
    String cnpj;
    
    public Editora(int id) {
        this.id = id;
    }

    public Editora(String nome) {
        this.nome = nome;
    }

    public Editora(String nome, String fundacao, String sede, String cnpj) {
        this.nome = nome;
        this.fundacao = fundacao;
        this.sede = sede;
        this.cnpj = cnpj;
    }
    
    public Editora(int id, String nome, String fundacao, String sede, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.fundacao = fundacao;
        this.sede = sede;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFundacao() {
        return fundacao;
    }

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }  
    
    @Override
    public String toString() {
        return "Editora{" + "id=" + id + ", nome=" + nome + ", fundação=" + fundacao + ", sede=" + sede + ", cnpj=" + cnpj + '}';
    }
}
