package view;

import controller.JTextFieldLimit;
import dao.FuncionarioDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Funcionario;
import tableModel.PesquisarFuncionarioTableModel;

/**
 *
 * @author UEMERSON
 */
public class frmPesquisaFuncionario extends javax.swing.JDialog {
    
    //Variaveis
    Funcionario funcionarioSelecionado = null;
    String ultimaColunaSelecionada = null;
    
    public frmPesquisaFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        tbFuncionario.getTableHeader().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int col = tbFuncionario.columnAtPoint(e.getPoint());
                    String name = tbFuncionario.getColumnName(col);
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
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = null;
        
        if (ultimaColunaSelecionada.equals("ID") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setId_funcionario(Integer.parseInt(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("NOME COMPLETO") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setNome_completo(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CPF") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setCpf(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CEP") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setCep(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("CIDADE") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setCidade(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("ENDEREÇO") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setEndereco(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("BAIRRO") && !txtBuscar.getText().isEmpty()){
            funcionario = new Funcionario();
            funcionario.setBairro(txtBuscar.getText());
        }
            
        try {
            PesquisarFuncionarioTableModel pesquisarFuncionarioTableModel = new PesquisarFuncionarioTableModel(funcionarioDAO.listaFuncionarioPesquisar(funcionario));
            
            tbFuncionario.setModel(pesquisarFuncionarioTableModel);
            
            tbFuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbFuncionario.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbFuncionario.getColumnModel().getColumn(2).setPreferredWidth(110);
            tbFuncionario.getColumnModel().getColumn(3).setPreferredWidth(110);
            tbFuncionario.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbFuncionario.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbFuncionario.getColumnModel().getColumn(6).setPreferredWidth(250);
            tbFuncionario.getColumnModel().getColumn(7).setPreferredWidth(250);
            
            tbFuncionario.getTableHeader().setReorderingAllowed(false);
            tbFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbFuncionario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmPesquisaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagemFormulario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionario = new javax.swing.JTable();
        lblPesquisarPor = new javax.swing.JLabel();
        txtBuscar = new controller.TextFieldIconPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar funcionário");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Procurar funcionário");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boss 64x64 pesquisar.png"))); // NOI18N

        tbFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFuncionario);

        lblPesquisarPor.setText("Pesquisar pelo(a) NOME COMPLETO");

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

    private void tbFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionarioMouseClicked
        if (evt.getClickCount() >= 2){
            funcionarioSelecionado = new Funcionario();
            funcionarioSelecionado.setId_funcionario((int) tbFuncionario.getValueAt(tbFuncionario.getSelectedRow(), 0));
            dispose();
        }
    }//GEN-LAST:event_tbFuncionarioMouseClicked
    
    public Funcionario getFuncionarioSelecionado(){
        return funcionarioSelecionado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JTable tbFuncionario;
    private controller.TextFieldIconPlaceHolder txtBuscar;
    // End of variables declaration//GEN-END:variables
}
