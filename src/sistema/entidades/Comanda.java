/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistema.principal.Conexao;
import sistema.utils.Utils;
import sistema.utils.ClasseRegistravelNoBD;

/**
 *
 * @author MATHEUS-PC
 */
public class Comanda implements ClasseRegistravelNoBD{
    
    private Animal animal;
    private Funcionario entregador;
    private ArrayList<Servico> servicos;
    private double desconto;
    private double acrescimo;
    private String dtConcluido;
    private int idComanda;
    
    public Comanda(int idComanda,Animal animal, Funcionario entregador, ArrayList<Servico> servicos, double desconto, double acrescimo) {
        this.animal = animal;
        this.entregador = entregador;
        this.servicos = servicos;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.idComanda=idComanda;
    }
    
    public Comanda(int idComanda,Animal animal, ArrayList<Servico> servicos, double desconto, double acrescimo) {
        this.animal = animal;
        this.servicos = servicos;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.idComanda=idComanda;
    }
    
    public Comanda(int idComanda){
        this.idComanda=idComanda;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }
    
    
    
    public double calculaTotal(){
        double totalServicos=0;
        for(int i=0;i<servicos.size();i++){
            totalServicos+=servicos.get(i).getVlServico();
        }
        
        return totalServicos+acrescimo-desconto;
    }
    
    public boolean finalizarComanda(){
        
        this.dtConcluido= Utils.pegarDataAtual();
         // conexão
        Connection conexao;

        //intruçao sql
        PreparedStatement instrucaoSQL;

        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            //instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String comando = "UPDATE Comanda set idFuncionario=?,dtConcluido=?";
            comando = comando + " WHERE idComanda=?";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setInt(1, this.entregador.getIdFuncionario());
            instrucaoSQL.setString(2, dtConcluido);
            instrucaoSQL.setInt(3, idComanda);
            instrucaoSQL.executeUpdate();

            JOptionPane.showMessageDialog(null, "Finalizado com sucesso");
            
            conexao.close();
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao editar dados");
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;

    }

    public String getDtConcluido() {
        return dtConcluido;
    }

    
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Funcionario getEntregador() {
        return entregador;
    }

    public void setEntregador(Funcionario entregador) {
        this.entregador = entregador;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }
    
    

    @Override
    public boolean inserir() {
         // conexão
        Connection conexao;
         //intruçao sql
        PreparedStatement instrucaoSQL;
        Statement instrucaoSQLPesquisa;
        // resultados
        ResultSet resultados;
        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);
            //inserir comanda
            String comando = "INSERT INTO Comanda (idAnimal, idPessoa, desconto, acrescimos)";
            comando = comando + " VALUES (?,?,?,?)";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setInt(1, animal.getIdAnimal());
            instrucaoSQL.setInt(2, animal.getDono().getIdPessoa());
            instrucaoSQL.setDouble(3, desconto);
            instrucaoSQL.setDouble(4, acrescimo);
            instrucaoSQL.executeUpdate();
            
            //tenta pegar id da comanda inserida
            instrucaoSQLPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultados = instrucaoSQLPesquisa.executeQuery("select top(1) * from Comanda order by idComanda desc");
            int id=0;
            while(resultados.next()){
              id=resultados.getInt("idComanda");
            }
            setIdComanda(id);
            for(int i=0;i<servicos.size();i++){
                Servico s=servicos.get(i);
                comando = "INSERT INTO tbgServicoComanda (idComanda, idServico, vlServico)";
                comando = comando + " VALUES (?,?,?)";
                instrucaoSQL = conexao.prepareStatement(comando);
                instrucaoSQL.setInt(1, this.getIdComanda());
                instrucaoSQL.setInt(2, s.getIdServico());
                instrucaoSQL.setDouble(3, s.getVlServico());
                instrucaoSQL.executeUpdate();
            }
            
            
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
            String sql = "DELETE FROM Comanda";
            sql = sql + " WHERE idComanda = ?";

            instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1, idComanda);
            instrucaoSQL.executeUpdate();
            
            
            sql="DELETE FROM tbgServicoComanda";
            sql = sql + " WHERE idComanda = ?";
            
            instrucaoSQL = conexao.prepareStatement(sql);
            instrucaoSQL.setInt(1, idComanda);
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
        throw new UnsupportedOperationException("Não implemantado ainda");
    }
    
    
    
}
