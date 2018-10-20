package view;

import comboModel.EstadoCellRenderer;
import comboModel.EstadoComboModel;
import controller.Funcoes;
import dao.ClienteDAO;
import dao.EstadoDAO;
import java.awt.Container;
import java.awt.Dimension;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Cliente;
import model.Estado;

/**
 *
 * @author Uemerson
 */
public class frmCliente extends javax.swing.JInternalFrame {
    public frmCliente() {
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
            Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRG = new controller.TextFieldIconPlaceHolder();
        jLabel5 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
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

        jLabel23.setText("Campos com * devem ser preenchidos obrigatóriamente");

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Cliente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar (F6)");
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boss 64x64.png"))); // NOI18N

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

        jLabel2.setText("ID");

        txtNomeCompleto.setUpper(true);
        txtNomeCompleto.setMaxLength(50);
        txtNomeCompleto.setEnabled(false);

        jLabel3.setText("Nome Completo*");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);

        jLabel4.setText("CPF*");

        txtRG.setUpper(true);
        txtRG.setMaxLength(10);
        txtRG.setEnabled(false);

        jLabel5.setText("RG*");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataNascimento.setEnabled(false);

        jLabel20.setText("Data Nascimento*");

        jLabel24.setText("Campos com * devem ser preenchidos obrigatóriamente");

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
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
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
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

