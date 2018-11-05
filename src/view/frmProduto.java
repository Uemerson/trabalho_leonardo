package view;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.Funcoes;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.Document;
import model.Produto;

/**
 *
 * @author Taynan
 */
public class frmProduto extends javax.swing.JInternalFrame {
    
    Produto produto;
    List<Produto> listaProduto;
    ProdutoDAO produtoDAO;
    Document doc;

    public frmProduto() {
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
        tbpCadastro = new javax.swing.JTabbedPane();
        pnlDados = new javax.swing.JPanel();
        txtId = new controller.TextFieldIconPlaceHolder();
        lblId = new javax.swing.JLabel();
        txtNomeProduto = new controller.TextFieldIconPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblQuantidadeEstoque = new javax.swing.JLabel();
        lblPrecoCompra = new javax.swing.JLabel();
        txtPrecoCompra = new javax.swing.JTextField();
        lblPrecoVenda = new javax.swing.JLabel();
        txtPrecoVenda = new javax.swing.JTextField();
        lblFornecedor = new javax.swing.JLabel();
        lblMargen = new javax.swing.JLabel();
        txtMarca = new controller.TextFieldIconPlaceHolder();
        txtFornecedor = new controller.TextFieldIconPlaceHolder();
        txtMargem = new controller.TextFieldIconPlaceHolder();
        txtQuantidadeEstoque = new controller.TextFieldIconPlaceHolder();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Produto");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar (F6)");
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delivery-cart (1).png"))); // NOI18N

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

        txtId.setEnabled(false);

        lblId.setText("ID");

        txtNomeProduto.setUpper(true);
        txtNomeProduto.setMaxLength(50);
        txtNomeProduto.setEnabled(false);
        txtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome do Produto");

        lblMarca.setText("Marca");

        lblQuantidadeEstoque.setText("Quantidade de Estoque");

        lblPrecoCompra.setText("Preço de Compra");

        txtPrecoCompra.setEnabled(false);

        lblPrecoVenda.setText("Preço de Venda");

