package comboModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import model.Estado;

/**
 *
 * @author Uemerson
 */
public class EstadoComboModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    private List<Estado> listEstado;
    private Estado selectedEstado;
    private final static int FIRSTINDEX = 0;
 
    public EstadoComboModel() {
        this.listEstado = new ArrayList<Estado>();
    }
     
    public EstadoComboModel(List<Estado> listEstado) {
        this();
        this.listEstado.addAll(listEstado);
        if (getSize() > 0) {
            setSelectedItem(this.listEstado.get(FIRSTINDEX));
        }
    }
     
    @Override
    public Object getElementAt(int index) {
        return listEstado.get(index);
    }
 
    @Override
    public int getSize() {
        return listEstado.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return selectedEstado;
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        selectedEstado = (Estado) anItem;
    }
     
    public void addEstado(Estado Estado) {
        listEstado.add(Estado);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(listEstado.get(getSize() - 1));
    }
     
    public void addListEstado(List<Estado> Estados) {
        int primeiraLinha = getSize();
        listEstado.addAll(Estados);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + Estados.size());
        setSelectedItem(listEstado.get(getSize() - 1));
    }
     
    public void removeEstado() {
        listEstado.remove(getSelectedItem());
        fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
        setSelectedItem(listEstado.get(FIRSTINDEX));
    }
     
    public void clear() {
        listEstado.clear();
        fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
    }
}
