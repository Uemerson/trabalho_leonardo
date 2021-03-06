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
import comboModel.CargoCellRenderer;
import comboModel.CargoComboModel;
import comboModel.EstadoCellRenderer;
import comboModel.EstadoComboModel;
import controller.Funcoes;
import dao.CargoDAO;
import dao.EstadoDAO;
import dao.FuncionarioDAO;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Cargo;
import model.Estado;
import model.Funcionario;

/**
 *
 * @author Uemerson
 */
public class frmFuncionario extends javax.swing.JInternalFrame {
    public frmFuncionario() {
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
            
            //Carrega lista de cargos na caixa de seleção
            CargoDAO cargoDAO = new CargoDAO();
            CargoComboModel cargoComboModel = new CargoComboModel(cargoDAO.listaCargo());
            cbCargo.setModel(cargoComboModel);
            cbCargo.setRenderer(new CargoCellRenderer());
            cbCargo.setSelectedItem(null);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        jLabel2 = new javax.swing.JLabel();
        txtNomeCompleto = new controller.TextFieldIconPlaceHolder();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtRG = new controller.TextFieldIconPlaceHolder();
        jLabel5 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txtId = new controller.TextFieldIconPlaceHolder();
        jLabel23 = new javax.swing.JLabel();
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
        pnlEmpresa = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtSalario = new controller.TextFieldIconPlaceHolder();
        jLabel16 = new javax.swing.JLabel();
        txtDataAdmissao = new javax.swing.JFormattedTextField();
        txtDataDemissao = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        pnlSistema = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtLogin = new controller.TextFieldIconPlaceHolder();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new controller.PasswordFieldIconPlaceHolder();
        btnRelatorio = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Funcionário");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar 24x24.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boss 64x64.png"))); // NOI18N

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adicionar 24x24.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lixo 24x24.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar 24x24.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvar 24x24.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar 24x24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });

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
        txtDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataNascimentoFocusLost(evt);
            }
        });
        txtDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataNascimentoKeyPressed(evt);
            }
        });
        txtDataNascimento.setFocusTraversalKeysEnabled(false);

        jLabel20.setText("Data Nascimento*");

        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setEnabled(false);

        jLabel23.setText("Campos com * devem ser preenchidos obrigatóriamente");

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
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
                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jLabel23)
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
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
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
                .addContainerGap(34, Short.MAX_VALUE))
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
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
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
                .addContainerGap(79, Short.MAX_VALUE))
        );

        tbpCadastro.addTab("Endereço", pnlEndereco);

        txtEmail.setUpper(true);
        txtEmail.setMaxLength(50);
        txtEmail.setEnabled(false);

        jLabel13.setText("Email");

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
        txtCelular.setFocusTraversalKeysEnabled(false);

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
                .addContainerGap(181, Short.MAX_VALUE))
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

        jLabel14.setText("Cargo*");

        cbCargo.setEnabled(false);

        jLabel15.setText("Salário*");

        txtSalario.setUpper(true);
        txtSalario.setMaxLength(14); //999.999.999,99
        txtSalario.setEnabled(false);
        txtSalario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalarioFocusLost(evt);
            }
        });

        jLabel16.setText("Data Admissão*");

        try {
            txtDataAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataAdmissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataAdmissao.setEnabled(false);
        txtDataAdmissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataAdmissaoFocusLost(evt);
            }
        });

        try {
            txtDataDemissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataDemissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataDemissao.setEnabled(false);
        txtDataDemissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataDemissaoFocusLost(evt);
            }
        });
        txtDataDemissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataDemissaoKeyPressed(evt);
            }
        });
        txtDataDemissao.setFocusTraversalKeysEnabled(false);

        jLabel17.setText("Data Demissão");

        javax.swing.GroupLayout pnlEmpresaLayout = new javax.swing.GroupLayout(pnlEmpresa);
        pnlEmpresa.setLayout(pnlEmpresaLayout);
        pnlEmpresaLayout.setHorizontalGroup(
            pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDataAdmissao, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(pnlEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEmpresaLayout.setVerticalGroup(
            pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        tbpCadastro.addTab("Empresa", pnlEmpresa);

        jLabel21.setText("Login");

        txtLogin.setUpper(true);
        txtLogin.setMaxLength(50);
        txtLogin.setEnabled(false);

        lblSenha.setText("Senha");

        txtSenha.setEnabled(false);
        txtSenha.setMaxLength(50);

        txtSenha.setFocusTraversalKeysEnabled(false);
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlSistemaLayout = new javax.swing.GroupLayout(pnlSistema);
        pnlSistema.setLayout(pnlSistemaLayout);
        pnlSistemaLayout.setHorizontalGroup(
            pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21)
                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        pnlSistemaLayout.setVerticalGroup(
            pnlSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        tbpCadastro.addTab("Sistema", pnlSistema);

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btnRelatorio.setText("Relatório");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagemFormulario)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelatorio)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tbpCadastro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnRelatorio)))
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Funcoes.ativaCampos(pnlDados);
        Funcoes.ativaCampos(pnlEndereco);
        Funcoes.ativaCampos(pnlContato);
        Funcoes.ativaCampos(pnlEmpresa);
        Funcoes.ativaCampos(pnlSistema);
        
        Funcoes.limpaCampos(pnlDados);
        Funcoes.limpaCampos(pnlEndereco);
        Funcoes.limpaCampos(pnlContato);
        Funcoes.limpaCampos(pnlEmpresa);
        Funcoes.limpaCampos(pnlSistema);
        
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

    private void txtDataNascimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataNascimentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtCep.requestFocus();
        }
    }//GEN-LAST:event_txtDataNascimentoKeyPressed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlContato);
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtBairroKeyPressed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlEmpresa);
            cbCargo.requestFocus();
        }
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtDataDemissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataDemissaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlSistema);
            txtLogin.requestFocus();
        }
    }//GEN-LAST:event_txtDataDemissaoKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB){
            tbpCadastro.setSelectedComponent(pnlDados);
            txtNomeCompleto.requestFocus();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Funcoes.desativaCampos(pnlDados);
        Funcoes.desativaCampos(pnlEndereco);
        Funcoes.desativaCampos(pnlContato);
        Funcoes.desativaCampos(pnlEmpresa);
        Funcoes.desativaCampos(pnlSistema);
        
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
            Funcoes.limpaCampos(pnlEmpresa);
            Funcoes.limpaCampos(pnlSistema);

            txtId.setText(null);
            txtId.setEnabled(false);
        }else{
            
            //Retorna os dados que estão cadastrados no banco
            try {
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionarioId = new Funcionario();
                funcionarioId.setId_funcionario(Integer.parseInt(txtId.getText()));
                Funcionario funcionario = funcionarioDAO.buscar(funcionarioId);
                
                txtNomeCompleto.setText(funcionario.getNome_completo());
                
                javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                
                txtCpf.setValue(mask.valueToString(funcionario.getCpf()));
                txtRG.setText(funcionario.getRg());
                txtDataNascimento.setValue(new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getData_nascimento()));
                
                mask.setMask("#####-###");
                txtCep.setValue(mask.valueToString(funcionario.getCep()));
                txtCidade.setText(funcionario.getCidade());
                cbEstado.getModel().setSelectedItem(funcionario.getEstado());
                txtEndereco.setText(funcionario.getEndereco());
                txtNumero.setText(funcionario.getNumero());
                txtComplemento.setText(funcionario.getComplemento());
                txtBairro.setText(funcionario.getBairro());
                txtEmail.setText(funcionario.getEmail());
                
                mask.setMask("(**)####-####");
                mask.setValidCharacters("0123456789 ");
                txtTelefone.setValue((funcionario.getTelefone() != null) ? mask.valueToString(funcionario.getTelefone()) : null);
                
                mask.setMask("(**)*####-####");
                mask.setValidCharacters("0123456789 ");
                txtCelular.setValue((funcionario.getCelular() != null) ? mask.valueToString(funcionario.getCelular()) : null);
                cbCargo.getModel().setSelectedItem(funcionario.getCargo());
                txtSalario.setText(Float.toString(funcionario.getSalario()));
                
                txtDataAdmissao.setValue(new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getData_contratado()));
                txtDataDemissao.setValue((funcionario.getData_demissao() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getData_demissao()) : null);
                txtLogin.setText(funcionario.getLogin());
                txtSenha.setText(null);
                
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //Verifica os campos obrigatórios
        if (txtNomeCompleto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Nome Completo deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtNomeCompleto.requestFocusInWindow();
        }else if (txtCpf.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo CPF deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtCpf.requestFocusInWindow();
        }else if (txtRG.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo RG deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtRG.requestFocusInWindow();
        }else if (txtDataNascimento.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo Data Nascimento deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlDados);
            txtDataNascimento.requestFocusInWindow();
        }
        
        else if (txtCep.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo CEP deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtCep.requestFocusInWindow();
        }else if (txtCidade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Cidade deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtCidade.requestFocusInWindow();
        }else if (cbEstado.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "O campo Estado deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            cbEstado.requestFocusInWindow();
        }else if (txtEndereco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Endereço deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEndereco);
            txtEndereco.requestFocusInWindow();
        }
        
        else if (txtCelular.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo Celular deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlContato);
            txtCelular.requestFocusInWindow();
        }
        
        else if (cbCargo.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "O campo Cargo deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEmpresa);
            cbCargo.requestFocusInWindow();
        }else if (txtSalario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo Salário deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEmpresa);
            txtSalario.requestFocusInWindow();
        }else if (txtDataAdmissao.getValue() == null){
            JOptionPane.showMessageDialog(null, "O campo Data Admissão deve ser preenchido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlEmpresa);
            txtDataAdmissao.requestFocusInWindow();
        }
        
        //Verifica se o email é valido
        else if (!txtEmail.getText().isEmpty() && !Funcoes.isEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Entre com um Email válido!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            tbpCadastro.setSelectedComponent(pnlContato);
            txtEmail.requestFocusInWindow();
        }
        
        //Todos os campos necessários preenchidos
        else{
            Funcionario funcionario = new Funcionario();
            
            funcionario.setNome_completo(txtNomeCompleto.getText());
            funcionario.setCpf(txtCpf.getValue().toString().replace(".", "").replace("-", ""));
            funcionario.setRg(txtRG.getText());
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
                dateFormat.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
                funcionario.setData_nascimento(dateFormat.parse(txtDataNascimento.getValue().toString()));
            } catch (ParseException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            funcionario.setCep(txtCep.getValue().toString().replace("-", ""));
            funcionario.setCidade(txtCidade.getText());

            Estado estado = new Estado();
            estado = (Estado) cbEstado.getSelectedItem();
            
            funcionario.setEstado(estado);
            funcionario.setEndereco(txtEndereco.getText());
            funcionario.setNumero((txtNumero.getText().isEmpty()) ? null : txtNumero.getText());
            funcionario.setComplemento((txtComplemento.getText().isEmpty()) ? null : txtComplemento.getText());
            funcionario.setBairro((txtBairro.getText().isEmpty()) ? null : txtBairro.getText());
            funcionario.setEmail((txtEmail.getText().isEmpty()) ? null : txtEmail.getText());
            funcionario.setTelefone((txtTelefone.getValue() != null) ? 
                                    txtTelefone.getValue().toString().replace("(", "").replace(")", "").replace("-", "") : null);
            funcionario.setCelular((txtCelular.getValue() != null) ? 
                                    txtCelular.getValue().toString().replace("(", "").replace(")", "").replace("-", "") : null);
            
            Cargo cargo = new Cargo();
            cargo = (Cargo) cbCargo.getSelectedItem();
            
            funcionario.setCargo(cargo);
            funcionario.setSalario(Float.parseFloat(txtSalario.getText()));
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
                dateFormat.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
                funcionario.setData_contratado(dateFormat.parse(txtDataAdmissao.getValue().toString()));
            } catch (ParseException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
                dateFormat.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
                funcionario.setData_demissao((txtDataDemissao.getValue() != null) ? dateFormat.parse(txtDataDemissao.getValue().toString()) : null);
            } catch (ParseException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            funcionario.setLogin((txtLogin.getText().isEmpty()) ? null : txtLogin.getText());
            funcionario.setSenha((String.valueOf(txtSenha.getPassword()).isEmpty()) ? null : String.valueOf(txtSenha.getPassword()));
            
            if (txtId.getText().equals("NOVO")){ //Inserindo um novo funcionário
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                try {
                    funcionarioDAO.inserir(funcionario);
                    
                    Funcoes.desativaCampos(pnlDados);
                    Funcoes.desativaCampos(pnlEndereco);
                    Funcoes.desativaCampos(pnlContato);
                    Funcoes.desativaCampos(pnlEmpresa);
                    Funcoes.desativaCampos(pnlSistema);

                    Funcoes.limpaCampos(pnlDados);
                    Funcoes.limpaCampos(pnlEndereco);
                    Funcoes.limpaCampos(pnlContato);
                    Funcoes.limpaCampos(pnlEmpresa);
                    Funcoes.limpaCampos(pnlSistema);

                    txtId.setText(null);
                    txtId.setEnabled(false);

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(false);
                    btnExcluir.setEnabled(false);
                    btnPesquisar.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de funcionário salvo com sucesso!", "Sistema - Cadstro de funcionário", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar funcionário", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
                }
            }else { //Atualizando os dados do funcionário
                funcionario.setId_funcionario(Integer.parseInt(txtId.getText()));
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                try {
                    funcionarioDAO.alterar(funcionario);
                    
                    Funcoes.desativaCampos(pnlDados);
                    Funcoes.desativaCampos(pnlEndereco);
                    Funcoes.desativaCampos(pnlContato);
                    Funcoes.desativaCampos(pnlEmpresa);
                    Funcoes.desativaCampos(pnlSistema);

                    btnNovo.setEnabled(true);
                    btnSalvar.setEnabled(false);
                    btnCancelar.setEnabled(false);
                    btnEditar.setEnabled(true);
                    btnExcluir.setEnabled(true);
                    btnPesquisar.setEnabled(true);
                    
                    txtSenha.setText(null);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro de funcionário alterado com sucesso!", "Sistema - Cadstro de funcionário", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (UnsupportedEncodingException | NoSuchAlgorithmException | SQLException ex) {
                    Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao tentar alterar funcionário", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        //Verifica o que preencheu é um CPF
        if (!Funcoes.isCPF(txtCpf.getText().replace(".", "").replace("-", "").replace(" ", "")) 
                && txtCpf.getText().replace(".", "").replace("-", "").replace(" ", "").length() >= 11){
            txtCpf.setValue(null);
            tbpCadastro.setSelectedComponent(pnlDados);
            
            //Força o foco
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    txtCpf.requestFocusInWindow();
                }
            });
            
            JOptionPane.showMessageDialog(null, "CPF inválido, tente novamente!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
       
        }else{
            //Verifica se o CPF está duplicada
            Funcionario funcionario = new Funcionario();
            
            if (!txtId.getText().equals("NOVO") && !txtId.getText().isEmpty())
                funcionario.setId_funcionario(Integer.parseInt(txtId.getText()));
            
            funcionario.setCpf(txtCpf.getText().replace(".", "").replace("-", "").replace(" ", ""));
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            try {
                if (funcionarioDAO.verificaCpfDuplicado(funcionario)){
                    JOptionPane.showMessageDialog(null, "Já existe cadastro com esse CPF, tente novamente!", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
                    txtCpf.setValue(null);
                    txtCpf.requestFocusInWindow();
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtCpfFocusLost

    private void txtDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataNascimentoFocusLost
        
        if (txtDataNascimento.getText().replace("/", "").trim().length() >= 8){
            DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
            df.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
            try {
                df.parse (txtDataNascimento.getText());
            } catch (ParseException ex) {
               JOptionPane.showMessageDialog(null, "Data de Nascimento inválida", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
               txtDataNascimento.setValue(null);
               tbpCadastro.setSelectedComponent(pnlDados);
               txtDataNascimento.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtDataNascimentoFocusLost

    private void txtDataAdmissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataAdmissaoFocusLost
        if (txtDataAdmissao.getText().replace("/", "").trim().length() >= 8){
            DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
            df.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
            try {
                df.parse (txtDataAdmissao.getText());
            } catch (ParseException ex) {
               JOptionPane.showMessageDialog(null, "Data de Admissão inválida", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
               txtDataAdmissao.setValue(null);
               tbpCadastro.setSelectedComponent(pnlEmpresa);
               txtDataAdmissao.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtDataAdmissaoFocusLost

    private void txtDataDemissaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataDemissaoFocusLost
        if (txtDataDemissao.getText().replace("/", "").trim().length() <= 0){
            txtDataDemissao.setValue(null);
        }else if (txtDataDemissao.getText().replace("/", "").trim().length() >= 8){
            DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
            df.setLenient (false); // Não permite transformar essa data caso a pessoa entre com uma data errada
            try {
                df.parse (txtDataDemissao.getText());
            } catch (ParseException ex) {
               JOptionPane.showMessageDialog(null, "Data de Demissão inválida", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
               txtDataDemissao.setValue(null);
               tbpCadastro.setSelectedComponent(pnlEmpresa);
               txtDataDemissao.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_txtDataDemissaoFocusLost

    private void txtSalarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalarioFocusLost
        if (!txtSalario.getText().isEmpty()){
            try{
                Float.parseFloat(txtSalario.getText());
            }catch(NumberFormatException ex){
                txtSalario.setText(null);
                txtSalario.requestFocusInWindow();                
                JOptionPane.showMessageDialog(null, "Salário invalido", "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtSalarioFocusLost

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Funcoes.desativaCampos(pnlDados);
        Funcoes.desativaCampos(pnlEndereco);
        Funcoes.desativaCampos(pnlContato);
        Funcoes.desativaCampos(pnlEmpresa);
        Funcoes.desativaCampos(pnlSistema);

        Funcoes.limpaCampos(pnlDados);
        Funcoes.limpaCampos(pnlEndereco);
        Funcoes.limpaCampos(pnlContato);
        Funcoes.limpaCampos(pnlEmpresa);
        Funcoes.limpaCampos(pnlSistema);

        txtId.setText(null);
        txtId.setEnabled(false);

        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(true);
        
        frmPesquisaFuncionario pesquisarFuncionario = new frmPesquisaFuncionario(null, true);
        pesquisarFuncionario.setVisible(true);
        
        Funcionario funcionarioSelecionado = pesquisarFuncionario.getFuncionarioSelecionado();
        
        if (funcionarioSelecionado != null){
            txtId.setText(Integer.toString(funcionarioSelecionado.getId_funcionario()));
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            
            try {
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionario = funcionarioDAO.buscar(funcionarioSelecionado);
                
                txtNomeCompleto.setText(funcionario.getNome_completo());
                
                javax.swing.text.MaskFormatter mask = new javax.swing.text.MaskFormatter("###.###.###-##");
                mask.setValueContainsLiteralCharacters(false);
                
                txtCpf.setValue(mask.valueToString(funcionario.getCpf()));
                txtRG.setText(funcionario.getRg());
                txtDataNascimento.setValue(new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getData_nascimento()));
                
                mask.setMask("#####-###");
                txtCep.setValue(mask.valueToString(funcionario.getCep()));
                txtCidade.setText(funcionario.getCidade());
                cbEstado.getModel().setSelectedItem(funcionario.getEstado());
                txtEndereco.setText(funcionario.getEndereco());
                txtNumero.setText(funcionario.getNumero());
                txtComplemento.setText(funcionario.getComplemento());
                txtBairro.setText(funcionario.getBairro());
                txtEmail.setText(funcionario.getEmail());
                
                mask.setMask("(**)####-####");
                mask.setValidCharacters("0123456789 ");
                txtTelefone.setValue((funcionario.getTelefone() != null) ? mask.valueToString(funcionario.getTelefone()) : null);
                
                mask.setMask("(**)*####-####");
                mask.setValidCharacters("0123456789 ");
                txtCelular.setValue((funcionario.getCelular() != null) ? mask.valueToString(funcionario.getCelular()) : null);
                cbCargo.getModel().setSelectedItem(funcionario.getCargo());
                txtSalario.setText(Float.toString(funcionario.getSalario()));
                
                txtDataAdmissao.setValue(new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getData_contratado()));
                txtDataDemissao.setValue((funcionario.getData_demissao() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(funcionario.getData_demissao()) : null);
                txtLogin.setText(funcionario.getLogin());
                
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o cadastro do funcionário?", 
                    "Sistema - Cadastro de funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

            try {
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(Integer.parseInt(txtId.getText()));
                funcionarioDAO.excluir(funcionario);
                
                Funcoes.desativaCampos(pnlDados);
                Funcoes.desativaCampos(pnlEndereco);
                Funcoes.desativaCampos(pnlContato);
                Funcoes.desativaCampos(pnlEmpresa);
                Funcoes.desativaCampos(pnlSistema);

                Funcoes.limpaCampos(pnlDados);
                Funcoes.limpaCampos(pnlEndereco);
                Funcoes.limpaCampos(pnlContato);
                Funcoes.limpaCampos(pnlEmpresa);
                Funcoes.limpaCampos(pnlSistema);

                txtId.setText(null);
                txtId.setEnabled(false);

                btnNovo.setEnabled(true);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnPesquisar.setEnabled(true);
                
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!", "Sistema - Cadastro de funcionário", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);

                if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do funcionário.\nExistem dados vinculados com esse cadastro!", 
                                            "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Erro - Não foi possível excluir cadastro do funcionário, entre em contato com o desenvolvedor!", 
                                                "Sistema - Cadastro de funcionário", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost
        if (txtTelefone.getText().replace("-", "").replace("(", "").replace(")", "").trim().length() <= 0)
            txtTelefone.setValue(null);
    }//GEN-LAST:event_txtTelefoneFocusLost

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Funcoes.ativaCampos(pnlDados);
        Funcoes.ativaCampos(pnlEndereco);
        Funcoes.ativaCampos(pnlContato);
        Funcoes.ativaCampos(pnlEmpresa);
        Funcoes.ativaCampos(pnlSistema);
        
        txtId.setEnabled(false);
        
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnPesquisar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        FileFilter filter = new FileNameExtensionFilter("Arquivos em PDF", ".pdf");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooser.setDialogTitle("Salvar relatório de funcionário");
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
    
    public void gerarDocumento(String path) {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            ArrayList<Funcionario> lista = new ArrayList<>();
            lista = funcionarioDAO.listaFuncionario();
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

            Paragraph titulo2 = new Paragraph("Relatório de Funcionários", f1);
            titulo2.setAlignment(Element.ALIGN_CENTER);
            titulo2.setSpacingAfter(0);

            PdfPTable tabela = new PdfPTable(new float[]{0.10f, 0.40f, 0.40f, 0.40f});     //Define o tamanho das colunas
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(100f);
            
            PdfPCell cabecalho0 = new PdfPCell(new Paragraph("ID", f3));
            //cabecalho1.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho0.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho0.setBorder(0);
            
            PdfPCell cabecalho1 = new PdfPCell(new Paragraph("Nome", f3));
            //cabecalho1.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho1.setBorder(0);

            PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Endereço", f3));
            //cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho2.setBorder(0);
            
            PdfPCell cabecalho3 = new PdfPCell(new Paragraph("CPF", f3));
            //cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho3.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho3.setBorder(0);
            
            tabela.addCell(cabecalho0);
            tabela.addCell(cabecalho1);
            tabela.addCell(cabecalho2);
            tabela.addCell(cabecalho3);
            
            for (Funcionario funcionario : lista) {
                
                Paragraph p0 = new Paragraph(Integer.toString(funcionario.getId_funcionario()), f5);
                p0.setAlignment(Element.ALIGN_RIGHT);
                PdfPCell col0 = new PdfPCell(p0);
                col0.setBorder(0);
                
                Paragraph p1 = new Paragraph(funcionario.getNome_completo(), f5);
                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col1 = new PdfPCell(p1);
                col1.setBorder(0);
                
                Paragraph p2 = new Paragraph(funcionario.getEndereco(), f5);
                p2.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col2 = new PdfPCell(p2);
                col2.setBorder(0);
               
                Paragraph p3 = new Paragraph(funcionario.getCpf(), f5);
                p3.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col3 = new PdfPCell(p3);
                col3.setBorder(0);
                
                tabela.addCell(col0);
                tabela.addCell(col1);
                tabela.addCell(col2);
                tabela.addCell(col3);          
                
            }
            
            doc.add(titulo2);
            doc.add(titulo1);
            doc.add(tabela);
            doc.close();
            
            JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso\nSalvo em: " + path, "Sistema - Relatório cadastro de funcionário", JOptionPane.INFORMATION_MESSAGE);
            Desktop.getDesktop().open(new File(path));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Documento de Requisitos aberto. Feche para gerar um novo.", "Sistema - Erro ao abrir", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(frmFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox cbCargo;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlContato;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlEmpresa;
    private javax.swing.JPanel pnlEndereco;
    private javax.swing.JPanel pnlSistema;
    private javax.swing.JTabbedPane tbpCadastro;
    private controller.TextFieldIconPlaceHolder txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private controller.TextFieldIconPlaceHolder txtCidade;
    private controller.TextFieldIconPlaceHolder txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataAdmissao;
    private javax.swing.JFormattedTextField txtDataDemissao;
    private javax.swing.JFormattedTextField txtDataNascimento;
    private controller.TextFieldIconPlaceHolder txtEmail;
    private controller.TextFieldIconPlaceHolder txtEndereco;
    private controller.TextFieldIconPlaceHolder txtId;
    private controller.TextFieldIconPlaceHolder txtLogin;
    private controller.TextFieldIconPlaceHolder txtNomeCompleto;
    private controller.TextFieldIconPlaceHolder txtNumero;
    private controller.TextFieldIconPlaceHolder txtRG;
    private controller.TextFieldIconPlaceHolder txtSalario;
    private controller.PasswordFieldIconPlaceHolder txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
