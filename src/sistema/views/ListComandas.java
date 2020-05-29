/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.entidades.Animal;
import sistema.entidades.Comanda;
import sistema.entidades.Funcionario;
import sistema.principal.Conexao;


public class ListComandas extends javax.swing.JInternalFrame {

    Comanda comanda;
    Funcionario funcionario;
      private DefaultTableModel modelLista;
    public ListComandas() {
        initComponents();
        modelLista = (DefaultTableModel) listComandas.getModel() ;
        montaComandas();
        montaFuncionarios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listComandas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbConcluidas = new javax.swing.JCheckBox();
        cbFuncionario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Lista de comandas");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód Comanda", "Cliente", "CPF", "Endereco", "Nome", "Especie", "Serviços", "Func Entrega"
            }
        ));
        jScrollPane1.setViewportView(listComandas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1007, 410));

        jButton1.setText("ENVIAR PARA ENTREGA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 239, 59));

        jButton2.setText("VISUALIZAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 296, 59));

        jButton3.setText("CANCELAR COMANDA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 303, 61));

        cbConcluidas.setText("Exibir Comandas Concluídas");
        cbConcluidas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbConcluidasStateChanged(evt);
            }
        });
        jPanel1.add(cbConcluidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        cbFuncionario.setMaximumRowCount(100);
        jPanel1.add(cbFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 440, 240, -1));

        jLabel1.setText("Funcionario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String entregador="";
        entregador=(String)modelLista.getValueAt(listComandas.getSelectedRow(), 7);
        if(entregador==null){
        
            comanda=new Comanda((int)modelLista.getValueAt(listComandas.getSelectedRow(), 0));

            comanda.setEntregador((Funcionario)cbFuncionario.getSelectedItem());
            if(comanda.finalizarComanda()){
             montaComandas();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        comanda=new Comanda((int)modelLista.getValueAt(listComandas.getSelectedRow(), 0));
        if(comanda.deletar()){
            montaComandas();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbConcluidasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbConcluidasStateChanged
        montaComandas();
    }//GEN-LAST:event_cbConcluidasStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id=(int)modelLista.getValueAt(listComandas.getSelectedRow(), 0);
        VisualizaComanda vis = new VisualizaComanda(id);
        Principal.adicionarAoDsk(vis);
        vis.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbConcluidas;
    private javax.swing.JComboBox<Funcionario> cbFuncionario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listComandas;
    // End of variables declaration//GEN-END:variables

    private void montaComandas() {
        // conexão
        Connection conexao;
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
         modelLista.setRowCount(0);
        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql="select * from vwComandas where 1=1";
            
            if (!cbConcluidas.isSelected()) {
                sql=sql+" and dtConcluido is null ";
            }
            
            
            sql=sql+"order by idComanda desc";
            resultados = instrucaoSQL.executeQuery(sql);

           

            while (resultados.next()) {
                Object [] comanda = {resultados.getInt("idComanda"), resultados.getString("nmCliente"), resultados.getString("cpfCliente") , resultados.getString("endCliente"), resultados.getString("NmAnimal"), resultados.getString("especie"), resultados.getString("servicos"), resultados.getString("nmFunc") };        
                modelLista.addRow(comanda);
            }

            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar dados.");
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void montaFuncionarios() {
        // conexão
        Connection conexao;
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
         cbFuncionario.removeAllItems();
        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql="select * from vwFuncionario";
            
            
            sql=sql+" order by nmPessoa";
            resultados = instrucaoSQL.executeQuery(sql);



            while (resultados.next()) {
                funcionario=new Funcionario(resultados.getInt("idFuncionario"), resultados.getDouble("vlComissao"), resultados.getString("docHabilitacao"),resultados.getInt("id"), resultados.getString("nmPessoa")
                        , resultados.getString("cdCpfCnpj"), resultados.getString("dtnascimento"), resultados.getString("telefone"), resultados.getString("endereco"));
                        
                cbFuncionario.addItem(funcionario);
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar animais.");
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}