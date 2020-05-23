/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;

import java.util.ArrayList;

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

    public Comanda(Animal animal, Funcionario entregador, ArrayList<Servico> servicos, double desconto, double acrescimo) {
        this.animal = animal;
        this.entregador = entregador;
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
    
    
    
}
