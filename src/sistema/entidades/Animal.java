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
public class Animal implements ClasseRegistravelNoBD{
    private int idAnimal;
    private String NmAnimal;
    private String cor;
    private String raca;
    private String especie;
    private Pessoa dono;

    

    public Animal(int idAnimal, String NmAnimal, String cor, String raca, String especie, Pessoa dono) {
        this.idAnimal = idAnimal;
        this.NmAnimal = NmAnimal;
        this.cor = cor;
        this.raca = raca;
        this.especie = especie;
        this.dono=dono;
    }

    public Animal(int idAnimal) {
        this.idAnimal=idAnimal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNmAnimal() {
        return NmAnimal;
    }

    public void setNmAnimal(String NmAnimal) {
        this.NmAnimal = NmAnimal;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
   
    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
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
            String comando = "INSERT INTO Animal (NmAnimal,cor,raca,especie,idPessoa)";
            comando = comando + " VALUES (?,?,?,?,?)";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setString(1, getNmAnimal());
            instrucaoSQL.setString(2, getCor());
            instrucaoSQL.setString(3, getRaca());
            instrucaoSQL.setString(4, getEspecie());
            instrucaoSQL.setInt(5, getDono().getIdPessoa());
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
            
            conexao.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao adicionar.");
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
            String sql = "DELETE FROM Animal";
            sql = sql + " WHERE idAnimal = ?";

            instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1, idAnimal);
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
            String comando = "Update Animal SET NmAnimal=?,cor=?,raca=?,especie=? where idAnimal=?";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setString(1, NmAnimal);
            instrucaoSQL.setString(2, cor);
            instrucaoSQL.setString(3, raca);
            instrucaoSQL.setString(4, especie);
            instrucaoSQL.setInt(5, idAnimal);
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
