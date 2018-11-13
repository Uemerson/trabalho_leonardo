package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;


/**
 *
 * @author Uemerson
 */
public class PesquisarFornecedorTableModel extends AbstractTableModel{
    private ArrayList<Fornecedor> linhas;
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "ID", "NOME COMPLETO", "CNPJ", "RG", "CEP", "CIDADE", "ENDEREÇO", "BAIRRO"};

    // Constantes representando o índice das colunas
    private static final int  = 0;
    private static final int NOME_COMPLETO = 1;
    private static final int CNPJ = 2;
    private static final int CEP = 3;
    private static final int CIDADE = 4;
    private static final int ENDERECO = 5;
    private static final int BAIRRO = 6;
    
    public PesquisarFornecedorTableModel(){
        linhas = new ArrayList<>();
    }
    
    public PesquisarFornecedorTableModel(ArrayList<Fornecedor> linhas){
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
            case NOME_COMPLETO:
                return String.class;
            case CNPJ:
                return String.class;
            case CEP:
                return String.class;
            case CIDADE:
                return String.class;
            case ENDERECO:
                return String.class;
            case BAIRRO:
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
        Fornecedor fornecedor = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                return fornecedor.getId_fornecedor();
            case NOME_COMPLETO:
                return fornecedor.getNome_completo();
            case CNPJ:
                return fornecedor.getCnpj();
            case CEP:
                return fornecedor.getCep();
            case CIDADE:
                return fornecedor.getCidade();
            case ENDERECO:
                return fornecedor.getEndereco();
            case BAIRRO:
                return fornecedor.getBairro();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    // Se as células não forem editáveis, nem precisamos implementar o método
    // “setValueAt
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Fornecedor fornecedor = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                fornecedor.setId_fornecedor((int) aValue);
                break;

            case NOME_COMPLETO:
                fornecedor.setNome_completo((String) aValue);
                break;

            case CNPJ:
                fornecedor.setCnpj((String) aValue);
                break;
                
            case CEP:
                fornecedor.setCep((String) aValue);
                break;

            case CIDADE:
                fornecedor.setCidade((String) aValue);
                break;

            case ENDERECO:
                fornecedor.setEndereco((String) aValue);
                break;

            case BAIRRO:
                fornecedor.setBairro((String) aValue);
                break; 

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
    
    // Retorna a permissão referente a linha especificada
    public Fornecedor getFuncionario(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    // Adiciona a permissão especificado ao modelo
    public void addFuncionario(Fornecedor fornecedor) {
        // Adiciona o registro.
        linhas.add(fornecedor);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Remove a permissão da linha especificada.
    public void removeFuncionario(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    // Adiciona uma lista de permissões no final da lista.
    public void addListaPermissaoFuncionario(ArrayList<Fornecedor> funcionario) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(funcionario);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + funcionario.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de permissões.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}
