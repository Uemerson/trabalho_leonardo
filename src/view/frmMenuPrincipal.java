package view;

import model.Fornecedor;
import model.Funcionario;

/**
 *
 * @author Uemerson
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    public frmMenuPrincipal(Funcionario funcionario) {
        initComponents();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        
        if(funcionario.getCargo().equals(1)){
            mniCadastroFuncionario.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        pnlPrincipal = new javax.swing.JDesktopPane();
        mnuMenu = new javax.swing.JMenuBar();
        mnuCliente = new javax.swing.JMenu();
        mniCadastroCliente = new javax.swing.JMenuItem();
        mnuFuncionario = new javax.swing.JMenu();
        mniCadastroFuncionario = new javax.swing.JMenuItem();
        mniCadastroCargo = new javax.swing.JMenuItem();
        mnuProduto = new javax.swing.JMenu();
        mniCadastroProduto = new javax.swing.JMenuItem();
        mnuFornecedor = new javax.swing.JMenu();
        mniCadastroFornecedor = new javax.swing.JMenuItem();
        mnuVenda = new javax.swing.JMenu();
        mnuCadastroVenda = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        mnuCliente.setText("Cliente");

        mniCadastroCliente.setText("Cadastro de cliente");
        mniCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroClienteActionPerformed(evt);
            }
        });
        mnuCliente.add(mniCadastroCliente);

        mnuMenu.add(mnuCliente);

        mnuFuncionario.setText("Funcionário");

        mniCadastroFuncionario.setText("Cadastro de funcionário");
        mniCadastroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroFuncionarioActionPerformed(evt);
            }
        });
        mnuFuncionario.add(mniCadastroFuncionario);

        mniCadastroCargo.setText("Cadastro de cargo");
        mniCadastroCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroCargoActionPerformed(evt);
            }
        });
        mnuFuncionario.add(mniCadastroCargo);

        mnuMenu.add(mnuFuncionario);

        mnuProduto.setText("Produto");

        mniCadastroProduto.setText("Cadastro de produto");
        mniCadastroProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroProdutoActionPerformed(evt);
            }
        });
        mnuProduto.add(mniCadastroProduto);

        mnuMenu.add(mnuProduto);

        mnuFornecedor.setText("Fornecedor");

        mniCadastroFornecedor.setText("Cadastro de fornecedor");
        mniCadastroFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastroFornecedorActionPerformed(evt);
            }
        });
        mnuFornecedor.add(mniCadastroFornecedor);

        mnuMenu.add(mnuFornecedor);

        mnuVenda.setText("Venda");

        mnuCadastroVenda.setText("Cadastro de venda");
        mnuCadastroVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadastroVendaActionPerformed(evt);
            }
        });
        mnuVenda.add(mnuCadastroVenda);

        mnuMenu.add(mnuVenda);

        setJMenuBar(mnuMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mniCadastroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroFuncionarioActionPerformed
        pnlPrincipal.removeAll();
        pnlPrincipal.updateUI();
        
        frmFuncionario funcionario = new frmFuncionario();
       
        pnlPrincipal.add(funcionario);
        funcionario.setPosicao();                                               //Centraliza
        funcionario.setVisible(true);
        
    }//GEN-LAST:event_mniCadastroFuncionarioActionPerformed

    private void mniCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroClienteActionPerformed
        pnlPrincipal.removeAll();
        pnlPrincipal.updateUI();
        
        frmCliente cliente = new frmCliente();
        
        pnlPrincipal.add(cliente);
        cliente.setPosicao();                                                   //Centraliza
        cliente.setVisible(true);
    }//GEN-LAST:event_mniCadastroClienteActionPerformed

    private void mniCadastroCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroCargoActionPerformed
        pnlPrincipal.removeAll();
        pnlPrincipal.updateUI();
        
        frmCargo cargo = new frmCargo();
        
        pnlPrincipal.add(cargo);
        cargo.setPosicao();
        cargo.setVisible(true);
    }//GEN-LAST:event_mniCadastroCargoActionPerformed

    private void mniCadastroProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroProdutoActionPerformed
        pnlPrincipal.removeAll();
        
        frmProduto produto = new frmProduto();
        
        pnlPrincipal.add(produto);
        produto.setPosicao();
        produto.setVisible(true);
    }//GEN-LAST:event_mniCadastroProdutoActionPerformed

    private void mniCadastroFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroFornecedorActionPerformed
        pnlPrincipal.removeAll();
        
        frmFornecedor fornecedor = new frmFornecedor();
        
        pnlPrincipal.add(fornecedor);
        fornecedor.setPosicao();
        fornecedor.setVisible(true);
    }//GEN-LAST:event_mniCadastroFornecedorActionPerformed

    private void mnuCadastroVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadastroVendaActionPerformed
        pnlPrincipal.removeAll();
        
        frmVenda venda = new frmVenda();
        
        pnlPrincipal.add(venda);
        venda.setPosicao();
        venda.setVisible(true);
    }//GEN-LAST:event_mnuCadastroVendaActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem mniCadastroCargo;
    private javax.swing.JMenuItem mniCadastroCliente;
    private javax.swing.JMenuItem mniCadastroFornecedor;
    private javax.swing.JMenuItem mniCadastroFuncionario;
    private javax.swing.JMenuItem mniCadastroProduto;
    private javax.swing.JMenuItem mnuCadastroVenda;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenu mnuFornecedor;
    private javax.swing.JMenu mnuFuncionario;
    private javax.swing.JMenuBar mnuMenu;
    private javax.swing.JMenu mnuProduto;
    private javax.swing.JMenu mnuVenda;
    private javax.swing.JDesktopPane pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
