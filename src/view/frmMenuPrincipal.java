package view;

/**
 *
 * @author Uemerson
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    public frmMenuPrincipal() {
        initComponents();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JDesktopPane();
        mnuMenu = new javax.swing.JMenuBar();
        mnuCliente = new javax.swing.JMenu();
        mniCadastroCliente = new javax.swing.JMenuItem();
        mnuFuncionario = new javax.swing.JMenu();
        mniCadastroFuncionario = new javax.swing.JMenuItem();

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

        mnuMenu.add(mnuFuncionario);

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
        frmFuncionario funcionario = new frmFuncionario();
        funcionario.setVisible(true);
        
        pnlPrincipal.add(funcionario);
    }//GEN-LAST:event_mniCadastroFuncionarioActionPerformed

    private void mniCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastroClienteActionPerformed
        frmCliente cliente = new frmCliente();
        cliente.setVisible(true);
        
        pnlPrincipal.add(cliente);
    }//GEN-LAST:event_mniCadastroClienteActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem mniCadastroCliente;
    private javax.swing.JMenuItem mniCadastroFuncionario;
    private javax.swing.JMenu mnuCliente;
    private javax.swing.JMenu mnuFuncionario;
    private javax.swing.JMenuBar mnuMenu;
    private javax.swing.JDesktopPane pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
