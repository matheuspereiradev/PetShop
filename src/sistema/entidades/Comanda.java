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
    
    public Comanda(Animal animal, Funcionario entregador, ArrayList<Servico> servicos, double desconto, double acrescimo) {
        this.animal = animal;
        this.entregador = entregador;
        this.servicos = servicos;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
    }
    
    public Comanda(Animal animal, ArrayList<Servico> servicos, double desconto, double acrescimo) {
        this.animal = animal;
        this.servicos = servicos;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
    }
    
    public double calculaTotal(){
        double totalServicos=0;
        for(int i=0;i<servicos.size();i++){
            totalServicos+=servicos.get(i).getVlServico();
        }
        
        return totalServicos+acrescimo-desconto;
    }
    
    public void finalizarComanda(){
        
        this.dtConcluido= Utils.pegarDataAtual();

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

        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            //instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String comando = "INSERT INTO Comanda (idAnimal, idPessoa, desconto, acrescimos)";
            comando = comando + " VALUES (?,?,?,?)";
            instrucaoSQL = conexao.prepareStatement(comando);
            instrucaoSQL.setInt(1, animal.getIdAnimal());
            instrucaoSQL.setInt(2, animal.getDono().getIdPessoa());
            instrucaoSQL.setDouble(3, desconto);
            instrucaoSQL.setDouble(4, acrescimo);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Não implemantado ainda");
    }
    
    
    
}
