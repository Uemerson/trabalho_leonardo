package view;

import controller.JTextFieldLimit;
import dao.ClienteDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Cliente;
import tableModel.PesquisarClienteTableModel;
import tableModel.PesquisarFuncionarioTableModel;

/**
 *
 * @author UEMERSON
 */
public class frmPesquisaCliente extends javax.swing.JDialog {
    
    //Variaveis
    private Cliente clienteSelecionado = null;
    private String ultimaColunaSelecionada = null;
    
    public frmPesquisaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        tbCliente.getTableHeader().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int col = tbCliente.columnAtPoint(e.getPoint());
                    String name = tbCliente.getColumnName(col);
                    //System.out.println("Column index selected " + col + " " + name);

                    lblPesquisarPor.setText("Pesquisar pelo(a) " + name);
                    ultimaColunaSelecionada = name;
                    
                    if (name.equals("ID")){
                        txtBuscar.setDocument(new JTextFieldLimit(10, true, true));
                    }else if (name.equals("CPF")){
                        txtBuscar.setDocument(new JTextFieldLimit(11, true, true));
                    }else if (name.equals("CEP")){    
                        txtBuscar.setDocument(new JTextFieldLimit(8, true, true));
                    }else if (name.equals("RG")){
                        txtBuscar.setDocument(new JTextFieldLimit(10, true));
                    }else{
                        txtBuscar.setDocument(new JTextFieldLimit(50, true, false));
                    }
                    
                    txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            atualizarTabela();
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            atualizarTabela();
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                        }
                    });
                    atualizarTabela();
                }
        });
        
        txtBuscar.setDocument(new JTextFieldLimit(50, true, false));
        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarTabela();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                atualizarTabela();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        ultimaColunaSelecionada = "NOME COMPLETO";
        
        atualizarTabela();
    }

    private void atualizarTabela(){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = null;
        
        if (ultimaColunaSelecionada.equals("ID") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setId_cliente(Integer.parseInt(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("NOME COMPLETO") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setNome_completo(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CPF") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setCpf(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("RG") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setRg(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CEP") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setCep(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CIDADE") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setCidade(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("ENDEREÇO") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setEndereco(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("BAIRRO") && !txtBuscar.getText().isEmpty()){
            cliente = new Cliente();
            cliente.setBairro(txtBuscar.getText());
        }
            
        try {
            PesquisarClienteTableModel pesquisarClienteTableModel = new PesquisarClienteTableModel(clienteDAO.listaClientePesquisar(cliente));
            
            tbCliente.setModel(pesquisarClienteTableModel);
            
            tbCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbCliente.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbCliente.getColumnModel().getColumn(2).setPreferredWidth(110);
            tbCliente.getColumnModel().getColumn(3).setPreferredWidth(110);
            tbCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbCliente.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbCliente.getColumnModel().getColumn(6).setPreferredWidth(250);
            tbCliente.getColumnModel().getColumn(7).setPreferredWidth(250);
            
            tbCliente.getTableHeader().setReorderingAllowed(false);
            tbCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmPesquisaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagemFormulario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        lblPesquisarPor = new javax.swing.JLabel();
        txtBuscar = new controller.TextFieldIconPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar funcionário");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Procurar cliente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boss 64x64 pesquisar.png"))); // NOI18N

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        lblPesquisarPor.setText("Pesquisar pelo(a) NOME COMPLETO");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagemFormulario)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 143, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisarPor)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisarPor)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        if (evt.getClickCount() >= 2){
            clienteSelecionado = new Cliente();
            clienteSelecionado.setId_cliente((int) tbCliente.getValueAt(tbCliente.getSelectedRow(), 0));
            dispose();
        }
    }//GEN-LAST:event_tbClienteMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed
    
    public Cliente getClienteSelecionado(){
        return clienteSelecionado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JTable tbCliente;
    private controller.TextFieldIconPlaceHolder txtBuscar;
    // End of variables declaration//GEN-END:variables
}
