package view;

import comboModel.VendedorCellRenderer;
import comboModel.VendedorComboModel;
import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.ProdutoDAO;
import dao.VendaDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Cliente;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import tableModel.ItensVendaTableModel;

public class frmVenda extends javax.swing.JInternalFrame {
    
    //Variaveis
    ArrayList<ItemVenda> itensVenda = new ArrayList<>();
    
    public frmVenda() {
        initComponents();
        
        // Hack para remover icone do nimbus
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false);
        
        try {
            //Carrrega lista de vendedores na caixa de seleção
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            VendedorComboModel vendedorComboModel = new VendedorComboModel(funcionarioDAO.listaVendedor());
            cbVendedor.setModel(vendedorComboModel);
            cbVendedor.setRenderer(new VendedorCellRenderer());
            cbVendedor.setSelectedItem(null);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        atualizaTabela();
    }

    private void atualizaTabela(){
        //Adiciona o table model na tabela
        ItensVendaTableModel itensVendaTableModel = new ItensVendaTableModel(itensVenda);
            
        tbItensVenda.setModel(itensVendaTableModel);

        tbItensVenda.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbItensVenda.getColumnModel().getColumn(1).setPreferredWidth(495);
        tbItensVenda.getColumnModel().getColumn(2).setPreferredWidth(110);
        tbItensVenda.getColumnModel().getColumn(3).setPreferredWidth(110);
        tbItensVenda.getColumnModel().getColumn(4).setPreferredWidth(110);

        tbItensVenda.getTableHeader().setReorderingAllowed(false);
        tbItensVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbItensVenda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    
    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagemFormulario = new javax.swing.JLabel();
        btnAdicionarProduto = new javax.swing.JButton();
        btnRemoverProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtIdProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPrecoTotal = new javax.swing.JTextField();
        txtPrecoUnidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItensVenda = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btnPesquisarCliente = new javax.swing.JButton();
        btnPesquisarProduto = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox();
        txtQuantidadeProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtVendaTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Vendas");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cash-register 64x64.png"))); // NOI18N

        btnAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus 24x24.png"))); // NOI18N
        btnAdicionarProduto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        btnRemoverProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus 24x24.png"))); // NOI18N
        btnRemoverProduto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverProdutoActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("ID");

        txtIdCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCliente.setEnabled(false);

        txtIdProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdProduto.setEnabled(false);

        jLabel4.setText("CLIENTE");

        jLabel5.setText("PRODUTO");

        txtNomeProduto.setEnabled(false);

        txtNomeCliente.setEnabled(false);

        jLabel6.setText("QTDE:");

        jLabel7.setText("PREÇO UNID.:");

        jLabel8.setText("PREÇO TOTAL:");

        txtPrecoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecoTotal.setEnabled(false);

        txtPrecoUnidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecoUnidade.setEnabled(false);

        jScrollPane1.setViewportView(tbItensVenda);

        btnPesquisarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        btnPesquisarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar 24x24.png"))); // NOI18N
        btnSalvar.setText("Finalizar Venda (F5)");
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("Vendedor");

        txtQuantidadeProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantidadeProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtQuantidadeProdutoCaretUpdate(evt);
            }
        });

        jLabel10.setText("Venda total");

        txtVendaTotal.setEnabled(false);

        jLabel11.setText("Desconto");

        txtDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCliente)
                            .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeCliente)
                            .addComponent(txtNomeProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblImagemFormulario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(9, 9, 9)
                                .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionarProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoverProduto)))
                        .addGap(0, 251, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVendaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPesquisarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRemoverProduto)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(txtPrecoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtVendaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        frmPesquisaCliente pesquisarCliente = new frmPesquisaCliente(null, true);
        
        pesquisarCliente.setVisible(true);
        
        Cliente clienteSelecionado = pesquisarCliente.getClienteSelecionado();
        
        if (clienteSelecionado != null){
            
            ClienteDAO clienteDAO = new ClienteDAO();
            try {
                Cliente cliente = clienteDAO.buscar(clienteSelecionado);
                txtIdCliente.setText(Integer.toString(cliente.getId_cliente()));
                txtNomeCliente.setText(cliente.getNome_completo());
                
            } catch (SQLException ex) {
                Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        frmPesquisaProduto pesquisarProduto = new frmPesquisaProduto(null, true);
        
        pesquisarProduto.setVisible(true);
        
        Produto produtoSelecionado = pesquisarProduto.getProdutoSelecionado();
        
        if (produtoSelecionado != null){
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            try {
                Produto produto = produtoDAO.buscar(produtoSelecionado);
                txtIdProduto.setText(Integer.toString(produto.getId_produto()));
                txtNomeProduto.setText(produto.getNome_produto());
                txtPrecoUnidade.setText(Float.toString(produto.getPreco_venda()));
                txtPrecoTotal.setText(null);
                txtQuantidadeProduto.setText(null);
                txtQuantidadeProduto.requestFocusInWindow();
            } catch (SQLException ex) {
                Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void txtQuantidadeProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtQuantidadeProdutoCaretUpdate
        if (!txtQuantidadeProduto.getText().isEmpty() && !txtPrecoUnidade.getText().isEmpty()){
            float precoUnidade = Float.parseFloat(txtPrecoUnidade.getText());
            float quantidade = Float.parseFloat(txtQuantidadeProduto.getText());
            
            txtPrecoTotal.setText(Float.toString(precoUnidade * quantidade));
        }else{
            txtPrecoTotal.setText(Float.toString(0));
        }
    }//GEN-LAST:event_txtQuantidadeProdutoCaretUpdate

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        if (txtIdProduto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Entre com um produto!", "Erro ao tentar inserir produto!", JOptionPane.ERROR_MESSAGE);
        }else if (txtQuantidadeProduto.getText().isEmpty() || Float.parseFloat(txtQuantidadeProduto.getText()) <= 0){
            JOptionPane.showMessageDialog(null, "Entre com uma quantidade maior que zero!", "Erro ao tentar inserir produto!", JOptionPane.ERROR_MESSAGE);
            txtQuantidadeProduto.requestFocusInWindow();
        }else {
            Produto produto = new Produto();
            produto.setId_produto(Integer.parseInt(txtIdProduto.getText()));
            produto.setNome_produto(txtNomeProduto.getText());
            produto.setPreco_venda(Float.parseFloat(txtPrecoUnidade.getText()));
            
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setQuantidade(Float.parseFloat(txtQuantidadeProduto.getText()));
            itemVenda.setTotalVenda(Float.parseFloat(txtQuantidadeProduto.getText()) * Float.parseFloat(txtPrecoUnidade.getText()));
            
            itensVenda.add(itemVenda);
            txtVendaTotal.setText(Float.toString(calculaVendaTotal()));
            atualizaTabela();
        }
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void btnRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverProdutoActionPerformed
        //System.out.println("x: " + tbItensVenda.getSelectedRow());
        
        if (tbItensVenda.getSelectedRow() >= 0){
            itensVenda.remove(tbItensVenda.getSelectedRow());
            txtVendaTotal.setText(Float.toString(calculaVendaTotal()));
            atualizaTabela();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um item a remover!", "Erro ao tentar excluir produto!", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRemoverProdutoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (cbVendedor.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione um vendedor!", "Erro ao finalizar a venda!", JOptionPane.ERROR_MESSAGE);
            cbVendedor.requestFocusInWindow();
        }else if (txtIdCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um cliente!", "Erro ao finalizar a venda!", JOptionPane.ERROR_MESSAGE);
            btnPesquisarCliente.requestFocusInWindow();
        }else if (calculaVendaTotal() <= 0){
            JOptionPane.showMessageDialog(null, "Venda negativa ou nula, não é possível finalizar a venda!", "Erro ao finalizar a venda!", JOptionPane.ERROR_MESSAGE);
        }else{
        
            Venda venda = new Venda();

            Funcionario vendedor = (Funcionario) cbVendedor.getModel().getSelectedItem();
            Cliente cliente = new Cliente();
            cliente.setId_cliente(Integer.parseInt(txtIdCliente.getText()));

            venda.setVendedor(vendedor);
            venda.setCliente(cliente);
            venda.setVenda_total(calculaVendaTotal());
            float desconto = (txtDesconto.getText().isEmpty() ? 0 : Float.parseFloat(txtDesconto.getText()));
            venda.setDesconto(desconto);
            venda.setData_venda(new Date());
            venda.setItensVenda(itensVenda);
            
            //TODO CADASTRAR
            VendaDAO vendaDAO = new VendaDAO();
            
            try {
                vendaDAO.inserir(venda);
                JOptionPane.showMessageDialog(null, "Venda finalizada com sucesso!", "Venda finalizada com sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não foi possível finalizar a venda!", "Erro ao finalizar a venda!", JOptionPane.ERROR_MESSAGE);
            }
            
            //Limpa os campos
            cbVendedor.setSelectedItem(null);
            txtIdCliente.setText(null);
            txtNomeCliente.setText(null);
            txtIdProduto.setText(null);
            txtNomeProduto.setText(null);
            
            txtQuantidadeProduto.setText(null);
            txtPrecoUnidade.setText(null);
            txtPrecoTotal.setText(null);
            
            txtDesconto.setText(null);
            txtVendaTotal.setText(null);
            
            itensVenda.clear();
            atualizaTabela();
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontoFocusLost
        if (!txtDesconto.getText().isEmpty()){
            if (calculaVendaTotal() <= 0){
                JOptionPane.showMessageDialog(null, "Venda total nula, não é possível dar desconto!", "Erro ao tentar dar desconto!", JOptionPane.ERROR_MESSAGE);
                txtDesconto.setText(null);
                btnPesquisarProduto.requestFocusInWindow();
            }else {
                
                try{
                    Float.parseFloat(txtDesconto.getText());
                    
                    if (Float.parseFloat(txtDesconto.getText()) < 0){
                        JOptionPane.showMessageDialog(null, "Desconto não pode ser negativo!", "Erro ao tentar dar desconto!", JOptionPane.ERROR_MESSAGE);
                        txtDesconto.setText(null);
                        txtVendaTotal.setText(Float.toString(calculaVendaTotal()));
                        btnPesquisarProduto.requestFocusInWindow();
                    }else if (Float.parseFloat(txtDesconto.getText()) >= calculaVendaTotal()){
                        JOptionPane.showMessageDialog(null, "Desconto não pode ser maior ou igual ao total da venda!", "Erro ao tentar dar desconto!", JOptionPane.ERROR_MESSAGE);
                        txtDesconto.setText(null);
                        txtVendaTotal.setText(Float.toString(calculaVendaTotal()));
                        btnPesquisarProduto.requestFocusInWindow();
                    }else {
                        txtVendaTotal.setText(Float.toString(calculaVendaTotal() - Float.parseFloat(txtDesconto.getText())));
                    }
                    
                } catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Desconto inválido!", "Erro ao tentar dar desconto!", JOptionPane.ERROR_MESSAGE);
                    txtDesconto.setText(null);
                    txtVendaTotal.setText(Float.toString(calculaVendaTotal()));
                    btnPesquisarProduto.requestFocusInWindow();
                }
                
            }
        }else{
           txtVendaTotal.setText(Float.toString(calculaVendaTotal())); 
        }
    }//GEN-LAST:event_txtDescontoFocusLost
    
    private float calculaVendaTotal(){
        float total = 0;
        
        for (ItemVenda itemVenda : itensVenda) {
            total += itemVenda.getTotalVenda();
        }
        
        return total;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnRemoverProduto;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JTable tbItensVenda;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPrecoTotal;
    private javax.swing.JTextField txtPrecoUnidade;
    private javax.swing.JTextField txtQuantidadeProduto;
    private javax.swing.JTextField txtVendaTotal;
    // End of variables declaration//GEN-END:variables
}