/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;

import java.util.Calendar;

/**
 *
 * @author MATHEUS-PC
 */
public class Funcionario extends Pessoa {
    
    private double vlComissao;
    private String docHabilitacao;

    public Funcionario(double vlComissao, String docHabilitacao, int idPessoa, String nmPessoa, String cdCpfCnpj, String dtnascimento, String telefone, String endereco) {
        super(idPessoa, nmPessoa, cdCpfCnpj, dtnascimento, telefone, endereco);
        this.vlComissao = vlComissao;
        this.docHabilitacao = docHabilitacao;
    }

    public double getVlComissao() {
        return vlComissao;
    }

    public void setVlComissao(double vlComissao) {
        this.vlComissao = vlComissao;
    }

    public String getDocHabilitacao() {
        return docHabilitacao;
    }

    public void setDocHabilitacao(String docHabilitacao) {
        this.docHabilitacao = docHabilitacao;
    }
 
}
