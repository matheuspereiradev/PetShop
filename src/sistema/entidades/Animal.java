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
public class Animal {
    private int idAnimal;
    private String NmAnimal;
    private String cor;
    private String raca;
    private String especie;

    public Animal(int idAnimal, String NmAnimal, String cor, String raca, String especie) {
        this.idAnimal = idAnimal;
        this.NmAnimal = NmAnimal;
        this.cor = cor;
        this.raca = raca;
        this.especie = especie;
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
   

}
