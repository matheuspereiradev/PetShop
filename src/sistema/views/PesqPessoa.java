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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.entidades.Pessoa;
import sistema.principal.Conexao;

/**
 *
 * @author MATHEUS-PC
 */
public class PesqPessoa extends javax.swing.JInternalFrame {

    CadFuncionario frame;
    Pessoa pessoa;
    private DefaultTableModel modelListaPessoas;
    
    public PesqPessoa(CadFuncionario frame) {
        initComponents();
        modelListaPessoas = (DefaultTableModel) jTabelPessoas.getModel() ;
        montaPessoas();
        this.frame=frame;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSeleciona = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelPessoas = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setTitle("Selecione uma pessoa");

        btnSeleciona.setText("Selecionar");
        btnSeleciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionaActionPerformed(evt);
            }
        });

        jTabelPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome", "CPF/CNPJ", "Dt Nasc", "Telefone", "Endereco"
            }
        ));
        jScrollPane3.setViewportView(jTabelPessoas);

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSeleciona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionaActionPerformed
        pessoa= new Pessoa((int) jTabelPessoas.getValueAt(jTabelPessoas.getSelectedRow(), 0),(String) jTabelPessoas.getValueAt(jTabelPessoas.getSelectedRow(), 1),(String)  jTabelPessoas.getValueAt(jTabelPessoas.getSelectedRow(), 2),(String) jTabelPessoas.getValueAt(jTabelPessoas.getSelectedRow(), 3), (String) jTabelPessoas.getValueAt(jTabelPessoas.getSelectedRow(), 4), (String)jTabelPessoas.getValueAt(jTabelPessoas.getSelectedRow(), 5));
        frame.setPessoa(pessoa);
        dispose();
    }//GEN-LAST:event_btnSelecionaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       montaPessoas();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleciona;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabelPessoas;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void montaPessoas() {
       // conexão
        Connection conexao;
        // instrucao SQL
        Statement instrucaoSQL;
        // resultados
        ResultSet resultados;
        
         modelListaPessoas.setRowCount(0);
        try {
            // conectando ao banco de dados
            conexao = DriverManager.getConnection(Conexao.servidor, Conexao.usuario, Conexao.senha);

            // criando a instrução SQL
            instrucaoSQL = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Cliente where 1=1";
            if(!jTextField1.getText().equals("")){
                sql=sql+" and nmPessoa like '%"+jTextField1.getText()+"%'";
            }
            sql=sql+"order by nmPessoa";
            resultados = instrucaoSQL.executeQuery(sql);

           

            while (resultados.next()) {
                Object [] pessoa = {resultados.getInt("id"), resultados.getString("nmPessoa"), resultados.getString("cdCpfCnpj") , resultados.getString("dtnascimento"), resultados.getString("telefone"), resultados.getString("endereco")};        
                modelListaPessoas.addRow(pessoa);
            }

            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar dados.");
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
