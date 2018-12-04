package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ItemVenda;

/**
 *
 * @author Uemerson
 */
public class ItensVendaTableModel extends AbstractTableModel{
    private ArrayList<ItemVenda> linhas;
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "ID", "NOME DO PRODUTO", "QTDE", "PREÇO UNIT", "PREÇO TOT"};

    // Constantes representando o índice das colunas
    private static final int ID = 0;
    private static final int NOME_PRODUTO = 1;
    private static final int QTDE = 2;
    private static final int PRECO_UNIT = 3;
    private static final int PRECO_TOT = 4;
    
    public ItensVendaTableModel(){
        linhas = new ArrayList<>();
    }
    
    public ItensVendaTableModel(ArrayList<ItemVenda> linhas){
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
            case NOME_PRODUTO:
                return String.class;
            case QTDE:
                return Float.class;
            case PRECO_UNIT:
                return Float.class;
            case PRECO_TOT:
                return Float.class;
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
        ItemVenda itemVenda = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                return itemVenda.getProduto().getId_produto();
            case NOME_PRODUTO:
                return itemVenda.getProduto().getNome_produto();
            case QTDE:
                return itemVenda.getQuantidade();
            case PRECO_UNIT:
                return itemVenda.getProduto().getPreco_venda();
            case PRECO_TOT:
                return itemVenda.getTotalVenda();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    // Se as células não forem editáveis, nem precisamos implementar o método
    // “setValueAt
    
    // Retorna a permissão referente a linha especificada
    public ItemVenda getItem(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    // Adiciona a permissão especificado ao modelo
    public void addItemVenda(ItemVenda itemVenda) {
        // Adiciona o registro.
        linhas.add(itemVenda);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Remove a permissão da linha especificada.
    public void removeItemVenda(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    // Adiciona uma lista de permissões no final da lista.
    public void addListaItemVenda(ArrayList<ItemVenda> itemVenda) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(itemVenda);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + itemVenda.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de permissões.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}