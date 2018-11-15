/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;
import model.Produto;

/**
 *
 * @author tayna
 */
public class PesquisarProdutoTableModel extends AbstractTableModel{
    private ArrayList<Produto> linhas;
    
    // Array com os nomes das colunas.
    private String[] colunas = new String[] { "ID", "NOME DO PRODUTO", "MARCA", "QUANTIDADE DE ESTOQUE", "PREÇO DE COMPRA", "PREÇO DE VENDA", "FORNECEDOR", "MARGEM"};

    // Constantes representando o índice das colunas
    private static final int ID = 0;
    private static final int NOME_PRODUTO = 1;
    private static final int MARCA = 2;
    private static final int QUANTIDADE_ESTOQUE = 3;
    private static final int PRECO_COMPRA = 4;
    private static final int PRECO_VENDA = 5;
    private static final int FORNECEDOR = 6;
    private static final int MARGEM = 7;
    
    public PesquisarProdutoTableModel(){
        linhas = new ArrayList<>();
    }
    
    public PesquisarProdutoTableModel(ArrayList<Produto> linhas){
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
            case MARCA:
                return String.class;
            case QUANTIDADE_ESTOQUE:
                return String.class;
            case PRECO_COMPRA:
                return String.class;
            case PRECO_VENDA:
                return String.class;
            case FORNECEDOR:
                return String.class;
            case MARGEM:
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
        Produto produto = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                return produto.getId_produto();
            case NOME_PRODUTO:
                return produto.getNome_produto();
            case MARCA:
                return produto.getMarca();
            case QUANTIDADE_ESTOQUE:
                return produto.getQuantidade_estoque();
            case PRECO_COMPRA:
                return produto.getPreco_compra();
            case PRECO_VENDA:
                return produto.getPreco_venda();
            case FORNECEDOR:
                return produto.getFornecedor();
            case MARGEM:
                return produto.getMargem();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    // Se as células não forem editáveis, nem precisamos implementar o método
    // “setValueAt
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);

        switch (columnIndex) {
            case ID:
                produto.setId_produto((int) aValue);
                break;

            case NOME_PRODUTO:
                produto.setNome_produto((String) aValue);
                break;

            case MARCA:
                produto.setMarca((String) aValue);
                break;

            case QUANTIDADE_ESTOQUE:
                produto.setQuantidade_estoque((int) aValue);
                break;
                
            case PRECO_COMPRA:
                produto.setPreco_compra((float) aValue);
                break;

            case PRECO_VENDA:
                produto.setPreco_venda((float) aValue);
                break;

            case FORNECEDOR:
                produto.setFornecedor((Fornecedor) aValue);
                break;

            case MARGEM:
                produto.setMargem((Float) aValue);
                break; 

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }
    
    // Retorna a permissão referente a linha especificada
    public Produto getProduto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    // Adiciona a permissão especificado ao modelo
    public void addProduto(Produto produto) {
        // Adiciona o registro.
        linhas.add(produto);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    // Remove a permissão da linha especificada.
    public void removeProduto(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    // Adiciona uma lista de permissões no final da lista.
    public void addListaPermissaoProduto(ArrayList<Produto> produto) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(produto);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + produto.size());
    }

    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de permissões.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
}