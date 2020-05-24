package sistema.principal;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sistema.entidades.*;



/**
 *
 * @author MATHEUS-PC
 */
public class Main {
    
    public static JPanel painel;
    public static JFrame frame;
    
    public static void main(String[]args){
        
        frame = new JFrame("SISTEMA");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Navegador.menu();
        
        /*
        testeOO();
        */
    
    }
    
    public void testeOO(){
    Pessoa ana= new Pessoa(1, "Ana de Souza", "000.000.000-00", "01/01/1997", "98888-1234", "Rua A, nº 12, Juazeiro do norte");
        Animal animal1 = new Animal(1, "Apollo", "Marrom", "Shipooh", "Cachorro", ana);
        Servico tosa=new Servico(1, "Tosa", 40);
        Servico banho=new Servico(2, "Banho", 30);
        Funcionario funcionario=new Funcionario(12, "28821892198", 1, "José Entregador", "010.000.111-11", "15/12/1997", "88992211212", "Rua do Junco, nº 1, Crato");
        
        ArrayList<Servico> serv = new ArrayList<Servico>();
        
        serv.add(tosa);
        serv.add(banho);
        
        Comanda c = new Comanda(animal1, funcionario, serv, 12, 1);
        
        c.finalizarComanda();
        System.out.println(c.calculaTotal());
        
        System.out.println("=============CLIENTE===========");
        System.out.println(c.getAnimal().getDono().getNmPessoa()+" Tel:."+c.getAnimal().getDono().getTelefone()+ " CPF/CNPJ:"+c.getAnimal().getDono().getCdCpfCnpj());
        System.out.println(c.getAnimal().getDono().getEndereco());
        System.out.println("=============ANIMAL============");
        System.out.println(c.getAnimal().getNmAnimal()+" "+c.getAnimal().getRaca()+"("+c.getAnimal().getEspecie()+")");
        System.out.println("=============FINANCEIRO=======");
        for (int i =0;i< serv.size();i++) {
            System.out.println(serv.get(i).getNmServico()+"----"+serv.get(i).getVlServico());
        }
        System.out.println("TOTAL========================="+c.calculaTotal());
        System.out.println("============Entrega===========");
        System.out.println(c.getEntregador().getNmPessoa()+" "+c.getDtConcluido());
    }
}
