package comboModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Funcionario;

/**
 *
 * @author Uemerson
 */
public class VendedorComboModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private List<Funcionario> listVendedor;
    private Funcionario selectedVendedor;
    private final static int FIRSTINDEX = 0;
 
    public VendedorComboModel() {
        this.listVendedor = new ArrayList<Funcionario>();
    }
     
    public VendedorComboModel(List<Funcionario> listVendedor) {
        this();
        this.listVendedor.addAll(listVendedor);
        if (getSize() > 0) {
            setSelectedItem(this.listVendedor.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Object getElementAt(int index) {
        return listVendedor.get(index);
    }
 
    @Override
    public int getSize() {
        return listVendedor.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return selectedVendedor;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedVendedor = (Funcionario) anItem;
    }
     
    public void addVendedor(Funcionario Funcionario) {
        listVendedor.add(Funcionario);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listVendedor.get(getSize() - 1));
    }
     
    public void addlistVendedor(List<Funcionario> Funcionarios) {
        int primeiraLinha = getSize();
        listVendedor.addAll(Funcionarios);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + Funcionarios.size());
        setSelectedItem(listVendedor.get(getSize() - 1));
    }
     
    public void removeVendedor() {
        listVendedor.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listVendedor.get(FIRSTINDEX));
    }
     
    public void clear() {
        listVendedor.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
}
