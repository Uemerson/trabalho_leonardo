package view;

import controller.JTextFieldLimit;
import dao.ClienteDAO;
import dao.ProdutoDAO;
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
import model.Produto;
import tableModel.PesquisarClienteTableModel;
import tableModel.PesquisarFuncionarioTableModel;
import tableModel.PesquisarProdutoTableModel;

/**
 *
 * @author UEMERSON
 */
public class frmPesquisaProduto extends javax.swing.JDialog {
    
    //Variaveis
    private Produto produtoSelecionado = null;
    private String ultimaColunaSelecionada = null;
    
    public frmPesquisaProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        tbProduto.getTableHeader().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int col = tbProduto.columnAtPoint(e.getPoint());
                    String name = tbProduto.getColumnName(col);
                    //System.out.println("Column index selected " + col + " " + name);

                    lblPesquisarPor.setText("Pesquisar pelo(a) " + name);
                    ultimaColunaSelecionada = name;
                    
                    if (name.equals("ID") || 
                        name.equals("QUANTIDADE DE ESTOQUE") || 
                        name.equals("PREÇO DE COMPRA")|| 
                        name.equals("PREÇO DE VENDA")){
                        txtBuscar.setDocument(new JTextFieldLimit(10, true, true));
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
        ultimaColunaSelecionada = "NOME DO PRODUTO";
        
        atualizarTabela();
    }

    private void atualizarTabela(){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = null;
        
        if (ultimaColunaSelecionada.equals("ID") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setId_produto(Integer.parseInt(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("NOME DA PEÇA") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setNome_peca(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("MARCA") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setMarca(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("QUANTIDADE DE ESTOQUE") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setQuantidade_estoque(Integer.parseInt(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("PREÇO DE COMPRA ") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setPreco_compra(Float.parseFloat(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("PREÇO DE VENDA") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setPreco_venda(Float.parseFloat(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("FORNECEDOR") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setFornecedor(txtBuscar.getText());
        }else if (ultimaColunaSelecionada.equals("MARGEM") && !txtBuscar.getText().isEmpty()){
            produto = new Produto();
            produto.setMargem(txtBuscar.getText());
        }
            
        try {
            PesquisarProdutoTableModel pesquisarProdutoTableModel = new PesquisarProdutoTableModel(produtoDAO.listaProdutoPesquisar(produto));
            
            tbProduto.setModel(pesquisarProdutoTableModel);
            
            tbProduto.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbProduto.getColumnModel().getColumn(1).setPreferredWidth(250);
            tbProduto.getColumnModel().getColumn(2).setPreferredWidth(110);
            tbProduto.getColumnModel().getColumn(3).setPreferredWidth(110);
            tbProduto.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbProduto.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbProduto.getColumnModel().getColumn(6).setPreferredWidth(250);
            tbProduto.getColumnModel().getColumn(7).setPreferredWidth(250);
            
            tbProduto.getTableHeader().setReorderingAllowed(false);
            tbProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbProduto.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmPesquisaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagemFormulario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduto = new javax.swing.JTable();
        lblPesquisarPor = new javax.swing.JLabel();
        txtBuscar = new controller.TextFieldIconPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar funcionário");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Procurar produto");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boss 64x64 pesquisar.png"))); // NOI18N

        tbProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduto);

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

    private void tbProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutoMouseClicked
        if (evt.getClickCount() >= 2){
            produtoSelecionado = new Produto();
            produtoSelecionado.setId_produto((int) tbProduto.getValueAt(tbProduto.getSelectedRow(), 0));
            dispose();
        }
    }//GEN-LAST:event_tbProdutoMouseClicked
    
    public Produto getProdutoSelecionado(){
        return produtoSelecionado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JTable tbProduto;
    private controller.TextFieldIconPlaceHolder txtBuscar;
    // End of variables declaration//GEN-END:variables
}
