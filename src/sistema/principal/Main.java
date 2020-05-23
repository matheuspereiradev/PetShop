package sistema.principal;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import sistema.entidades.*;



/**
 *
 * @author MATHEUS-PC
 */
public class Main {
    
    public static void main(String[]args){
        

        
        Pessoa ana= new Pessoa(1, "Ana de Souza", "000.000.000-00", new GregorianCalendar(1997,12,31), "98888-1234", "Rua A, nº 12, Juazeiro do norte");
        Animal animal1 = new Animal(1, "Apollo", "Marrom", "Shipooh", "Cachorro", ana);
        Servico tosa=new Servico(1, "Tosa", 40);
        Servico banho=new Servico(2, "Banho", 30);
        Funcionario funcionario=new Funcionario(12, "28821892198", 1, "José Entregador", "010.000.111-11", new GregorianCalendar(1997, 11, 15), "88992211212", "Rua do Junco, nº 1, Crato");
        
        ArrayList<Servico> serv = new ArrayList<Servico>();
        
        serv.add(tosa);
        serv.add(banho);
        
        Comanda c = new Comanda(animal1, funcionario, serv, 12, 1);
        
        System.out.println(c.calculaTotal());
    }
}
