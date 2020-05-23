/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.entidades;

/**
 *
 * @author MATHEUS-PC
 */
public class Servico {
    
    private int idServico;
    private String nmServico;
    private double vlServico;

  

    
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
    
    
    
}
