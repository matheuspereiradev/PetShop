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
public class Pessoa {
    private int idPessoa;
    private String nmPessoa;
    private String cdCpfCnpj;
    private Calendar dtnascimento;
    private String telefone;
    private String endereco;

    public Pessoa(int idPessoa, String nmPessoa, String cdCpfCnpj, Calendar dtnascimento, String telefone, String endereco) {
        this.idPessoa = idPessoa;
        this.nmPessoa = nmPessoa;
        this.cdCpfCnpj = cdCpfCnpj;
        this.dtnascimento = dtnascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getCdCpfCnpj() {
        return cdCpfCnpj;
    }

    public void setCdCpfCnpj(String cdCpfCnpj) {
        this.cdCpfCnpj = cdCpfCnpj;
    }

    public Calendar getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Calendar dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
}
