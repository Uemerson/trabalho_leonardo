package view;

import controller.Funcoes;
import dao.CargoDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Cargo;



public class frmVenda extends javax.swing.JInternalFrame {

    public frmVenda() {
        initComponents();
        
        // Hack para remover icone do nimbus
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false);
    }

    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblImagemFormulario = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar1 = new javax.swing.JButton();
        btnPesquisar2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(883, 483));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Venda");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar (F6)");
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/employee 64x64.png"))); // NOI18N

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar 24x24.png"))); // NOI18N
        btnNovo.setText("(F3)");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar 24x24.png"))); // NOI18N
        btnSalvar.setText("Finalizar Venda (F5)");
        btnSalvar.setEnabled(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar 24x24.png"))); // NOI18N
        btnCancelar.setText("(F4)");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar1.setText("Buscar (F2)");
        btnPesquisar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar1ActionPerformed(evt);
            }
        });

        btnPesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar2.setText("Buscar (F1)");
        btnPesquisar2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisar2ActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel3.setText("ID:");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField1");

        jLabel4.setText("NOME:");

        jLabel5.setText("DESCRIÇÃO:");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField3");

        jLabel6.setText("QTDE:");

        jLabel7.setText("PREÇO UNID.:");

        jLabel8.setText("PREÇO TOTAL:");

        jTextField5.setText("jTextField1");

        jTextField6.setText("jTextField1");

        jTextField7.setText("jTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1111, 1111, 1111)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(196, 196, 196)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(25, 25, 25)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(183, 183, 183)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                                        .addComponent(jTextField3)))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblImagemFormulario)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(9, 9, 9)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblImagemFormulario))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btnPesquisar2)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnPesquisar1)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNovo)
                                .addComponent(btnCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                           
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if (txtNomeCargo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Nome do cargo deve ser preenchido!", "Sistema - Cadastro de cargo", JOptionPane.ERROR_MESSAGE);
            tbpCadastroCargo.setSelectedComponent(pnlDados);
            txtNomeCargo.requestFocusInWindow();
        }
        //Todos os campos necessários preenchidos
        else{
            Cargo cargo = new Cargo();
            
            cargo.setNome_cargo(txtNomeCargo.getText());
            
            if (txtId.getText().equals("NOVO")){ //Inserindo um novo funcionário
                CargoDAO cargoDAO = new CargoDAO();
                try {
                    cargoDAO.inserir(cargo);
                    
                    Funcoes.desativaCampos(pnlDados);
                    
                    Funcoes.limpaCampos(pnlDados);
                    
                    txtId.setText(null);
                    txtId.setEnabled(false);

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    btnPesquisar.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de cargo salvo com sucesso!", "Sistema - Cadstro de cargo", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar cargo", "Sistema - Cadastro de cargo", JOptionPane.ERROR_MESSAGE);
                }
            }else { //Atualizando os dados do funcionário
                cargo.setId_Cargo(Integer.parseInt(txtId.getText()));
                CargoDAO cargoDAO = new CargoDAO();
                try {
                    cargoDAO.alterar(cargo);
                    
                    Funcoes.desativaCampos(pnlDados);
                    
                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(true);
                    btnExcluir.setEnabled(true);
                    btnPesquisar.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de cargo alterado com sucesso!", "Sistema - Cadstro de cargo", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    if(ex instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException){
                        JOptionPane.showMessageDialog(null, "Já existe um cargo com esse nome!", "Sistema - Cadastro de cargo", JOptionPane.ERROR_MESSAGE);
                    }else{
                        Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cargo", "Sistema - Cadastro de cargo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Funcoes.desativaCampos(pnlDados);
        
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(true);
        
        if (txtId.getText().equals("NOVO")){
            Funcoes.limpaCampos(pnlDados);

            txtId.setText(null);
            txtId.setEnabled(false);
        }else{
            
            //Retorna os dados que estão cadastrados no banco
            try {
                CargoDAO cargoDAO = new CargoDAO();
                Cargo cargoId = new Cargo();
                cargoId.setId_cargo(Integer.parseInt(txtId.getText()));
                Cargo cargo = cargoDAO.buscar(cargoId);
                
                txtNomeCargo.setText(cargo.getNome_cargo());
                                
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Funcoes.desativaCampos(pnlDados);

        Funcoes.limpaCampos(pnlDados);
        
        txtId.setText(null);
        txtId.setEnabled(false);

        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(true);
        
        frmPesquisaCargo pesquisarCargo = new frmPesquisaCargo(null, true);
        pesquisarCargo.setVisible(true);
        
        Cargo cargoSelecionado = pesquisarCargo.getCargoSelecionado();
        
        if (cargoSelecionado != null){
            txtId.setText(Integer.toString(cargoSelecionado.getId_cargo()));
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            
            try {
                CargoDAO cargoDAO = new CargoDAO();
                Cargo cargo = cargoDAO.buscar(cargoSelecionado);
                
                txtNomeCargo.setText(cargo.getNome_cargo());
                
            } catch (SQLException ex) {
                Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        Funcoes.ativaCampos(pnlDados);

        Funcoes.limpaCampos(pnlDados);
        txtId.setText("NOVO");
        txtId.setEnabled(false);

        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);

        tbpCadastroCargo.setSelectedComponent(pnlDados);
        txtNomeCargo.requestFocusInWindow();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisar1ActionPerformed

    private void btnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisar2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisar1;
    private javax.swing.JButton btnPesquisar2;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblImagemFormulario;
    // End of variables declaration//GEN-END:variables
}