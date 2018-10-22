package view;

import controller.JTextFieldLimit;
import dao.CargoDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Cargo;
import tableModel.PesquisarCargoTableModel;

/**
 *
 * @author UEMERSON
 */
public class frmPesquisaCargo extends javax.swing.JDialog {
    
    //Variaveis
    Cargo cargoSelecionado = null;
    String ultimaColunaSelecionada = null;
    
    public frmPesquisaCargo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        tbCargo.getTableHeader().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int col = tbCargo.columnAtPoint(e.getPoint());
                    String name = tbCargo.getColumnName(col);
                    //System.out.println("Column index selected " + col + " " + name);

                    lblPesquisarPor.setText("Pesquisar pelo(a) " + name);
                    ultimaColunaSelecionada = name;
                    
                    if (name.equals("ID")){
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
        ultimaColunaSelecionada = "NOME DO CARGO";
        
        atualizarTabela();
    }

    private void atualizarTabela(){
        CargoDAO cargoDAO = new CargoDAO();
        Cargo cargo = null;
        
        if (ultimaColunaSelecionada.equals("ID") && !txtBuscar.getText().isEmpty()){
            cargo = new Cargo();
            cargo.setId_cargo(Integer.parseInt(txtBuscar.getText()));
        }else if (ultimaColunaSelecionada.equals("NOME DO CARGO") && !txtBuscar.getText().isEmpty()){ 
            cargo = new Cargo();
            cargo.setNome_cargo(txtBuscar.getText());
        }
            
        try {
            PesquisarCargoTableModel pesquisarCargoTableModel = new PesquisarCargoTableModel(cargoDAO.listaCargoPesquisar(cargo));
            
            tbCargo.setModel(pesquisarCargoTableModel);
            
            tbCargo.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbCargo.getColumnModel().getColumn(1).setPreferredWidth(629);
           
            tbCargo.getTableHeader().setReorderingAllowed(false);
            tbCargo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbCargo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
        } catch (SQLException ex) {
            Logger.getLogger(frmPesquisaCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagemFormulario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCargo = new javax.swing.JTable();
        lblPesquisarPor = new javax.swing.JLabel();
        txtBuscar = new controller.TextFieldIconPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procurar funcionário");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Procurar cargo");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblImagemFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boss 64x64 pesquisar.png"))); // NOI18N

        tbCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCargoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCargo);

        lblPesquisarPor.setText("Pesquisar pelo(a) NOME DO CARGO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
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

    private void tbCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCargoMouseClicked
        if (evt.getClickCount() >= 2){
            cargoSelecionado = new Cargo();
            cargoSelecionado.setId_cargo((int) tbCargo.getValueAt(tbCargo.getSelectedRow(), 0));
            dispose();
        }
    }//GEN-LAST:event_tbCargoMouseClicked
    
    public Cargo getCargoSelecionado(){
        return cargoSelecionado;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblImagemFormulario;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JTable tbCargo;
    private controller.TextFieldIconPlaceHolder txtBuscar;
    // End of variables declaration//GEN-END:variables
}
