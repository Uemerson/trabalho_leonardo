package comboModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Fornecedor;

/**
 *
 * @author Uemerson
 */
public class FornecedorComboModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private List<Fornecedor> listFornecedor;
    private Fornecedor selectedFornecedor;
    private final static int FIRSTINDEX = 0;
 
    public FornecedorComboModel() {
        this.listFornecedor = new ArrayList<Fornecedor>();
    }
     
    public FornecedorComboModel(List<Fornecedor> listFornecedor) {
        this();
        this.listFornecedor.addAll(listFornecedor);
        if (getSize() > 0) {
            setSelectedItem(this.listFornecedor.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Object getElementAt(int index) {
        return listFornecedor.get(index);
    }
 
    @Override
    public int getSize() {
        return listFornecedor.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return selectedFornecedor;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedFornecedor = (Fornecedor) anItem;
    }
     
    public void addFornecedor(Fornecedor Fornecedor) {
        listFornecedor.add(Fornecedor);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listFornecedor.get(getSize() - 1));
    }
     
    public void addListFornecedor(List<Fornecedor> Fornecedors) {
        int primeiraLinha = getSize();
        listFornecedor.addAll(Fornecedors);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + Fornecedors.size());
        setSelectedItem(listFornecedor.get(getSize() - 1));
    }
     
    public void removeFornecedor() {
        listFornecedor.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listFornecedor.get(FIRSTINDEX));
    }
     
    public void clear() {
        listFornecedor.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
}
