package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import comboModel.EstadoCellRenderer;
import comboModel.EstadoComboModel;
import controller.Funcoes;
import dao.EstadoDAO;
import dao.FornecedorDAO;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Estado;
import model.Fornecedor;

/**
 *
 * @author Uemerson
 */
public class frmFornecedor extends javax.swing.JInternalFrame {
    
    Fornecedor fornecedor;
    List<Fornecedor> listaFornecedor;
    FornecedorDAO fornecedorDAO;
    Document doc;
   
    public frmFornecedor() {
       fornecedorDAO = new FornecedorDAO();
        listaFornecedor = new ArrayList<>();
        
        
        initComponents();
        // Hack para remover icone do nimbus
        Container pane = ((BasicInternalFrameUI) this.getUI()).getNorthPane();
        pane.getComponent(0).setVisible(false);
        
        try {
            //Carrrega lista de estados na caixa de seleção
            EstadoDAO estadoDAO = new EstadoDAO();
            EstadoComboModel estadoComboModel = new EstadoComboModel(estadoDAO.listaEstado());
            cbEstado.setModel(estadoComboModel);
            cbEstado.setRenderer(new EstadoCellRenderer());
            cbEstado.setSelectedItem(null);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        txtNomeCompleto = new controller.TextFieldIconPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnlEndereco = new javax.swing.JPanel();
        txtCep = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEndereco = new controller.TextFieldIconPlaceHolder();
        txtCidade = new controller.TextFieldIconPlaceHolder();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new controller.TextFieldIconPlaceHolder();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        txtComplemento = new controller.TextFieldIconPlaceHolder();
        jLabel11 = new javax.swing.JLabel();
        txtBairro = new controller.TextFieldIconPlaceHolder();
        jLabel12 = new javax.swing.JLabel();
        pnlContato = new javax.swing.JPanel();
        txtEmail = new controller.TextFieldIconPlaceHolder();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField("");
        txtCelular = new javax.swing.JFormattedTextField("");
        jLabel19 = new javax.swing.JLabel();
        btnRelatorio = new javax.swing.JButton();

        jLabel23.setText("Campos com * devem ser preenchidos obrigatóriamente");

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Fornecedor");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar (F6)");
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deal 64x64.png"))); // NOI18N

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

        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        txtNomeCompleto.setUpper(true);
        txtNomeCompleto.setMaxLength(50);
        txtNomeCompleto.setEnabled(false);

        jLabel3.setText("Nome Completo*");

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setEnabled(false);
        txtCnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCnpjFocusLost(evt);
            }
        });
        txtCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnpjActionPerformed(evt);
            }
        });

        jLabel4.setText("CNPJ*");

        jLabel24.setText("Campos com * devem ser preenchidos obrigatóriamente");

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
                    .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );

        tbpCadastro.addTab("Dados", pnlDados);

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setEnabled(false);

        jLabel6.setText("CEP*");

        jLabel7.setText("Endereço*");

        txtEndereco.setUpper(true);
        txtEndereco.setMaxLength(50);
        txtEndereco.setEnabled(false);

        txtCidade.setUpper(true);
        txtCidade.setMaxLength(255);
        txtCidade.setEnabled(false);

        jLabel8.setText("Cidade*");

        txtNumero.setUpper(true);
        txtNumero.setMaxLength(5);
        txtNumero.setEnabled(false);

        jLabel9.setText("Numero");

        jLabel10.setText("Estado*");

        cbEstado.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N

        txtComplemento.setUpper(true);
        txtComplemento.setMaxLength(50);
        txtComplemento.setEnabled(false);

        jLabel11.setText("Complemento");

        txtBairro.setUpper(true);
        txtBairro.setMaxLength(50);
        txtBairro.setEnabled(false);
        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBairroKeyPressed(evt);
            }
        });
        txtBairro.setFocusTraversalKeysEnabled(false);

        jLabel12.setText("Bairro");

        javax.swing.GroupLayout pnlEnderecoLayout = new javax.swing.GroupLayout(pnlEndereco);
        pnlEndereco.setLayout(pnlEnderecoLayout);
        pnlEnderecoLayout.setHorizontalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEnderecoLayout.setVerticalGroup(
            pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        tbpCadastro.addTab("Endereço", pnlEndereco);

        txtBairro.setUpper(true);
        txtBairro.setMaxLength(50);
        txtEmail.setEnabled(false);

        jLabel13.setText("Email*");

        jLabel18.setText("Telefone");

        try {
            javax.swing.text.MaskFormatter mascaraTelefone = new javax.swing.text.MaskFormatter("(**)####-####");
            mascaraTelefone.setValidCharacters("0123456789 ");
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraTelefone));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setText(null);
        txtTelefone.setEnabled(false);
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        try {
            javax.swing.text.MaskFormatter mascaraCelular = new javax.swing.text.MaskFormatter("(**)*####-####");
            mascaraCelular.setValidCharacters("0123456789 ");
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraCelular));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setText(null);
        txtCelular.setEnabled(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
        });

        jLabel19.setText("Celular*");

        javax.swing.GroupLayout pnlContatoLayout = new javax.swing.GroupLayout(pnlContato);
        pnlContato.setLayout(pnlContatoLayout);
        pnlContatoLayout.setHorizontalGroup(
            pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        pnlContatoLayout.setVerticalGroup(
            pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContatoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContatoLayout.createSequentialGroup()
                        .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        tbpCadastro.addTab("Contato", pnlContato);

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btnRelatorio.setText("Relatório (F7)");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbpCadastro)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblImagemFormulario)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRelatorio)
                                .addGap(18, 18, 18)
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
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblImagemFormulario))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPesquisar)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(tbpCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cadastro do cliente?", 
                    "Sistema - Cadastro de cliente", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

            try {
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId_fornecedor(Integer.parseInt(txtId.getText()));
                fornecedorDAO.excluir(fornecedor);
                
                Funcoes.desativaCampos(pnlDados);
                Funcoes.desativaCampos(pnlEndereco);
                Funcoes.desativaCampos(pnlContato);
                

                Funcoes.limpaCampos(pnlDados);
                Funcoes.limpaCampos(pnlEndereco);
                Funcoes.limpaCampos(pnlContato);
               

                txtId.setText(null);
                txtId.setEnabled(false);

                btnNovo.setEnabled(true);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnPesquisar.setEnabled(true);
                
                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!", "Sistema - Cadastro de fornecedor", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);

                if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do fornecedor.\nExistem dados vinculados com esse cadastro!", 
                                            "Sistema - Cadastro de fornecedor", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do fornecedor, entre em contato com o desenvolvedor!", 
                                                "Sistema - Cadastro de fornecedor", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Funcoes.ativaCampos(pnlDados);
        Funcoes.ativaCampos(pnlEndereco);
        Funcoes.ativaCampos(pnlContato);
        
        
        Funcoes.limpaCampos(pnlDados);
        Funcoes.limpaCampos(pnlEndereco);
        Funcoes.limpaCampos(pnlContato);
        
        
        txtId.setText("NOVO");
        txtId.setEnabled(false);
        
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
        
        tbpCadastro.setSelectedComponent(pnlDados);
        txtNomeCompleto.requestFocusInWindow();
    }//GEN-LAST:event_btnNovoActionPerformed
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         //Verifica os campos obrigatórios
        if (txtNomeCompleto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Nome Completo deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtNomeCompleto.requestFocusInWindow();
        }else if (txtCnpj.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo CPF deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtCnpj.requestFocusInWindow();
        }else if (txtCep.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo CEP deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtCep.requestFocusInWindow();
        }else if (txtCidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Cidade deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtCidade.requestFocusInWindow();
        }else if (cbEstado.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "O campo Estado deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            cbEstado.requestFocusInWindow();
        }else if (txtEndereco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Endereço deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtEndereco.requestFocusInWindow();
        }
        
        else if (txtCelular.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo Celular deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlContato);
            txtCelular.requestFocusInWindow();
        }
        
        
        
        //Verifica se o email é valido
        else if (!txtEmail.getText().isEmpty() && !Funcoes.isEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Entre com um Email válido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlContato);
            txtEmail.requestFocusInWindow();
        }
        
        //Todos os campos necessários preenchidos
        else{
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setRazaoSocial(txtNomeCompleto.getText());
            fornecedor.setCnpj(txtCnpj.getValue().toString().replace(".", "").replace("-", ""));
            
            fornecedor.setCep(txtCep.getValue().toString().replace("-", ""));
            fornecedor.setCidade(txtCidade.getText());

            Estado estado = new Estado();
            estado = (Estado) cbEstado.getSelectedItem();
            
            fornecedor.setEstado(estado);
            fornecedor.setEndereco(txtEndereco.getText());
            fornecedor.setNumero((txtNumero.getText().isEmpty()) ? null : txtNumero.getText());
            fornecedor.setComplemento((txtComplemento.getText().isEmpty()) ? null : txtComplemento.getText());
            fornecedor.setBairro((txtBairro.getText().isEmpty()) ? null : txtBairro.getText());
            fornecedor.setEmail((txtEmail.getText().isEmpty()) ? null : txtEmail.getText());
            fornecedor.setTelefone((txtTelefone.getValue() != null) ? 
                                    txtTelefone.getValue().toString().replace("(", "").replace(")", "").replace("-", "") : null);
            fornecedor.setCelular((txtCelular.getValue() != null) ? 
                                    txtCelular.getValue().toString().replace("(", "").replace(")", "").replace("-", "") : null);
            
            
            
            
            if (txtId.getText().equals("NOVO")){ //Inserindo um novo funcionário
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                try {
                    fornecedorDAO.inserir(fornecedor);
                    
                    Funcoes.desativaCampos(pnlDados);
                    Funcoes.desativaCampos(pnlEndereco);
                    Funcoes.desativaCampos(pnlContato);
                    
                    Funcoes.limpaCampos(pnlDados);
                    Funcoes.limpaCampos(pnlEndereco);
                    Funcoes.limpaCampos(pnlContato);
                    
                    txtId.setText(null);
                    txtId.setEnabled(false);

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    btnPesquisar.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de cliente salvo com sucesso!", "Sistema - Cadstro de cliente", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar cliente", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
                }
            }else { //Atualizando os dados do funcionário
                fornecedor.setId_fornecedor(Integer.parseInt(txtId.getText()));
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                try {
                    fornecedorDAO.alterar(fornecedor);
                    
                    Funcoes.desativaCampos(pnlDados);
                    Funcoes.desativaCampos(pnlEndereco);
                    Funcoes.desativaCampos(pnlContato);
                    

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(true);
                    btnExcluir.setEnabled(true);
                    btnPesquisar.setEnabled(true);
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de fornecedor alterado com sucesso!", "Sistema - Cadstro de fornecedor", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar alterar fornecedor", "Sistema - Cadastro de fornecedor", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Funcoes.ativaCampos(pnlDados);
        Funcoes.ativaCampos(pnlEndereco);
        Funcoes.ativaCampos(pnlContato);
        
        
        txtId.setEnabled(false);
        
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Funcoes.desativaCampos(pnlDados);
        Funcoes.desativaCampos(pnlEndereco);
        Funcoes.desativaCampos(pnlContato);
        
        
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(true);
        
        if (txtId.getText().equals("NOVO")){
            Funcoes.limpaCampos(pnlDados);
            Funcoes.limpaCampos(pnlEndereco);
            Funcoes.limpaCampos(pnlContato);
            

            txtId.setText(null);
            txtId.setEnabled(false);
        }else{
            
            //Retorna os dados que estão cadastrados no banco
            try {
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId_fornecedor(Integer.parseInt(txtId.getText()));
                fornecedorDAO.excluir(fornecedor);
                
                txtNomeCompleto.setText(fornecedor.getRazaoSocial());
                
                javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                
                txtCnpj.setValue(mask.valueToString(fornecedor.getCnpj()));
            
                mask.setMask("#####-###");
                txtCep.setValue(mask.valueToString(fornecedor.getCep()));
                txtCidade.setText(fornecedor.getCidade());
                cbEstado.getModel().setSelectedItem(fornecedor.getEstado());
                txtEndereco.setText(fornecedor.getEndereco());
                txtNumero.setText(fornecedor.getNumero());
                txtComplemento.setText(fornecedor.getComplemento());
                txtBairro.setText(fornecedor.getBairro());
                txtEmail.setText(fornecedor.getEmail());
                
                mask.setMask("(**)####-####");
                mask.setValidCharacters("0123456789 ");
                txtTelefone.setValue((fornecedor.getTelefone() != null) ? mask.valueToString(fornecedor.getTelefone()) : null);
                
                mask.setMask("(**)*####-####");
                mask.setValidCharacters("0123456789 ");
                txtCelular.setValue((fornecedor.getCelular() != null) ? mask.valueToString(fornecedor.getCelular()) : null);
                
                
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Funcoes.desativaCampos(pnlDados);
        Funcoes.desativaCampos(pnlEndereco);
        Funcoes.desativaCampos(pnlContato);
        

        Funcoes.limpaCampos(pnlDados);
        Funcoes.limpaCampos(pnlEndereco);
        Funcoes.limpaCampos(pnlContato);
        

        txtId.setText(null);
        txtId.setEnabled(false);

        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(true);
        
        frmPesquisaFornecedor pesquisarFornecedor = new frmPesquisaFornecedor(null, true);
        pesquisarFornecedor.setVisible(true);
        
        Fornecedor fornecedorSelecionado = pesquisarFornecedor.getFornecedorSelecionado();
        
        if (fornecedorSelecionado != null){
            txtId.setText(Integer.toString(fornecedorSelecionado.getId_fornecedor()));
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            
            try {
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                Fornecedor fornecedor = fornecedorDAO.buscar(fornecedorSelecionado);
                
                txtNomeCompleto.setText(fornecedor.getRazaoSocial());
                
                javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                
                txtCnpj.setValue(mask.valueToString(fornecedor.getCnpj()));
                
                mask.setMask("#####-###");
                txtCep.setValue(mask.valueToString(fornecedor.getCep()));
                txtCidade.setText(fornecedor.getCidade());
                cbEstado.getModel().setSelectedItem(fornecedor.getEstado());
                txtEndereco.setText(fornecedor.getEndereco());
                txtNumero.setText(fornecedor.getNumero());
                txtComplemento.setText(fornecedor.getComplemento());
                txtBairro.setText(fornecedor.getBairro());
                txtEmail.setText(fornecedor.getEmail());
                
                mask.setMask("(**)####-####");
                mask.setValidCharacters("0123456789 ");
                txtTelefone.setValue((fornecedor.getTelefone() != null) ? mask.valueToString(fornecedor.getTelefone()) : null);
                
                
                
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCnpjActionPerformed

    private void txtCnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCnpjFocusLost
        //Verifica o que preencheu é um CPF
        if (!Funcoes.isCNPJ(txtCnpj.getText().replace(".", "").replace("-", "").replace(" ", "")) 
                && txtCnpj.getText().replace(".", "").replace("-", "").replace(" ", "").length() >= 11){
            txtCnpj.setValue(null);
            tbpCadastro.setSelectedComponent(pnlDados);
            
            //Força o foco
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    txtCnpj.requestFocusInWindow();
                }
            });
            
            JOptionPane.showMessageDialog(null, "CPF inválido, tente novamente!", "Sistema - Cadastro de Cliente", JOptionPane.ERROR_MESSAGE);
       
        }else{
            //Verifica se o CPF está duplicada
            Fornecedor fornecedor = new Fornecedor();
            
            if (!txtId.getText().equals("NOVO") && !txtId.getText().isEmpty())
                fornecedor.setId_fornecedor(Integer.parseInt(txtId.getText()));
            
            fornecedor.setCnpj(txtCnpj.getText().replace(".", "").replace("-", "").replace(" ", ""));
            FornecedorDAO fornecedorDAO = new FornecedorDAO();
            try {
                if (fornecedorDAO.verificaCnpjDuplicado(fornecedor)){
                    JOptionPane.showMessageDialog(null, "Já existe cadastro com esse CNPJ, tente novamente!", "Sistema - Cadastro de Fornecedor", JOptionPane.ERROR_MESSAGE);
                    txtCnpj.setValue(null);
                    txtCnpj.requestFocusInWindow();
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCnpjFocusLost

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost
        if (txtTelefone.getText().replace("-", "").replace("(", "").replace(")", "").trim().length() <= 0)
            txtTelefone.setValue(null);
    }//GEN-LAST:event_txtTelefoneFocusLost

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlContato);
            txtTelefone.requestFocus();
        }
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlContato);
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtBairroKeyPressed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        FileFilter filter = new FileNameExtensionFilter("Arquivos em PDF", ".pdf");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooser.setDialogTitle("Salvar relatório de Fornecedor");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File diretorio = new File(
                                (!fileChooser.getSelectedFile().toString().toLowerCase().endsWith(".pdf")) ? 
                                fileChooser.getSelectedFile().toString() + ".pdf" : fileChooser.getSelectedFile().toString());
            
            gerarDocumento(diretorio.getAbsolutePath().toString());
        }
      
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    public void gerarDocumento(String path) {
        try {
            List<Fornecedor> lista = new ArrayList<>();
            lista = fornecedorDAO.listaFornecedorPesquisar(fornecedor);
            Document doc = new Document(PageSize.A4, 41.5f, 41.5f, 55.2f, 55.2f);
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();

            Font f1 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font f2 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font f3 = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font f4 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font f5 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

            Paragraph titulo1 = new Paragraph("Sistema de Auto Peças", f2);
            titulo1.setAlignment(Element.ALIGN_CENTER);
            titulo1.setSpacingAfter(10);

            Paragraph titulo2 = new Paragraph("Relatório de Fornecedor", f1);
            titulo2.setAlignment(Element.ALIGN_CENTER);
            titulo2.setSpacingAfter(0);

            PdfPTable tabela = new PdfPTable(new float[]{0.40f, 0.40f, 0.40f});
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(100f);

            PdfPCell cabecalho1 = new PdfPCell(new Paragraph("Nome", f3));
            //cabecalho1.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho1.setBorder(0);

            PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Endereço", f3));
            //cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho2.setBorder(0);
            
            PdfPCell cabecalho3 = new PdfPCell(new Paragraph("CNPJ", f3));
            //cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho3.setBorder(0);
            
           

            tabela.addCell(cabecalho1);
            tabela.addCell(cabecalho2);
            tabela.addCell(cabecalho3);
            

            for (Fornecedor  fornecedor : lista) {
                
                Paragraph p1 = new Paragraph(fornecedor.getRazaoSocial(), f5);
                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col1 = new PdfPCell(p1);
                col1.setBorder(0);
                
                Paragraph p2 = new Paragraph(fornecedor.getEndereco(), f5);
                p2.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col2 = new PdfPCell(p2);
                col2.setBorder(0);
               
                
                Paragraph p3 = new Paragraph(fornecedor.getCnpj(), f5);
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
            
            JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso\nSalvo em: " + path, "Sistema - Relatório cadastro de Fornecedor", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(path));
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
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JPanel pnlContato;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlEndereco;
    private javax.swing.JTabbedPane tbpCadastro;
    private controller.TextFieldIconPlaceHolder txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private controller.TextFieldIconPlaceHolder txtCidade;
    private javax.swing.JFormattedTextField txtCnpj;
    private controller.TextFieldIconPlaceHolder txtComplemento;
    private controller.TextFieldIconPlaceHolder txtEmail;
    private controller.TextFieldIconPlaceHolder txtEndereco;
    private controller.TextFieldIconPlaceHolder txtId;
    private controller.TextFieldIconPlaceHolder txtNomeCompleto;
    private controller.TextFieldIconPlaceHolder txtNumero;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
