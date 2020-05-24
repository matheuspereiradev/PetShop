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
public class Servico implements ClasseRegistravelNoBD{
    
    private int idServico;
    private String nmServico;
    private double vlServico;

  

    public Servico(int idServico){
        this.idServico=idServico;
    }
    
    public Servico(int idServico, String nmServico, double vlServico) {
        this.idServico = idServico;
        this.nmServico = nmServico;
        this.vlServico = vlServico;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public double getVlServico() {
        return vlServico;
    }

    public void setVlServico(double vlServico) {
        this.vlServico = vlServico;
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
            String comando = "INSERT INTO Servico (nmServico,vlServico)";
            comando = comando + " VALUES (?,?)";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setString(1, nmServico);
            instrucaoSQL.setDouble(2, vlServico);
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
            
            conexao.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar");
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
            String sql = "DELETE FROM Servico";
            sql = sql + " WHERE idServico = ?";

            instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1, idServico);
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
            String comando = "UPDATE Servico set nmServico=?,vlServico=?";
            comando = comando + " WHERE idServico=?";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setString(1, nmServico);
            instrucaoSQL.setDouble(2, vlServico);
            instrucaoSQL.setInt(3, idServico);
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editado com sucesso");
            
            conexao.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    
}
