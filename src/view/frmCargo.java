package view;

import controller.Funcoes;
import dao.CargoDAO;
import dao.FuncionarioDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Cargo;
import model.Funcionario;

public class frmCargo extends javax.swing.JInternalFrame {

    public frmCargo() {
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
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tbpCadastroCargo = new javax.swing.JTabbedPane();
        pnlDados = new javax.swing.JPanel();
        txtId = new controller.TextFieldIconPlaceHolder();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCargo = new controller.TextFieldIconPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Cargo");
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
        btnNovo.setText("Novo (F1)");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lixo 24x24.png"))); // NOI18N
        btnExcluir.setText("Excluir (F2)");
        btnExcluir.setEnabled(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar 24x24.png"))); // NOI18N
        btnEditar.setText("Editar (F3)");
        btnEditar.setEnabled(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar 24x24.png"))); // NOI18N
        btnSalvar.setText("Salvar (F4)");
        btnSalvar.setEnabled(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar 24x24.png"))); // NOI18N
        btnCancelar.setText("Cancelar (F5)");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnlDados.setToolTipText("");

        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setEnabled(false);

        jLabel2.setText("ID");

        txtNomeCargo.setUpper(true);
        txtNomeCargo.setMaxLength(50);
        txtNomeCargo.setEnabled(false);

        jLabel3.setText("Nome do Cargo*");

        jLabel4.setText("Campos com * devem ser preenchidos obrigatóriamente");

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(364, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        tbpCadastroCargo.addTab("Dados", pnlDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblImagemFormulario)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(tbpCadastroCargo))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblImagemFormulario))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(tbpCadastroCargo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                       
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
    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cadastro do cargo?", 
                    "Sistema - Cadastro de cargo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

            try {
                CargoDAO cargoDAO = new CargoDAO();
                Cargo cargo = new Cargo();
                cargo.setId_cargo(Integer.parseInt(txtId.getText()));
                cargoDAO.excluir(cargo);
                
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
                
                JOptionPane.showMessageDialog(null, "Cargo excluído com sucesso!", "Sistema - Cadastro de cargo", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);

                if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do cargo.\nExistem dados vinculados com esse cadastro!", 
                                            "Sistema - Cadastro de cargo", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do cargo, entre em contato com o desenvolvedor!", 
                                                "Sistema - Cadastro de cargo", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Funcoes.ativaCampos(pnlDados);
        
        txtId.setEnabled(false);
        
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        
        tbpCadastroCargo.setSelectedComponent(pnlDados);
        txtNomeCargo.requestFocusInWindow();
    }//GEN-LAST:event_btnEditarActionPerformed

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
                    Logger.getLogger(frmCargo.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(frmCargo.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(frmCargo.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(frmCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JTabbedPane tbpCadastroCargo;
    private controller.TextFieldIconPlaceHolder txtId;
    private controller.TextFieldIconPlaceHolder txtNomeCargo;
    // End of variables declaration//GEN-END:variables
}