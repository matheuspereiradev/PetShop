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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.principal.Conexao;
import sistema.utils.ClasseRegistravelNoBD;

/**
 *
 * @author MATHEUS-PC
 */
public class Pessoa implements ClasseRegistravelNoBD{
    private int idPessoa;
    private String nmPessoa;
    private String cdCpfCnpj;
    private String dtnascimento;
    private String telefone;
    private String endereco;

    public Pessoa(int idPessoa, String nmPessoa, String cdCpfCnpj, String dtnascimento, String telefone, String endereco) {
        this.idPessoa = idPessoa;
        this.nmPessoa = nmPessoa;
        this.cdCpfCnpj = cdCpfCnpj;
        this.dtnascimento = dtnascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public Pessoa(int idPessoa){
        this.idPessoa=idPessoa;
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

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
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
            String comando = "INSERT INTO Cliente (nmPessoa,cdCpfCnpj,dtnascimento,telefone,endereco)";
            comando = comando + " VALUES (?,?,?,?,?)";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setString(1, getNmPessoa());
            instrucaoSQL.setString(2, getCdCpfCnpj());
            instrucaoSQL.setString(3, getDtnascimento());
            instrucaoSQL.setString(4, getTelefone());
            instrucaoSQL.setString(5, getEndereco());
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

    @Override
    public boolean deletar() {
        Connection conexao;
        // instrucao SQL
        PreparedStatement instrucaoSQL;
        

        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            String sql = "DELETE FROM Cliente";
            sql = sql + " WHERE id = ?";

            instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1, idPessoa);
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Apagado com sucesso");
            
            conexao.close();
            
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir.");
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar() {
        
        // conexão
        Connection conexao;

        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            //instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String comando = "Update Cliente SET nmPessoa=?,cdCpfCnpj=?,dtnascimento=?,telefone=?,endereco=? where id=?";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setString(1, getNmPessoa());
            instrucaoSQL.setString(2, getCdCpfCnpj());
            instrucaoSQL.setString(3, getDtnascimento());
            instrucaoSQL.setString(4, getTelefone());
            instrucaoSQL.setString(5, getEndereco());
            instrucaoSQL.setInt(6, getIdPessoa());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editado com sucesso");
            
            conexao.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
        
       /*  //conexão
        Connection conexao;
        //insrução sql
        Statement instrucaoSQL;

        try {
            //conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);
            //criando a conexão
            
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql="UPDATE Cliente SET nmPessoa='"+getNmPessoa()
                    +"',cdCpfCnpj='"+getCdCpfCnpj()
                    + "',dtnascimento='"+getDtnascimento()
                            + "',telefone='"+getTelefone()
                            + "',endereco ='"+getEndereco()+"' where id ='"+getIdPessoa()+"'";
            instrucaoSQL.executeUpdate(sql);

            
            
            JOptionPane.showMessageDialog(null, "Sucesso ao editar cargo");
           

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO AO EDITAR");
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, erro);
        }
*/
    }
    
    
    
}
