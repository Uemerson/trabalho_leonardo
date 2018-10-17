package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;

/**
 *
 * @author Uemerson
 */
public class PesquisarFuncionarioTableModel extends AbstractTableModel{
    private ArrayList<Funcionario> linhas;
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "ID", "NOME COMPLETO", "CPF", "RG", "CEP", "CIDADE", "ENDEREÇO", "BAIRRO"};

    // Constantes representando o índice das colunas
    private static final int ID = 0;
    private static final int NOME_COMPLETO = 1;
    private static final int CPF = 2;
    private static final int RG = 3;
    private static final int CEP = 4;
    private static final int CIDADE = 5;
    private static final int ENDERECO = 6;
    private static final int BAIRRO = 7;
    
    public PesquisarFuncionarioTableModel(){
        linhas = new ArrayList<>();
    }
    
    public PesquisarFuncionarioTableModel(ArrayList<Funcionario> linhas){
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
            case CPF:
                return String.class;
            case RG:
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
        Funcionario funcionario = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                return funcionario.getId_funcionario();
            case NOME_COMPLETO:
                return funcionario.getNome_completo();
            case CPF:
                return funcionario.getCpf();
            case RG:
                return funcionario.getRg();
            case CEP:
                return funcionario.getCep();
            case CIDADE:
                return funcionario.getCidade();
            case ENDERECO:
                return funcionario.getEndereco();
            case BAIRRO:
                return funcionario.getBairro();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    // Se as células não forem editáveis, nem precisamos implementar o método
    // “setValueAt
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Funcionario funcionario = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                funcionario.setId_funcionario((int) aValue);
                break;

            case NOME_COMPLETO:
                funcionario.setNome_completo((String) aValue);
                break;

            case CPF:
                funcionario.setCpf((String) aValue);
                break;

            case RG:
                funcionario.setRg((String) aValue);
                break;
                
            case CEP:
                funcionario.setCep((String) aValue);
                break;

            case CIDADE:
                funcionario.setCidade((String) aValue);
                break;

            case ENDERECO:
                funcionario.setEndereco((String) aValue);
                break;

            case BAIRRO:
                funcionario.setBairro((String) aValue);
                break; 

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
    
    // Retorna a permissão referente a linha especificada
    public Funcionario getFuncionario(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    // Adiciona a permissão especificado ao modelo
    public void addFuncionario(Funcionario funcionario) {
        // Adiciona o registro.
        linhas.add(funcionario);

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
    public void addListaPermissaoFuncionario(ArrayList<Funcionario> funcionario) {
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
