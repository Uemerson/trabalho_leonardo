package view;

import controller.JTextFieldLimit;
import dao.FornecedorDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Fornecedor;
import tableModel.PesquisarFornecedorTableModel;

/**
 *
 * @author UEMERSON
 */
public class frmPesquisaFornecedor extends javax.swing.JDialog {
    
    //Variaveis
    private Fornecedor fornecedorSelecionado = null;
    private String ultimaColunaSelecionada = null;
    
    public frmPesquisaFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        tbFornecedor.getTableHeader().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int col = tbFornecedor.columnAtPoint(e.getPoint());
                    String name = tbFornecedor.getColumnName(col);
                    //System.out.println("Column index selected " + col + " " + name);

                    lblPesquisarPor.setText("Pesquisar pelo(a) " + name);
                    ultimaColunaSelecionada = name;
                   
                    if (name.equals("ID")){
                        txtBuscar.setDocument(new JTextFieldLimit(10, true, true));
                    }else if (name.equals("CNPJ")){
                        txtBuscar.setDocument(new JTextFieldLimit(11, true, true));
                    }else if (name.equals("CEP")){    
                        txtBuscar.setDocument(new JTextFieldLimit(8, true, true));
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
        ultimaColunaSelecionada = "NOME FANTASIA";
        
        atualizarTabela();
    }

    private void atualizarTabela(){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = null;
        
        if (ultimaColunaSelecionada.equals("ID") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setId_fornecedor(Integer.parseInt(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("NOME FANTASIA") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setNomeFantasia(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("RAZÃO SOCIAL") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setRazaoSocial(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CNPJ") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setCnpj(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CEP") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setCep(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CIDADE") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setCidade(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("ENDEREÇO") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setEndereco(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("BAIRRO") && !txtBuscar.getText().isEmpty()){
            fornecedor = new Fornecedor();
            fornecedor.setBairro(txtBuscar.getText());
        }
            
        try {
            PesquisarFornecedorTableModel pesquisarFornecedorTableModel = new PesquisarFornecedorTableModel(fornecedorDAO.listaFornecedorPesquisar(fornecedor));
            
            tbFornecedor.setModel(pesquisarFornecedorTableModel);
            
            tbFornecedor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbFornecedor.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbFornecedor.getColumnModel().getColumn(2).setPreferredWidth(250);
            tbFornecedor.getColumnModel().getColumn(3).setPreferredWidth(110);
            tbFornecedor.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbFornecedor.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbFornecedor.getColumnModel().getColumn(6).setPreferredWidth(250);
            tbFornecedor.getColumnModel().getColumn(7).setPreferredWidth(250);
            
            tbFornecedor.getTableHeader().setReorderingAllowed(false);
            tbFornecedor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbFornecedor.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmPesquisaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagemFormulario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFornecedor = new javax.swing.JTable();
        lblPesquisarPor = new javax.swing.JLabel();
        txtBuscar = new controller.TextFieldIconPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar funcionário");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Procurar fornecedor");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deal 64x64.png"))); // NOI18N

        tbFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFornecedor);

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

    private void tbFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFornecedorMouseClicked
        if (evt.getClickCount() >= 2){
            fornecedorSelecionado = new Fornecedor();
            fornecedorSelecionado.setId_fornecedor((int) tbFornecedor.getValueAt(tbFornecedor.getSelectedRow(), 0));
            dispose();
        }
    }//GEN-LAST:event_tbFornecedorMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed
    
    public Fornecedor getFornecedorSelecionado(){
        return fornecedorSelecionado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JTable tbFornecedor;
    private controller.TextFieldIconPlaceHolder txtBuscar;
    // End of variables declaration//GEN-END:variables
}