        try {
            javax.swing.text.MaskFormatter mascaraCelular = new javax.swing.text.MaskFormatter("(**)*####-####");
            mascaraCelular.setValidCharacters("0123456789 ");
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraCelular));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setText(null);
        txtCelular.setEnabled(false);

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
                ClienteDAO clienteDAO = new ClienteDAO();
               Cliente cliente = new Cliente();
                cliente.setId_cliente(Integer.parseInt(txtId.getText()));
                clienteDAO.excluir(cliente);
                
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
                
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sistema - Cadastro de cliente", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);

                if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do cliente.\nExistem dados vinculados com esse cadastro!", 
                                            "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do cliente, entre em contato com o desenvolvedor!", 
                                                "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
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
        }else if (txtCpf.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo CPF deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtCpf.requestFocusInWindow();
        }else if (txtRG.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo RG deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtRG.requestFocusInWindow();
        }else if (txtDataNascimento.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo Data Nascimento deve ser preenchido!", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtDataNascimento.requestFocusInWindow();
        }
        
        else if (txtCep.getValue() == null){
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
            Cliente cliente = new Cliente();
            
            cliente.setNome_completo(txtNomeCompleto.getText());
            cliente.setCpf(txtCpf.getValue().toString().replace(".", "").replace("-", ""));
            cliente.setRg(txtRG.getText());
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
                dateFormat.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
                cliente.setData_nascimento(dateFormat.parse(txtDataNascimento.getValue().toString()));
            } catch (ParseException ex) {
                Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cliente.setCep(txtCep.getValue().toString().replace("-", ""));
            cliente.setCidade(txtCidade.getText());

            Estado estado = new Estado();
            estado = (Estado) cbEstado.getSelectedItem();
            
            cliente.setEstado(estado);
            cliente.setEndereco(txtEndereco.getText());
            cliente.setNumero((txtNumero.getText().isEmpty()) ? null : txtNumero.getText());
            cliente.setComplemento((txtComplemento.getText().isEmpty()) ? null : txtComplemento.getText());
            cliente.setBairro((txtBairro.getText().isEmpty()) ? null : txtBairro.getText());
            cliente.setEmail((txtEmail.getText().isEmpty()) ? null : txtEmail.getText());
            cliente.setTelefone((txtTelefone.getValue() != null) ? 
                                    txtTelefone.getValue().toString().replace("(", "").replace(")", "").replace("-", "") : null);
            cliente.setCelular((txtCelular.getValue() != null) ? 
                                    txtCelular.getValue().toString().replace("(", "").replace(")", "").replace("-", "") : null);
            
            
            
            
            if (txtId.getText().equals("NOVO")){ //Inserindo um novo funcionário
                ClienteDAO clienteDAO = new ClienteDAO();
                try {
                    clienteDAO.inserir(cliente);
                    
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
                    Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar cliente", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
                }
            }else { //Atualizando os dados do funcionário
                cliente.setId_cliente(Integer.parseInt(txtId.getText()));
                ClienteDAO clienteDAO = new ClienteDAO();
                try {
                    clienteDAO.alterar(cliente);
                    
                    Funcoes.desativaCampos(pnlDados);
                    Funcoes.desativaCampos(pnlEndereco);
                    Funcoes.desativaCampos(pnlContato);
                    

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(true);
                    btnExcluir.setEnabled(true);
                    btnPesquisar.setEnabled(true);
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de cliente alterado com sucesso!", "Sistema - Cadstro de cliente", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar alterar cliente", "Sistema - Cadastro de cliente", JOptionPane.ERROR_MESSAGE);
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
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente clienteId = new Cliente();
                clienteId.setId_cliente(Integer.parseInt(txtId.getText()));
                Cliente cliente = clienteDAO.buscar(clienteId);
                
                txtNomeCompleto.setText(cliente.getNome_completo());
                
                javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                
                txtCpf.setValue(mask.valueToString(cliente.getCpf()));
                txtRG.setText(cliente.getRg());
                txtDataNascimento.setValue(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getData_nascimento()));
                
                mask.setMask("#####-###");
                txtCep.setValue(mask.valueToString(cliente.getCep()));
                txtCidade.setText(cliente.getCidade());
                cbEstado.getModel().setSelectedItem(cliente.getEstado());
                txtEndereco.setText(cliente.getEndereco());
                txtNumero.setText(cliente.getNumero());
                txtComplemento.setText(cliente.getComplemento());
                txtBairro.setText(cliente.getBairro());
                txtEmail.setText(cliente.getEmail());
                
                mask.setMask("(**)####-####");
                mask.setValidCharacters("0123456789 ");
                txtTelefone.setValue((cliente.getTelefone() != null) ? mask.valueToString(cliente.getTelefone()) : null);
                
                mask.setMask("(**)*####-####");
                mask.setValidCharacters("0123456789 ");
                txtCelular.setValue((cliente.getCelular() != null) ? mask.valueToString(cliente.getCelular()) : null);
                
                
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        
        frmPesquisaCliente pesquisarCliente = new frmPesquisaCliente(null, true);
        pesquisarCliente.setVisible(true);
        
        Cliente clienteSelecionado = pesquisarCliente.getClienteSelecionado();
        
        if (clienteSelecionado != null){
            txtId.setText(Integer.toString(clienteSelecionado.getId_cliente()));
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            
            try {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.buscar(clienteSelecionado);
                
                txtNomeCompleto.setText(cliente.getNome_completo());
                
                javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                
                txtCpf.setValue(mask.valueToString(cliente.getCpf()));
                txtRG.setText(cliente.getRg());
                txtDataNascimento.setValue(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getData_nascimento()));
                
                mask.setMask("#####-###");
                txtCep.setValue(mask.valueToString(cliente.getCep()));
                txtCidade.setText(cliente.getCidade());
                cbEstado.getModel().setSelectedItem(cliente.getEstado());
                txtEndereco.setText(cliente.getEndereco());
                txtNumero.setText(cliente.getNumero());
                txtComplemento.setText(cliente.getComplemento());
                txtBairro.setText(cliente.getBairro());
                txtEmail.setText(cliente.getEmail());
                
                mask.setMask("(**)####-####");
                mask.setValidCharacters("0123456789 ");
                txtTelefone.setValue((cliente.getTelefone() != null) ? mask.valueToString(cliente.getTelefone()) : null);
                
                
                
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(frmCliente.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private controller.TextFieldIconPlaceHolder txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private controller.TextFieldIconPlaceHolder txtEmail;
    private controller.TextFieldIconPlaceHolder txtEndereco;
    private controller.TextFieldIconPlaceHolder txtId;
    private controller.TextFieldIconPlaceHolder txtNomeCompleto;
    private controller.TextFieldIconPlaceHolder txtNumero;
    private controller.TextFieldIconPlaceHolder txtRG;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
