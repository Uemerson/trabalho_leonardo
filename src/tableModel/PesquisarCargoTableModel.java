package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Cargo;

/**
 *
 * @author Uemerson
 */
public class PesquisarCargoTableModel extends AbstractTableModel{
    private ArrayList<Cargo> linhas;
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "ID", "NOME DO CARGO"};

    // Constantes representando o índice das colunas
    private static final int ID = 0;
    private static final int NOME_DO_CARGO = 1;
    
    public PesquisarCargoTableModel(){
        linhas = new ArrayList<>();
    }
    
    public PesquisarCargoTableModel(ArrayList<Cargo> linhas){
        this.linhas = linhas;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    };
    
    @Override
    // Este método deve verificar o índice recebido por parâmetro e retornar o tipo
    // de classe correspondente à coluna.
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case ID:
                return Integer.class;
            case NOME_DO_CARGO:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    // Definir quais células são editáveis ou não
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    // Retornar o conteúdo da célula especificada
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega a permissao referente a linha especificada.
        Cargo cargo = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                return cargo.getId_cargo();
            case NOME_DO_CARGO:
                return cargo.getNome_cargo();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    // Se as células não forem editáveis, nem precisamos implementar o método
    // “setValueAt
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cargo cargo = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                cargo.setId_Cargo((int) aValue);
                break;

            case NOME_DO_CARGO:
                cargo.setNome_cargo((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
    
    // Retorna a permissão referente a linha especificada
    public Cargo getCargo(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    // Adiciona a permissão especificado ao modelo
    public void addCargo(Cargo cargo) {
        // Adiciona o registro.
        linhas.add(cargo);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Remove a permissão da linha especificada.
    public void removeCargo(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    // Adiciona uma lista de permissões no final da lista.
    public void addListaPermissaoCargo(ArrayList<Cargo> cargo) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(cargo);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + cargo.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de permissões.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
