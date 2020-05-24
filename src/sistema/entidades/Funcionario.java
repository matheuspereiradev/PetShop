/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.principal.Conexao;

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

    @Override
    public boolean atualizar() {
        return super.atualizar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar() {
        return super.deletar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir() {
        // conexão
        Connection conexao;

        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            //instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String comando = "INSERT INTO Funcionario (vlComissao,docHabilitacao, idPessoa)";
            comando = comando + " VALUES (?,?,?)";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setDouble(1, vlComissao);
            instrucaoSQL.setString(2, docHabilitacao);
            instrucaoSQL.setInt(3, getIdPessoa());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
            
            conexao.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar o funcionario.");
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
 
}
