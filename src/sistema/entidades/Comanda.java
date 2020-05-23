/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import sistema.principal.Utils;

/**
 *
 * @author MATHEUS-PC
 */
public class Comanda {
    
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
        Calendar dtConcluido = new GregorianCalendar();
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
    
    
    
}