        txtPrecoVenda.setEnabled(false);
        txtPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoVendaActionPerformed(evt);
            }
        });

        lblFornecedor.setText("Fornecedor");

        lblMargen.setText("Margem");

        txtMarca.setUpper(true);
        txtMarca.setMaxLength(50);
        txtMarca.setEnabled(false);

        txtFornecedor.setUpper(true);
        txtFornecedor.setMaxLength(50);
        txtFornecedor.setEnabled(false);

        txtMargem.setUpper(true);
        txtMargem.setMaxLength(50);
        txtMargem.setEnabled(false);

        txtQuantidadeEstoque.setOnlyNumber(true);
        txtQuantidadeEstoque.setMaxLength(50);
        txtQuantidadeEstoque.setEnabled(false);

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblId))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuantidadeEstoque)
                            .addComponent(txtQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecoCompra))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecoVenda)
                            .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFornecedor)
                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlDadosLayout.createSequentialGroup()
                                .addComponent(lblMargen)
                                .addGap(100, 100, 100))
                            .addComponent(txtMargem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(jLabel3)
                    .addComponent(lblMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidadeEstoque)
                    .addComponent(lblPrecoCompra)
                    .addComponent(lblPrecoVenda)
                    .addComponent(lblFornecedor)
                    .addComponent(lblMargen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMargem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        tbpCadastro.addTab("Dados", pnlDados);

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
                    .addComponent(tbpCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addComponent(tbpCadastro)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoVendaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        if (txtNomeProduto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Nome da produto deve ser preenchido!", "Sistema - Cadastro de produto", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtNomeProduto.requestFocusInWindow();
        }else if (txtMarca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Marca deve ser preenchido!", "Sistema - Cadastro de produto", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtMarca.requestFocusInWindow();
        }
        else if (txtQuantidadeEstoque.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Quantidade de estoque deve ser preenchido!", "Sistema - Cadastro de produto", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtQuantidadeEstoque.requestFocusInWindow();
            
        }else if (txtPrecoCompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Preço de Compra deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtPrecoCompra.requestFocusInWindow();
        }
        else if (txtPrecoVenda.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Preço de Venda deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtPrecoVenda.requestFocusInWindow();
        }
        else if (txtMargem.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Margem deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtMargem.requestFocusInWindow();
        }
        
        
        
        //Todos os campos necessários preenchidos
        else{
            Produto produto = new Produto();
            
            produto.setNome_produto(txtNomeProduto.getText());
            produto.setMarca(txtMarca.getText());
            produto.setQuantidade_estoque(Integer.parseInt(txtQuantidadeEstoque.getText()));
            produto.setPreco_compra(Float.parseFloat(txtPrecoCompra.getText()));
            produto.setPreco_venda(Float.parseFloat(txtPrecoVenda.getText()));
            produto.setFornecedor(txtFornecedor.getText());
            produto.setMargem(txtMargem.getText());
            
            
            
            if (txtId.getText().equals("NOVO")){ //Inserindo um produto
                ProdutoDAO produtoDAO = new ProdutoDAO();
                try {
                    produtoDAO.inserir(produto);
                    
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
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de produto salvo com sucesso!", "Sistema - Cadstro de produto", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmProduto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar produto", "Sistema - Cadastro de produto", JOptionPane.ERROR_MESSAGE);
                }
            }else { //Atualizando os dados do funcionário
                produto.setId_produto(Integer.parseInt(txtId.getText()));
                ProdutoDAO produtoDAO = new ProdutoDAO();
                try {
                    produtoDAO.alterar(produto);
                    
                    Funcoes.desativaCampos(pnlDados);
                    

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(true);
                    btnExcluir.setEnabled(true);
                    btnPesquisar.setEnabled(true);
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de produto alterado com sucesso!", "Sistema - Cadstro de produto", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmProduto.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar alterar produto", "Sistema - Cadastro de produto", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
        
        tbpCadastro.setSelectedComponent(pnlDados);
        txtNomeProduto.requestFocusInWindow();
    }//GEN-LAST:event_btnNovoActionPerformed

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
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produtoId = new Produto();
                produtoId.setId_produto(Integer.parseInt(txtId.getText()));
                Produto produto = produtoDAO.buscar(produtoId);
                
                txtNomeProduto.setText(produto.getNome_produto());
                txtMarca.setText(produto.getMarca());
                txtQuantidadeEstoque.setText(Integer.toString(produto.getQuantidade_estoque()) );
                txtPrecoCompra.setText(Float.toString(produto.getPreco_compra()));
                txtPrecoVenda.setText(Float.toString(produto.getPreco_venda()));
                txtFornecedor.setText(produto.getFornecedor());
                txtMargem.setText(produto.getMargem());
                
               
                
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmProduto.class.getName()).log(Level.SEVERE, null, ex);
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
        
        frmPesquisaProduto pesquisarProduto = new frmPesquisaProduto(null, true);
        pesquisarProduto.setVisible(true);
        
        Produto produtoSelecionado = pesquisarProduto.getProdutoSelecionado();
        
        if (produtoSelecionado != null){
            txtId.setText(Integer.toString(produtoSelecionado.getId_produto()));
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            
            try {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = produtoDAO.buscar(produtoSelecionado);
                
                txtNomeProduto.setText(produto.getNome_produto());
                txtMarca.setText(produto.getMarca());
                txtQuantidadeEstoque.setText(Integer.toString(produto.getQuantidade_estoque()));
                txtPrecoCompra.setText(Float.toString(produto.getPreco_compra()));
                txtPrecoVenda.setText(Float.toString(produto.getPreco_venda()));
                txtFornecedor.setText(produto.getFornecedor());
                txtMargem.setText(produto.getMargem());
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(frmProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cadastro do produto?", 
                    "Sistema - Cadastro de produto", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

            try {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = new Produto();
                produto.setId_produto(Integer.parseInt(txtId.getText()));
                produtoDAO.excluir(produto);
                
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
                
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!", "Sistema - Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(frmProduto.class.getName()).log(Level.SEVERE, null, ex);

                if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do Produto.\nExistem dados vinculados com esse cadastro!", 
                                            "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do produto, entre em contato com o desenvolvedor!", 
                                                "Sistema - Cadastro de produto", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoActionPerformed

        private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String nomediretorio = null;
        String nomepasta = "PRODUTO"; // Informe o nome da pasta que armazenará o relatório
        String separador = java.io.File.separator;
        try {
            nomediretorio = "C:" + separador + nomepasta;
            if (!new File(nomediretorio).exists()) {
                (new File(nomediretorio)).mkdir();
            }
            gerarDocumento();
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }                                            

    public void gerarDocumento() throws IOException, SQLException {
        try {
            List<Produto> lista = new ArrayList<>();
            lista = produtoDAO.listaProdutoPesquisar(produto);
            doc = new Document(PageSize.A4, 41.5f, 41.5f, 55.2f, 55.2f) {};
            PdfWriter.getInstance(doc, new FileOutputStream("C:/PRODUTO/RelatorioProduto" + ".pdf"));
            doc.open();

            Font f1 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font f2 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font f3 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font f4 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font f5 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            Paragraph titulo1 = new Paragraph("Sistema de Auto Peças", f2);
            titulo1.setAlignment(Element.ALIGN_CENTER);
            titulo1.setSpacingAfter(10);

            Paragraph titulo2 = new Paragraph("Relatório de Produtos", f1);
            titulo2.setAlignment(Element.ALIGN_CENTER);
            titulo2.setSpacingAfter(0);

            PdfPTable tabela = new PdfPTable(new float[]{0.40f, 0.40f, 0.40f});
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(100f);

            PdfPCell cabecalho1 = new PdfPCell(new Paragraph("Nome do Produto:", f3));
            //cabecalho1.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho1.setBorder(0);

            PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Marca:", f3));
            //cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho2.setBorder(0);
            
            PdfPCell cabecalho3 = new PdfPCell(new Paragraph("Quantidade em estoque:", f3));
            //cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho3.setBorder(0);
            
           

            tabela.addCell(cabecalho1);
            tabela.addCell(cabecalho2);
            tabela.addCell(cabecalho3);
            

            for (Produto  produto : lista) {
                
                Paragraph p1 = new Paragraph(produto.getNomeproduto(), f5);
                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col1 = new PdfPCell(p1);
                col1.setBorder(0);
                
                Paragraph p2 = new Paragraph(produto.getMarca(), f5);
                p2.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col2 = new PdfPCell(p2);
                col2.setBorder(0);
               
                
                Paragraph p3 = new Paragraph(produto.getQuantidadeEstoque(), f5);
                p3.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col3 = new PdfPCell(p3);
                col3.setBorder(0);           
                tabela.addCell(col1);
                tabela.addCell(col2);
                tabela.addCell(col3);          
                
              
            }
            
            doc.add(titulo2);
            doc.add(titulo1);
            doc.add(tabela);
            doc.close();
            
            JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso");
            String caminho = "C:/PRODUTO/RelatorioProduto.pdf";
            Desktop.getDesktop().open(new File(caminho));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException exx) {
            exx.printStackTrace();
            JOptionPane.showMessageDialog(null, "Documento de Requisitos aberto. Feche para gerar um novo.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblMargen;
    private javax.swing.JLabel lblPrecoCompra;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblQuantidadeEstoque;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JTabbedPane tbpCadastro;
    private controller.TextFieldIconPlaceHolder txtFornecedor;
    private controller.TextFieldIconPlaceHolder txtId;
    private controller.TextFieldIconPlaceHolder txtMarca;
    private controller.TextFieldIconPlaceHolder txtMargem;
    private controller.TextFieldIconPlaceHolder txtNomeProduto;
    private javax.swing.JTextField txtPrecoCompra;
    private javax.swing.JTextField txtPrecoVenda;
    private controller.TextFieldIconPlaceHolder txtQuantidadeEstoque;
    // End of variables declaration//GEN-END:variables
}
